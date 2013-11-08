package trading.app.adapter.plaza2;

import trading.app.adapter.plaza2.scheme.FutInfo;
import trading.data.model.Instrument;

public class SchemeConverter {
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
}
