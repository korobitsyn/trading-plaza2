package trading.app.neural.events;

/**
 * Event of train iteration completion
 * @author dima
 *
 */
public class TrainIterationCompletedEvent {
    private int lastEpoch;
    private long lastEpochMilliseconds = 0;
    private long trainMilliseconds = 0;
    private double lastError = 0;

    /**
     * Constructor with all data needed
     * @param lastEpoch
     * @param lastEpochMilliseconds
     * @param trainMilliseconds
     */
    public TrainIterationCompletedEvent(int lastEpoch, long lastEpochMilliseconds, long trainMilliseconds, double lastError){
    	this.lastEpoch = lastEpoch;
    	this.lastEpochMilliseconds = lastEpochMilliseconds;
    	this.trainMilliseconds = trainMilliseconds;
    	this.lastError = lastError;
    }
	/**
	 * @return the lastEpochMilliseconds
	 */
	public long getLastEpochMilliseconds() {
		return lastEpochMilliseconds;
	}

	/**
	 * @return the lastEpoch
	 */
	public int getLastEpoch() {
		return lastEpoch;
	}

	/**
	 * @return the trainMilliseconds
	 */
	public long getTrainMilliseconds() {
		return trainMilliseconds;
	}
	/**
	 * @return the lastError
	 */
	public double getLastError() {
		return lastError;
	}
}
