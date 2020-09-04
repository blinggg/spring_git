package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.BoardVO;
import com.example.domain.Criteria;
import com.example.domain.PageMaker;
import com.example.mapper.BoardMapper;

@Controller
public class BoardController {
	@Autowired
	BoardMapper mapper;
	
	@RequestMapping("/board/list")
	public String list(Model model,Criteria cri) {
		cri.setPerPageNum(10);
		
		PageMaker pm=new PageMaker();
		pm.setCri(cri);
		pm.setTotalCount(mapper.totalCount(cri));
		
		model.addAttribute("cri", cri);
		model.addAttribute("pm", pm);
		model.addAttribute("list",mapper.list(cri));
		return "/board/list";
	}
	
	@RequestMapping("/board/read")
	public void read(int bno,Model model,Criteria cri) {
		model.addAttribute("cri", cri);
		
		model.addAttribute("vo", mapper.read(bno));
	}
	
	@RequestMapping(value="/board/delete",method=RequestMethod.POST)
	public String deletePost(int bno,Model model,Criteria cri) {
		mapper.delete(bno);
		model.addAttribute("page", cri.getPage());
		
		return "redirect:list";
	
	}
	
	@RequestMapping(value="/board/update",method=RequestMethod.POST)
	public String updatePost(BoardVO vo, Model model, Criteria cri) {
		mapper.update(vo);
		model.addAttribute("page", cri.getPage());
		return "redirect:list";
	}
	
	@RequestMapping(value="/replyCount",method=RequestMethod.POST)
	@ResponseBody
	public int replyCount(int bno) {
		int count=mapper.replyCount(bno);
		if(count==0) {
			mapper.delete(bno);
		}
		return count;
	}
}