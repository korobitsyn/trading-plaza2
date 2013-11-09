package trading.app.adapter.plaza2;

import java.util.Hashtable;
import java.util.Map;
import java.util.Observable;

import ru.micexrts.cgate.CGateException;
import ru.micexrts.cgate.Connection;
import ru.micexrts.cgate.ErrorCode;
import ru.micexrts.cgate.ISubscriber;
import ru.micexrts.cgate.Listener;
import ru.micexrts.cgate.MessageType;
import ru.micexrts.cgate.messages.AbstractDataMessage;
import ru.micexrts.cgate.messages.DataMessage;
import ru.micexrts.cgate.messages.Message;
import ru.micexrts.cgate.messages.StreamDataMessage;
import trading.app.adapter.plaza2.scheme.FutInfo;
import trading.data.model.Instrument;

/**
 * Processes plaza2 messages
 * 
 * @author dima
 * 
 */
public class Plaza2Adapter implements ISubscriber {
	
	/**
	 * Instrument info adapter
	 */
	private InstrumentAdapter instrumentAdapter = new InstrumentAdapter();

	/**
	 * Subadapters for different messages (Instrument, quote, level1 etc)
	 */
	private Map<String,SpecificAdapter> adaptersByMessage = new Hashtable<String, SpecificAdapter>(){{ 
		put(InstrumentAdapter.MESSAGE_NAME,instrumentAdapter);	
		}};


	/**
	 * Process new message
	 */
	public int onMessage(Connection conn, Listener listener, Message message) {
		
		// Process by message type
		switch (message.getType()) {
		// Data messages
		case MessageType.MSG_DATA:
		case MessageType.MSG_STREAM_DATA:
			// Get adapter by message name
			AbstractDataMessage msgData = (AbstractDataMessage) message;
			SpecificAdapter specificAdapter = adaptersByMessage.get(msgData.getMsgName());
			if(specificAdapter != null){
				specificAdapter.onMessage(msgData);
			}
			break;
		// Timeout
		case MessageType.MSG_P2MQ_TIMEOUT:
			System.out.println("Timeout message");
			break;
		// Default	
		default:
			System.out.println(message);
			System.out.println(String.format("Message type: %d", message.getType()));
		}

		return ErrorCode.OK;
	}

	
	/**
	 * Main cycle for dev only
	 * ToDo: remove later
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws CGateException,
			InterruptedException {

		new Plaza2Client().run();
	}	

}
