package com.example.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.mapper.StudentsMapper;

@Controller
public class StudentsController {
	@Autowired
	StudentsMapper mapper;
	
	@RequestMapping("/stu/list")
	public String list(Model model) {
		model.addAttribute("list",mapper.list());
		return "/stu/list";
		
	}
	
	@RequestMapping("/stu/rest/elist")
	@ResponseBody
	public HashMap<String, Object> elist(String scode){
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("array", mapper.elist(scode));
		return map;
	}
}
