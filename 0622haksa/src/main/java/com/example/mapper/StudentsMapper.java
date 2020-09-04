package com.example.mapper;

import java.util.ArrayList;

import com.example.domain.StudentsVO;

public interface StudentsMapper {
	//학생목록
		public ArrayList<StudentsVO> list();
	//교수등록
		public void insert(StudentsVO vo);
		
}
