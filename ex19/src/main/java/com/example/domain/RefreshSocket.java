package com.example.domain;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class RefreshSocket extends TextWebSocketHandler{
	//������ ����� ����ŭ Ŭ���̾�Ʈ�� �ؽ����� ������
	 Set<WebSocketSession> clients=new HashSet<WebSocketSession>();
	 
	//ä�ù��� ������
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("closed");
		//���������ߴ��� ���� �ֱ�
		clients.add(session);
		super.afterConnectionEstablished(session);
	}

	//�������� ��
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println(session+"connect");
		super.afterConnectionClosed(session, status);
	}
	
	//�޽����� ������ ��
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
