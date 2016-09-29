package com.shaglama.SSS;

import com.shaglama.Messenger.Handle;
import com.shaglama.Messenger.Message;
import com.shaglama.Messenger.MessageType;
import com.shaglama.Messenger.MessengerListener;

public abstract class Module implements MessengerListener{
	private String id;
	private Handle handle;
	public Module(String id, Handle handle) {
		this.id = id;
		this.handle = handle;
	}
	public String getId(){
		return id;
	}
	public void postMessage(MessageType type,String audience, Object data ){
		handle.sendMessage(type, audience, data);		
	}
	public void postEvent(String audience, Object data){
		handle.sendMessage(MessageType.EVENT, audience, data);
	}
	public void postError(String audience,Object data){
		handle.sendMessage(MessageType.ERROR, audience, data);
	}
	public void postInfo(String audience,Object data){
		handle.sendMessage(MessageType.INFO, audience, data);
	}
	public void postLog(String audience,Object data){
		handle.sendMessage(MessageType.LOG, audience, data);
	}
	public abstract void newMessage(Message message);
}
