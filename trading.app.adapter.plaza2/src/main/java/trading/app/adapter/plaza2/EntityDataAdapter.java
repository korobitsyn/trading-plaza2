package trading.app.adapter.plaza2;


/**
 * Interface for adapter to specific entity data
 * Example: Level1Adapter, level1 is a data for an Instrument
 * Can have listeners for specific instruments
 * @author dima
 *
 */
public interface EntityDataAdapter<T> {

	/**
	 * Add listener
	 * @param parentEntityId id of parent entity, example: instrument id for level1 listener
	 * @param marketlistener
	 */
	public void addMarketListener(int parentEntityId, MarketListener<T> listener);

	/**
	 * Remove listener
	 * @param parentEntityId id of parent entity, example: instrument id for level1 listener
	 * @param listener
	 */
	public void removeMarketListener(int parentEntityId, MarketListener<T> listener);

	/**
	 * Notify all listeners of specific parent entity, example: notify all listeners of RTS futures instrument
	 * @param entity
	 */
	public void fireMarketDataChangedEvent(int parentEntityId, T entity);
	
}