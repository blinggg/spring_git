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
import com.example.domain.EnrollVO;
import com.example.domain.PageMaker;
import com.example.domain.StuVO;
import com.example.mapper.CouMapper;
import com.example.mapper.ProMapper;
import com.example.mapper.StuMapper;


@Controller
public class StuController {
	@Autowired
	StuMapper mapper;
	@Autowired
	ProMapper pmapper;
	@Autowired
	CouMapper cmapper;
	
	@RequestMapping("/stu/list")
	public String list(Model model,Criteria cri) {
		cri.setPerPageNum(3);//보여지는 데이터의 갯수
		
		PageMaker pm=new PageMaker();
		pm.setCri(cri); //
		pm.setTotalCount(mapper.totalCount());//실제데이터의 갯수만큼 페이징 처리
		model.addAttribute("pm", pm);
		model.addAttribute("list",mapper.list(cri));
		return "/stu/list";
	}
	
	@RequestMapping("/stu/read")
	public void read(Model model, int page, String scode) {
		model.addAttribute("vo", mapper.read(scode));
		model.addAttribute("page",page);
		model.addAttribute("plist",pmapper.list());
		model.addAttribute("clist",cmapper.list());
	}
	
	@RequestMapping(value="/stu/delete",method=RequestMethod.POST)
	public String delete(String scode,int page) {
		System.out.println(toString());
		mapper.delete(scode);
		return "redirect:list?page="+page;
	
	}
	
	@RequestMapping(value="/stu/update",method=RequestMethod.POST)
	public String update(StuVO vo, int page) {
		mapper.update(vo);
		return "redirect:list?page="+page;
	}
	
	@RequestMapping(value="/enrollCount",method=RequestMethod.POST)
	@ResponseBody
	public int enrollCount(String scode) {
		int count=mapper.enrollCount(scode);
		if(count==0) {
			mapper.delete(scode);
		}
		return count;
	}
	
	@RequestMapping(value="/stu/listEnroll")
	@ResponseBody
	public HashMap<String,Object>listEnroll(String scode){
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("total",mapper.enrollCount(scode));
		map.put("list",mapper.listEnroll(scode));
		return map;
	}
	
	@RequestMapping(value="/stu/chart")
	public void chart() {
		
	}
	
	@RequestMapping(value="/stu/chartEnroll")
	@ResponseBody
	public ArrayList chartEnroll(String scode){
		ArrayList arrayList=new ArrayList();
		ArrayList array=new ArrayList();
		array.add("과목명");
		array.add("점수");
		arrayList.add(array);
		List<EnrollVO> list=mapper.listEnroll(scode);
		for(EnrollVO vo:list) {
			array=new ArrayList();
			array.add(vo.getLname());
			array.add(vo.getGrade());
			arrayList.add(array);
		}
		return arrayList;

	}
}
