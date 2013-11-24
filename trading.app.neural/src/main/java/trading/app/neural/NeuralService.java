package trading.app.neural;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import com.google.common.eventbus.*;

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
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public abstract void trainNetwork() throws FileNotFoundException, IOException;

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

	/**
	 * Gets event bus for this service
	 * @return
	 */
	public abstract EventBus getEventBus();

}
