package trading.view.swing;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JProgressBar;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.SpringLayout;

import trading.app.history.HistoryProvider;
import trading.app.neural.NeuralContext;
import trading.app.neural.TrainingContext;
import trading.app.neural.events.TrainIterationCompletedEvent;
import trading.data.model.Instrument;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.event.ListDataListener;

import com.google.common.eventbus.Subscribe;

import javax.swing.JFormattedTextField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class LearnPanel extends JPanel {
	private NeuralContext neuralContext;
	private final JProgressBar learnProgressBar;
	private final JLabel lblEpoch;
	private final JLabel lblLastEpochTime;
	private final JLabel lblTotalTime;
	private final JComboBox instrumentComboBox;
	JButton learnButton;
	private final JFormattedTextField txtMaxEpochCount;
	private JLabel lblLastError;
	private JFreeChart errorChart;
	private XYSeries errorXYSeries;

	/**
	 * Create the panel.
	 * 
	 * @param context
	 *            Neural network context to work with
	 */
	public LearnPanel(NeuralContext context) {

		this.neuralContext = context;
		this.neuralContext.getNeuralService().getEventBus().register(this);

		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);

		learnProgressBar = new JProgressBar();
		springLayout.putConstraint(SpringLayout.NORTH, learnProgressBar, 75,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, learnProgressBar, 12,
				SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, learnProgressBar, -162,
				SpringLayout.EAST, this);
		add(learnProgressBar);

		learnButton = new JButton("Learn");
		springLayout.putConstraint(SpringLayout.NORTH, learnButton, 70,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, learnButton, -125,
				SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, learnButton, 100,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, learnButton, -27,
				SpringLayout.EAST, this);
		learnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trainNetwork();
			}
		});
		add(learnButton);

		lblEpoch = new JLabel("Epoch 0 of 0");
		springLayout.putConstraint(SpringLayout.NORTH, lblEpoch, 29,
				SpringLayout.SOUTH, learnProgressBar);
		springLayout.putConstraint(SpringLayout.WEST, lblEpoch, 10,
				SpringLayout.WEST, this);
		add(lblEpoch);

		lblLastEpochTime = new JLabel("Last epoch: 0 ms");
		springLayout.putConstraint(SpringLayout.NORTH, lblLastEpochTime, 0,
				SpringLayout.NORTH, lblEpoch);
		springLayout.putConstraint(SpringLayout.WEST, lblLastEpochTime, 109,
				SpringLayout.EAST, lblEpoch);
		add(lblLastEpochTime);

		lblTotalTime = new JLabel("Total time: 0 sec");
		springLayout.putConstraint(SpringLayout.NORTH, lblTotalTime, 6,
				SpringLayout.SOUTH, lblEpoch);
		springLayout.putConstraint(SpringLayout.WEST, lblTotalTime, 0,
				SpringLayout.WEST, lblEpoch);
		add(lblTotalTime);

		instrumentComboBox = new JComboBox();
		springLayout.putConstraint(SpringLayout.SOUTH, instrumentComboBox, -6,
				SpringLayout.NORTH, learnProgressBar);
		instrumentComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (neuralContext != null) {
					Instrument instrument = (Instrument) instrumentComboBox
							.getSelectedItem();
					neuralContext.getTradingApplicationContext()
							.getInstrumentContext().setInstrument(instrument);
					updateView();
				}
			}
		});
		add(instrumentComboBox);

		JLabel lblInstrument = new JLabel("Instrument:");
		springLayout.putConstraint(SpringLayout.WEST, instrumentComboBox, 7,
				SpringLayout.EAST, lblInstrument);
		springLayout.putConstraint(SpringLayout.NORTH, lblInstrument, 5,
				SpringLayout.NORTH, instrumentComboBox);
		springLayout.putConstraint(SpringLayout.EAST, lblInstrument, 0,
				SpringLayout.EAST, lblEpoch);
		add(lblInstrument);

		txtMaxEpochCount = new JFormattedTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtMaxEpochCount, 27,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, txtMaxEpochCount, -225,
				SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.EAST, txtMaxEpochCount, -186,
				SpringLayout.EAST, this);
		txtMaxEpochCount.setText("10");
		add(txtMaxEpochCount);

		JLabel lblEpochCount = new JLabel("Epoch count");
		springLayout.putConstraint(SpringLayout.NORTH, lblEpochCount, 0,
				SpringLayout.NORTH, txtMaxEpochCount);
		springLayout.putConstraint(SpringLayout.EAST, lblEpochCount, -11,
				SpringLayout.WEST, txtMaxEpochCount);
		add(lblEpochCount);

		lblLastError = new JLabel("Last error: 0");
		springLayout.putConstraint(SpringLayout.NORTH, lblLastError, 6,
				SpringLayout.SOUTH, lblTotalTime);
		springLayout.putConstraint(SpringLayout.WEST, lblLastError, 10,
				SpringLayout.WEST, this);
		add(lblLastError);
		// Chart creation
		createChart();
		// ChartPanel
		ChartPanel chartPanel = new ChartPanel(errorChart);
		springLayout.putConstraint(SpringLayout.NORTH, chartPanel, 200,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, chartPanel, 0,
				SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, chartPanel, 0,
				SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, chartPanel, 0,
				SpringLayout.EAST, this);
		add(chartPanel);
		initInstrumentComboBox();

		updateView();

	}

	/**
	 * Init JFreeChart
	 */
	private void createChart() {
		// Create dataset and series
		TableXYDataset ds = new DefaultTableXYDataset();
		XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
		errorXYSeries = new XYSeries("Error");
		xySeriesCollection.addSeries(errorXYSeries);

		// Create chart
		errorChart = ChartFactory.createXYLineChart("Error value", "Epoch",
				"Error, %", xySeriesCollection, PlotOrientation.VERTICAL, true,
				true, true);
		XYPlot plot = (XYPlot) errorChart.getPlot();
		plot.getRangeAxis().setAutoRange(true);
		plot.getDomainAxis().setRange(1,
				neuralContext.getTrainingContext().getMaxEpochCount());

	}

	/**
	 * Do neural network training
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private void trainNetwork() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				// Run training thread
				resetTrainingContext();
				neuralContext.getNeuralService().trainNetwork();

			}
		}).start();
		;

	}

	/**
	 * Initiate instrument combo box
	 */
	private void initInstrumentComboBox() {
		if (neuralContext == null) {
			return;
		}
		// Load instruments from data
		HistoryProvider history = neuralContext.getTradingApplicationContext()
				.getHistoryProvider();
		List<Instrument> instruments = history.findInstrumentAll();
		// Add instruments to combo box
		ComboBoxModel<Instrument> model = new DefaultComboBoxModel<Instrument>(
				instruments.toArray(new Instrument[] {}));
		instrumentComboBox.setModel(model);
		if (instrumentComboBox.getModel().getSize() > 0) {
			instrumentComboBox.setSelectedIndex(0);
		}
	}

	/**
	 * Update view from context
	 */
	private void updateView() {
		if (neuralContext == null) {
			return;
		}
		TrainingContext context = neuralContext.getTrainingContext();
		// Update progress bar
		learnProgressBar.setMaximum(context.getMaxEpochCount());
		learnProgressBar.setValue(context.getLastEpoch());
		// Labels
		lblEpoch.setText(String.format("Epoch %d of %d",
				context.getLastEpoch(), context.getMaxEpochCount()));
		lblLastEpochTime.setText(String.format("Last epoch: %f sec ", new Long(
				context.getLastEpochMilliseconds()).doubleValue() / 1000));
		lblTotalTime.setText(String.format("Total time: %f sec", new Long(
				context.getTrainMilliseconds()).doubleValue()));

		lblLastError.setText(String.format("Last error: %f %%",
				new Double(context.getLastError()/0.01)));

		// Enable learn button if instrument is set
		learnButton.setEnabled(neuralContext.getTradingApplicationContext()
				.getInstrumentContext().getInstrument() != null);
	}

	/**
	 * Reset context
	 */
	private void resetTrainingContext() {
		TrainingContext context = neuralContext.getTrainingContext();
		context.setLastEpoch(0);
		context.setLastEpochMilliseconds(0);
		context.setTrainMilliseconds(0);
		errorXYSeries.clear();
		Integer maxEpochCount = Integer.valueOf(txtMaxEpochCount.getText());
		neuralContext.getTrainingContext().setMaxEpochCount(maxEpochCount);
		updateView();
	}

	@Subscribe
	public void onTrainIterationCompleted(TrainIterationCompletedEvent event) {
		updateView();
		errorXYSeries.add(errorXYSeries.getItemCount() + 1,
				event.getLastError()/0.01);
	}
}
