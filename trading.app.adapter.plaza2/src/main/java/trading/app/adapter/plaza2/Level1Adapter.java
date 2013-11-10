package trading.app.adapter.plaza2;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Observable;
import java.util.Observer;

import org.hibernate.Session;

import ru.micexrts.cgate.messages.AbstractDataMessage;
import trading.app.adapter.plaza2.scheme.FutCommon;
import trading.data.HibernateUtil;
import trading.data.model.Instrument;
import trading.data.model.Level1;

/**
 * Adapter for level1 data
 * @author dima
 *
 */
public class Level1Adapter extends Observable implements SpecificAdapter {
	public static final String MESSAGE_NAME="common";
	
	/**
	 * Convert plaza2 entity to level1 object
	 * @param schemeEntity
	 * @return
	 */
	public static Level1 convert(FutCommon.common schemeEntity){
		Level1 entity = new Level1();
		// Get instrument
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Instrument instrument = (Instrument) session.get(Instrument.class, schemeEntity.get_isin_id());
		// Set properties
		entity.setInstrument(instrument);
		// time
		Timestamp date = new Timestamp(schemeEntity.get_deal_time().getTime());
		entity.setDate(date);
		Time lastTime = new Time(date.getTime());
		entity.setLastTime(lastTime);
		// Price
		entity.setLastPrice(schemeEntity.get_price());
		entity.setLastPriceDelta(schemeEntity.get_trend());
		entity.setLastSize(schemeEntity.get_amount());
		// Ask and bid
		entity.setAsk(schemeEntity.get_best_sell());
		entity.setAskSize(schemeEntity.get_amount_sell());
		entity.setBid(schemeEntity.get_best_buy());
		entity.setBidSize(schemeEntity.get_amount_buy());
		return entity;
		
	}
	/**
	 * Message received
	 */
	public void onMessage(AbstractDataMessage message) {
		FutCommon.common schemeEntity = new FutCommon.common(message.getData());
		Level1 level1 = convert(schemeEntity);
		
		// Fire event
		this.setChanged();
		this.notifyObservers();
		this.clearChanged();
		
	}


}
