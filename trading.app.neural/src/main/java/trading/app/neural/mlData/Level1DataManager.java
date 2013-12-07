package trading.app.neural.mlData;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.encog.ml.data.MLData;
import org.encog.ml.data.MLDataPair;
import org.encog.ml.data.MLDataSet;
import org.encog.ml.data.basic.BasicMLData;
import org.encog.ml.data.basic.BasicMLDataPair;
import org.encog.ml.data.basic.BasicMLDataSet;
import org.jboss.logging.Logger;

import trading.app.history.HistoryProvider;
import trading.app.neural.NeuralContext;
import trading.data.model.Level1;

/**
 * Get ML data for network learning
 * 
 * @author pdg
 * 
 */
public class Level1DataManager implements NeuralDataManager {

	private NeuralContext neuralContext;

	private static Logger LOG = Logger.getLogger(Level1DataManager.class);

	/**
	 * Size of one level1 data
	 */
	public static final int LEVEL1_DATA_SIZE = 7;

	public static final int OUTPUT_SIZE = 2;

	/**
	 * Constructor for context
	 * 
	 * @param context
	 */
	public Level1DataManager(NeuralContext context) {
		neuralContext = context;
	}

	/**
	 * Convert level1 to array data
	 * 
	 * @param level1
	 * @return index position
	 */
	private int addLevel1Data(MLData data, int pos, Level1 level1,
			Level1 prevLevel1) {
		// List<Double> data = new ArrayList();
		// 0 - Date
		double normalizedDate = getNormalizedDate(level1.getDate());
		data.add(pos++, normalizedDate);
		// 1 - Price
		double normalizedPrice = getNormalizedPrice(level1.getLastPrice(),
				prevLevel1.getLastPrice());
		data.add(pos++, normalizedPrice);
		// 2- Size
		double normalizedSize = getNormalizedSize(level1.getLastSize(),
				prevLevel1.getLastSize());
		data.add(pos++, normalizedSize);
		// 3,4 - Bid and bid size
		double normalizedBid = getNormalizedPrice(level1.getBid(),
				prevLevel1.getBid());
		data.add(pos++, normalizedBid);
		double normalizedBidSize = getNormalizedSize(level1.getBidSize(),
				prevLevel1.getBidSize());
		data.add(pos++, normalizedBidSize);
		// 5,6 - Ask and ask size
		double normalizedAsk = getNormalizedPrice(level1.getAsk(),
				prevLevel1.getAsk());
		data.add(pos++, normalizedAsk);
		double normalizedAskSize = getNormalizedSize(level1.getAskSize(),
				prevLevel1.getAskSize());
		data.add(pos++, normalizedAskSize);

		return pos;
	}

	/**
	 * Convert level1 list to mldata
	 * 
	 * @param entityList
	 * @return
	 */
	private MLData entitiesToMLData(List<Level1> entityList) {
		// Contains network input data
		MLData data = new BasicMLData(LEVEL1_DATA_SIZE
				* (entityList.size() - 1));

		Level1 lastEntity = null;
		int pos = 0;
		for (Level1 entity : entityList) {
			if (lastEntity == null) {
				lastEntity = entity;
				continue;
			}
			// Add to data and update pos
			pos = addLevel1Data(data, pos, entity, lastEntity);
			lastEntity = entity;
		}

		return data;
	}

	/**
	 * @see NeuralDataManager#getInputData(List, int)
	 */
	@Override
	public MLData getInputData(List<Level1> data, int index) {
		// Get input data
		List<Level1> inputWindow = data.subList(
				index - neuralContext.getLevel1WindowSize(), index + 1);
		MLData inputData = entitiesToMLData(inputWindow);
		return inputData;
	}

	/**
	 * Get MLDataPair to train for prediction
	 * 
	 * @param data
	 * @param index
	 *            Current item index. Prediction window starts next item after
	 *            index
	 */
	@Override
	public MLDataPair getMLDataPair(List<Level1> data, int index) {
		// Get input and output
		MLData inputData = getInputData(data, index);
		MLData outputData = getOutputData(data, index);

		// Create data pair for encog and add to dataset
		MLDataPair pair = new BasicMLDataPair(inputData, outputData);
		return pair;
	}

	/**
	 * Date normalization
	 * 
	 * @param date
	 * @return
	 */
	private double getNormalizedDate(Date date) {
		return 1 / (new Long(date.getTime()).doubleValue());

	}

	/**
	 * Get normalized value for price
	 * 
	 * @param current
	 * @param prev
	 * @return
	 */
	private double getNormalizedPrice(BigDecimal current, BigDecimal prev) {
		// Convert to delta %
		double normalized = (current.doubleValue() - prev.doubleValue())
				/ prev.doubleValue();
		return normalized;
	}

