package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.example.domain.BoardVO;
import com.example.domain.ChartVO;
import com.example.domain.Criteria;
import com.example.domain.PageMaker;
import com.example.mapper.BoardMapper;
import com.example.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	BoardMapper mapper;
	
	@RequestMapping("/board/insert")
	public void insert() {

	}
	
	@RequestMapping(value="/board/insert",method=RequestMethod.POST)
	public String insertPost(BoardVO vo) {
		mapper.insert(vo);
		return "redirect:list";
	}
	
	@RequestMapping("/board/list")
	public void list(Criteria cri, Model model,HttpServletRequest request){
		//저장되어있는 쿠키 불러오기
		Cookie cookie=WebUtils.getCookie(request, "id");
		if(cookie!=null) {
			request.getSession().setAttribute("id", cookie.getValue());
		}
		
		cri.setPerPageNum(5);
		PageMaker pm=new PageMaker();
		pm.setCri(cri);
		pm.setTotalCount(mapper.totalCount(cri));
		
		model.addAttribute("pm", pm);
		model.addAttribute("list", mapper.list(cri));
	}
	
	@Autowired
	BoardService service;
	
	@RequestMapping("/board/read")
	public void read(int bno, Model model){
		model.addAttribute("vo", service.read(bno));
	}
	
	@RequestMapping(value="/board/update", method=RequestMethod.POST)
	public String update(BoardVO vo, int page){
		System.out.println(vo.toString() + " page:" + page);
		mapper.update(vo);
		return "redirect:list?page="+page;
	}
	
	@RequestMapping(value="/board/delete", method=RequestMethod.POST)
	public String delete(int bno, int page){
		mapper.delete(bno);
		return "redirect:list?page="+page;
	}
	
	@RequestMapping(value="/replyCount")
	@ResponseBody
	public HashMap<String,Object> ReplyCount(int bno){
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("count", mapper.replyCount(bno));
		return map;
	}
	
	@RequestMapping(value="/chartUser")
	@ResponseBody
	public ArrayList graphUser(){
		ArrayList jList=new ArrayList();
		ArrayList list=new ArrayList();
		list.add("작성자");
		list.add("게시글수");
		jList.add(list);
		
		List<ChartVO> array=mapper.chartUser();
		for(ChartVO vo:array){
			list=new ArrayList();
			list.add(vo.getName());
			list.add(vo.getValue());
			jList.add(list);
		}
		return jList;
	}
	
	
	@RequestMapping(value="/chart")
	public void graph(){
	}
}




