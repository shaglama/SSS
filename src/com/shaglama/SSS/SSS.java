package com.shaglama.SSS;

import com.shaglama.Messenger.*;

public class SSS {

	public static void main(String[] args) {
		//create messenger and audiences for test
		Messenger messenger = new Messenger();
		messenger.addAudience("system");
		messenger.addAudience("output");
		messenger.addAudience("logger");
		
		//using a lambda expression to create a listener instead of creating a new class that implements MesssengerListener interface
		MessengerListener l = (message) -> System.out.println("used lambda, message: " + message.getData());
		
		//create listeners using classes that implmenet MessengerListener interface
		SSS_System system = new SSS_System(messenger.makeHandle("SSS_System"));
		Output out = new Output(messenger.makeHandle("output"));
		Logger log = new Logger(messenger.makeHandle("logger"));
		
		//add lambda listener to audience
		messenger.addToAudience("system",l);
		
		//add class based listeners to audiences
		messenger.addToAudience("system", system);
		messenger.addToAudience("system", log);
		messenger.addToAudience("system", out);
		messenger.addToAudience("output", out);
		messenger.addToAudience("output", log);		
		messenger.addToAudience("logger", log);	
		
		//send some messages to test
		Message msg = new Message(MessageType.EVENT,"system","message from SSS to system");
		messenger.post(msg);
		String[] audiences = messenger.listAudiences();
		for(int i = 0; i < audiences.length; i++){
			System.out.println(audiences[i]);
		}
		system.postEvent("system", "test");
		system.postInfo("system", "logging");
		system.postLog("system", "logging");
		system.postInfo("logger", "output from system");
		system.postLog("output", "log from system");
		system.postError("system", "ERROR");
	}
	
	
}
