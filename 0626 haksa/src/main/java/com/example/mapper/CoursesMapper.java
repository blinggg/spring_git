package com.example.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.example.domain.CoursesVO;
import com.example.domain.Criteria;
import com.example.domain.StudentsVO;

public interface CoursesMapper {
	public List<CoursesVO> listAll();
	public List<CoursesVO> list(Criteria cri);
	public int totalCount();
	public List<HashMap<String, Object>> slist(String lcode);
	//public void update(CoursesVO vo);
	
	
	
}
