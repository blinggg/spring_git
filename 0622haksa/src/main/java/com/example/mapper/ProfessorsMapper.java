package com.example.mapper;

import java.util.ArrayList;

import com.example.domain.ProfessorsVO;

public interface ProfessorsMapper {
	//교수목록
	public ArrayList<ProfessorsVO> list();
	
	//교수등록
	public void insert(ProfessorsVO vo);
}
