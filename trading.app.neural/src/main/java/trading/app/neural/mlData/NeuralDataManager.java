package trading.app.neural.mlData;

import org.encog.ml.data.MLDataSet;

public interface NeuralDataManager {

	/* (non-Javadoc)
	 * @see trading.app.neural.converter.MLDataLoader#loadTrainMLDataSet()
	 */
	public abstract MLDataSet loadTrainMLDataSet();

}