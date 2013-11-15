package trading.app.adapter;

import java.util.ArrayList;
import java.util.List;

import trading.app.realtime.MarketListener;

/**
 * Base entity adapter functionality
 * @author dima
 *
 */
public abstract class EntityAdapterBase<T> implements EntityAdapter<T> {

	// Listener list
	private List<MarketListener<T>> listeners = new ArrayList<MarketListener<T>>();
	
	/**
	 * Add listener
	 * @param marketlistener
	 */
	@Override
	public void addMarketListener(MarketListener<T> listener){
		listeners.add(listener);
	}
	/**
	 * Remove listener
	 * @param listener
	 */
	@Override
	public void removeMarketListener(MarketListener<T> listener){
		listeners.remove(listener);
	}
	/**
	 * Notify all listeners
	 * @param entity
	 */
	@Override
	public void fireMarketDataChangedEvent(T entity){
		for(MarketListener<T> listener: listeners){
			listener.OnMarketDataChanged(entity);
		}
	}
}
