package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.domain.MessageVO;
import com.example.mapper.MessageMapper;
import com.example.service.MessageService;

@RestController
public class MessageController {
	@Autowired
	MessageMapper mapper;
	
	@Autowired
	MessageService service;
	
    //메시지 삭제하기
	@RequestMapping("/message/sdelete")
	public void sdelete(int mid) {
		mapper.updateSdel(mid);
	}
	
    //보낸메시지 리스트
	@RequestMapping("/list/send")
	public List<MessageVO> listSend(String id){		
		return mapper.listSend(id);
	}
	
	 //받은메시지 리스트
	@RequestMapping("/list/received")
	public List<MessageVO> listReceived(String id){		
		return mapper.listReceived(id);
	}
	
	//메시지 보내기
	@RequestMapping("/message/insert")
	public void insert(MessageVO vo) {
		service.insert(vo);
	}
	
    //받은 메시지 읽기
	@RequestMapping("/message/read")
	public MessageVO read(int mid) {
		return service.read(mid);
	}
	
    //삭제된 목록 보이기
	@RequestMapping("/list/delete")
	public List<MessageVO> listDelete(String id){		
		return mapper.listDelete(id);
	}
	
    //삭제복원하기
	@RequestMapping("/list/RestoreSdel")
	public void update(int mid) {
		mapper.RestoreSdel(mid);
	}
}
