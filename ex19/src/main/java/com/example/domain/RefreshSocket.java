package com.example.domain;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class RefreshSocket extends TextWebSocketHandler{
	//접속한 사람의 수만큼 클라이언트에 해쉬셋이 생성됨
	 Set<WebSocketSession> clients=new HashSet<WebSocketSession>();
	 
	//채팅방이 닫힐때
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("closed");
		//누가접속했는지 정보 넣기
		clients.add(session);
		super.afterConnectionEstablished(session);
	}

	//접속했을 때
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println(session+"connect");
		super.afterConnectionClosed(session, status);
	}
	
	//메시지를 보냈을 때
	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		super.handleMessage(session, message);
		String strMessage=(String)message.getPayload();
		System.out.println(strMessage);
		for(WebSocketSession client:clients) {
			if(!client.equals(session)) {
				client.sendMessage(new TextMessage(strMessage));
			}
		}
	}
	 
}
