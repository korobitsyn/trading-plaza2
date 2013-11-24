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
public abstract class NeuralServiceBase implements NeuralService {

	protected NeuralContext neuralContext;

	/* (non-Javadoc)
	 * @see trading.app.neural.NeuralService#setNeuralContext(trading.app.neural.NeuralContext)
	 */
	@Override
	public void setNeuralContext(NeuralContext neuralContext) {
		this.neuralContext = neuralContext;
	}
	/**
	 * Construct with neural context data
	 * @param neuralContext
	 */
	public NeuralServiceBase() {

	}
	/* (non-Javadoc)
	 * @see trading.app.neural.NeuralService#createNetwork(java.util.List)
	 */
    @Override
	public abstract BasicNetwork createNetwork(List<Integer> layers); 
    
    /* (non-Javadoc)
	 * @see trading.app.neural.NeuralService#trainNetwork()
	 */
    @Override
	public abstract void trainNetwork();
    
    
	/* (non-Javadoc)
	 * @see trading.app.neural.NeuralService#getNeuralContext()
	 */
	@Override
	public NeuralContext getNeuralContext() {
		return neuralContext;
	}

	/* (non-Javadoc)
	 * @see trading.app.neural.NeuralService#saveNetwork(java.io.File)
	 */
	@Override
	public void saveNetwork(File file) {
	    EncogDirectoryPersistence.saveObject(file, neuralContext.getNetwork());
	}

	/* (non-Javadoc)
	 * @see trading.app.neural.NeuralService#loadNetwork(java.io.File)
	 */
	@Override
	public void loadNetwork(File file) {
	    BasicNetwork network = (BasicNetwork) EncogDirectoryPersistence.loadObject(file);
	    neuralContext.setNetwork(network);
	}

	/* (non-Javadoc)
	 * @see trading.app.neural.NeuralService#resetNetwork()
	 */
	@Override
	public void resetNetwork() {
	    neuralContext.getNetwork().reset();
	}
}