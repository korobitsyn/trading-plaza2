package trading.view.swing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSplitPane;
import javax.swing.SpringLayout;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import trading.app.neural.NeuralContext;

/**
 * Test neural network view with charts
 * @author dima
 *
 */
public class TestPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private NeuralContext neuralContext;
	private final JButton testButton;
	private final JProgressBar progressBar;

	JFreeChart chartAbsolute;

	TimeSeries idealHighSeriesAbsolute;
	TimeSeries idealLowSeriesAbsolute;
	TimeSeries predictedHighSeriesAbsolute;
	TimeSeries predictedLowSeriesAbsolute;
	JFreeChart chartRelative;
	TimeSeries idealHighSeriesRelative;
	TimeSeries idealLowSeriesRelative;
	TimeSeries predictedHighSeriesRelative;
	TimeSeries predictedLowSeriesRelative;
	/**
	 * Create the panel.
	 */
	public TestPanel(NeuralContext context) {
		neuralContext = context;
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);

		testButton = new JButton("Test");
		testButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				testNetwork();
			}
		});
		springLayout.putConstraint(SpringLayout.EAST, testButton, -10,
				SpringLayout.EAST, this);
		add(testButton);

		progressBar = new JProgressBar();
		springLayout.putConstraint(SpringLayout.SOUTH, testButton, 0,
				SpringLayout.SOUTH, progressBar);
		springLayout.putConstraint(SpringLayout.NORTH, progressBar, 25,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, progressBar, 10,
				SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, progressBar, -100,
				SpringLayout.EAST, this);
		add(progressBar);

		JSplitPane chartsPanel = new JSplitPane();
		chartsPanel.setResizeWeight(0.5);
		chartsPanel.setOrientation(JSplitPane.VERTICAL_SPLIT);
		springLayout.putConstraint(SpringLayout.NORTH, chartsPanel, 60,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, chartsPanel, 0,
				SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, chartsPanel, 0,
				SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, chartsPanel, 0,
				SpringLayout.SOUTH, this);
		add(chartsPanel);

		// Init charts variables
		createChartAbsolute();
		createChartRelative();
		// Add charts to panels
		ChartPanel absoluteChartPanel = new ChartPanel(chartAbsolute);
		ChartPanel relativeChartPanel = new ChartPanel(chartRelative);
		chartsPanel.setTopComponent(absoluteChartPanel);
		chartsPanel.setBottomComponent(relativeChartPanel);

	}

	/**
	 * Init JFreeChart
	 */
	private void createChartAbsolute() {
		// Create dataset and series
		//TableXYDataset ds = new DefaultTableXYDataset();
		TimeSeriesCollection seriesCollection = new TimeSeriesCollection();
		idealHighSeriesAbsolute = new TimeSeries("Ideal High");
		idealLowSeriesAbsolute = new TimeSeries("Ideal Low");
		predictedHighSeriesAbsolute = new TimeSeries("Predicted High");
		predictedLowSeriesAbsolute = new TimeSeries("Predicted Low");
		seriesCollection.addSeries(idealHighSeriesAbsolute);
		seriesCollection.addSeries(idealLowSeriesAbsolute);
		seriesCollection.addSeries(predictedHighSeriesAbsolute);
		seriesCollection.addSeries(predictedLowSeriesAbsolute);
		// Create chartAbsolute
		// chartAbsolute = ChartFactory.createXYLineChart("Price values",
		// "Iteration", "Price", xySeriesCollection, PlotOrientation.VERTICAL,
		// true, true, true);
		chartAbsolute = ChartFactory.createTimeSeriesChart("Price values", // title
				"Iteration", // x-axis label
				"Price", // y-axis label
				seriesCollection, // data
				true, // create legend?
				true, // generate tooltips?
				false // generate URLs?
				);
		initChart(chartAbsolute);
	}

	/**
	 * Init JFreeChart
	 */
	private void createChartRelative() {
		// Create dataset and series
		//TableXYDataset ds = new DefaultTableXYDataset();
		TimeSeriesCollection seriesCollection = new TimeSeriesCollection();
		idealHighSeriesRelative = new TimeSeries("Ideal High");
		idealLowSeriesRelative = new TimeSeries("Ideal Low");
		predictedHighSeriesRelative = new TimeSeries("Predicted High");
		predictedLowSeriesRelative = new TimeSeries("Predicted Low");
		seriesCollection.addSeries(idealHighSeriesRelative);
		seriesCollection.addSeries(idealLowSeriesRelative);
		seriesCollection.addSeries(predictedHighSeriesRelative);
		seriesCollection.addSeries(predictedLowSeriesRelative);
		// Create chartAbsolute
		// chartRelative = ChartFactory.createXYLineChart("Price change %",
		// "Iteration", "Change %", xySeriesCollection,
		// PlotOrientation.VERTICAL, true, true, true);
		chartRelative = ChartFactory.createTimeSeriesChart("Price change %", // title
				"Iteration", // x-axis label
				"Change %", // y-axis label
				seriesCollection, // data
				true, // create legend?
				true, // generate tooltips?
				false // generate URLs?
				);
		initChart(chartRelative);

		// plot.getDomainAxis().setRange(1,
		// (double)NeuralContext.Test.getMaxIterationCount());
	}

	/**
	 * Initialization, common for both charts
	 * 
	 * @param chart
	 */
	private void initChart(JFreeChart chart) {
		XYPlot plot = (XYPlot) chart.getPlot();
		plot.getRangeAxis().setAutoRange(true);
		// Auto range
		NumberAxis valueAxis = (NumberAxis) plot.getRangeAxis();
		valueAxis.setAutoRangeIncludesZero(false);
		// Set line colors
		plot.getRenderer().setSeriesPaint(0, Color.GREEN);
		plot.getRenderer().setSeriesPaint(1, Color.GREEN);
		plot.getRenderer().setSeriesPaint(2, Color.BLUE);
		plot.getRenderer().setSeriesPaint(3, Color.BLUE);
	}

	/**
	 * Test neural network
	 */
	private void testNetwork() {
		// neuralContext.getNeuralService().Network();
	}

	/**
	 * Update view from context
	 */
	public void updateView() {
		testButton.setEnabled(neuralContext != null);
	}
}
