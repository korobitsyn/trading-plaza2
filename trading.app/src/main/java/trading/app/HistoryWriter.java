package trading.app;

import java.util.Observable;
import java.util.Observer;

import org.hibernate.Session;

import trading.app.adapter.plaza2.Adapter;
import trading.data.HibernateUtil;
import trading.data.model.Instrument;
import trading.data.model.Level1;

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
		adapter.getLevel1Adapter().addObserver(new Observer(){
			@Override
			public void update(Observable o, Object arg) {
				onLevel1((Level1)arg);
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
		//session.beginTransaction();
		if(!session.getTransaction().isActive()){session.getTransaction().begin();}
		session.merge(instrument);
		session.getTransaction().commit();

	}
	/**
	 * Instrument listener method
	 * @param instrument
	 */
	protected void onLevel1(Level1 level1){
		try{ 
		//Write to database
		Session session = hibernateSession;
		//session.beginTransaction();
		if(!session.getTransaction().isActive()){session.getTransaction().begin();}
		Instrument instrument = (Instrument)session.get(Instrument.class, level1.getInstrument().getId());
		level1.setInstrument(instrument);
		session.merge(level1);
		session.getTransaction().commit();
		}catch(org.hibernate.ObjectNotFoundException ex){
			// If not found => instrument does not exist
			System.err.println(ex);
		}

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
