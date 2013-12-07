package trading.app.neural.events;

import trading.data.model.Level1;

/**
 * Test iteration completed
 * @author dima
 *
 */
public class TestIterationCompletedEvent {
	private Level1 level1;
	private double idealHigh;
	private double predictedHigh;
	private double idealLow;
	private double predictedLow;
	private double error;
	private int iteration;
	
	/**
	 * @return the iteration
	 */
	public int getIteration() {
		return iteration;
	}

	/**
	 * Ctor with all params
	 * @param level1
	 * @param idealHigh
	 * @param idealLow
	 * @param predictedHigh
	 * @param predictedLow
	 */
	public TestIterationCompletedEvent(Level1 level1, int iteration, double predictedLow, double predictedHigh,  double idealLow, double idealHigh, double error){
		this.level1 = level1;
		this.iteration = iteration;
		this.idealHigh = idealHigh;
		this.idealLow = idealLow;
		this.predictedHigh = predictedHigh;
		this.predictedLow = predictedLow;
		this.error = error;
	}

	/**
	 * @return the idealHigh
	 */
	public double getIdealHigh() {
		return idealHigh;
	}
	/**
	 * @return the idealLow
	 */
	public double getIdealLow() {
		return idealLow;
	}
	/**
	 * @return the level1
	 */
	public Level1 getLevel1() {
		return level1;
	}
	/**
	 * @return the predictedHigh
	 */
	public double getPredictedHigh() {
		return predictedHigh;
	}
	
	/**
	 * @return the predictedLow
	 */
	public double getPredictedLow() {
		return predictedLow;
	}

	/**
	 * @return the error
	 */
	public double getError() {
		return error;
	}
}
