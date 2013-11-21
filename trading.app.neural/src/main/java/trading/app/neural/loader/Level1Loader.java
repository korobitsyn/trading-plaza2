package trading.app.neural.loader;

import java.util.List;

import org.encog.ml.data.MLData;

import trading.app.TradingApplicationContext;
import trading.app.neural.NeuralContext;
import trading.data.model.Level1;

/**
 * Get ML data for network learning
 * @author pdg
 *
 */
public class Level1Loader  {
	private NeuralContext neuralContext;

	
	/**
	 * Constructor for context
	 * @param context
	 */
	public Level1Loader(NeuralContext context){
		neuralContext = context;
	}
	
	/* (non-Javadoc)
	 * @see trading.app.neural.converter.MLDataLoader#loadTrainMLDataSet()
	 */
	public MLData loadTrainMLDataSet(){
		int instrumentId = neuralContext.getTradingApplicationContext().getInstrumentContext().getInstrument().getId();
		
		int dataSize = neuralContext.getLevel1WindowSize();
		List<Level1> data = neuralContext.getTradingApplicationContext().getHistoryProvider().findLevel1Last(neuralContext.getTradingApplicationContext().getInstrumentContext().getInstrument().getId(), dataSize);
		
		
		return null;
	}
	
	

	
	
}
