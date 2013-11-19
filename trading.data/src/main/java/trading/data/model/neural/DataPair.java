package trading.data.model.neural;

/**
 * Input and output data pair for neural network
 * @author pdg
 *
 */
public class DataPair {
	private InputEntity inputEntity;
	private OutputEntity outputEntity;
	/**
	 * @return the inputEntity
	 */
	public InputEntity getInputEntity() {
		return inputEntity;
	}
	/**
	 * @param inputEntity the inputEntity to set
	 */
	public void setInputEntity(InputEntity inputEntity) {
		this.inputEntity = inputEntity;
	}
	/**
	 * @return the outputEntity
	 */
	public OutputEntity getOutputEntity() {
		return outputEntity;
	}
	/**
	 * @param outputEntity the outputEntity to set
	 */
	public void setOutputEntity(OutputEntity outputEntity) {
		this.outputEntity = outputEntity;
	}

}
