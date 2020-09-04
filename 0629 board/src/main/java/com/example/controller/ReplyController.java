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
import com.example.domain.ReplyVO;
import com.example.mapper.BoardMapper;
import com.example.mapper.ReplyMapper;

@Controller
public class ReplyController {
	@Autowired
	ReplyMapper mapper;
	
	@Autowired
	BoardMapper bmapper;
	
	@RequestMapping("/reply/list")
	@ResponseBody
	public HashMap<String, Object> list(int bno) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("list",mapper.list(bno));
		map.put("count",bmapper.replyCount(bno));
		return map;
	}
	
	@RequestMapping(value="/reply/reply")
	public String reply() {
		return "/reply/reply";
	}
	
	@RequestMapping(value="/reply/insert")
	@ResponseBody
	public void insert(ReplyVO vo) {
		mapper.insert(vo);
	}
	
	@RequestMapping(value="/reply/delete")
	@ResponseBody
	public void delete(int rno) {
		mapper.delete(rno);
	}
}