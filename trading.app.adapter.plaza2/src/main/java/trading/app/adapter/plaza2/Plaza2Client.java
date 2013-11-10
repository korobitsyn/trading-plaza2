package trading.app.adapter.plaza2;

import java.util.ArrayList;
import java.util.List;

import ru.micexrts.cgate.*;
import ru.micexrts.cgate.messages.*;

/**
 * Plaza2 client
 * 
 * @author dima
 * 
 */
public class Plaza2Client {

	private Connection connection;
	private List<Listener> listeners = new ArrayList<Listener>();
	private Plaza2Adapter plaza2Adapter;

	private static volatile boolean exitFlag = false;
	private static volatile boolean cleanedUp = false;
	private static int MAX_CONNECTION_ATTEMPT = 5;
	private static int connectionAttempts = 0;

	/**
	 * Ctor for plaza2 adapter
	 * 
	 * @param adapter
	 */
	public Plaza2Client(Plaza2Adapter adapter) {
		plaza2Adapter = adapter;
	}

	/**
	 * Run cycle
	 * 
	 * @throws CGateException
	 */
	public void run() {
		exitFlag = false;
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				exitFlag = true;
				while (!cleanedUp)
					;
			}
		});

		try {
			// CGate.open("key=11111111");
			CGate.open("ini=ini/jsend.ini;key=11111111");
			connection = new Connection(
					"p2tcp://127.0.0.1:4001;app_name=plaza2_client");

			// Create listeners
			listeners.add(new Listener(connection,
					"p2repl://FORTS_FUTINFO_REPL", plaza2Adapter));
			/*listeners.add(new Listener(connection,
					"p2repl://FORTS_FUTCOMMON_REPL", plaza2Adapter));*/

			while (!exitFlag) {

				int state = connection.getState();
				switch (state) {

				case State.ERROR:
					connection.close();
					break;
				case State.CLOSED:
					if (connectionAttempts >= MAX_CONNECTION_ATTEMPT) {
						System.err.println("Max connection attempts reached");
						exitFlag = true;
					} else if (!exitFlag) {
						try {
							connection.open("");
						} catch (CGateException ec) {
							connectionAttempts++;
							System.err.println("Failed opening connection: "
									+ ec);
						}
					}
					break;
				case State.ACTIVE:

					int result = connection.process(1);

					if (result != ErrorCode.OK && result != ErrorCode.TIMEOUT) {
						System.err
								.println(String
										.format("Warning: connection state request failed: 0x%X",
												result));
					}
					// Process listeners
					for (Listener listener : listeners) {
						try {
							int listenerState = listener.getState();
							switch (listenerState) {
							case State.ERROR:
								listener.close();
								break;
							case State.CLOSED:
								listener.open("");
								break;
							}
						} catch (CGateException el) {
							System.err.println("Failed working with listener: "
									+ el);
						}
					}
					break;

				}
			}
		} catch (CGateException cgex) {
			System.out.println("Exception: " + cgex);
		} finally {
			// Close listener
			for (Listener listener : listeners) {

				if (listener != null) {
					try {
						listener.close();
					} catch (CGateException cgex) {
					}
					try {
						listener.dispose();
					} catch (CGateException cgex) {
					}
				}
			}
			// Close connection
			if (connection != null) {
				try {
					connection.close();
				} catch (CGateException cgex) {
				}
				try {
					connection.dispose();
				} catch (CGateException cgex) {
				}
			}
			// Close cgate

			try {
				// Close plaza gate
				CGate.close();
			} catch (CGateException cgex) {

			}
			cleanedUp = true;
		}
	}

	/**
	 * Connect to plaza gate - start run cycle in another thread
	 */
	public void connect() {
		final Plaza2Client this_ = this;
		new Thread(new Runnable() {
			public void run() {
				this_.run();

			}
		}).start();
	}

	/**
	 * Disconnect from gate
	 */
	public void disconnect() {
		exitFlag = true;
		cleanedUp = false;
	}

}
