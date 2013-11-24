package trading.app.neural;

import java.io.File;
import java.util.List;

import org.encog.neural.networks.BasicNetwork;

/**
 * Neural service interface
 * @author dima
 *
 */
public interface NeuralService {

	/**
	 * @param neuralContext the neuralContext to set
	 */
	public abstract void setNeuralContext(NeuralContext neuralContext);

	/**
	 * Create network with layers
	 * @param layers Neurons in layers
	 * @return
	 */
	public abstract BasicNetwork createNetwork(List<Integer> layers);

	/**
	 * Create train dataset and train network
	 */
	public abstract void trainNetwork();

	/**
	 * Get context
	 * @return
	 */
	public abstract NeuralContext getNeuralContext();

	/**
	 * Saves current network to file
	 *
	 * @param fileName
	 */
	public abstract void saveNetwork(File file);

	/**
	 * Load network from file
	 *
	 * @param fileName
	 */
	public abstract void loadNetwork(File file);

	/**
	 * Reset network weights
	 */
	public abstract void resetNetwork();

}