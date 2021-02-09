package com.ggiriggiri.web.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.WebSocketSession;


public class ChatRoom {
	private int id;
	private String name;
	private List<WebSocketSession> sessions;
	
	public ChatRoom() {
		sessions = new ArrayList<>();
	}

	public ChatRoom(int id, String name, List<WebSocketSession> sessions) {
		super();
		this.id = id;
		this.name = name;
		this.sessions = sessions;
	}

	@Override
	public String toString() {
		return "ChatRoom [id=" + id + ", name=" + name + ", sessions=" + sessions + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<WebSocketSession> getSessions() {
		return sessions;
	}

	public void setSessions(List<WebSocketSession> sessions) {
		this.sessions = sessions;
	}
	
}
