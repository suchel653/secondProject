package com.ggiriggiri.web.handler;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ChatWebSocketHandler extends TextWebSocketHandler {

	private List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessions.add(session);
		System.out.println(sessions.size()+"명이 연결");
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		for(WebSocketSession ws : sessions)
			ws.sendMessage(message);
		
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessions.remove(session);
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
