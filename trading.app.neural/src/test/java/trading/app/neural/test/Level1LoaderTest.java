/**
 * 
 */

package trading.app.neural.test;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.encog.ml.data.MLData;
import org.encog.ml.data.basic.BasicMLData;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import trading.app.neural.loader.Level1Loader;
import trading.app.neural.test.config.Constants;
import trading.data.model.Level1;

/**
 * @author dima
 *
 */
public class Level1LoaderTest extends AbstractTest {

	/**
	 * Test method for {@link trading.app.neural.loader.Level1Loader#loadTrainMLDataSet()}.
	 */
	@Test
	public void testLoadTrainMLDataSet() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link trading.app.neural.loader.Level1Loader#getOutputData()}.
	 */
	@Test
	public void getOutputDataTest(){
		Level1Loader loader = new Level1Loader(null);
		// Prepare params
		Level1 item1 = new Level1(new Date(), new BigDecimal(1), 1, new BigDecimal(1),1, new BigDecimal(1),1);
		Level1 item2 = new Level1(new Date(), new BigDecimal(2), 2, new BigDecimal(2),2, new BigDecimal(2),2);
		Level1 item3 = new Level1(new Date(), new BigDecimal(3), 3, new BigDecimal(3),3, new BigDecimal(3),3);
		double minBid = (Math.min(item3.getBid().doubleValue(), item2.getBid().doubleValue()) - item1.getBid().doubleValue()) / item1.getBid().doubleValue();
		double maxAsk = (Math.max(item3.getAsk().doubleValue(), item2.getAsk().doubleValue()) - item1.getAsk().doubleValue()) / item1.getAsk().doubleValue();
		// Invoke
		MLData data = ReflectionTestUtils.invokeMethod(loader, "getOutputData", item1, Arrays.asList(new Level1[]{item2, item3}));
		// Assert
		assertEquals(data.getData(0), minBid, Constants.DOUBLE_COMPARISON_PRECISION);
		assertEquals(data.getData(1), maxAsk, Constants.DOUBLE_COMPARISON_PRECISION);
	}
	
	/**
	 * Test method for {@link trading.app.neural.loader.Level1Loader#addLevel1Data}.
	 */
	@Test
	public void addLevel1DataTest(){
		// Prepare method wide params
		Level1Loader loader = new Level1Loader(null);
		Integer singleLevel1Size = (Integer)ReflectionTestUtils.getField(loader, "LEVEL1_DATA_SIZE");
		MLData mlData = new BasicMLData(singleLevel1Size +2);
		for(double value: mlData.getData()){
			assertEquals(0, value, Constants.DOUBLE_COMPARISON_PRECISION);
		}
		
		// Prepare 2 level1
		final Calendar cal = new GregorianCalendar();
		final Calendar prevCal = new GregorianCalendar();
		prevCal.set(Calendar.MILLISECOND, cal.get(Calendar.MILLISECOND));
		prevCal.add(Calendar.MILLISECOND, -1);

		Level1 level1 = new Level1(cal.getTime(),new BigDecimal(2),2, new BigDecimal(2),2,new BigDecimal(2),2);
		Level1 prevLevel1 = new Level1(cal.getTime(),new BigDecimal(1),1, new BigDecimal(1),1,new BigDecimal(1),1);
		
		// Call and check the result
		int pos = 0;
		Integer resultPos = ReflectionTestUtils.invokeMethod(loader, "addLevel1Data", mlData, pos, level1, prevLevel1);
		assertEquals(singleLevel1Size, resultPos);
		assertMLDataContainsLevel1(loader, mlData, pos, level1, prevLevel1);
		assertEquals(0.0, mlData.getData(singleLevel1Size), Constants.DOUBLE_COMPARISON_PRECISION);
		assertEquals(0.0, mlData.getData(singleLevel1Size+1), Constants.DOUBLE_COMPARISON_PRECISION);
		
		mlData = new BasicMLData(singleLevel1Size +2);
		// Call and check the result
		pos = 1;
		resultPos = ReflectionTestUtils.invokeMethod(loader, "addLevel1Data", mlData, pos, level1, prevLevel1);
		Integer idealPos = pos + singleLevel1Size;
		assertEquals(idealPos, resultPos);
		assertEquals(0, mlData.getData(0), Constants.DOUBLE_COMPARISON_PRECISION);
		assertMLDataContainsLevel1(loader, mlData, pos, level1, prevLevel1);
		assertEquals(0, mlData.getData(singleLevel1Size+1), Constants.DOUBLE_COMPARISON_PRECISION);
		
	}
	/**
	 * Test method for {@link trading.app.neural.loader.Level1Loader#getNormalizedPrice}.
	 */
	@Test
	public void testGetNormalizedPrice(){
		
		Level1Loader loader = new Level1Loader(null);
		double result = ReflectionTestUtils.invokeMethod(loader, "getNormalizedPrice", new BigDecimal(1),new BigDecimal(1));
		assertEquals(0,result, Constants.DOUBLE_COMPARISON_PRECISION);
		
		result = ReflectionTestUtils.invokeMethod(loader, "getNormalizedPrice", new BigDecimal(2), new BigDecimal(1));
		assertEquals(1, result, Constants.DOUBLE_COMPARISON_PRECISION);

		result = ReflectionTestUtils.invokeMethod(loader, "getNormalizedPrice", new BigDecimal(1), new BigDecimal(2));
		assertEquals(-0.5, result, Constants.DOUBLE_COMPARISON_PRECISION);

		
		double prevValue = 150.34;
		double curValue = 134.06;
		double expected = (curValue - prevValue) / prevValue;
		result = ReflectionTestUtils.invokeMethod(loader, "getNormalizedPrice", new BigDecimal(curValue), new BigDecimal(prevValue));
		assertEquals(result, expected, Constants.DOUBLE_COMPARISON_PRECISION);
		
	}
	/**
	 * Test method for {@link trading.app.neural.loader.Level1Loader#getNormalizedSize}.
	 */
	@Test
	public void testGetNormalizedSize(){
		Level1Loader loader = new Level1Loader(null);
		double result = ReflectionTestUtils.invokeMethod(loader, "getNormalizedSize", 1,1);
		assertEquals(0.0, result, Constants.DOUBLE_COMPARISON_PRECISION);
		
		result = ReflectionTestUtils.invokeMethod(loader, "getNormalizedSize", 2,1);
		assertEquals(1, result, Constants.DOUBLE_COMPARISON_PRECISION);

		result = ReflectionTestUtils.invokeMethod(loader, "getNormalizedSize", 1,2);
		assertEquals(-0.5, result, Constants.DOUBLE_COMPARISON_PRECISION);
		
		
		int prevValue = 26;
		int curValue = 86;
		double expected = new Double(curValue - prevValue) / new Double(prevValue);
		result = ReflectionTestUtils.invokeMethod(loader, "getNormalizedSize", curValue, prevValue);
		assertEquals(expected, result, Constants.DOUBLE_COMPARISON_PRECISION);
		
	}
	
