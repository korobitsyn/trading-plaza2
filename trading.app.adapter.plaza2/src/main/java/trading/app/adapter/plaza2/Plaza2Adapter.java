package trading.app.adapter.plaza2;

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
	 * Process new message
	 */
	public int onMessage(Connection conn, Listener listener, Message message) {

		
		// Process by message type
		switch (message.getType()) {
/*		case MessageType.MSG_STREAM_DATA:
			AbstractDataMessage d;
			
			StreamDataMessage streamMsg = (StreamDataMessage) message;

			break;*/
		case MessageType.MSG_STREAM_DATA:
			AbstractDataMessage msgData = (AbstractDataMessage) message;
			String msgName = msgData.getMsgName();

			// Instrument received
			switch(msgName){
			case "fut_instruments":
				FutInfo.fut_instruments schemeEntity = new FutInfo.fut_instruments(msgData.getData());
				Instrument instrument = SchemeConverter.convert(schemeEntity);
				System.out.println(instrument.getCode());
				//processDataMessage(msgData);
				break;
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
	 * Data message received
	 * @param message
	 */
	private void processDataMessage(AbstractDataMessage message){
		int index = message.getMsgIndex();
		String name = message.getMsgName();
		int id = message.getMsgId();
		System.out.println(String.format("Message id = %d, index = %d, name = %s.", id, index, name));
	}

}
