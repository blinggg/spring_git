package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.Criteria;
import com.example.domain.EnoVO;
import com.example.domain.PageMaker;
import com.example.domain.StuVO;
import com.example.mapper.CouMapper;
import com.example.mapper.EnoMapper;
import com.example.mapper.ProMapper;
import com.example.mapper.StuMapper;

@Controller
public class StuController {
	@Autowired
	StuMapper mapper;
	
	@Autowired
	ProMapper pmapper;
	
	@Autowired
	EnoMapper emapper;
	
	@Autowired
	CouMapper cmapper;
	
	@RequestMapping("/stu/list")
	public void list(Criteria cri, Model model) {
		cri.setPerPageNum(5);
		PageMaker pm=new PageMaker();
		pm.setCri(cri);
		pm.setTotalCount(mapper.totalCount());
		model.addAttribute("pm", pm);
		model.addAttribute("list", mapper.list(cri));
	}
	
	@RequestMapping("/stu/read")
	public void read(Model model,String scode, int page) {
		model.addAttribute("page", page);
		model.addAttribute("vo", mapper.read(scode));
		model.addAttribute("plist", pmapper.plist());
		model.addAttribute("clist", cmapper.list());
	}
	
	@RequestMapping(value="/stu/update", method=RequestMethod.POST)
	public String update(int page, StuVO vo) {
		mapper.update(vo);
		return "redirect:list?page="+page;
	}
	
	@RequestMapping(value="/stu/delete", method=RequestMethod.POST)
	public String delete(int page, String scode) {
		mapper.delete(scode);
		return "redirect:list?page="+page;
	}
	
	@RequestMapping(value="/eno/enrollCount")
	@ResponseBody
	public int enrollCount(String scode) {
		return emapper.enrollCount(scode);
	}
	
	@RequestMapping("/stu/enoList")
	@ResponseBody
	public HashMap<String,Object> enoList(String scode) {
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("elist", mapper.enoList(scode));
		map.put("total", emapper.enrollCount(scode));
		return map;
	}
	
	@RequestMapping("/stu/chart")
	public void chart() {
	}
	
	@RequestMapping("/stu/chartEno")
	@ResponseBody
	public ArrayList chartEno(String scode) {
		ArrayList arrayList= new  ArrayList<EnoVO>();
		ArrayList array=new ArrayList();
		array.add("과목명");
		array.add("점수");
		arrayList.add(array);
		
		List<EnoVO> list= mapper.enoList(scode);
		for(EnoVO vo:list) {
			array=new ArrayList();
			array.add(vo.getLname());
			array.add(vo.getGrade());
			arrayList.add(array);
		}
		return arrayList;
	}
}
