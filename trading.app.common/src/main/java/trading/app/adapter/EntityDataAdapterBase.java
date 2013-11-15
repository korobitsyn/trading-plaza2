package trading.app.adapter;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import trading.app.realtime.MarketListener;

/**
 * Base class for entity data like level1 of instrument
 * 
 * @author dima
 * 
 * @param <T>
 *            parent entity type
 */
public abstract class EntityDataAdapterBase<T> implements EntityDataAdapter<T> {
	/**
	 * All listeners map
	 */
	private Map<Integer, List<MarketListener<T>>> listenersByEntityId = new Hashtable<Integer, List<MarketListener<T>>>();

	/**
	 * Add listener for specific entity or instrument
	 */
	@Override
	public void addMarketListener(int parentEntityId, MarketListener<T> listener) {
		// Create record for this parent entity if empty
		if (!listenersByEntityId.containsKey(parentEntityId)) {
			listenersByEntityId.put(parentEntityId,
					new ArrayList<MarketListener<T>>());
		}
		// Now we can add the listener
		listenersByEntityId.get(parentEntityId).add(listener);
	}

	/**
	 * Remove listener for specific entity or instrument
	 */
	@Override
	public void removeMarketListener(int parentEntityId, MarketListener<T> listener) {
		if (listenersByEntityId.containsKey(parentEntityId)) {
			List<MarketListener<T>> entityListeners = listenersByEntityId
					.get(parentEntityId);
			// Remove listener
			entityListeners.remove(listener);
		}
	}

	/**
	 * Fire listener for specific entity or instrument
	 */
	@Override
	public void fireMarketDataChangedEvent(int parentEntityId, T entity) {
		List<MarketListener<T>> entityListeners = listenersByEntityId
				.get(parentEntityId);
		if (entityListeners != null) {
			for (MarketListener<T> listener : entityListeners) {
				// Fire event for one listener
				listener.OnMarketDataChanged(entity);
			}
		}

	}
}
