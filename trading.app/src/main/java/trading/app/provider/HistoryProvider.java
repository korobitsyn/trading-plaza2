package trading.app.provider;

import java.util.Date;

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
	public List<Level1> getLevel1Range(Date start, Date end){
		Query query = hibernateSession.getNamedQuery(trading.data.Constants.QueryName.LEVEL1_FIND_RANGE);
		
		int year = start.getYear();
		year = end.getYear();

		query.setParameter(trading.data.Constants.QueryParamName.START_TIME, start);
		query.setParameter(trading.data.Constants.QueryParamName.END_TIME, end);
		
		List<Level1> data = query.list();
		int size = data.size();
		return data;
	}
}
