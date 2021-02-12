package com.ggiriggiri.web.chat;

import org.springframework.web.socket.WebSocketSession;

public class Client {
	private int type;
	private int chatId;
	private WebSocketSession session;
	
	public Client() {

	}
	
	public Client(int type, int chatId, WebSocketSession session) {
		super();
		this.type = type;
		this.chatId = chatId;
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

	public int getChatId() {
		return chatId;
	}

	public void setChatId(int chatId) {
		this.chatId = chatId;
	}
	
}