	/**
	 * Check whether mldata contains level1
	 * @param loader
	 * @param mlData
	 * @param index level1 data index in mldata
	 * @param level1
	 * @param prevLevel1
	 */
	private void assertMLDataContainsLevel1(Level1Loader loader, MLData mlData, int index, Level1 level1, Level1 prevLevel1){

		// Get normalized data to compare
		double nDate = ReflectionTestUtils.invokeMethod(loader, "getNormalizedDate", level1.getDate());
		double nPrice = ReflectionTestUtils.invokeMethod(loader, "getNormalizedPrice", level1.getLastPrice(), prevLevel1.getLastPrice());
		double nSize = ReflectionTestUtils.invokeMethod(loader, "getNormalizedSize", level1.getLastSize(), prevLevel1.getLastSize());
		double nBid = ReflectionTestUtils.invokeMethod(loader, "getNormalizedPrice", level1.getBid(), prevLevel1.getBid());
		double nBidSize = ReflectionTestUtils.invokeMethod(loader, "getNormalizedSize", level1.getBidSize(), prevLevel1.getBidSize());
		double nAsk = ReflectionTestUtils.invokeMethod(loader, "getNormalizedPrice", level1.getAsk(), prevLevel1.getAsk());
		double nAskSize = ReflectionTestUtils.invokeMethod(loader, "getNormalizedSize", level1.getAskSize(), prevLevel1.getAskSize());

		assertEquals(nDate, mlData.getData(index + 0), Constants.DOUBLE_COMPARISON_PRECISION);
		assertEquals(nPrice, mlData.getData(index + 1),Constants.DOUBLE_COMPARISON_PRECISION);
		assertEquals(nSize, mlData.getData(index + 2),Constants.DOUBLE_COMPARISON_PRECISION);
		assertEquals(nBid, mlData.getData(index + 3),Constants.DOUBLE_COMPARISON_PRECISION);
		assertEquals(nBidSize, mlData.getData(index + 4),Constants.DOUBLE_COMPARISON_PRECISION);
		assertEquals(nAsk, mlData.getData(index + 5),Constants.DOUBLE_COMPARISON_PRECISION);
		assertEquals(nAskSize, mlData.getData(index + 6), Constants.DOUBLE_COMPARISON_PRECISION);
		assertEquals(0, mlData.getData(8), Constants.DOUBLE_COMPARISON_PRECISION);
		
	}

}
