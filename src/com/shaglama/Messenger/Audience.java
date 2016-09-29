package com.shaglama.Messenger;

import java.util.ArrayList;

public class Audience {
	private String name;
	private ArrayList<MessengerListener> event = new ArrayList<MessengerListener>();
	private ArrayList<MessengerListener> info = new ArrayList<MessengerListener>();
	private ArrayList<MessengerListener> error = new ArrayList<MessengerListener>();
	private ArrayList<MessengerListener> log = new ArrayList<MessengerListener>();
	private MessageType[] types = new MessageType[] {MessageType.EVENT,MessageType.INFO,MessageType.ERROR,MessageType.LOG};
	public Audience(String name) {
		this.name = name;
	}
	public Audience(String name, MessengerListener[] members){
		this.name=name;
		for(MessengerListener listener : members){
			add(listener);
		}	
	}
	public void add(MessengerListener listener){
		add(listener,types);
	}
	public void add(MessengerListener listener,MessageType filter) {
		switch(filter){
		case EVENT:
			if(!event.contains(listener)){
				event.add(listener);
			}
			break;
		case INFO:
			if(!info.contains(listener)){
				info.add(listener);
			}
			break;
		case LOG:
			if(!log.contains(listener)){
				log.add(listener);
			}
			break;
		case ERROR:
			if(!error.contains(listener)){
				error.add(listener);
			}
			break;
		default:
			//error
		}
	}
	public void add(MessengerListener listener, MessageType[] filters){
		for(MessageType filter : filters){
			add(listener,filter);
		}
	}
	
	public void remove(MessengerListener listener){
		remove(listener,types);
	}
	public void remove(MessengerListener listener,MessageType filter){
		switch(filter){
		case EVENT:
			event.remove(listener);
			break;
		case INFO:
			
			info.remove(listener);
			break;
		case LOG:
			log.remove(listener);
			break;
		case ERROR:
			error.remove(listener);
			break;
		default:
			//error
		}
	}
	public void remove(MessengerListener listener,MessageType[] filters){
		for(MessageType filter : filters){
			remove(listener,filter);
		}
	}
	public MessengerListener[] getMembers(){
		return getMembers(types);
		
	}
	public MessengerListener[] getMembers(MessageType filter){
		MessengerListener[] out;
		switch(filter){
		case EVENT:
			out = event.toArray(new MessengerListener[event.size()]);
			break;
		case INFO:
			out = info.toArray(new MessengerListener[info.size()]);
			break;
		case LOG:
			out = log.toArray(new MessengerListener[log.size()]);
			break;
		case ERROR:
			out = error.toArray(new MessengerListener[error.size()]);
			break;
		default:
			out = new MessengerListener[0];
		}
		return out;
	}
	public MessengerListener[] getMembers(MessageType[] filters){
		ArrayList<MessengerListener> list = new ArrayList<MessengerListener>();
		MessengerListener[] members;
		for(MessageType filter : filters){
			members = getMembers(filter);
			for(MessengerListener member : members){
				if(!list.contains(member)){
					list.add(member);
				}
			}
		}
		return list.toArray(new MessengerListener[list.size()]);
	}
	public String getName() {
		
		return name;
	}
}