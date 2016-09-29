package com.shaglama.Messenger;
import java.util.HashMap;
import java.util.Set;

public class Messenger {
	HashMap<String, Audience> audiences = new HashMap<String, Audience>();
	
	public Messenger() {
		
	}
	
	public int post(Message message){
		return fireNewMessageEvent(message);
	}
	private int fireNewMessageEvent(Message msg){
		MessengerListener[] members;
		String audience = msg.getAudience();
		if(audiences.containsKey(audience)){
			members = audiences.get(audience).getMembers(msg.getType());
			for(MessengerListener l : members){
				l.newMessage(msg);
			}
			return 1;
		} else {
			return -1;
		}
		
		
	}
	public int addAudience(String name){
		if(audiences.containsKey(name)){
			return -1;
		} else {
			audiences.put(name, new Audience(name));
			return 1;
		}
	}
	public int removeAudience(String name){
		if(audiences.containsKey(name)){
			audiences.remove(name);
			return 1;
		} else {
			return -1;
		}
		
	}
	public String[] listAudiences(){	
		Set<String> set = audiences.keySet();
		return set.toArray(new String[set.size()]);	
	}
	public int addToAudience(String audience,MessengerListener listener){
		Audience members;
		if(audiences.containsKey(audience)){
			members = audiences.get(audience);
			members.add(listener);
			return 1;
		} else {
			return -1;
		}
	}
	public int addToAudience(String audience,MessengerListener listener, MessageType filter){
		Audience members;
		if(audiences.containsKey(audience)){
			members = audiences.get(audience);
			members.add(listener,filter);
			return 1;
		} else {
			return -1;
		}
	}
	public int addToAudience(String audience, MessengerListener listener, MessageType[] filters){
		Audience members;
		if(audiences.containsKey(audience)){
			members = audiences.get(audience);
			members.add(listener,filters);
			return 1;
		} else {
			return -1;
		}
	}
	public int removeFromAudience(String audience, MessengerListener listener){
		Audience members;
		if(audiences.containsKey(audience)){
			members= audiences.get(audience);
			members.remove(listener);
			return 1;
		} else {
			return -1;
		}
	}
	public int removeFromAudience(String audience, MessengerListener listener,MessageType filter){
		Audience members;
		if(audiences.containsKey(audience)){
			members= audiences.get(audience);
			members.remove(listener,filter);
			return 1;
		} else {
			return -1;
		}
	}
	public int removeFromAudience(String audience, MessengerListener listener,MessageType[] filters){
		Audience members;
		if(audiences.containsKey(audience)){
			members= audiences.get(audience);
			members.remove(listener,filters);
			return 1;
		} else {
			return -1;
		}
	}
	public Handle makeHandle(String id){
		return new Handle(this,id);
		
	}
}