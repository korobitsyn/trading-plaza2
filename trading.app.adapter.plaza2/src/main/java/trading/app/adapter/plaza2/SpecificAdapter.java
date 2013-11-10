package trading.app.adapter.plaza2;

import java.util.Observer;

import ru.micexrts.cgate.messages.AbstractDataMessage;
/**
 * Interface for Instrument, Level1 etc adapters
 * @author dima
 *
 */
public interface SpecificAdapter {

	/**
	 * Process Plaza2 message
	 * @param message
	 */

	public void onMessage(AbstractDataMessage message);
	
	/**
	 * Method from java.util.Observer
	 * @param o
	 */
    void addObserver(Observer o);    
    /**
     * Method from java.util.Observer
     * @param o
     */
    void deleteObserver(Observer o); 
}