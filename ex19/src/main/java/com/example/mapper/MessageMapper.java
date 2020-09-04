package com.example.mapper;

import java.util.List;

import com.example.domain.MessageVO;

public interface MessageMapper {
	public List<MessageVO> listSend(String id);
	public List<MessageVO> listReceive(String id);
	public void insert(MessageVO vo);
	public MessageVO read(int mid);
	public void updateRead(int mid);
	public void updateSdel(int mid);
	public void updateRdel(int mid);
}
