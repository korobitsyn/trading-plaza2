package trading.app.neural;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.encog.neural.networks.BasicNetwork;
import org.encog.persist.EncogDirectoryPersistence;

/**
 * Base class for all neural services
 * @author dima
 *
 */
public abstract class NeuralServiceBase {

	protected NeuralContext neuralContext;

	/**
	 * Construct with neural context data
	 * @param neuralContext
	 */
	public NeuralServiceBase(NeuralContext neuralContext) {
		this.neuralContext = neuralContext;
	}
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
	public NeuralContext getNeuralContext() {
		return neuralContext;
	}

	/**
	 * Saves current network to file
	 *
	 * @param fileName
	 */
	public void saveNetwork(File file) {
	    EncogDirectoryPersistence.saveObject(file, neuralContext.getNetwork());
	}

	/**
	 * Load network from file
	 *
	 * @param fileName
	 */
	public void loadNetwork(File file) {
	    BasicNetwork network = (BasicNetwork) EncogDirectoryPersistence.loadObject(file);
	    neuralContext.setNetwork(network);
	}

	/**
	 * Reset network weights
	 */
	public void resetNetwork() {
	    neuralContext.getNetwork().reset();
	}
}