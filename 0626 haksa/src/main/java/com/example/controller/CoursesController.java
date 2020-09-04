package com.example.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.Criteria;
import com.example.domain.PageMaker;
import com.example.mapper.CoursesMapper;

@Controller
public class CoursesController {
	@Autowired
	CoursesMapper mapper;
	
	@RequestMapping("/cou/list")
	public String list(Model model, Criteria cri){
		cri.setPerPageNum(10);
		
		PageMaker pm=new PageMaker();
		pm.setCri(cri);
		pm.setTotalCount(mapper.totalCount());
		model.addAttribute("pm", pm);
		model.addAttribute("list", mapper.list(cri));
		return "/cou/list";
	}
	
	@RequestMapping("/cou/rest/slist")
	@ResponseBody
	public List<HashMap<String, Object>> slist(String lcode){
		return mapper.slist(lcode);
	}
}
