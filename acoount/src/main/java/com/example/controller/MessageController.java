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
	
	@RequestMapping("/message/sdelete")
	public void sdelete(int mid) {
		mapper.updatesdel(mid);
	}
	
	@RequestMapping("/list/send")
	public List<MessageVO> listsend(String id){
		return mapper.listsend(id);
	}
	
	@RequestMapping("/list/receive")
	public List<MessageVO> listreceive(String id){
		return mapper.listreceive(id);
	}
	
	@RequestMapping("/message/insert")
	public void insert(MessageVO vo) {
		service.insert(vo);
	}
	
	@RequestMapping("/message/read")
	public MessageVO read(int mid) {
		return service.read(mid);
	}
}
