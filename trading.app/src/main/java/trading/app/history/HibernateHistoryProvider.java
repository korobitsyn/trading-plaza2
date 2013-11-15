package trading.app.history;

import java.util.Date;
import java.util.List;

import javax.persistence.TemporalType;

import org.hibernate.Query;
import org.hibernate.Session;

import trading.app.adapter.Adapter;
import trading.app.history.HistoryProvider;
import trading.data.HibernateUtil;
import trading.data.model.Level1;

/**
 * History data provider
 * @author dima
 *
 */
public class HibernateHistoryProvider implements HistoryProvider {
	private Session hibernateSession;
	
	/**
	 * Ctor
	 * @param adapter
	 */
	public HibernateHistoryProvider() {
		// Init hibernate session
		hibernateSession = HibernateUtil.getSessionFactory().openSession();
	}
	
	/* (non-Javadoc)
	 * @see trading.app.provider.HistoryProvider#getLevel1Range(java.util.Date, java.util.Date)
	 */
	@Override
	public List<Level1> getLevel1Range(Date start, Date end){
		Query query = hibernateSession.getNamedQuery(trading.data.Constants.QueryName.LEVEL1_FIND_RANGE);

		query.setParameter(trading.data.Constants.QueryParamName.START_TIME, start);
		query.setParameter(trading.data.Constants.QueryParamName.END_TIME, end);
		
		List<Level1> data = query.list();
		int size = data.size();
		return data;
	}
}
