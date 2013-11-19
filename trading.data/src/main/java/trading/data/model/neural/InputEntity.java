package trading.data.model.neural;

import java.util.ArrayList;
import java.util.List;

import trading.data.model.Level1;

/**
 * Input to neural network
 * @author pdg
 *
 */
public class InputEntity {
	private List<Level1> leve1List = new ArrayList<Level1>();

	/**
	 * @return the leve1List
	 */
	public List<Level1> getLeve1List() {
		return leve1List;
	}

	/**
	 * @param leve1List the leve1List to set
	 */
	public void setLeve1List(List<Level1> leve1List) {
		this.leve1List = leve1List;
	}
}
