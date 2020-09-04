package com.example.mapper;

import java.util.ArrayList;

import com.example.domain.BoardVO;

public interface BoardMapper {
	//�Խñ� ��� ���
	public ArrayList<BoardVO> list();
	public void insert(BoardVO vo);
	 public BoardVO read(int bno);
	 public void update(BoardVO vo);
	 public void delete(int bno); 
}
