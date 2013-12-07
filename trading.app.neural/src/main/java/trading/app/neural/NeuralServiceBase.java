package trading.app.neural;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.encog.ml.data.MLData;
import org.encog.ml.data.MLDataPair;
import org.encog.ml.data.MLDataSet;
import org.encog.ml.data.basic.BasicMLDataSet;
import org.encog.neural.networks.BasicNetwork;
import org.encog.persist.EncogDirectoryPersistence;

import trading.app.neural.events.TestIterationCompletedEvent;
import trading.data.model.Level1;

import com.google.common.eventbus.*;

/**
 * Base class for all neural services
 * @author dima
 *
 */
public abstract class NeuralServiceBase implements NeuralService {
	EventBus eventBus = new EventBus();
	protected NeuralContext neuralContext;

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
	/**
	 * @return the eventBus
	 */
	@Override
	public EventBus getEventBus() {
		return eventBus;
	} 
    
    /**
	 * @see trading.app.neural.NeuralService#trainNetwork()
	 */

    /**
	* @see NeuralService#getFirstLayerSize(int)
	 */
	@Override
	public abstract int getFirstLayerSize(int entityListSize);
    
	/**
	 * @see NeuralService#getLastLayerSize()
	 */
	public abstract int getLastLayerSize();    
    
    
	/* (non-Javadoc)
	 * @see trading.app.neural.NeuralService#getNeuralContext()
	 */
	@Override
	public NeuralContext getNeuralContext() {
		return neuralContext;
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

	/* (non-Javadoc)
	 * @see trading.app.neural.NeuralService#saveNetwork(java.io.File)
	 */
	@Override
	public void saveNetwork(File file) {
	    EncogDirectoryPersistence.saveObject(file, neuralContext.getNetwork());
	}
	/* (non-Javadoc)
	 * @see trading.app.neural.NeuralService#setNeuralContext(trading.app.neural.NeuralContext)
	 */
	@Override
	public void setNeuralContext(NeuralContext neuralContext) {
		this.neuralContext = neuralContext;
	}
	
	/**
     * General train of network
     */
    @Override
	public abstract void trainNetwork();
	
	/**
	 * Train network on last data
	 */
	public abstract void trainNetworkAdditional();

	/**
	 * @see NeuralService#testNetwork()
	 */
	@Override
	public abstract void testNetwork();
	

}
