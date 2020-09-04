package com.example.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mapper.UserMapper;

@RestController //리스폰스 바디 생략가능
public class UserController {
	@Autowired
	UserMapper mapper;
	
	@RequestMapping("/user/rest/list")
	public HashMap<String, Object> list() {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("list", mapper.list());
		return map;
	}
}
