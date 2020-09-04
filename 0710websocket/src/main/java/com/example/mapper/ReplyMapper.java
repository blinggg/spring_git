package com.example.mapper;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.domain.Criteria;
import com.example.domain.ReplyVO;

public interface ReplyMapper {
	public List<ReplyVO> list(HashMap<String,Object> map);
	public void insert(ReplyVO vo);
	public void delete(int rno);
	public ReplyVO read(int rno);
}
