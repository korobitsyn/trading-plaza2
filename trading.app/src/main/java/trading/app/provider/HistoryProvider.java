package trading.app.provider;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.TemporalType;

import org.hibernate.Query;
import org.hibernate.Session;

import trading.app.adapter.plaza2.Adapter;
import trading.data.HibernateUtil;
import trading.data.model.Level1;

/**
 * History data provider
 * @author dima
 *
 */
public class HistoryProvider {
	private Session hibernateSession;
	
	/**
	 * Ctor
	 * @param adapter
	 */
	public HistoryProvider() {
		// Init hibernate session
		hibernateSession = HibernateUtil.getSessionFactory().openSession();
	}
	
	/**
	 * Get level1 data for specific interval
	 * @param start
	 * @param end
	 * @return
	 */
	public List<Level1> getLevel1Range(Timestamp start, Timestamp end){
		Query query = hibernateSession.getNamedQuery(trading.data.Constants.QueryName.LEVEL1_FIND_RANGE);
		query.setParameter(trading.data.Constants.QueryParamName.START_TIME, start);
		query.setParameter(trading.data.Constants.QueryParamName.END_TIME, end);
		
		List<Level1> data = query.list();
		return data;
	}
}
