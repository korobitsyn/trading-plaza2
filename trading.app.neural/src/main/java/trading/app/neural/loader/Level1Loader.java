package trading.app.neural.loader;

import java.math.BigDecimal;
import java.util.List;

import org.encog.ml.data.MLData;
import org.encog.ml.data.MLDataPair;
import org.encog.ml.data.MLDataSet;
import org.encog.ml.data.basic.BasicMLData;
import org.encog.ml.data.basic.BasicMLDataPair;
import org.encog.ml.data.basic.BasicMLDataSet;

import trading.app.history.HistoryProvider;
import trading.app.neural.NeuralContext;
import trading.data.model.Level1;

/**
 * Get ML data for network learning
 * @author pdg
 *
 */
public class Level1Loader  {
	private NeuralContext neuralContext;

	
	/**
	 * Constructor for context
	 * @param context
	 */
	public Level1Loader(NeuralContext context){
		neuralContext = context;
	}
	
	/* (non-Javadoc)
	 * @see trading.app.neural.converter.MLDataLoader#loadTrainMLDataSet()
	 */
	public MLDataSet loadTrainMLDataSet(){
		// Prepare parameters to use further in this function
		int windowSize = neuralContext.getLevel1WindowSize();
		int trainStep = neuralContext.getTrainingContext().getTrainStep();
		int predictionSize = neuralContext.getPredictionSize();
		int trainSamples = neuralContext.getTrainingContext().getTrainSamples();
		int predictionSamples = neuralContext.getTrainingContext().getPredictionSamples();	
		
		// Train and prediction offsets offset from end
		int predictionOffset = predictionSize * predictionSamples;		
		int trainOffset = predictionOffset + windowSize*trainSamples; 
		int dataSize = trainOffset;
		
		// Load last data from database
		int instrumentId = neuralContext.getTradingApplicationContext().getInstrumentContext().getInstrument().getId();
		HistoryProvider historyProvider = neuralContext.getTradingApplicationContext().getHistoryProvider();
		List<Level1> data = historyProvider.findLevel1Last( instrumentId, dataSize);
		if(data.size() < dataSize){
			throw new IllegalArgumentException("History data is not enough for given window size, prediction size and samples count");
		}
		
		// Create and fill dataset
		MLDataSet dataSet = new BasicMLDataSet();
		// Prepare samples for training
		for(int i = 0; i < trainSamples; i+=trainStep) {
			// Extract input data for one sample
			List<Level1> inputWindow = data.subList(i, i+windowSize);
			MLData inputData = entitiesToMLData(inputWindow);

			// Get output data
			Level1 lastInputLevel1 = inputWindow.get(inputWindow.size()-1);
			List<Level1> predictionWindow = data.subList(i+windowSize, i+windowSize + predictionSize);
			MLData outputData = getOutputData(lastInputLevel1, predictionWindow);
			
			// Create data pair for encog and add to dataset
			MLDataPair pair = new BasicMLDataPair(inputData, outputData);
			dataSet.add(pair);
		}
		return dataSet;
	}
	
	/**
	 * Get output data from prediction window
	 * @param predictionWindow
	 * @return
	 */
	private MLData getOutputData(Level1 currentLevel1, List<Level1> predictionWindow){
		MLData outputData = new BasicMLData(OUTPUT_SIZE);
		Double minBid = Double.MAX_VALUE;
		Double maxAsk = Double.MIN_VALUE;
		// Go through prediction window
		for(Level1 level1: predictionWindow){
			Double bid = getNormalizedPrice(level1.getBid(), currentLevel1.getBid()); 
			Double ask = getNormalizedPrice(level1.getAsk(), currentLevel1.getAsk());
			if(bid < minBid){minBid = bid;}
			if(ask > maxAsk){maxAsk = ask;}
		}
		// Form outputData
		outputData.add(0, minBid);
		outputData.add(1, maxAsk);
		return outputData;
	}
	
	/**
	 * Size of one level1 data
	 */
	private static final int LEVEL1_DATA_SIZE = 7;
	private static final int OUTPUT_SIZE = 2;
	
	/**
	 * Convert level1 list to mldata
	 * @param entityList
	 * @return
	 */
	private MLData entitiesToMLData(List<Level1> entityList){
		// Contains network input data
		MLData data = new BasicMLData(LEVEL1_DATA_SIZE * entityList.size());

		Level1 lastEntity = null;
		int pos = 0;
		for(Level1 entity: entityList){
			if(lastEntity == null){
				continue;
			}
			// Add to data and update pos
			pos = addLevelData(data, pos, entity, lastEntity);
			lastEntity = entity;
		}
		
		return data;
	}
	
	/**
	 * Convert level1 to array data
	 * @param level1
	 * @return index position
	 */ 
	private int addLevelData(MLData data, int pos, Level1 level1, Level1 prevLevel1){
		//List<Double> data = new ArrayList();
		// 0 - Date
		double normalizedDate = 1/(new Long(level1.getDate().getTime()).doubleValue());
		data.add(pos++, normalizedDate);
		// 1 - Price
		double normalizedPrice = getNormalizedPrice(level1.getLastPrice(), prevLevel1.getLastPrice()); 
		data.add(pos++, normalizedPrice);
		// 2- Size
		double normalizedSize = getNormalizedSize(level1.getLastSize(), prevLevel1.getLastSize());
		data.add(pos++, normalizedSize);
		// 3,4 - Bid and bid size
		double normalizedBid = getNormalizedPrice(level1.getBid(), prevLevel1.getBid());
		data.add(pos++, normalizedBid);
		double normalizedBidSize = getNormalizedSize(level1.getBidSize(), prevLevel1.getBidSize());
		data.add(pos++, normalizedBidSize);
		// 5,6 - Ask and ask size
		double normalizedAsk = getNormalizedPrice(level1.getAsk(), prevLevel1.getAsk());
		data.add(pos++, normalizedAsk);
		double normalizedAskSize = getNormalizedSize(level1.getAskSize(), prevLevel1.getAskSize());
		data.add(pos++, normalizedAskSize);
		
		return pos;
	}
	
	/**
	 * Get normalized value for price
	 * @param current
	 * @param prev
	 * @return
	 */
	private double getNormalizedPrice(BigDecimal current, BigDecimal prev){
		// Convert to delta %
		double normalized = (current.doubleValue() - prev.doubleValue()) / prev.doubleValue();
		return normalized;
	}
	/**
	 * Get normalized value for volume
	 * @param current
	 * @param prev
	 * @return
	 */
	private double getNormalizedSize(Integer current, Integer prev){
		// Convert to delta %
		double normalized = (current.doubleValue() - prev.doubleValue()) / prev.doubleValue();
		return normalized;
	}
}
