package trading.app.neural;

import org.encog.neural.networks.BasicNetwork;

/**
 * Context contains neural network configuration and current state
 * @author pdg
 */
public class NeuralContext {
	private BasicNetwork network;
	private TrainingContext trainingContext;

	/**
	 * @return the network
	 */
	public BasicNetwork getNetwork() {
		return network;
	}

	/**
	 * @param network the network to set
	 */
	public void setNetwork(BasicNetwork network) {
		this.network = network;
	}

	/**
	 * @return the trainingContext
	 */
	public TrainingContext getTrainingContext() {
		return trainingContext;
	}

	/**
	 * @param trainingContext the trainingContext to set
	 */
	public void setTrainingContext(TrainingContext trainingContext) {
		this.trainingContext = trainingContext;
	}
	
}
