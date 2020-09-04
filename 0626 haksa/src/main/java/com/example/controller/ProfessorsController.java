package com.example.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.mapper.ProfessorsMapper;

@Controller
public class ProfessorsController {
	@Autowired
	ProfessorsMapper mapper;
	
	@RequestMapping("/pro/list")
	public String list(Model model) {
		model.addAttribute("list",mapper.list());
		return "/pro/list";
	}
	
	@RequestMapping("/pro/plist")
	@ResponseBody
	public HashMap<String, Object> plist(String pcode){
		HashMap<String, Object> map=new HashMap<String,Object>();
		map.put("slist", mapper.slist(pcode));
		map.put("clist", mapper.clist(pcode));
		System.out.println(map);
		return map;
		
	}
	
}
