package trading.data;

/**
 * String constants
 * @author dima
 *
 */
public class Constants {
	/**
	 * Query names constants
	 * @author dima
	 */
	public static class QueryName{
		public final static String LEVEL1_FIND_RANGE = "LEVEL1_FIND_RANGE";
		public final static String LEVEL1_FIND_LAST = "LEVEL1_FIND_LAST";
		public final static String LEVEL1_FIND_COUNT = "LEVEL1_FIND_COUNT"; 
	}
	
	/**
	 * Query parameter names
	 * @author dima
	 */
	public static class QueryParamName{
		public final static String START_TIME = "START_TIME";
		public final static String END_TIME = "END_TIME";
		public final static String COUNT = "COUNT";
		public final static String INSTRUMENT_ID = "INSTRUMENT_ID";
	}
}
