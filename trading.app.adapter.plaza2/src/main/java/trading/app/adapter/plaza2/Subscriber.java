package trading.app.adapter.plaza2;

import ru.micexrts.cgate.Connection;
import ru.micexrts.cgate.ErrorCode;
import ru.micexrts.cgate.ISubscriber;
import ru.micexrts.cgate.Listener;
import ru.micexrts.cgate.MessageType;
import ru.micexrts.cgate.messages.DataMessage;
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
		// Process by message type
		switch (message.getType()) {
		// Data message
		case MessageType.MSG_DATA:
			DataMessage msgData = (DataMessage) message;
		
			System.out.println(String.format(
					"Reply message. ID=%d, User-Id=%d, content=%s",
					msgData.getMsgId(), msgData.getUserId(), message));
			break;
		// Timeout
		case MessageType.MSG_P2MQ_TIMEOUT:
			System.out.println("Timeout message");
			break;
		// Default	
		default:
			System.out.println(message);
		}

		return ErrorCode.OK;
	}

}
