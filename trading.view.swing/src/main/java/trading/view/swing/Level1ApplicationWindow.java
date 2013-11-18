package trading.view.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import org.springframework.context.support.GenericXmlApplicationContext;

//import trading.app.TradingApplication1;
import trading.app.TradingApplicationContext;
import trading.app.realtime.MarketListener;
import trading.data.model.Instrument;
import trading.data.model.Level1;

public class Level1ApplicationWindow implements MarketListener<Level1> {
	// Spring application context
	static GenericXmlApplicationContext ctx;	
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
		final Level1ApplicationWindow appWindow = ctx.getBean(Level1ApplicationWindow.class);
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					//Level1ApplicationWindow window = new Level1ApplicationWindow(context);
					appWindow.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}	
	
	/**
	 * Capture real time data action
	 */
	private class CaptureAction extends AbstractAction {
		public CaptureAction() {
			putValue(NAME, "Listen");
			putValue(SHORT_DESCRIPTION, "Listen market data");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			AbstractButton source = (AbstractButton) e.getSource();
			if (source.isSelected()) {
				historyAction.setEnabled(false);
				Instrument selectedInstrument = getInstrument();
				instrumentComboBox.setEnabled(false);
				level1Chart.clear();

				tradingApplicationContext.getRealTimeProvider().addLevel1Listener(selectedInstrument.getId(),
						windowInstance);

			} else {
				Instrument selectedInstrument = (Instrument) instrumentComboBox
						.getSelectedItem();
				tradingApplicationContext.getRealTimeProvider().removeLevel1Listener(
						selectedInstrument.getId(), windowInstance);
				instrumentComboBox.setEnabled(true);
				historyAction.setEnabled(true);
			}
		}
	}
	/**
	 * Connect to data provider
	 * 
	 * @author dimaString title
	 */
	private class ConnectAction extends AbstractAction {
		public ConnectAction() {
			putValue(NAME, "Connect");
			putValue(SHORT_DESCRIPTION, "Connect to data provider");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			AbstractButton source = (AbstractButton) e.getSource();
			if (source.isSelected()) {
				tradingApplicationContext.getAdapter().connect();
			} else {
				tradingApplicationContext.getAdapter().disconnect();
			}
		}
	}
	/**
	 * Load history from data provider
	 * 
	 * @author dima
	 * 
	 */
	private class HistoryAction extends AbstractAction {
		public HistoryAction() {
			putValue(NAME, "Load history");
			putValue(SHORT_DESCRIPTION, "Loads history");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			level1Chart.clear();
			// Load history
			List<Level1> data = tradingApplicationContext.getHistoryProvider().findLevel1Last(getInstrument()
					.getId(), level1Chart.getMaxItemCount());
			level1Chart.addLevel1(data);
		}
	}
	/**
	 * Launch the application. For test only
	 */
	public static void run(final TradingApplicationContext context) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Level1ApplicationWindow window = new Level1ApplicationWindow(context);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private Level1ApplicationWindow windowInstance = this;
	private Level1Chart level1Chart;
	private JComboBox<Instrument> instrumentComboBox;
	private JFrame frame;

	private TradingApplicationContext tradingApplicationContext;
	
	private final Action connectAction = new ConnectAction();
	private final Action listenAction = new CaptureAction();
	private final Action historyAction = new HistoryAction();
	private boolean isWriteEnabled = true;

	public Level1ApplicationWindow(){
		
	}
	
	/**
	 * Ctor
	 * @param context Trading application context
	 */
	public Level1ApplicationWindow(TradingApplicationContext context) {
		tradingApplicationContext = context;
		// Listen instrument info
		tradingApplicationContext.getRealTimeProvider()
				.addInstrumentListener(new MarketListener<Instrument>() {
					@Override
					public void OnMarketDataChanged(Instrument entity) {
						instrumentComboBox.addItem(entity);
					}
				});
		// Standard initialization call
		initialize();
	}

	/**
	 * Returns current instrument
	 * 
	 * @return
	 */
	private Instrument getInstrument() {
		Instrument selectedInstrument = (Instrument) instrumentComboBox
				.getSelectedItem();
		return selectedInstrument;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				List<Instrument> instruments = tradingApplicationContext.getHistoryProvider()
						.findInstrumentAll();
				ComboBoxModel<Instrument> model = new DefaultComboBoxModel(
						instruments.toArray());
				instrumentComboBox.setModel(model);
				level1Chart.setTitle(instrumentComboBox.getSelectedItem()
						.toString());
			}
		});
		frame.setTitle("Level1"); //$NON-NLS-1$ 
		frame.setBounds(100, 100, 1024, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Main chart
		level1Chart = new Level1Chart("No instrument selected");
		level1Chart.setTitle("");
		frame.getContentPane().add(level1Chart, BorderLayout.CENTER);

		JPanel controlPanel = new JPanel();
		frame.getContentPane().add(controlPanel, BorderLayout.NORTH);

		// Connect to provider button 
		JToggleButton connectButton = new JToggleButton("Connect");
		connectButton.setToolTipText("Connect to data provider");
		connectButton.setHorizontalAlignment(SwingConstants.LEFT);
		connectButton.setAction(connectAction);

		// Instrument selector combo
		instrumentComboBox = new JComboBox<Instrument>();
		instrumentComboBox.setToolTipText("Select instrument to work with");
		instrumentComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Set caption to selected instrument
				JComboBox<Instrument> source = (JComboBox<Instrument>) e
						.getSource();
				Instrument instrument = (Instrument) source.getSelectedItem();
				level1Chart.setTitle(instrument.toString());
				// Add to history writer
				tradingApplicationContext.getHistoryWriter().getInstrumentIds().clear();
				tradingApplicationContext.getHistoryWriter().getInstrumentIds().add(
						new Integer(instrument.getId()));
			}
		});
		// Load history button
		JButton historyButton = new JButton("History");
		historyButton.setToolTipText("Load history from database");
		historyButton.setAction(historyAction);

		// Listen market button
		JToggleButton listenButon = new JToggleButton("Listen");
		listenButon.setToolTipText("Capture real time data from market");
		listenButon.setAction(listenAction);
		controlPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		controlPanel.add(connectButton);
		controlPanel.add(instrumentComboBox);
		controlPanel.add(historyButton);
		controlPanel.add(listenButon);

		// History write checkbox
		JCheckBox writeHistoryCheckBox = new JCheckBox("Write history");
		writeHistoryCheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Enable/disable history writer
				JCheckBox source = (JCheckBox) e.getSource();
				isWriteEnabled = source.isSelected();
				tradingApplicationContext.getHistoryWriter().setEnabled(isWriteEnabled);
			}
		});
		writeHistoryCheckBox.setToolTipText("Write to database when listening");
		writeHistoryCheckBox.setSelected(true);
		controlPanel.add(writeHistoryCheckBox);
	}

	/**
	 * Level1 changed event
	 */
	@Override
	public void OnMarketDataChanged(Level1 level1) {
		// Add prices to chart
		level1Chart.addLevel1(level1);
	}

}
