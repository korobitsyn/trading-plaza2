package trading.app.neural.mlData;

import java.util.List;

import org.encog.ml.data.MLDataPair;
import org.encog.ml.data.MLDataSet;

import trading.data.model.Level1;

public interface NeuralDataManager {

	/* (non-Javadoc)
	 * @see trading.app.neural.converter.MLDataLoader#loadTrainMLDataSet()
	 */
	public abstract MLDataSet loadTrainMLDataSet();

	public abstract MLDataPair getMLDataPair(List<Level1> data, int index);

	public abstract MLDataSet loadAdditionalTrainMLDataSet();

}