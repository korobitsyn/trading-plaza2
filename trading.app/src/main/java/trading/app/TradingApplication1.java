package trading.app;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import trading.app.adapter.plaza2.Adapter;
import trading.app.adapter.plaza2.Plaza2Adapter;
import trading.app.provider.HistoryProvider;
import trading.data.model.Level1;

/**
 * Main application class for debugging under JavaSE
 * @author dima
 *
 */
public class TradingApplication1 {
	/**
	 * Get history from plaza 2
	 * @param adapter
	 */
	protected static void getHistory(Adapter adapter){
		HistoryProvider historyProvider = new HistoryProvider();
		Calendar startCal = GregorianCalendar.getInstance();
		startCal.set(Calendar.YEAR, 2010);
		
		Calendar endCal = GregorianCalendar.getInstance();
		endCal.set(Calendar.YEAR, 2014);
	
		
		Date startTime = startCal.getTime();
		Date endTime = endCal.getTime();

		List<Level1> range = historyProvider.getLevel1Range(startTime, endTime);		
	}
	
	/**
	 * Write data from adapter to history
	 * @param adapter
	 * @throws IOException 
	 */
	protected static void writeHistory(Adapter adapter) throws IOException{
		HistoryWriter historyWriter = new HistoryWriter(adapter);
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
		// Create adapter
		System.out.println("Creating adapter");
		Adapter adapter = new Plaza2Adapter();
		writeHistory(adapter);
		
	}	
}
