package trading.app.history;

import trading.app.realtime.RealTimeProvider;

/**
 * History writer to persistence layer
 * @author pdg
 *
 */
public interface HistoryWriter {

	/**
	 * @return the provider
	 */
	public abstract RealTimeProvider getRealTimeProvider();

	/**
	 * @param provider the provider to set
	 */
	public abstract void setRealTimeProvider(RealTimeProvider provider);

	/**
	 * Initialization
	 * 
	 * @param adapter
	 */
	public abstract void init();

}