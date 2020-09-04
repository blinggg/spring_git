package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.EnoVO;
import com.example.mapper.EnoMapper;

@RestController
public class EnoController {
	@Autowired
	EnoMapper mapper;
	
	@RequestMapping(value="/eno/insert", method=RequestMethod.POST)
	public void insert(EnoVO vo) {
		mapper.insert(vo);
	}
	
	@RequestMapping(value="/eno/delete", method=RequestMethod.POST)
	public void delete(EnoVO vo) {
		mapper.delete(vo);
	}
	
	@RequestMapping(value="/eno/update", method=RequestMethod.POST)
	public void update(EnoVO vo) {
		mapper.update(vo);
	}
	
	@RequestMapping(value="/eno/read", method=RequestMethod.GET)
	public int read(EnoVO vo) {
		return mapper.read(vo);
	}
}
