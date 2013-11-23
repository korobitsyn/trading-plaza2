package trading.app.neural.test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

import static org.junit.Assert.*;
import trading.data.model.Level1;

/**
 * Level1 entity test
 * @author dima
 *
 */
public class Level1EntityTest extends AbstractTest {
	
	/**
	 * Test level1 constructor
	 */
	@Test
	public void level1ConstructorTest(){
		// Just test empty level1 creation
		Level1 level1 = new Level1();
		assertNotNull(level1);
		// Prepare params
		Calendar cal = GregorianCalendar.getInstance();
		BigDecimal price = new BigDecimal(1.1);
		Integer size = new Integer(1);
		BigDecimal bid = new BigDecimal(1.2);
		Integer bidSize = new Integer(2);
		BigDecimal ask = new BigDecimal(1.2);
		Integer askSize = new Integer(2);
		// Create with params
		level1 = new Level1(cal.getTime(), price, size, bid, bidSize, ask, askSize);
		// Assert datetime
		Calendar level1DateCal = GregorianCalendar.getInstance();
		level1DateCal.setTime(level1.getDate());
		assertEquals(cal.getTimeInMillis(), level1DateCal.getTimeInMillis());
		// Assert time of day
		Calendar level1LastTimeCal = GregorianCalendar.getInstance();
		level1LastTimeCal.setTime(level1.getLastTime());
		assertEquals(cal.get(Calendar.HOUR_OF_DAY), level1LastTimeCal.get(Calendar.HOUR_OF_DAY));
		assertEquals(cal.get(Calendar.MINUTE), level1LastTimeCal.get(Calendar.MINUTE));
		assertEquals(cal.get(Calendar.SECOND), level1LastTimeCal.get(Calendar.SECOND));
		assertEquals(cal.get(Calendar.MILLISECOND), level1LastTimeCal.get(Calendar.MILLISECOND));
		// Assert prices and volumes
		assertEquals(price, level1.getLastPrice());
		assertEquals(size, level1.getLastSize());
		assertEquals(bid, level1.getBid());
		assertEquals(bidSize, level1.getBidSize());
		assertEquals(ask, level1.getAsk());
		assertEquals(askSize, level1.getAskSize());
	}
}
