package trading.app.adapter.plaza2;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import ru.micexrts.cgate.messages.AbstractDataMessage;

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