package com.example.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.AddressVO;
import com.example.mapper.AddressMapper;

@Controller
public class AddressController {
	@Autowired
	AddressMapper mapper;
	
	@RequestMapping("/add/list")
	public String list(Model model) {
		model.addAttribute("list",mapper.list());
		return "/add/list";
	}
	
	@RequestMapping("/add/insert")
	public String insert() {

		return "/add/insert";
		
	}
	
	
	@RequestMapping(value="/add/insert",method = RequestMethod.POST)
	public String insertPost(AddressVO vo) {
		System.out.println(vo.toString());
		mapper.insert(vo);
		//return "/add/insert";
		return "redirect:list";	
	}
	
	@RequestMapping("/add/read")
	public String read(int id,Model model) {
		model.addAttribute("vo",mapper.read(id));
		return "/add/read";
		
	}
	
	@RequestMapping(value="/add/update",method = RequestMethod.POST)
	public String updatePost(AddressVO vo) {
		System.out.println(vo.toString());
		mapper.update(vo);
		return "redirect:list";	
	}
	
	@RequestMapping(value="/add/delete",method = RequestMethod.POST)
	public String deletePost(AddressVO vo) {
		System.out.println(vo.toString());
		mapper.delete(vo.getId());
		return "redirect:list";	
	}
	
	@RequestMapping(value="/add/rest/list")
	@ResponseBody
	public HashMap<String, Object> test() {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("list", mapper.list());
		return map;
		
	}
	
	@RequestMapping(value="/add/rest/insert",method = RequestMethod.POST)
	@ResponseBody
	public void restInsert(@RequestBody AddressVO vo) {
		mapper.insert(vo);
		
		
	}
	
	@RequestMapping(value="/add/rest/update",method = RequestMethod.POST)
	@ResponseBody
	public void restUpdate(@RequestBody AddressVO vo) {
		System.out.println(vo.toString());
		mapper.update(vo);
		
		
	}
	
	
	@RequestMapping(value="/add/rest/delete",method = RequestMethod.POST)
	@ResponseBody
	public void restDelete(int id) {
		mapper.delete(id);
		
		
	}
	
	@RequestMapping(value="/add/rest/read/{id}",method = RequestMethod.GET)
	@ResponseBody
	public AddressVO restRead(@PathVariable("id") int id) {
		return mapper.read(id);

	}
	
	@RequestMapping(value="/add/address")
	public String address() {
		return "/add/address";
	}
}
