package trading.app.history;

import java.util.Date;
import java.util.List;

import trading.data.model.Instrument;
import trading.data.model.Level1;

/**
 * Provides history
 * @author pdg
 *
 */
public interface HistoryProvider {

	/**
	 * Get all instrument from database
	 * @return
	 */
	public abstract List<Instrument> findInstrumentAll();
	
	/**
	 * Get last n level1 items
	 * @param lastCount
	 * @return
	 */
	public abstract List<Level1> findLevel1Last(int instrumentId, int lastCount);
	/**
	 * Get level1 data for specific interval
	 * @param start
	 * @param end
	 * @return
	 */
	public abstract List<Level1> findLevel1Range(int instrumentId, Date start, Date end);

}