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
	private TrainingContext trainingContext;
	private TradingApplicationContext tradingApplicationContext;

	
	
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

	/**
	 * @return the tradingApplicationContext
	 */
	public TradingApplicationContext getTradingApplicationContext() {
		return tradingApplicationContext;
	}

	/**
	 * @param tradingApplicationContext the tradingApplicationContext to set
	 */
	public void setTradingApplicationContext(TradingApplicationContext tradingApplicationContext) {
		this.tradingApplicationContext = tradingApplicationContext;
	}
	
}
