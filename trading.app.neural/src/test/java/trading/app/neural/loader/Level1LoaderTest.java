/**
 * 
 */

package trading.app.neural.loader;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import trading.app.neural.test.config.Constants;

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
