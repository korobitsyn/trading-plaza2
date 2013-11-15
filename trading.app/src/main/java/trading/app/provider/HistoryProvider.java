package trading.app.provider;

import java.util.Date;
import java.util.List;

import trading.data.model.Level1;

/**
 * Provides history
 * @author pdg
 *
 */
public interface HistoryProvider {

	/**
	 * Get level1 data for specific interval
	 * @param start
	 * @param end
	 * @return
	 */
	public abstract List<Level1> getLevel1Range(Date start, Date end);

}