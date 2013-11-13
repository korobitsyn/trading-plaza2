package trading.app.adapter.plaza2;

import java.util.Date;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import ru.micexrts.cgate.Connection;
import ru.micexrts.cgate.ErrorCode;
import ru.micexrts.cgate.ISubscriber;
import ru.micexrts.cgate.Listener;
import ru.micexrts.cgate.messages.AbstractDataMessage;
import ru.micexrts.cgate.messages.Message;
import trading.app.adapter.plaza2.scheme.FutCommon;
import trading.data.model.Instrument;
import trading.data.model.Level1;

/**
 * Adapter for level1 data
 * 
 * @author dima
 * 
 */
public class Level1Adapter extends EntityDataAdapterBase<Level1> implements EntityDataAdapter<Level1>, ISubscriber {
	public static final String MESSAGE_NAME = "common";
	

	/**
	 * Convert plaza2 entity to level1 object
	 * 
	 * @param schemeEntity
	 * @return
	 */
	public static Level1 convert(FutCommon.common schemeEntity) {
		Level1 entity = new Level1();

		// Set to new instrument with proper id. Will be processed in listeners
		Instrument instrument = new Instrument();
		instrument.setId(schemeEntity.get_isin_id());
		//instrument.setName(instrument.getId().toString());
		// Set properties
		entity.setInstrument(instrument);
		// time
		//Timestamp date = new Timestamp(schemeEntity.get_deal_time().getTime());

		entity.setDate(schemeEntity.get_deal_time());
		//Time lastTime = new Time(date.getTime());
		entity.setLastTime(schemeEntity.get_deal_time());
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
	public int onMessage(Connection conn, Listener listener, Message message) {
		//AbstractDataMessage dataMessage = (AbstractDataMessage) message;
		FutCommon.common schemeEntity = new FutCommon.common(message.getData());
		Level1 level1 = convert(schemeEntity);
		if (level1 != null) {
			fireMarketDataChangedEvent(level1.getInstrument().getId(), level1);
		}
		return ErrorCode.OK;

	}

/*	public int onMessage(Connection arg0, Listener arg1, Message arg2) {
		// TODO Auto-generated method stub
		return 0;
	}*/
}
