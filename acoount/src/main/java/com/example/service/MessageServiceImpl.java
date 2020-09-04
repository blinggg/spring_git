package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.domain.MessageVO;
import com.example.mapper.MessageMapper;
import com.example.mapper.UserMapper;

@Service
public class MessageServiceImpl implements MessageService{
	@Autowired
	MessageMapper mmapper;
	
	@Autowired
	UserMapper umapper;
	
	@Transactional
	@Override
	public MessageVO read(int mid) {
		MessageVO vo=mmapper.read(mid);
		if(vo.getReadDate()==null) {
			umapper.update(vo.getReceiver(), 5);
			mmapper.updateRead(mid);
			vo=mmapper.read(mid);
		}
		
		return vo;
	}
	
	@Transactional
	@Override
	public void insert(MessageVO vo) {
		mmapper.insert(vo);
		umapper.update(vo.getSender(), 10);
		
	}
}
