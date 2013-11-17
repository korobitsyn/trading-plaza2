package trading.app;

import java.awt.EventQueue;
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
import trading.view.swing.Level1ApplicationWindow;

/**
 * Main application class for debugging under JavaSE
 * @author dima
 *
 */
public class TradingApplication1  {
	// Spring application context
	static GenericXmlApplicationContext ctx;
	private TradingApplicationContext applicationContext;
	
	/**
	 * @return the applicationContext
	 */
	public TradingApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * @param applicationContext the applicationContext to set
	 */
	public void setApplicationContext(TradingApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
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
		Level1ApplicationWindow.run(applicationContext.getAdapter(), applicationContext.getRealTimeProvider(), applicationContext.getHistoryProvider(), applicationContext.getHistoryWriter());
		
		
		//readHistory();
		//writeHistory();
	}
}
