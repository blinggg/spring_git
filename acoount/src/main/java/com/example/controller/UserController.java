package com.example.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.UserVO;
import com.example.mapper.UserMapper;

@Controller
public class UserController {
	@Autowired
	UserMapper mapper;
	
	
	@RequestMapping("/user/list")
	public void list(Model model){
		model.addAttribute("list",mapper.list());
	}
	
	@RequestMapping("/user/send")
	public void readsend(Model model,String id){
		model.addAttribute("list",mapper.list());
		model.addAttribute("vo",mapper.read(id));
	}
	
	@RequestMapping("/user/receive")
	public void readreceive(Model model,String id){
		model.addAttribute("list",mapper.list());
		model.addAttribute("vo",mapper.read(id));
	}
	
	@RequestMapping("/user/getUser")
	@ResponseBody
	public UserVO getUser(String id){
		return mapper.read(id);
	}
	
}
