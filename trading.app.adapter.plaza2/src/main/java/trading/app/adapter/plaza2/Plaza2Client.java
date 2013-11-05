package trading.app.adapter.plaza2;


import ru.micexrts.cgate.*;
import ru.micexrts.cgate.messages.*;

/**
 * Plaza2 client
 * @author dima
 *
 */
public class Plaza2Client {

	private Connection connection;
	private Listener listener;

	private static volatile boolean exitFlag = false;
	private static volatile boolean cleanedUp = false;

	/**
	 * Run cycle
	 * @throws CGateException
	 */
	
	public void run() throws CGateException {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				exitFlag = true;
				while (!cleanedUp)
					;
			}
		});

		try {
			CGate.open("key=11111111");
			//CGate.open("ini=./jsend.ini;key=11111111");			
			connection = new Connection(
					"p2tcp://127.0.0.1:4001;app_name=plaza2_client");
			// listener = new Listener(connection,
			// "p2repl://FORTS_FUTINFO_REPL", new Subscriber());
			// listener = new Listener(connection,
			// "p2repl://FORTS_FUTTRADE_REPL", new Subscriber());
			listener = new Listener(connection,
					"p2repl://FORTS_FUTCOMMON_REPL", new Subscriber());

			while (!exitFlag) {

				int state = connection.getState();
				switch (state) {

				case State.ERROR:
					connection.close();
					break;
				case State.CLOSED:
					try {
						connection.open("");
					} catch (CGateException ec) {
						System.err.println("Failed opening connection: " + ec);
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
					break;

				}
			}
		} catch (CGateException cgex) {
			System.out.println("Exception: " + cgex);
		} finally {
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
			CGate.close();
			cleanedUp = true;
		}
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
