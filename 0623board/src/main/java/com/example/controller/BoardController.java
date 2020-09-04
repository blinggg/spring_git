package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.domain.BoardVO;
import com.example.mapper.BoardMapper;

@Controller
@RequestMapping("/board/")
public class BoardController {
	@Autowired
	BoardMapper mapper;
	
	@RequestMapping("list")
	public String list(Model model) {
		model.addAttribute("list",mapper.list());
		return "/board/list";
	}
		//void>> return list
	@RequestMapping("insert")
	public void insert() {
		
	}
	
	@RequestMapping(value="insert",method=RequestMethod.POST)
	public String insertPost(BoardVO vo) {
		System.out.println(vo.toString());
		mapper.insert(vo);
		return "redirect:list";
	}
	
	@RequestMapping("read")
	public void read(int bno, Model model) {
		System.out.println("bno"+bno);
		model.addAttribute("vo",mapper.read(bno));
		//return "redirect:list";
		
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updatePost(BoardVO vo) {
		System.out.println(vo.toString());
		mapper.update(vo);
		return "redirect:list";
	}
	
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String deletePost(int bno) {
		mapper.delete(bno);
		return "redirect:list";
	}
}
