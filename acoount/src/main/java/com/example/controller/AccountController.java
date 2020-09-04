package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mapper.AccountMapper;

@Controller
public class AccountController {
	@Autowired
	AccountMapper mapper;
	
	@RequestMapping("/account/list")
	public void list(Model model) {
		model.addAttribute("list",mapper.list());
	}
	
	@RequestMapping("/account/read")
	public void read(String ano,Model model) {
		model.addAttribute("vo",mapper.read(ano));
		model.addAttribute("list",mapper.list());
	}
}
