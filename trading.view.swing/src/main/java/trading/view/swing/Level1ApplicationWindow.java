package trading.view.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;

import trading.app.history.HistoryProvider;
import trading.app.realtime.RealTimeProvider;

public class Level1ApplicationWindow {

	private JFrame frame;
	private HistoryProvider historyProvider;
	private RealTimeProvider realTimeProvider;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Level1ApplicationWindow window = new Level1ApplicationWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void run(final RealTimeProvider rp, final HistoryProvider hp){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Level1ApplicationWindow window = new Level1ApplicationWindow(rp, hp);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});		
	}
	
	/**
	 * Create the application.
	 */
	public Level1ApplicationWindow() {
		initialize();
	}
	
	public Level1ApplicationWindow(RealTimeProvider rp, HistoryProvider hp){
		this();
		historyProvider = hp;
		realTimeProvider = rp;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
