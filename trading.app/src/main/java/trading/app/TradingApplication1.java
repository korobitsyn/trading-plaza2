package trading.app;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import trading.app.adapter.Adapter;
import trading.app.history.HistoryProvider;
import trading.app.history.HistoryWriter;
import trading.app.realtime.RealTimeProvider;
import trading.data.model.Level1;

/**
 * Main application class for debugging under JavaSE
 * @author dima
 *
 */
public class TradingApplication1  {
	private int instrumentId = 193886;	
	// Spring application context
	static GenericXmlApplicationContext ctx;
	
	private Adapter adapter;
	private RealTimeProvider realTimeProvider;
	private HistoryProvider historyProvider;
	private HistoryWriter historyWriter;
	

	/* (non-Javadoc)
	 * @see trading.app.TradingApplication#getRealTimeProvider()
	 */
	public RealTimeProvider getRealTimeProvider() {
		return realTimeProvider;
	}

	/* (non-Javadoc)
	 * @see trading.app.TradingApplication#setRealTimeProvider(trading.app.realtime.RealTimeProvider)
	 */
	public void setRealTimeProvider(RealTimeProvider realTimeProvider) {
		this.realTimeProvider = realTimeProvider;
	}

	/* (non-Javadoc)
	 * @see trading.app.TradingApplication#getHistoryWriter()
	 */
	public HistoryWriter getHistoryWriter() {
		return historyWriter;
	}

	/* (non-Javadoc)
	 * @see trading.app.TradingApplication#setHistoryWriter(trading.app.history.HistoryWriter)
	 */
	public void setHistoryWriter(HistoryWriter historyWriter) {
		this.historyWriter = historyWriter;
	}

	/* (non-Javadoc)
	 * @see trading.app.TradingApplication#getAdapter()
	 */
	public Adapter getAdapter() {
		return adapter;
	}

	/* (non-Javadoc)
	 * @see trading.app.TradingApplication#setAdapter(trading.app.adapter.Adapter)
	 */
	public void setAdapter(Adapter adapter) {
		this.adapter = adapter;
	}

	/* (non-Javadoc)
	 * @see trading.app.TradingApplication#getHistoryProvider()
	 */
	public HistoryProvider getHistoryProvider() {
		return historyProvider;
	}

	/* (non-Javadoc)
	 * @see trading.app.TradingApplication#setHistoryProvider(trading.app.history.HistoryProvider)
	 */
	public void setHistoryProvider(HistoryProvider historyProvider) {
		this.historyProvider = historyProvider;
	}



	/**
	 * Get history from plaza 2
	 * @param adapter
	 */
	protected void readHistory(){
		//HistoryProvider historyProvider = new HibernateHistoryProvider();
		Calendar startCal = GregorianCalendar.getInstance();
		startCal.set(Calendar.YEAR, 2010);
		
		Calendar endCal = GregorianCalendar.getInstance();
		endCal.set(Calendar.YEAR, 2014);
	
		
		Date startTime = startCal.getTime();
		Date endTime = endCal.getTime();

		List<Level1> range = historyProvider.findLevel1Range(instrumentId,startTime, endTime);
		
		range=historyProvider.findLevel1Last(instrumentId,10);
		System.out.println(String.format("Found %d items", range.size()) );
	}
	
	/**
	 * Write data from adapter to history
	 * @param adapter
	 * @throws IOException 
	 */
	protected void writeHistory() throws IOException{
		adapter.connect();
		System.out.println("Press any key to finish");
		System.in.read();		
		System.out.println("Disconnecting");
		adapter.disconnect();
		System.out.println("Complete");
	}
	
	/**
	 * Main cycle for dev only
	 * ToDo: remove later
	 * @param args
	 * @throws InterruptedException
	 * @throws IOException 
	 */
	public static void main(String[] args) throws
			InterruptedException, IOException {
		// Spring initialization
		ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/application-context.xml");
		ctx.registerShutdownHook();
		ctx.refresh();
		// Run application
		TradingApplication1 app = ctx.getBean(TradingApplication1.class);
		app.run();	

		
	}	
	
	/**
	 * Main entrance
	 * @throws IOException 
	 */
	public void run() throws IOException{
		//readHistory();
		//writeHistory();
	}
}
