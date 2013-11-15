package trading.app.realtime;

/**
 * Class who listens adapter for market changes
 * @author dima
 *
 * @param <T>
 */
public interface MarketListener<T> {
	public void OnMarketDataChanged(T entity);
}