	/**
	 * Get normalized value for volume
	 * 
	 * @param current
	 * @param prev
	 * @return
	 */
	private double getNormalizedSize(Integer current, Integer prev) {
		// Convert to delta %
		double normalized = (current.doubleValue() - prev.doubleValue())
				/ prev.doubleValue();
		return normalized;
	}

	/**
	 * @see NeuralDataManager#getOutputData(List, int)a
	 */
	@Override
	public MLData getOutputData(List<Level1> data, int index) {
		// Get output data - min, max
		Level1 currentLevel1 = data.get(index);
		List<Level1> predictionWindow = data.subList(index + 1, index + 1
				+ neuralContext.getPredictionSize());

		MLData outputData = new BasicMLData(OUTPUT_SIZE);
		Double minBid = Double.MAX_VALUE;
		Double maxAsk = Double.MIN_VALUE;
		// Go through prediction window
		for (Level1 level1 : predictionWindow) {
			Double bid = getNormalizedPrice(level1.getBid(),
					currentLevel1.getBid());
			Double ask = getNormalizedPrice(level1.getAsk(),
					currentLevel1.getAsk());
			if (bid < minBid) {
				minBid = bid;
			}
			if (ask > maxAsk) {
				maxAsk = ask;
			}
		}
		// Form outputData
		outputData.add(0, minBid);
		outputData.add(1, maxAsk);
		return outputData;
	}

	/**
	 * Load dataset for additional training on last data Is called when
	 * prediction interval completed and we can compare previous network
	 * prediction with reality happened.
	 * 
	 * @return
	 */
	@Override
	public MLDataSet loadAdditionalTrainMLDataSet() {
		// Load data with one last prediction and related training windows
		return loadTrainMLDataSet(1);

	}

	/**
	 * Load list of items for neural network test
	 * 
	 * @return
	 */
	@Override
	public List<Level1> loadTestData() {
		// Prepare parameters to use further in this function
		int windowSize = neuralContext.getLevel1WindowSize();
		int testStep = 1;
		int predictionSize = neuralContext.getPredictionSize();
		int predictionSamples = neuralContext.getTrainingContext()
				.getPredictionSamples();

		// Train and prediction offsets offset from end
		int predictionOffset = predictionSize * predictionSamples * testStep;
		// int trainOffset = predictionOffset + windowSize * trainSamples;
		int dataSize = predictionOffset + windowSize;

		// Load last data for current instrument from database
		int instrumentId = neuralContext.getTradingApplicationContext()
				.getInstrumentContext().getInstrument().getId();
		HistoryProvider historyProvider = neuralContext
				.getTradingApplicationContext().getHistoryProvider();
		List<Level1> data = historyProvider.findLevel1Last(instrumentId,
				dataSize);

		return data;
	}

	/**
	 * 
	 * @see trading.app.neural.mlData.EncogDataManager#loadTrainMLDataSet()
	 */
	@Override
	public MLDataSet loadTrainMLDataSet() {
		int predictionSamples = neuralContext.getTrainingContext()
				.getPredictionSamples();
		return loadTrainMLDataSet(predictionSamples);
	}

	/**
	 * 
	 * @param predictionSamples
	 *            prediction data samples in dataset. Got from context for main
	 *            training and 1 for additional training on last data
	 * 
	 */
	public MLDataSet loadTrainMLDataSet(int predictionSamples) {
		// Prepare parameters to use further in this function
		int windowSize = neuralContext.getLevel1WindowSize();
		int trainStep = neuralContext.getTrainingContext().getTrainStep();
		int trainSamples = neuralContext.getTrainingContext().getTrainSamples();
		int trainDataSize = windowSize + trainStep*trainSamples;
		
		int predictionSize = neuralContext.getPredictionSize();
		int predictionDataSize = neuralContext.getPredictionSize() * predictionSamples;
		//int predictionSamples = neuralContext.getTrainingContext()
		// .getPredictionSamples();

		// Train and prediction offsets offset from end
		int predictionOffset = predictionSize * predictionSamples;
		int trainOffset = predictionOffset + trainStep * trainSamples;
		int dataSize = trainDataSize + predictionDataSize;

		// Load last data from database
		int instrumentId = neuralContext.getTradingApplicationContext()
				.getInstrumentContext().getInstrument().getId();
		HistoryProvider historyProvider = neuralContext
				.getTradingApplicationContext().getHistoryProvider();
		List<Level1> data = historyProvider.findLevel1Last(instrumentId,
				dataSize + 1);
		if (data.size() < dataSize + 1) {
			IllegalArgumentException ex = new IllegalArgumentException(
					"History data is not enough for given window size, prediction size and samples count");
			LOG.error(ex);
			throw ex;

		}

		// Create and fill dataset
		MLDataSet dataSet = new BasicMLDataSet();
		// Prepare samples for training
		for (int i = 0; i < trainSamples; i += trainStep) {
			MLDataPair pair = getMLDataPair(data, windowSize + i);
			dataSet.add(pair);
		}
		return dataSet;
	}
}
