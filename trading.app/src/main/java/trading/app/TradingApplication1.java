package trading.app;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import trading.app.adapter.plaza2.Adapter;
import trading.app.adapter.plaza2.Plaza2Adapter;
import trading.app.provider.HistoryProvider;

/**
 * Main application class for debugging under JavaSE
 * @author dima
 *
 */
public class TradingApplication1 {

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
		// test history writer
		//HistoryWriter historyWriter = new HistoryWriter(adapter);

		// Test history provider
		HistoryProvider historyProvider = new HistoryProvider();
		Date startTime = new Timestamp(System.currentTimeMillis()){{setYear(2010);}};
		startTime.setYear(2010);
		Date endTime = new Timestamp(System.currentTimeMillis()){{setYear(2014);}};
		endTime.setYear(2014);
		historyProvider.getLevel1Range(startTime, endTime);
		
		// Connect to plaza2 gate
		/*System.out.println("Connecting");
		adapter.connect();
		// Waiting user input to finish
		System.out.println("Press any key to finish");
		System.in.read();
		// Disconnect from gate (async)
		System.out.println("Disconnecting");
		adapter.disconnect();
		System.out.println("Complete");*/
		
		//
	}	
}
