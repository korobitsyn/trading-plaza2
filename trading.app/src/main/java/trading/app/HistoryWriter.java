package trading.app;

import java.util.Observable;
import java.util.Observer;

import org.hibernate.Session;

import trading.app.adapter.plaza2.Adapter;
import trading.data.HibernateUtil;
import trading.data.model.Instrument;

/**
 * Receives data from adapter, writes to history
 * @author dima
 *
 */
public class HistoryWriter {

	/**
	 * Adapter to get data from
	 */
	private Adapter adapter = null;
	
	private Session hibernateSession = null;
	
	
	/**
	 * Ctor
	 * @param adapter
	 */
	public HistoryWriter(Adapter adapter){
		this.adapter = adapter;
		
		//Add instrument listener
		adapter.getInstrumentAdapter().addObserver(new Observer(){
			@Override
			public void update(Observable o, Object arg) {
				onInstrument((Instrument)arg);
			}});
		hibernateSession = HibernateUtil.getSessionFactory().openSession();

	}
	
	/**
	 * Instrument listener method
	 * @param instrument
	 */
	protected void onInstrument(Instrument instrument){
		// Write to database
		Session session = hibernateSession;
		session.beginTransaction();
		if(!session.getTransaction().isActive()){session.getTransaction().begin();}
		session.merge(instrument);
		session.getTransaction().commit();

	}
	/**
	 * Close session when being finalized
	 */
	public void finalize(){
		if(hibernateSession != null && hibernateSession.isOpen()){
			hibernateSession.close();
		}
	}
	
	
}
