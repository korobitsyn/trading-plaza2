/**
 * 
 */
package trading.app;

import trading.app.adapter.Adapter;
import trading.app.history.HistoryProvider;
import trading.app.history.HistoryWriter;
import trading.app.realtime.RealTimeProvider;

/**
 * @author dima
 * Trading application context class
 */
public class TradingApplicationContext {
	private Adapter adapter;
	private RealTimeProvider realTimeProvider;
	private HistoryProvider historyProvider;
	private HistoryWriter historyWriter;
	private InstrumentContext instrumentContext = new InstrumentContext();
	
	/**
	 * 
	 * @return current real time provider
	 */
	public RealTimeProvider getRealTimeProvider() {
		return realTimeProvider;
	}

	/**
	 * Set current real time provider
	 * @param realTimeProvider
	 */
	public void setRealTimeProvider(RealTimeProvider realTimeProvider) {
		this.realTimeProvider = realTimeProvider;
	}

	/**
	 * Current history writer
	 * @return
	 */
	public HistoryWriter getHistoryWriter() {
		return historyWriter;
	}

	/**
	 * Set current history writer
	 * @param historyWriter
	 */
	public void setHistoryWriter(HistoryWriter historyWriter) {
		this.historyWriter = historyWriter;
	}

	/**
	 * Current market adapter
	 * @return
	 */
	public Adapter getAdapter() {
		return adapter;
	}

	/**
	 * Set current market adapter
	 * @param adapter
	 */
	public void setAdapter(Adapter adapter) {
		this.adapter = adapter;
	}

	/**
	 * 
	 * @return current history provider
	 */
	public HistoryProvider getHistoryProvider() {
		return historyProvider;
	}

	/**
	 * Set current history provider
	 * @param historyProvider
	 */
	public void setHistoryProvider(HistoryProvider historyProvider) {
		this.historyProvider = historyProvider;
	}

	/**
	 * @return the instrumentContext
	 */
	public InstrumentContext getInstrumentContext() {
		return instrumentContext;
	}

	/**
	 * @param instrumentContext the instrumentContext to set
	 */
	public void setInstrumentContext(InstrumentContext instrumentContext) {
		this.instrumentContext = instrumentContext;
	}
}
