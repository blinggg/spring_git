package com.example.mapper;

import java.util.ArrayList;
import com.example.domain.*;

public interface BoardMapper {
	//리스트 출력
	public ArrayList<BoardVO> list(Criteria cri);
	//입력
	public void insert(BoardVO vo);
	//읽기
	public BoardVO read(int bno);
	//업데이트
	public void update(BoardVO vo);
	//삭제
	public void delete(int bno);
	//데이터갯수
	public int totalCount(Criteria cri);
}
