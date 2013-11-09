package trading.app.adapter.plaza2;

import java.util.Observable;

import ru.micexrts.cgate.messages.AbstractDataMessage;
import trading.app.adapter.plaza2.scheme.FutInfo;
import trading.data.model.Instrument;

/**
 * Instrument info adapter
 * @author dima
 *
 */
public class InstrumentAdapter extends Observable implements  SpecificAdapter {
	
	public static final String MESSAGE_NAME = "fut_instruments";
	
	/**
	 * Convert plaza fut_instruments message to Instrument
	 * @param schemeEntity
	 * @return
	 */
	public static Instrument convert(FutInfo.fut_instruments schemeEntity){
		Instrument entity = new Instrument();
		
		entity.setId(schemeEntity.get_isin_id());
		entity.setShortCode(schemeEntity.get_short_isin());
		entity.setCode(schemeEntity.get_isin());
		entity.setName(schemeEntity.get_name());
		
		return entity;
		
	}
	
	/**
	 * Message received
	 */
	public void onMessage(AbstractDataMessage message) 	
	{
		// Convert scheme to entity
		FutInfo.fut_instruments schemeEntity = new FutInfo.fut_instruments(message.getData());
		Instrument instrument = convert(schemeEntity);
		System.out.println(instrument.getCode());

			
	}	

}
