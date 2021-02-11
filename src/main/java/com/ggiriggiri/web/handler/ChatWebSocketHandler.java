package com.ggiriggiri.web.handler;

import java.net.URI;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ggiriggiri.web.chat.ChatMessage;
import com.ggiriggiri.web.chat.Client;

public class ChatWebSocketHandler extends TextWebSocketHandler {

	private List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();
	private List<Client> clientList = new CopyOnWriteArrayList<>();
	private ObjectMapper odjectMapper = new ObjectMapper();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		String uri = session.getUri().toString();
		String[] tokkens = uri.split("/");
		int type = 0;
		int chatId = Integer.parseInt(tokkens[4]);
		if(tokkens[3]=="study")
			type = 1;
		Client client = new Client(type,chatId,session);
		clientList.add(client);
		System.out.println("chatId : "+chatId);
		System.out.println("type : "+tokkens[3]);
		
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String msg = message.getPayload();
		ChatMessage chatmsg = odjectMapper.readValue(msg, ChatMessage.class);
		System.out.println(chatmsg.getChatId());
		
		for(Client client : clientList) {
			if(chatmsg.getChatId() == client.getChatId()) {
				client.getSession().sendMessage(message);
				System.out.println(message.getPayload());			
			}
		}
		
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
//		sessions.remove(session);
		for(Client client : clientList) {
			if(client.getSession() == session)
				clientList.remove(client);
		}
		System.out.println("연결이 해제되었습니다.");
		System.out.println(sessions.size()+"명이 연결");
	}
	
//	@Override
//	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//		System.out.println("누구야");
//	}
//
//	@Override
//	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
//		System.out.println(message.toString());
//
//	}
//
//	@Override
//	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public boolean supportsPartialMessages() {
//		// TODO Auto-generated method stub
//		return false;
//	}

}
