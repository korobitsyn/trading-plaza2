package trading.app.neural.mlData;

import java.util.List;

import org.encog.ml.data.MLData;
import org.encog.ml.data.MLDataPair;
import org.encog.ml.data.MLDataSet;

import trading.data.model.Level1;

public interface NeuralDataManager {

	/**
	 * Loads MLDataSet for network training
	 * @return
	 */
	public abstract MLDataSet loadTrainMLDataSet();

	/**
	 * Gets MLDataPair with input and output for specific position in data
	 * @param data All entities
	 * @param index Index of last item in window. Prediction window starts index+1 item
	 * @return
	 */
	public abstract MLDataPair getMLDataPair(List<Level1> data, int index);

	/**
	 * Gets MLDataSet for training on last data. Last predictionSize items are prediction window. Before them are  windowSize items - input window.
	 * @return
	 */
	public abstract MLDataSet loadAdditionalTrainMLDataSet();

	/**
	 * Load list of items for neural network test
	 * @return
	 */
	public abstract List<Level1> loadTestData();
	
	/**
	 * Returns input for prediction
	 * 
	 * @param data
	 * @param index
	 *            Current item index. Prediction window starts next item after
	 *            index
	 * @return input data for neural network
	 */
	public abstract MLData getInputData(List<Level1> data, int index);	

}