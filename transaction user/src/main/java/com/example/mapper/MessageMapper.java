package com.example.mapper;

import java.util.List;

import com.example.domain.MessageVO;

public interface MessageMapper {
	public List<MessageVO> listSend(String id);
	public List<MessageVO> listReceived(String id);
	public void insert(MessageVO vo);
	public MessageVO read(int mid);
	public void updateRead(int mid);
	public void updateSdel(int mid);
	public List<MessageVO> listDelete(String id);
	public void RestoreSdel(int mid);
	
}
