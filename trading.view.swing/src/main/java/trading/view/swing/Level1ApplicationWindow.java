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
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Level1ApplicationWindow implements MarketListener<Level1> {

	private JFrame frame;
	private Adapter adapter;
	private HistoryProvider historyProvider;
	private RealTimeProvider realTimeProvider;
	private JComboBox<Instrument> instrumentComboBox;
	private final Action connectAction = new ConnectAction();
	private final Action listenAction = new CaptureAction();
	private final Action historyAction = new HistoryAction();
	private Level1ApplicationWindow windowInstance = this;
	private Level1Chart level1Chart;

	/**
	 * Launch the application. For test only
	 */
	public static void run(final Adapter a, final RealTimeProvider rp,
			final HistoryProvider hp) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Level1ApplicationWindow window = new Level1ApplicationWindow(
							a, rp, hp);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Ctor
	 */
	public Level1ApplicationWindow(Adapter a, RealTimeProvider rp,
			HistoryProvider hp) {
		adapter = a;
		historyProvider = hp;
		realTimeProvider = rp;
		realTimeProvider
				.addInstrumentListener(new MarketListener<Instrument>() {
					@Override
					public void OnMarketDataChanged(Instrument entity) {
						instrumentComboBox.addItem(entity);
					}
				});
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
				List<Instrument> instruments = historyProvider
						.findInstrumentAll();
				ComboBoxModel<Instrument> model = new DefaultComboBoxModel(
						instruments.toArray());
				instrumentComboBox.setModel(model);
				level1Chart.setTitle(instrumentComboBox.getSelectedItem().toString());
			}
		});
		frame.setTitle("Level1"); //$NON-NLS-1$ //$NON-NLS-2$
		frame.setBounds(100, 100, 1024, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		level1Chart = new Level1Chart("No instrument selected");
		level1Chart.setTitle("");
		frame.getContentPane().add(level1Chart, BorderLayout.CENTER);

		JPanel controlPanel = new JPanel();
		frame.getContentPane().add(controlPanel, BorderLayout.NORTH);
		// Connect button
		JToggleButton connectButton = new JToggleButton("Connect");
		connectButton.setHorizontalAlignment(SwingConstants.LEFT);
		connectButton.setAction(connectAction);

		// Instrument selector combo
		instrumentComboBox = new JComboBox<Instrument>();

		JButton historyButton = new JButton("History");
		historyButton.setAction(historyAction);

		JToggleButton listenButon = new JToggleButton("Listen");
		listenButon.setAction(listenAction);
		controlPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		controlPanel.add(connectButton);
		controlPanel.add(instrumentComboBox);
		controlPanel.add(historyButton);
		controlPanel.add(listenButon);
		instrumentComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Set caption to selected instrument
				JComboBox<Instrument> source = (JComboBox<Instrument>) e
						.getSource();
				Instrument instrument = (Instrument) source.getSelectedItem();
				level1Chart.setTitle(instrument.toString());
			}
		});
	}


	/**
	 * Returns current instrument
	 * @return
	 */
	private Instrument getInstrument(){
		Instrument selectedInstrument = (Instrument) instrumentComboBox
				.getSelectedItem();
		return selectedInstrument;
	}
	/**
	 * Connect to data provider
	 * @author dimaString title
	 */
	private class ConnectAction extends AbstractAction {
		public ConnectAction() {
			putValue(NAME, "Connect");
			putValue(SHORT_DESCRIPTION, "Connect to data provider");
		}

		public void actionPerformed(ActionEvent e) {
			AbstractButton source = (AbstractButton) e.getSource();
			if (source.isSelected()) {
				putValue(NAME, "Connected");
				adapter.connect();
			} else {
				putValue(NAME, "Connect");
				adapter.disconnect();
			}
		}
	}

	/**
	 * Capture real time data action
	 */
	private class CaptureAction extends AbstractAction {
		public CaptureAction() {
			putValue(NAME, "Listen");
			putValue(SHORT_DESCRIPTION, "Listen market data");
		}

		public void actionPerformed(ActionEvent e) {
			AbstractButton source = (AbstractButton) e.getSource();
			if (source.isSelected()) {
				putValue(NAME, "Capturing");
				historyAction.setEnabled(false);
				Instrument selectedInstrument = getInstrument();
				instrumentComboBox.setEnabled(false);
				level1Chart.clear();
				
				realTimeProvider.addLevel1Listener(selectedInstrument.getId(),
						windowInstance);

			} else {
				putValue(NAME, "Capture");
				Instrument selectedInstrument = (Instrument) instrumentComboBox
						.getSelectedItem();
				realTimeProvider.removeLevel1Listener(
						selectedInstrument.getId(), windowInstance);
				instrumentComboBox.setEnabled(true);
				historyAction.setEnabled(true);
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

		public void actionPerformed(ActionEvent e) {
			level1Chart.clear();
			// Load history
			List<Level1> data = historyProvider.findLevel1Last(getInstrument().getId(), level1Chart.getMaxItemCount());
			level1Chart.addLevel1(data);
		}
	}	

	/**
	 * Level1 changed event
	 */
	@Override
	public void OnMarketDataChanged(Level1 level1) {
		level1Chart.addLevel1(level1);

	}

}
