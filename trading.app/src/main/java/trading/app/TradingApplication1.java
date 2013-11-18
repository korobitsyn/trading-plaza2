package trading.app;

import java.io.IOException;

import org.springframework.context.support.GenericXmlApplicationContext;
//import trading.view.swing.Level1ApplicationWindow;

/**
 * Main application class for debugging under JavaSE
 * @author dima
 *
 */
public class TradingApplication1  {
	// Spring application context
	static GenericXmlApplicationContext ctx;
	private TradingApplicationContext tradingApplicationContext;
	
	/**
	 * @return the applicationContext
	 */
	public TradingApplicationContext getTradingApplicationContext() {
		return tradingApplicationContext;
	}

	/**
	 * @param applicationContext the applicationContext to set
	 */
	public void setTradingApplicationContext(TradingApplicationContext applicationContext) {
		this.tradingApplicationContext = applicationContext;
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
		//Level1ApplicationWindow.run(tradingApplicationContext);
	}
}
