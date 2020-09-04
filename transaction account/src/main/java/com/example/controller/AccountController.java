package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.AccountVO;
import com.example.mapper.AccountMapper;

@Controller
public class AccountController {
	@Autowired
	AccountMapper mapper;
	
	@RequestMapping("/account/list")
	public void userlist(Model model,String id) {
		model.addAttribute("list",mapper.userList(id));
	}
	
	@RequestMapping("/account/read")
	public void read(Model model, String ano) {
		model.addAttribute("list",mapper.list());
		model.addAttribute("read",mapper.read(ano));
		
		System.out.println(mapper.read(ano));
	}
	
	@RequestMapping("/account/getBalance")
	@ResponseBody
	public AccountVO getBalance(String ano) {
		return mapper.read(ano);
	}
}
