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
	MessageMapper mMapper;
	
	@Autowired
	UserMapper uMapper;
	
	@Transactional
	@Override
	public MessageVO read(int mid) {
		MessageVO vo=mMapper.read(mid);
		if(vo.getReadDate()==null) {
			uMapper.update(vo.getReceiver(), 5);
			mMapper.updateRead(mid);
			vo=mMapper.read(mid);
		}
		return vo;
	}
	
	@Transactional
	@Override
	public void insert(MessageVO vo) {
		mMapper.insert(vo);
		uMapper.update(vo.getSender(), 10);
	}
	
}
