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
public class TradingApplication1 {
	// Spring application context
	static GenericXmlApplicationContext ctx;
	
	private Adapter adapter;
	private RealTimeProvider realTimeProvider;
	private HistoryProvider historyProvider;
	private HistoryWriter historyWriter;
	

	/**
	 * @return the realTimeProvider
	 */
	public RealTimeProvider getRealTimeProvider() {
		return realTimeProvider;
	}

	/**
	 * @param realTimeProvider the realTimeProvider to set
	 */
	public void setRealTimeProvider(RealTimeProvider realTimeProvider) {
		this.realTimeProvider = realTimeProvider;
	}

	/**
	 * @return the historyWriter
	 */
	public HistoryWriter getHistoryWriter() {
		return historyWriter;
	}

	/**
	 * @param historyWriter the historyWriter to set
	 */
	public void setHistoryWriter(HistoryWriter historyWriter) {
		this.historyWriter = historyWriter;
	}

	/**
	 * @return market adapter
	 */
	public Adapter getAdapter() {
		return adapter;
	}

	/**
	 * @param adapter the adapter to set
	 */
	public void setAdapter(Adapter adapter) {
		this.adapter = adapter;
	}

	/**
	 * @return the historyProvider
	 */
	public HistoryProvider getHistoryProvider() {
		return historyProvider;
	}

	/**
	 * @param historyProvider the historyProvider to set
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

		List<Level1> range = historyProvider.getLevel1Range(startTime, endTime);		
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
		writeHistory();
	}
}
