package trading.app.adapter.plaza2;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import ru.micexrts.cgate.CGateException;
import ru.micexrts.cgate.Connection;
import ru.micexrts.cgate.ErrorCode;
import ru.micexrts.cgate.ISubscriber;
import ru.micexrts.cgate.Listener;
import ru.micexrts.cgate.MessageType;
import ru.micexrts.cgate.messages.AbstractDataMessage;
import ru.micexrts.cgate.messages.Message;

/**
 * Processes plaza2 messages
 * 
 * @author dima
 * 
 */
public class Plaza2Adapter implements ISubscriber, Adapter {
	/**
	 * Main cycle for dev only ToDo: remove later
	 * 
	 * @param args
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public static void main(String[] args) throws CGateException,
			InterruptedException, IOException {
		// Create adapter
		System.out.println("Creating adapter");
		Adapter adapter = new Plaza2Adapter();
		// Connect to plaza2 gate
		System.out.println("Connecting");
		adapter.connect();
		// Waiting user input to finish
		System.out.println("Press any key to finish");
		System.in.read();
		// Disconnect from gate (async)
		System.out.println("Disconnecting");
		adapter.disconnect();
		System.out.println("Complete");
		//
	}

	private Plaza2Client plaza2Client;


	
	/**
	 * Instrument info adapter
	 */
	private InstrumentAdapter instrumentAdapter = new InstrumentAdapter();
	
	/**
	 * Adapter for level1 data(price, bid, ask and volumes)
	 */
	private Level1Adapter level1Adapter = new Level1Adapter();

	/**
	 * Subadapters for different messages (Instrument, quote, level1 etc)
	 */
	private Map<String, ISubscriber> adaptersByMessage = new Hashtable<String, ISubscriber>() {
		private static final long serialVersionUID = 1L;
		{
			put(InstrumentAdapter.MESSAGE_NAME, instrumentAdapter);
			put(Level1Adapter.MESSAGE_NAME, level1Adapter);
		}
	};

	/**
	 * Ctor, creates plaza2 client inside
	 */
	public Plaza2Adapter() {
		plaza2Client = new Plaza2Client(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see trading.app.adapter.plaza2.Adapter#connect()
	 */

	public void connect() {
		this.plaza2Client.connect();
	}

	// Disconnect from gate
	/*
	 * (non-Javadoc)
	 * 
	 * @see trading.app.adapter.plaza2.Adapter#disconnect()
	 */

	public void disconnect() {
		this.plaza2Client.disconnect();
	}

	/**
	 * Instrument adapter
	 */
	public InstrumentAdapter getInstrumentAdapter() {
		return instrumentAdapter;
	}
	/**
	 * Level1 adapter
	 */
	public Level1Adapter getLevel1Adapter() {
		return level1Adapter;
	}

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
			ISubscriber specificAdapter = adaptersByMessage.get(msgData
					.getMsgName());
			if (specificAdapter != null) {
				specificAdapter.onMessage(conn, listener, msgData);
			}
			//System.out.println(message);
			break;
		// Timeout
		case MessageType.MSG_P2MQ_TIMEOUT:
			System.out.println("Timeout message");
			break;
		// Default
		default:
			System.out.println(message);
			System.out.println(String.format("Message type: %d",
					message.getType()));
		}

		return ErrorCode.OK;
	}

}