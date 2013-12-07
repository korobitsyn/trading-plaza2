package trading.view.swing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.TimeSeriesDataItem;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.google.common.eventbus.Subscribe;

import trading.app.neural.NeuralContext;
import trading.app.neural.events.TestIterationCompletedEvent;
import javax.swing.JLabel;

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

	XYSeries idealHighSeriesAbsolute;
	XYSeries idealLowSeriesAbsolute;
	XYSeries predictedHighSeriesAbsolute;
	XYSeries predictedLowSeriesAbsolute;
	JFreeChart chartRelative;
	XYSeries idealHighSeriesRelative;
	XYSeries idealLowSeriesRelative;
	XYSeries predictedHighSeriesRelative;
	XYSeries predictedLowSeriesRelative;
	private final JLabel lblIteration;
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
		springLayout.putConstraint(SpringLayout.NORTH, chartsPanel, 89,
				SpringLayout.NORTH, this);
		chartsPanel.setResizeWeight(0.5);
		chartsPanel.setOrientation(JSplitPane.VERTICAL_SPLIT);
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
		
		// Attach to events
		neuralContext.getNeuralService().getEventBus().register(this);
		
		lblIteration = new JLabel("Test iteration:");
		springLayout.putConstraint(SpringLayout.NORTH, lblIteration, 6, SpringLayout.SOUTH, progressBar);
		springLayout.putConstraint(SpringLayout.WEST, lblIteration, 10, SpringLayout.WEST, this);
		add(lblIteration);

	}

	/**
	 * Init JFreeChart
	 */
	private void createChartAbsolute() {
		// Create dataset and series
		//TableXYDataset ds = new DefaultTableXYDataset();
		XYSeriesCollection seriesCollection = new XYSeriesCollection();
		idealHighSeriesAbsolute = new XYSeries("Ideal High");
		idealHighSeriesAbsolute.setMaximumItemCount(Constants.MAX_CHART_ITEM_C0UNT);

		idealLowSeriesAbsolute = new XYSeries("Ideal Low");
		idealLowSeriesAbsolute.setMaximumItemCount(Constants.MAX_CHART_ITEM_C0UNT);		

		predictedHighSeriesAbsolute = new XYSeries("Predicted High");
		predictedHighSeriesAbsolute.setMaximumItemCount(Constants.MAX_CHART_ITEM_C0UNT);		

		predictedLowSeriesAbsolute = new XYSeries("Predicted Low");
		predictedLowSeriesAbsolute.setMaximumItemCount(Constants.MAX_CHART_ITEM_C0UNT);		
		
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
		XYSeriesCollection seriesCollection = new XYSeriesCollection();
		idealHighSeriesRelative = new XYSeries("Ideal High");
		idealHighSeriesRelative.setMaximumItemCount(Constants.MAX_CHART_ITEM_C0UNT);		

		idealLowSeriesRelative = new XYSeries("Ideal Low");
		idealLowSeriesRelative.setMaximumItemCount(Constants.MAX_CHART_ITEM_C0UNT);		

		predictedHighSeriesRelative = new XYSeries("Predicted High");
		predictedHighSeriesRelative.setMaximumItemCount(Constants.MAX_CHART_ITEM_C0UNT);		

		predictedLowSeriesRelative = new XYSeries("Predicted Low");
		predictedLowSeriesRelative.setMaximumItemCount(Constants.MAX_CHART_ITEM_C0UNT);	

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
		// Delete previous chart
		clearCharts();

		// Start testing thread and continue this form 
		new Thread(new Runnable(){
			@Override
			public void run() {
				neuralContext.getNeuralService().testNetwork();
			}})
		.start();
	}

	/**
	 * Update view from context
	 */
	private void updateView() {
		testButton.setEnabled(neuralContext != null);
	}
	
	/**
	 * Clear all series in charts
	 */
	private void clearCharts(){
		idealHighSeriesAbsolute.clear();
		idealLowSeriesAbsolute.clear();;
		predictedHighSeriesAbsolute.clear();
		predictedLowSeriesAbsolute.clear();
		
		idealHighSeriesRelative.clear();
		idealLowSeriesRelative.clear();
		predictedHighSeriesRelative.clear();
		predictedLowSeriesRelative.clear();		

	}

	/**
	 * Add predicted and ideal data to charts
	 * @param e
	 */
	@Subscribe
	public synchronized void onTestIterationCompleted(TestIterationCompletedEvent e){
		// Get x value (time axis)
//		Calendar cal = GregorianCalendar.getInstance();
//		cal.setTime(e.getLevel1().getDate());
//		RegularTimePeriod x = RegularTimePeriod.createInstance(Millisecond.class, e.getLevel1().getDate(), cal.getTimeZone());
		// Add xy values to the charts

		double x = new Integer(e.getIteration()).doubleValue();
		// Relative chart
		predictedLowSeriesRelative.add(x, e.getPredictedLow()/0.01);
		predictedHighSeriesRelative.add(x, e.getPredictedHigh()/0.01);
		idealLowSeriesRelative.add(x, e.getIdealLow()/0.01);
		idealHighSeriesRelative.add(x, e.getIdealHigh()/0.01);
		// Absolute prices chart
		predictedLowSeriesAbsolute.add(x,e.getLevel1().getBid().doubleValue() * (1+e.getPredictedLow()));
		predictedHighSeriesAbsolute.add(x,e.getLevel1().getAsk().doubleValue() * (1+e.getPredictedHigh()));
		idealLowSeriesAbsolute.add(x,e.getLevel1().getBid().doubleValue() * (1+e.getIdealLow()));
		idealHighSeriesAbsolute.add(x,e.getLevel1().getAsk().doubleValue() * (1+e.getIdealHigh()));

		
		lblIteration.setText(String.format("Iteration: %d of %d", e.getIteration(), neuralContext.getPredictionSize()));
		progressBar.setMaximum(neuralContext.getTrainingContext().getPredictionSamples());
		progressBar.setValue(e.getIteration());


	}
}
