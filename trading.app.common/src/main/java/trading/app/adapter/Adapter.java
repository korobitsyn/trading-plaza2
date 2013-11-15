package trading.app.adapter;

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

	

}