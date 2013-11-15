package trading.app.history;

import org.hibernate.Session;

import trading.app.history.HistoryWriter;
import trading.app.realtime.MarketListener;
import trading.app.realtime.RealTimeProvider;
import trading.data.HibernateUtil;
import trading.data.model.Instrument;
import trading.data.model.Level1;

/**
 * Receives data from adapter, writes to history
 * 
 * @author dima
 * 
 */
public class HibernateHistoryWriter implements HistoryWriter {

	private  RealTimeProvider realTimeProvider = null;
	private Session hibernateSession = null;
	// Hardcode futures instrument id
	// ToDo: add instrument id setter
	private int instrumentId = 193886;

	
	
	/* (non-Javadoc)
	 * @see trading.app.HistoryWriter#getProvider()
	 */
	@Override
	public RealTimeProvider getRealTimeProvider() {
		return realTimeProvider;
	}




	/* (non-Javadoc)
	 * @see trading.app.HistoryWriter#setProvider(trading.app.provider.DynamicProvider)
	 */
	@Override
	public void setRealTimeProvider(RealTimeProvider provider) {
		this.realTimeProvider = provider;
	}




	/* (non-Javadoc)
	 * @see trading.app.HistoryWriter#init(trading.app.provider.DynamicProvider)
	 */
	@Override
	public void init() {


		// Init hibernate session
		hibernateSession = HibernateUtil.getSessionFactory().openSession();

		// Add instrument listener
		realTimeProvider.addInstrumentListener(
				new MarketListener<Instrument>() {
					@Override
					public void OnMarketDataChanged(Instrument entity) {
						onInstrument(entity);

					}
				});
		// Add level1 listener
		realTimeProvider.addLevel1Listener(instrumentId,
				new MarketListener<Level1>() {
					@Override
					public void OnMarketDataChanged(Level1 entity) {
						onLevel1(entity);
					}
				});
	}
	

	

	/**
	 * Instrument update received
	 * 
	 * @param instrument
	 */
	protected void onInstrument(Instrument instrument) {
		// Write to database
		Session session = hibernateSession;
		// session.beginTransaction();
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		session.merge(instrument);
		session.getTransaction().commit();
	}

	/**
	 * Level1 data received
	 * 
	 * @param level1
	 */
	protected void onLevel1(Level1 level1) {
		try {
			// Write to database
			Session session = hibernateSession;
			// session.beginTransaction();
			if (!session.getTransaction().isActive()) {
				session.getTransaction().begin();
			}
			Instrument instrument = (Instrument) session.get(Instrument.class,
					level1.getInstrument().getId());
			// If instrument does not exist, save it to be updated later from instrument adapter
			if (instrument == null) {
				session.save(level1.getInstrument());
				// session.merge(level1.getInstrument());
			} else {
				level1.setInstrument(instrument);
			}
			// Save level1
			session.merge(level1);
			// Commit
			session.getTransaction().commit();
		} catch (org.hibernate.ObjectNotFoundException ex) {
			// If not found => instrument does not exist
			System.err.println(ex);
		}
	}

	/**
	 * Close session when being finalized
	 */
	public void finalize() {
		if (hibernateSession != null && hibernateSession.isOpen()) {
			hibernateSession.close();
		}
	}
}
