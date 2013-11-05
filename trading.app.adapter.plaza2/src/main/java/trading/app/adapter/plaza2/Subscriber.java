package trading.app.adapter.plaza2;

import ru.micexrts.cgate.Connection;
import ru.micexrts.cgate.ErrorCode;
import ru.micexrts.cgate.ISubscriber;
import ru.micexrts.cgate.Listener;
import ru.micexrts.cgate.messages.Message;

/**
 * Processes plaza2 messages
 * 
 * @author dima
 * 
 */
public class Subscriber implements ISubscriber {
	/**
	 * Process new message
	 */
	public int onMessage(Connection conn, Listener listener, Message message) {
		
		System.out.println(message);
		return ErrorCode.OK;
	}




}
