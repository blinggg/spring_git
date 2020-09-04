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
		mapper.updateSdel(mid);
	}
	@RequestMapping("/message/rdelete")
	public void rdelete(int mid) {
		mapper.updateRdel(mid);
	}
	
	@RequestMapping("/list/send")
	public List<MessageVO> listSend(String id){
		
		return mapper.listSend(id);
	}
	
	@RequestMapping("/list/receive")
	public List<MessageVO> listReceive(String id){
		
		return mapper.listReceive(id);
	}
	
	@RequestMapping("/message/insert")
	public void insert(MessageVO vo) {
		service.insert(vo);
	}
	
	@RequestMapping("/message/read.json")
	public MessageVO read(int mid){
		return service.read(mid);
	}
}
