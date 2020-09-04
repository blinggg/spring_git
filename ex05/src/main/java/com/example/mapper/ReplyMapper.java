package com.example.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.example.domain.Criteria;
import com.example.domain.ReplyVO;

public interface ReplyMapper {
	//리스트 출력
	public ArrayList<ReplyVO> list(@Param("cri") Criteria cri,@Param("bno") int bno);
	//등록
	public void insert(ReplyVO vo);
	//삭제
	public void delete(int rno);
	//읽기
	public ReplyVO read(int rno);
	//update
	public void update(ReplyVO vo);
	//총갯수
	public int total(int bno);
}
