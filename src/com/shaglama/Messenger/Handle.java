package com.shaglama.Messenger;

public class Handle {
	Messenger messenger;
	String id;
	public Handle(Messenger messenger, String id) {
		this.messenger = messenger;
		this.id = id;
	}
	public void sendMessage(MessageType type,String audience, Object data){
		messenger.post(new Message(type,audience,data));	
	}	
}