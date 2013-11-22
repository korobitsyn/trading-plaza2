package trading.app.neural;

import org.encog.neural.networks.training.Train;

/**
 * @author pdg
 * Neural network training context
 */
public class TrainingContext {
    private int lastEpoch;
    private double lastError; 
    private int maxEpochCount = 10;
    private long lastEpochMilliseconds = 0;
    private int trainSamples = 10;
    private int predictionSamples = 10;
    private int trainStep = 1;
    
    private long trainMilliseconds = 0;
    private Train train;
    
	/**
	 * @return the lastEpoch
	 */
	public int getLastEpoch() {
		return lastEpoch;
	}
	/**
	 * @param lastEpoch the lastEpoch to set
	 */
	public void setLastEpoch(int lastEpoch) {
		this.lastEpoch = lastEpoch;
	}
	/**
	 * @return the lastError
	 */
	public double getLastError() {
		return lastError;
	}
	/**
	 * @param lastError the lastError to set
	 */
	public void setLastError(double lastError) {
		this.lastError = lastError;
	}
	/**
	 * @return the maxEpochCount
	 */
	public int getMaxEpochCount() {
		return maxEpochCount;
	}
	/**
	 * @param maxEpochCount the maxEpochCount to set
	 */
	public void setMaxEpochCount(int maxEpochCount) {
		this.maxEpochCount = maxEpochCount;
	}
	/**
	 * @return the lastEpochMilliseconds
	 */
	public long getLastEpochMilliseconds() {
		return lastEpochMilliseconds;
	}
	/**
	 * @param lastEpochMilliseconds the lastEpochMilliseconds to set
	 */
	public void setLastEpochMilliseconds(long lastEpochMilliseconds) {
		this.lastEpochMilliseconds = lastEpochMilliseconds;
	}

	/**
	 * @return the trainMilliseconds
	 */
	public long getTrainMilliseconds() {
		return trainMilliseconds;
	}
	/**
	 * @param trainMilliseconds the trainMilliseconds to set
	 */
	public void setTrainMilliseconds(long trainMilliseconds) {
		this.trainMilliseconds = trainMilliseconds;
	}
	/**
	 * @return the train
	 */
	public Train getTrain() {
		return train;
	}
	/**
	 * @param train the train to set
	 */
	public void setTrain(Train train) {
		this.train = train;
	}
	/**
	 * @return the trainSamples
	 */
	public Integer getTrainSamples() {
		return trainSamples;
	}
	/**
	 * @param trainSamples the trainSamples to set
	 */
	public void setTrainSamples(Integer trainSamples) {
		this.trainSamples = trainSamples;
	}
	/**
	 * @return the predictionSamples
	 */
	public Integer getPredictionSamples() {
		return predictionSamples;
	}
	/**
	 * @param predictionSamples the predictionSamples to set
	 */
	public void setPredictionSamples(Integer predictionSamples) {
		this.predictionSamples = predictionSamples;
	}
	/**
	 * @return the trainStep
	 */
	public Integer getTrainStep() {
		return trainStep;
	}
	/**
	 * @param trainStep the trainStep to set
	 */
	public void setTrainStep(Integer trainStep) {
		this.trainStep = trainStep;
	}
    
}
