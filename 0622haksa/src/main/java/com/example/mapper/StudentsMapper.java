package com.example.mapper;

import java.util.ArrayList;

import com.example.domain.StudentsVO;

public interface StudentsMapper {
	//�л����
		public ArrayList<StudentsVO> list();
	//�������
		public void insert(StudentsVO vo);
		
}
