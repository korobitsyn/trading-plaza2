package trading.app.neural;

import java.util.List;

import org.encog.neural.networks.BasicNetwork;

import trading.app.TradingApplicationContext;
import trading.app.neural.mlData.NeuralDataManager;

/**
 * Context contains neural network configuration and current state
 * @author pdg
 */
public class NeuralContext {
	private BasicNetwork network;
	private TrainingContext trainingContext = new TrainingContext();
	private TradingApplicationContext tradingApplicationContext;
	private NeuralService neuralService;
	private NeuralDataManager neuralDataManager;
	
	private int predictionSize = 60;
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
	public Integer getPredictionSize() {
		return predictionSize;
	}

	/**
	 * @param predictionSize the predictionInterval to set
	 */
	public void setPredictionSize(Integer predictionSize) {
		this.predictionSize = predictionSize;
	}

	/**
	 * @return the neuralService
	 */
	public NeuralService getNeuralService() {
		return neuralService;
	}
	public void setNeuralService(NeuralService neuralService){
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

	/**
	 * @return the neuralDataManager
	 */
	public NeuralDataManager getNeuralDataManager() {
		return neuralDataManager;
	}

	/**
	 * @param neuralDataManager the neuralDataManager to set
	 */
	public void setNeuralDataManager(NeuralDataManager neuralDataManager) {
		this.neuralDataManager = neuralDataManager;
	}

}
