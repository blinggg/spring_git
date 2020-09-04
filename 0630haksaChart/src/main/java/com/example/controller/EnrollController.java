package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.EnrollVO;
import com.example.mapper.EnrollMapper;

@RestController
public class EnrollController {
	@Autowired
	EnrollMapper mapper;
	
	@RequestMapping(value="/enroll/insert",method=RequestMethod.POST)
	public void insert(EnrollVO vo) {
		mapper.insert(vo);
	}
	
	@RequestMapping(value="/enroll/delete",method=RequestMethod.POST)
	public void delete(EnrollVO vo) {
		mapper.delete(vo);
	}
	
	@RequestMapping(value="/enroll/update",method=RequestMethod.POST)
	public void update(EnrollVO vo) {
		mapper.update(vo);
	}
	
	@RequestMapping(value="/enroll/read",method=RequestMethod.GET)
	public void read(EnrollVO vo) {
		mapper.read(vo);
	}
}
