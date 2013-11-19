package trading.app;

import java.util.ArrayList;
import java.util.List;

import trading.data.model.Instrument;
import trading.data.model.Level1;

/**
 * One instrument context
 * @author pdg
 *
 */
public class InstrumentContext {
	private Instrument instrument;
	private List<Level1> level1Data = new ArrayList<Level1>();
	/**
	 * @return the instrument
	 */
	public Instrument getInstrument() {
		return instrument;
	}
	/**
	 * @param instrument the instrument to set
	 */
	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}
	/**
	 * @return the level1Data for the instrumenbt
	 */
	public List<Level1> getLevel1Data() {
		return level1Data;
	}
	/**
	 * @param level1Data the level1Data for instrument to set
	 */
	public void setLevel1Data(List<Level1> level1Data) {
		this.level1Data = level1Data;
	}
}
