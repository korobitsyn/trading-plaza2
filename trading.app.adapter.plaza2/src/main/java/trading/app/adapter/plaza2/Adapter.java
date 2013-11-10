package trading.app.adapter.plaza2;

import java.util.Observable;

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
	public abstract SpecificAdapter getInstrumentAdapter();

}