package trading.app.adapter.plaza2;

import trading.data.model.Instrument;
import trading.data.model.Level1;

/**
 * Adapter interface
 * @author dima
 *
 */
public interface Adapter  {

	/**
	 * Connect to gate
	 */
	public abstract void connect();

	/**
	 * Disconnect from gate
	 */
	public abstract void disconnect();

	/**
	 * Get specific adapter for instrument, level1 etc
	 * @return
	 */
	public abstract EntityAdapter<Instrument> getInstrumentAdapter();
	/**
	 * Get specific adapter for level1
	 * @return
	 */
	public abstract EntityDataAdapter<Level1> getLevel1Adapter(); 	

}