package trading.app.adapter;

import trading.app.realtime.MarketListener;

/**
 * Interface for adapter to specific entity like Instrument etc
 * @author dima
 *
 */
public interface EntityAdapter<T> {
	/**
	 * Add listener
	 * @param marketlistener
	 */
	public void addMarketListener(MarketListener<T> listener);
	/**
	 * Remove listener
	 * @param listener
	 */
	public void removeMarketListener(MarketListener<T> listener);
	/**
	 * Notify all listeners
	 * @param entity
	 */
	public void fireMarketDataChangedEvent(T entity);
	
}