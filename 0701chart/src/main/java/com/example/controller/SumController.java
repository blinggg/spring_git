package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.SumVO;
import com.example.mapper.SumMapper;

@Controller
public class SumController {
	@Autowired
	SumMapper mapper;
	
	@RequestMapping("/chart")
	public void chart() {
		
	}
	
	@RequestMapping("/chart/sum1")
	@ResponseBody
	public ArrayList sum1() {
		ArrayList arrList=new ArrayList();
		ArrayList arr=new ArrayList();
		arr.add("강좌명");
		arr.add("평균");
		arrList.add(arr);
		List<SumVO> list=mapper.sum1();
		for(SumVO vo:list) {
			arr=new ArrayList();
			arr.add(vo.getName());
			arr.add(vo.getValue());
			arrList.add(arr);
		}
		return arrList;
	}
	
	@RequestMapping("/chart/sum2")
	@ResponseBody
	public ArrayList sum2() {
		ArrayList arrList=new ArrayList();
		ArrayList arr=new ArrayList();
		arr.add("학생명");
		arr.add("평균");
		arrList.add(arr);
		List<SumVO> list=mapper.sum2();
		for(SumVO vo:list) {
			arr=new ArrayList();
			arr.add(vo.getName());
			arr.add(vo.getValue());
			arrList.add(arr);
		}
		return arrList;
	}
	
	@RequestMapping("/chart/sum3")
	@ResponseBody
	public ArrayList sum3() {
		ArrayList arrList=new ArrayList();
		ArrayList arr=new ArrayList();
		arr.add("강좌명");
		arr.add("학생수");
		arrList.add(arr);
		List<SumVO> list=mapper.sum3();
		for(SumVO vo:list) {
			arr=new ArrayList();
			arr.add(vo.getName());
			arr.add(vo.getValue());
			arrList.add(arr);
		}
		return arrList;
	}
	
	@RequestMapping("/chart/sum4")
	@ResponseBody
	public ArrayList sum4() {
		ArrayList arrList=new ArrayList();
		ArrayList arr=new ArrayList();
		arr.add("학생명");
		arr.add("과목수");
		arrList.add(arr);
		List<SumVO> list=mapper.sum4();
		for(SumVO vo:list) {
			arr=new ArrayList();
			arr.add(vo.getName());
			arr.add(vo.getValue());
			arrList.add(arr);
		}
		return arrList;
	}
	
	@RequestMapping("/chart/sum5")
	@ResponseBody
	public ArrayList sum5() {
		ArrayList arrList=new ArrayList();
		ArrayList arr=new ArrayList();
		arr.add("학생명");
		arr.add("평균");
		arr.add("과목수");
		arrList.add(arr);
		List<SumVO> list=mapper.sum5();
		for(SumVO vo:list) {
			arr=new ArrayList();
			arr.add(vo.getName());
			arr.add(vo.getValue());
			arr.add(vo.getValue2());
			arrList.add(arr);
		}
		return arrList;
	}
	
	@RequestMapping("/chart/sum6")
	@ResponseBody
	public ArrayList sum6() {
		ArrayList arrList=new ArrayList();
		ArrayList arr=new ArrayList();
		arr.add("강좌명");
		arr.add("학생수");
		arr.add("최고점");
		arr.add("최저점");
		arr.add("평균");
		arrList.add(arr);
		List<SumVO> list=mapper.sum6();
		for(SumVO vo:list) {
			arr=new ArrayList();
			arr.add(vo.getName());
			arr.add(vo.getValue());
			arr.add(vo.getValue2());
			arr.add(vo.getValue3());
			arr.add(vo.getValue4());
			arrList.add(arr);
		}
		return arrList;
	}
	
	@RequestMapping("/chart/sum7")
	@ResponseBody
	public ArrayList sum7() {
		ArrayList arrList=new ArrayList();
		ArrayList arr=new ArrayList();
		arr.add("학과");
		arr.add("학생수");
		arrList.add(arr);
		List<SumVO> list=mapper.sum7();
		for(SumVO vo:list) {
			arr=new ArrayList();
			arr.add(vo.getName());
			arr.add(vo.getValue());
			arrList.add(arr);
		}
		return arrList;
	}
}
