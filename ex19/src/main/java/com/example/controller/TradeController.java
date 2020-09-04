package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.TradeVO;
import com.example.mapper.TradeMapper;
import com.example.service.TradeService;

@RestController
public class TradeController {
	@Autowired
	TradeMapper mapper;
	@Autowired
	TradeService service;
	
	@RequestMapping("/trade/insert")
	public void insert(TradeVO vo) {
		service.insert(vo);
	}
	
	@RequestMapping("/trade/list")
	public List<TradeVO> list(String ano) {
		return mapper.list(ano);
	}
}
