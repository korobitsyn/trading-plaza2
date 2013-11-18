package trading.app.adapter;


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