package com.example.service;

import com.example.domain.MessageVO;

public interface MessageService {
	public MessageVO read(int mid);
	public void insert(MessageVO vo);
}
