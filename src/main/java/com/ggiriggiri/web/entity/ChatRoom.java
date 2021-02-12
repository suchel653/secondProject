package com.ggiriggiri.web.entity;

public class ChatRoom {
	private int id;
	private String name;
	
	public ChatRoom() {
		// TODO Auto-generated constructor stub
	}

	public ChatRoom(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "ChatRoom [id=" + id + ", name=" + name + "]";
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
	
}
