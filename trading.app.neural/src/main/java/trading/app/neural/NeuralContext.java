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
	
	private int predictionInterval = 60;
	private int level1WindowSize = 100;

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
	public Integer getPredictionInterval() {
		return predictionInterval;
	}

	/**
	 * @param predictionInterval the predictionInterval to set
	 */
	public void setPredictionInterval(Integer predictionInterval) {
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

	/**
	 * Get level1 item count in data window
	 * @return the level1WindowSize
	 */
	public Integer getLevel1WindowSize() {
		return level1WindowSize;
	}

	/**
	 * Set level1 item count in data window
	 * @param level1WindowSize the level1WindowSize to set
	 */
	public void setLevel1WindowSize(Integer level1WindowSize) {
		this.level1WindowSize = level1WindowSize;
	}



	
}
