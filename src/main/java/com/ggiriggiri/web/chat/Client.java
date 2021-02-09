package com.ggiriggiri.web.chat;

import org.springframework.web.socket.WebSocketSession;

public class Client {
	private int type;
	private WebSocketSession session;
	
	public Client() {

	}
	
	public Client(int type, WebSocketSession session) {
		super();
		this.type = type;
		this.session = session;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public WebSocketSession getSession() {
		return session;
	}

	public void setSession(WebSocketSession session) {
		this.session = session;
	}
	
	
}
