package com.ggiriggiri.web.chat;

public class ChatMessage {
	private int chatId;
	private String username;
	private String chatData;
	
	public int getChatId() {
		return chatId;
	}
	public void setChatId(int chatId) {
		this.chatId = chatId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getChatData() {
		return chatData;
	}
	public void setChatData(String chatData) {
		this.chatData = chatData;
	}
	
}
