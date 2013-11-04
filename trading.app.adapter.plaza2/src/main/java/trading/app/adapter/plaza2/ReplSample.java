package trading.app.adapter.plaza2;



/*
Copyright (c) 2012, MICEX-RTS. All rights reserved.

Plaza-2 Client Gate API Usage Sample.
Replication DataStream Client.

All the software and documentation included in this and any
other MICEX-RTS CGate Releasese is copyrighted by MICEX-RTS.

Redistribution and use in source and binary forms, with or without
modification, are permitted only by the terms of a valid
software license agreement with MICEX-RTS.

THIS SOFTWARE IS PROVIDED "AS IS" AND MICEX-RTS DISCLAIMS ALL WARRANTIES
EXPRESS OR IMPLIED, INCLUDING WITHOUT LIMITATION, ANY IMPLIED WARRANTIES OF
NON-INFRINGEMENT, MERCHANTABILITY OR FITNESS FOR A PARTICULAR
PURPOSE.  MICEX-RTS DOES NOT WARRANT THAT USE OF THE SOFTWARE WILL BE
UNINTERRUPTED OR ERROR-FREE.  MICEX-RTS SHALL NOT, UNDER ANY CIRCUMSTANCES, BE
LIABLE TO LICENSEE FOR LOST PROFITS, CONSEQUENTIAL, INCIDENTAL, SPECIAL OR
INDIRECT DAMAGES ARISING OUT OF OR RELATED TO THIS AGREEMENT OR THE
TRANSACTIONS CONTEMPLATED HEREUNDER, EVEN IF MICEX-RTS HAS BEEN APPRISED OF
THE LIKELIHOOD OF SUCH DAMAGES.
*/

import ru.micexrts.cgate.*;
import ru.micexrts.cgate.messages.*;

public class ReplSample {

private class Subscriber implements ISubscriber{

@Override
public int onMessage(Connection conn, Listener listener, Message message) {
	
	
	System.out.println(message);
	
	return ErrorCode.OK;
}
}

private Connection connection;
private Listener listener;


private static volatile boolean exitFlag = false;
private static volatile boolean cleanedUp = false;

public void run() throws CGateException {	
Runtime.getRuntime(). addShutdownHook(new Thread() {
	public void run() {
		exitFlag = true;
		while (!cleanedUp);
	}
});

try
{
	CGate.open("ini=jsend.ini;key=11111111");
	connection = new Connection("p2tcp://127.0.0.1:4001;app_name=jtest_repl");
	//listener = new Listener(connection, "p2repl://FORTS_FUTINFO_REPL", new Subscriber());
	//listener = new Listener(connection, "p2repl://FORTS_FUTTRADE_REPL", new Subscriber());
	listener = new Listener(connection, "p2repl://FORTS_FUTCOMMON_REPL", new Subscriber());
	
	while (!exitFlag) {
	
		int state = connection.getState();
		switch (state) {
			
			case State.ERROR:						connection.close();
				break;
			case State.CLOSED:
				try {							connection.open("");
				} 
				catch (CGateException ec) {
					System.err.println("Failed opening connection: " + ec);
				}
				break;
			case State.ACTIVE:
				int result = connection.process(1);

				if (result != ErrorCode.OK && result != ErrorCode.TIMEOUT)
				{
					System.err.println(String.format("Warning: connection state request failed: 0x%X", result));
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
				}
				catch (CGateException el) {
					System.err.println("Failed working with listener: " + el);
				}						
				break;

		}
	}
}
catch (CGateException cgex) {
	System.out.println("Exception: " + cgex);
}
finally {	
	if (listener != null) {
		try { listener.close(); } catch (CGateException cgex) {}
		try { listener.dispose(); } catch (CGateException cgex) {}
	}			
	if (connection != null) {
		try { connection.close(); } catch (CGateException cgex) {}
		try { connection.dispose(); } catch (CGateException cgex) {}
	}
	CGate.close();
	cleanedUp = true;
}
}


/**
* @param args
* @throws InterruptedException 
*/
public static void main(String[] args) throws CGateException, InterruptedException{

new ReplSample().run();
}

}
