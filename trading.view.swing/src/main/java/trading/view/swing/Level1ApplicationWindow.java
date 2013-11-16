package trading.view.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;

import trading.app.adapter.Adapter;
import trading.app.history.HistoryProvider;
import trading.app.realtime.MarketListener;
import trading.app.realtime.RealTimeProvider;
import trading.data.model.Instrument;
import trading.data.model.Level1;

import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JToolBar;

import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.JToggleButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import javax.swing.Action;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Level1ApplicationWindow implements MarketListener<Level1>{

	private JFrame frame;
	private Adapter adapter;
	private HistoryProvider historyProvider;
	private RealTimeProvider realTimeProvider;
	private JComboBox<Instrument> instrumentComboBox;	
	private final Action connectAction = new ConnectAction();
	private final Action captureAction = new CaptureAction();
	private Level1ApplicationWindow windowInstance = this;

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
		realTimeProvider.addInstrumentListener(new MarketListener<Instrument>(){
			@Override
			public void OnMarketDataChanged(Instrument entity) {
				instrumentComboBox.addItem(entity);
			}});
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				List<Instrument> instruments = historyProvider.findInstrumentAll();
				ComboBoxModel<Instrument> model = new DefaultComboBoxModel(instruments.toArray());
				instrumentComboBox.setModel(model);
			}
		});
		frame.setTitle("Level1"); //$NON-NLS-1$ //$NON-NLS-2$
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		// Connect button
		JToggleButton connectButton = new JToggleButton("Connect"); //$NON-NLS-1$ //$NON-NLS-2$
		connectButton.setAction(connectAction);
		toolBar.add(connectButton);
		
		JSeparator separator = new JSeparator();
		toolBar.add(separator);
		
		instrumentComboBox = new JComboBox<Instrument>();
		toolBar.add(instrumentComboBox);
		
		JToggleButton captureButon = new JToggleButton("Capture"); //$NON-NLS-1$ //$NON-NLS-2$
		captureButon.setAction(captureAction);

		toolBar.add(captureButon);
	}
	
	/**
	 * Connect to data provider
	 * @author dima
	 *
	 */
	private class ConnectAction extends AbstractAction {
		public ConnectAction() {
			putValue(NAME, "Connect");
			putValue(SHORT_DESCRIPTION, "Connect to data provider");
		}
		public void actionPerformed(ActionEvent e) {
			AbstractButton source = (AbstractButton) e.getSource();
			if(source.isSelected()){
				putValue(NAME, "Connected");
				adapter.connect();
			} else{
				putValue(NAME, "Connect");				
				adapter.disconnect();
			}			
		}
	}
	private class CaptureAction extends AbstractAction {
		public CaptureAction() {
			putValue(NAME, "Capture");
			putValue(SHORT_DESCRIPTION, "Capture data");
		}
		public void actionPerformed(ActionEvent e) {
			AbstractButton source = (AbstractButton) e.getSource();
			if(source.isSelected()){
				putValue(NAME, "Capturing");
				Instrument selectedInstrument = (Instrument)instrumentComboBox.getSelectedItem();
				instrumentComboBox.setEnabled(false);
				realTimeProvider.addLevel1Listener(selectedInstrument.getId(),windowInstance);
				
			} else{
				putValue(NAME, "Capture");
				Instrument selectedInstrument = (Instrument)instrumentComboBox.getSelectedItem();
				realTimeProvider.removeLevel1Listener(selectedInstrument.getId(),windowInstance);
				instrumentComboBox.setEnabled(true);
			}				
		}
	}
	/**
	 * Level1 changed
	 */
	@Override
	public void OnMarketDataChanged(Level1 entity) {
		System.out.println(entity);
		
	}

}
