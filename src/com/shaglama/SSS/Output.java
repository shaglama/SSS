package com.shaglama.SSS;

import com.shaglama.Messenger.Handle;
import com.shaglama.Messenger.Message;
import com.shaglama.Messenger.MessageType;

public class Output extends Module{

	public Output(Handle handle) {
		// TODO Auto-generated constructor stub
		super("output",handle);
	}
	@Override
	public void newMessage(Message message){
		MessageType type = message.getType();
		switch(type){
		case EVENT:
			
			break;
		case ERROR:
			
			break;
		case INFO:
			System.out.println(message.getAudience() + " -- " + message.getData().toString());
			break;
		case LOG:
			
			break;
		default:
			//error		
		}
	}
}
