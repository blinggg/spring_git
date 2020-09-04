package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.domain.StudentsVO;
import com.example.mapper.StudentsMapper;

@Controller
@RequestMapping("/stu/")
public class StudentsController {
	@Autowired
	StudentsMapper mapper;
	
	@RequestMapping("list")
	public String list(Model model) {
		model.addAttribute("list",mapper.list());
		return "stu/list";
	}
	
	@RequestMapping("insert")
	public String insert() {
		return "stu/insert";
	}
	
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public String insertPost(StudentsVO vo) {
		System.out.println(vo.toString());
		mapper.insert(vo);
		return "redirect:list";
	
	}
}
