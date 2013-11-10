package trading.app;

import org.hibernate.Session;

import trading.app.adapter.plaza2.Adapter;
import trading.app.adapter.plaza2.MarketListener;
import trading.data.HibernateUtil;
import trading.data.model.Instrument;
import trading.data.model.Level1;

/**
 * Receives data from adapter, writes to history
 * 
 * @author dima
 * 
 */
public class HistoryWriter {

	private Adapter adapter = null;
	private Session hibernateSession = null;
	// Hardcode futures instrument id
	// ToDo: add instrument id setter
	private int instrumentId = 193886;

	/**
	 * Ctor
	 * 
	 * @param adapter
	 */
	public HistoryWriter(Adapter adapter) {
		// Store plaza adapter
		this.adapter = adapter;

		// Init hibernate session
		hibernateSession = HibernateUtil.getSessionFactory().openSession();

		// Add instrument listener
		adapter.getInstrumentAdapter().addMarketListener(
				new MarketListener<Instrument>() {
					@Override
					public void OnMarketDataChanged(Instrument entity) {
						onInstrument(entity);

					}
				});
		// Add level1 listener
		adapter.getLevel1Adapter().addMarketListener(instrumentId,
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
