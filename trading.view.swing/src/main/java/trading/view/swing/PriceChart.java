package trading.view.swing;


import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.ClusteredXYBarRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.FixedMillisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

import trading.data.model.Level1;

import java.util.Calendar;
import java.util.Random;

import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.GridLayout;

public class PriceChart extends JPanel  {
	String title;
	// Data for price chart
	TimeSeries priceSeries;
	// Data for volume chart
	TimeSeries volumeSeries;
	
	static int volumeSeriesIndex = 0;
	static int priceSeriesIndex = 0;
	static Color priceSeriesColor = Color.blue;
	static Color volumeSeriesColor = Color.red;
	// Max items in charts
	int maxItemCount = 10;

	/**
	 * Ctor, jfreechart init
	 * @param title
	 */
    public PriceChart(String title) {
    	this.title = title;
    	setBackground(SystemColor.control);
        final XYDataset priceDataSet = createPriceDataSet();
        final JFreeChart priceChart = createPriceChart(priceDataSet);
        setLayout(new GridLayout(0, 1, 0, 0));
        final ChartPanel priceChartPanel = new ChartPanel(priceChart);
        FlowLayout flowLayout_1 = (FlowLayout)priceChartPanel.getLayout();
        flowLayout_1.setAlignOnBaseline(true);
        priceChartPanel.setPreferredSize(new java.awt.Dimension(500, 370));
        add(priceChartPanel);
        
        final XYDataset volumeDataSet = createVolumeDataSet();
        final JFreeChart volumeChart = createVolumeChart(volumeDataSet);
        setLayout(new GridLayout(0, 1, 0, 0));
        final ChartPanel volumeChartPanel = new ChartPanel(volumeChart);
        FlowLayout flowLayout_2 = (FlowLayout) volumeChartPanel.getLayout();
        flowLayout_2.setAlignOnBaseline(true);
        volumeChartPanel.setPreferredSize(new java.awt.Dimension(500, 100));
        add(volumeChartPanel);
  
    }
    
    /**
     * Add level1 item to the chart
     * @param level1
     */
    public void addLevel1(Level1 level1){
    	FixedMillisecond fm = new FixedMillisecond(level1.getDate());
    	priceSeries.addOrUpdate(fm,level1.getLastPrice());
    	volumeSeries.addOrUpdate(fm, level1.getLastSize());
    	
    }

    /**
     * Data set for price chart
     * @return
     */
    private XYDataset createPriceDataSet() {
    	// Add empty time series to fill later
    	// Create price series
    	priceSeries = new TimeSeries("Last price");
    	priceSeries.setMaximumItemCount(this.maxItemCount);
    	// Create and return DataSet with all time series
    	TimeSeriesCollection dataSet = new TimeSeriesCollection();
    	dataSet.addSeries(priceSeries);
    	return dataSet;
    }
    /**
     * Some test data
     * @param priceSeries
     */
    private void fillTestData(TimeSeries priceSeries){
    	// Generates random data every second
    	Calendar cal = Calendar.getInstance();
    	Random generator = new Random();
    	for(int i = 0; i < 10; i ++){
        	FixedMillisecond fm = new FixedMillisecond(cal.getTime());   		
        	cal.add(Calendar.SECOND, 1);
        	double price = generator.nextDouble();
        	volumeSeries.addOrUpdate(fm,price);
    	}
    }
    
    /**
     * Price chart creation
     * @param dataset
     * @return
     */
    private JFreeChart createPriceChart(final XYDataset dataset) {
        final JFreeChart chart = ChartFactory.createTimeSeriesChart(
        		this.title, 
        		null, 
        		"price", 
        		dataset,
        		false, 
        		false, 
        		false);

        // get a reference to the plot for further customisation...
        final XYPlot plot = chart.getXYPlot();
        
        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(priceSeriesIndex, priceSeriesColor);
        renderer.setSeriesLinesVisible(priceSeriesIndex, true);
        renderer.setSeriesShapesVisible(priceSeriesIndex, false);

        plot.setRenderer(renderer);
                
        return chart;
        
    }

    /**
     * Data set for volume chart
     * @return
     */
    private XYDataset createVolumeDataSet() {
    	// Add empty time series to fill later
    	// Create price series
    	volumeSeries = new TimeSeries("Volume");
    	volumeSeries.setMaximumItemCount(this.maxItemCount);
    	// Create and return DataSet with all time series
    	TimeSeriesCollection dataSet = new TimeSeriesCollection();
    	dataSet.addSeries(volumeSeries);
    	return dataSet;
    }
    
    /**
     * Create chart for volume data
     * @param dataset
     * @return
     */
    private JFreeChart createVolumeChart(final XYDataset dataset) {
        final JFreeChart chart = ChartFactory.createTimeSeriesChart(
        		null, 
        		null, 
        		"volume", 
        		dataset,
        		false, 
        		false, 
        		false);

        // get a reference to the plot for further customisation...
        final XYPlot plot = chart.getXYPlot();
        final ClusteredXYBarRenderer renderer = new ClusteredXYBarRenderer();
        renderer.setSeriesPaint(volumeSeriesIndex, volumeSeriesColor);
        renderer.setShadowVisible(false);
        plot.setRenderer(renderer);
        return chart;
    }

}
