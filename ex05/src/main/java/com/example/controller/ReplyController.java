package com.example.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.Criteria;
import com.example.domain.PageMaker;
import com.example.domain.ReplyVO;
import com.example.mapper.ReplyMapper;

@Controller
@RequestMapping("/reply/")
public class ReplyController {
	@Autowired
	ReplyMapper mapper;
	
	@RequestMapping("list.json")
	@ResponseBody
	public HashMap<String,Object> listJSON(Model model,Criteria cri,int bno) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		System.out.println("bno: "+bno);
		cri.setPerPageNum(5);
		PageMaker pm=new PageMaker();
		pm.setCri(cri);
		pm.setTotalCount(mapper.total(bno));
		map.put("pm", pm);
		map.put("array",mapper.list(cri, bno));
		return map;
	}
	
	@RequestMapping("list")
	public void list() {
	}
	
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public String insert(ReplyVO vo) {
		System.out.println(vo.toString());
		mapper.insert(vo);
		return"redirect:list";
	}
	
	@RequestMapping("delete")
	public String delete(int rno,int page) {
		mapper.delete(rno);
		return"redirect:list?page="+page;
	}
}
