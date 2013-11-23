/**
 * 
 */

package trading.app.neural.loader;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.encog.ml.data.MLData;
import org.encog.ml.data.basic.BasicMLData;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

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

		Level1 level1 = new Level1(){{ 
			setDate(cal.getTime()); 
			setLastPrice(new BigDecimal(2)); 
			setLastSize(2);
			setBid(new BigDecimal(2));
			setBidSize(2);
			setAsk(new BigDecimal(2));
			setAskSize(2);
		}};
		Level1 prevLevel1 = new Level1(){{ 
			setDate(prevCal.getTime()); 
			setLastPrice(new BigDecimal(1)); 
			setLastSize(1);
			setBid(new BigDecimal(1));
			setBidSize(1);
			setAsk(new BigDecimal(1));
			setAskSize(1);
		}};
		// Get normalized data to compare
		double nDate = ReflectionTestUtils.invokeMethod(loader, "getNormalizedDate", level1.getDate());
		double nPrice = ReflectionTestUtils.invokeMethod(loader, "getNormalizedPrice", level1.getLastPrice(), prevLevel1.getLastPrice());
		double nSize = ReflectionTestUtils.invokeMethod(loader, "getNormalizedSize", level1.getLastSize(), prevLevel1.getLastSize());
		double nBid = ReflectionTestUtils.invokeMethod(loader, "getNormalizedPrice", level1.getBid(), prevLevel1.getBid());
		double nBidSize = ReflectionTestUtils.invokeMethod(loader, "getNormalizedSize", level1.getBidSize(), prevLevel1.getBidSize());
		double nAsk = ReflectionTestUtils.invokeMethod(loader, "getNormalizedPrice", level1.getAsk(), prevLevel1.getAsk());
		double nAskSize = ReflectionTestUtils.invokeMethod(loader, "getNormalizedSize", level1.getAskSize(), prevLevel1.getAskSize());
		
		// Call and check the result
		int pos = 0;
		Integer resultPos = ReflectionTestUtils.invokeMethod(loader, "addLevel1Data", mlData, pos, level1, prevLevel1);
		assertEquals(singleLevel1Size, resultPos);
		assertEquals(nDate, mlData.getData(0), Constants.DOUBLE_COMPARISON_PRECISION);
		assertEquals(nPrice, mlData.getData(1),Constants.DOUBLE_COMPARISON_PRECISION);
		assertEquals(nSize, mlData.getData(2),Constants.DOUBLE_COMPARISON_PRECISION);
		assertEquals(nBid, mlData.getData(3),Constants.DOUBLE_COMPARISON_PRECISION);
		assertEquals(nBidSize, mlData.getData(4),Constants.DOUBLE_COMPARISON_PRECISION);
		assertEquals(nAsk, mlData.getData(5),Constants.DOUBLE_COMPARISON_PRECISION);
		assertEquals(nAskSize, mlData.getData(6), Constants.DOUBLE_COMPARISON_PRECISION);
		assertEquals(0, mlData.getData(7), Constants.DOUBLE_COMPARISON_PRECISION);
		assertEquals(0, mlData.getData(8), Constants.DOUBLE_COMPARISON_PRECISION);
		
		mlData = new BasicMLData(singleLevel1Size +2);
		// Call and check the result
		pos = 1;
		resultPos = ReflectionTestUtils.invokeMethod(loader, "addLevel1Data", mlData, pos, level1, prevLevel1);
		Integer idealPos = pos + singleLevel1Size;
		assertEquals(idealPos, resultPos);
		assertEquals(0, mlData.getData(0), Constants.DOUBLE_COMPARISON_PRECISION);
		assertEquals(nDate, mlData.getData(pos + 0), Constants.DOUBLE_COMPARISON_PRECISION);
		assertEquals(nPrice, mlData.getData(pos + 1),Constants.DOUBLE_COMPARISON_PRECISION);
		assertEquals(nSize, mlData.getData(pos + 2),Constants.DOUBLE_COMPARISON_PRECISION);
		assertEquals(nBid, mlData.getData(pos + 3),Constants.DOUBLE_COMPARISON_PRECISION);
		assertEquals(nBidSize, mlData.getData(pos + 4),Constants.DOUBLE_COMPARISON_PRECISION);
		assertEquals(nAsk, mlData.getData(pos + 5),Constants.DOUBLE_COMPARISON_PRECISION);
		assertEquals(nAskSize, mlData.getData(pos + 6), Constants.DOUBLE_COMPARISON_PRECISION);
		assertEquals(0, mlData.getData(8), Constants.DOUBLE_COMPARISON_PRECISION);
		assertEquals(0, mlData.getData(resultPos), Constants.DOUBLE_COMPARISON_PRECISION);
		
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

}
