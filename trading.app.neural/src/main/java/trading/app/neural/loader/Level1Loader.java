package trading.app.neural.loader;

import java.util.ArrayList;
import java.util.List;

import org.encog.ml.data.MLData;
import org.encog.ml.data.basic.BasicMLData;

import trading.app.TradingApplicationContext;
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
	public MLData loadTrainMLDataSet(){
		
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
		
		// Prepare samples
		for(int i = 0; i < trainSamples; i+=trainStep) {
			List<Level1> inputSample = data.subList(i, i+windowSize);

		}
		return null;
	}
	/**
	 * Convert level1 list to mldata
	 * @param entityList
	 * @return
	 */
	private MLData entitiesToMLData(List<Level1> entityList){
		List<Double> inputData= new ArrayList<Double>();
		for(Level1 entity: entityList){
			
		}
		return null;
	}
	
	
	

	
	
}
