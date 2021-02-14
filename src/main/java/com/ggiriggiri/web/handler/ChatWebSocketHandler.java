package com.ggiriggiri.web.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ggiriggiri.web.chat.ChatMessage;
import com.ggiriggiri.web.chat.Client;

public class ChatWebSocketHandler extends TextWebSocketHandler {

	private List<Client> clientList = new CopyOnWriteArrayList<>();
	private ObjectMapper odjectMapper = new ObjectMapper();
	private Map<Integer, List<TextMessage>> map = new HashMap<>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		String uri = session.getUri().toString();
		String[] tokkens = uri.split("/");
		int chatId = Integer.parseInt(tokkens[5]);
		int type = Integer.parseInt(tokkens[4]);
		
		Client client = new Client(type,chatId,session);
		clientList.add(client);
		
		if(map.get(chatId) != null) {
			List<TextMessage> list = map.get(chatId);
			for(TextMessage chat : list) 
				session.sendMessage(chat);
		}
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String msg = message.getPayload();
		ChatMessage chatmsg = odjectMapper.readValue(msg, ChatMessage.class);
		int chatId = chatmsg.getChatId();
		
		for(Client client : clientList) {
			if(chatId == client.getChatId() && chatmsg.getType() == client.getType()) {
				client.getSession().sendMessage(message);
				if(map.get(chatId) == null) {
					List<TextMessage> list = new ArrayList<>();
					map.put(chatId, list);
				}
				
				List<TextMessage> list = map.get(chatId);
				list.add(message);
				map.put(chatId, list);
			}
		}
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		for(Client client : clientList) {
			if(client.getSession() == session)
				clientList.remove(client);
		}
	}

}
