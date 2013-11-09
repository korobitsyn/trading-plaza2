package trading.app;

import java.io.IOException;
import trading.app.adapter.plaza2.Plaza2Adapter;

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
		Plaza2Adapter adapter = new Plaza2Adapter();
		// Connect to plaza2 gate
		System.out.println("Connecting");
		adapter.connect();
		// Waiting user input to finish
		System.out.println("Press any key to finish");
		System.in.read();
		// Disconnect from gate (async)
		System.out.println("Disconnecting");
		adapter.disconnect();
		System.out.println("Complete");
		//
	}	

}
