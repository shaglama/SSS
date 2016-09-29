package com.shaglama.Messenger;

public class Message {
	private MessageType type;
	private String audience;
	private Object data;

	public Message(MessageType type,String audience, Object data) {
		setType(type);
		setAudience(audience);
		setData(data);
	}

	public MessageType getType() {
		return type;
	}

	private void setType(MessageType type) {
		this.type = type;
	}

	public String getAudience() {
		return audience;
	}

	private void setAudience(String audience) {
		this.audience = audience;
	}

	public Object getData() {
		return data;
	}

	private void setData(Object data) {
		this.data = data;
	}
}