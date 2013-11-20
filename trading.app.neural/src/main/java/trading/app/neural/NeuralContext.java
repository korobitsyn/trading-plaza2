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
	private NeuralServiceBase neuralService;
	
	private int predictionInterval;

	/**
	 * Main ctor
	 * @param tradingApplicationContext TradingApplicationContext
	 * @param neuralService Neural service bean
	 */
	public NeuralContext(TradingApplicationContext tradingApplicationContext){
		this.tradingApplicationContext = tradingApplicationContext;

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

	/**
	 * @return the predictionInterval
	 */
	public int getPredictionInterval() {
		return predictionInterval;
	}

	/**
	 * @param predictionInterval the predictionInterval to set
	 */
	public void setPredictionInterval(int predictionInterval) {
		this.predictionInterval = predictionInterval;
	}

	/**
	 * @return the neuralService
	 */
	public NeuralServiceBase getNeuralService() {
		return neuralService;
	}
	public void setNeuralService(NeuralServiceBase neuralService){
		this.neuralService = neuralService;
	}



	
}
