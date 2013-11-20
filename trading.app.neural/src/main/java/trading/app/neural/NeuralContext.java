package trading.app.neural;

import java.util.List;

import org.encog.neural.networks.BasicNetwork;

import trading.app.TradingApplicationContext;

/**
 * Context contains neural network configuration and current state
 * @author pdg
 */
public class NeuralContext {
	private BasicNetwork network;
	private TrainingContext trainingContext = new TrainingContext();
	private TradingApplicationContext tradingApplicationContext;

	/**
	 * Main ctor
	 * @param applicationContext TradingApplicationContext
	 */
	public NeuralContext(TradingApplicationContext applicationContext){
		tradingApplicationContext = applicationContext;
	}
	
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
	 * @return the tradingApplicationContext
	 */
	public TradingApplicationContext getTradingApplicationContext() {
		return tradingApplicationContext;
	}

	
}
