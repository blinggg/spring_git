package com.example.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.example.domain.Criteria;
import com.example.domain.StudentsVO;

public interface StudentsMapper {
	public List<StudentsVO> list(Criteria cri);
	public int totalCount();
	public List<HashMap<String,Object>> elist(String scode); 
	
	
}
