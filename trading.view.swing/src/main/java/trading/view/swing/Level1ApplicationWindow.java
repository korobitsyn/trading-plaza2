package trading.view.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;

import trading.app.adapter.Adapter;
import trading.app.history.HistoryProvider;
import trading.app.realtime.RealTimeProvider;

import java.util.ResourceBundle;

import javax.swing.JToolBar;

import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.JToggleButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Level1ApplicationWindow {

	private JFrame frame;
	private Adapter adapter;
	private HistoryProvider historyProvider;
	private RealTimeProvider realTimeProvider;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	}*/
	public static void run(final Adapter a, final RealTimeProvider rp, final HistoryProvider hp){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Level1ApplicationWindow window = new Level1ApplicationWindow(a, rp, hp);
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
	/*public Level1ApplicationWindow() {
		initialize();
	}*/
	
	public Level1ApplicationWindow(Adapter a, RealTimeProvider rp, HistoryProvider hp){
		adapter = a;
		historyProvider = hp;
		realTimeProvider = rp;
		initialize();

		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle(ResourceBundle.getBundle("trading.view.swing.messages").getString("Level1WindowTitle")); //$NON-NLS-1$ //$NON-NLS-2$
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JToggleButton connectButton = new JToggleButton(ResourceBundle.getBundle("trading.view.swing.messages").getString("Level1ApplicationWindow.Connectbutton.connectText")); //$NON-NLS-1$ //$NON-NLS-2$
		connectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JToggleButton source =  (JToggleButton) e.getSource();
				if(source.isSelected()){
					adapter.connect();
				} else{
					adapter.disconnect();
				}
					
			}
		});
		toolBar.add(connectButton);
		
		JComboBox instrumentComboBox = new JComboBox();
		toolBar.add(instrumentComboBox);
		
		JToggleButton captureButon = new JToggleButton(ResourceBundle.getBundle("trading.view.swing.messages").getString("Level1Window.captureButton.text")); //$NON-NLS-1$ //$NON-NLS-2$
		toolBar.add(captureButon);
	}

}
