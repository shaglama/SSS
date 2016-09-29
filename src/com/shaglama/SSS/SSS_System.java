package com.shaglama.SSS;
import com.shaglama.Messenger.*;

public class SSS_System extends Module {
	public SSS_System(Handle handle) {
		// TODO Auto-generated constructor stub
		super("SSS_System",handle);
	}

	@Override
	public void newMessage(Message message){
		MessageType type = message.getType();
		switch(type){
		case EVENT:
			postInfo("system", "event recieved: " + message.getData().toString());
			break;
		case ERROR:
			postInfo("system", "An error occurred: " + message.getData().toString());
			break;
		case INFO:
			break;
		case LOG:
			
			break;
			default:
				//error
		}
		
	}

}
