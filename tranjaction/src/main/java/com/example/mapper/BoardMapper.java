package com.example.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.example.domain.BoardVO;
import com.example.domain.Criteria;

public interface BoardMapper {
	public List<BoardVO> list(Criteria cri);
	public void insert(BoardVO vo);
	public BoardVO read(int bno);
	public void update(BoardVO vo);
	public void delete(int bno); 
	public int totalCount(Criteria cri);
	public int replyCount(int bno);
	public void updateReplycnt(@Param("bno") int bno, @Param("amount") int amount);
	public void updateViewcnt(int bno);//파라미터가 여러인경우 
}
