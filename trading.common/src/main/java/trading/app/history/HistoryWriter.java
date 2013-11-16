package trading.app.history;

import java.util.List;

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

	/**
	 * Whether data persisting allowed
	 * @return
	 */
	public abstract boolean isEnabled();
	
	/**
	 * Allow or deny data persisting
	 */
	public abstract void setEnabled(boolean isEnabled);

	/**
	 * List of instrument id to persist data for
	 * @return
	 */
	public abstract List<Integer> getInstrumentIds();

}