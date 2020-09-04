package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.ReplyVO;
import com.example.mapper.BoardMapper;
import com.example.mapper.ReplyMapper;

@Service
public class ReplyServiceImpl implements ReplyService{
	@Autowired
	ReplyMapper rMapper;
	
	@Autowired
	BoardMapper bMapper;
	
	@Transactional
	@Override
	public void insert(ReplyVO vo) {
		rMapper.insert(vo);
		bMapper.updateReplycnt(vo.getBno(), 1);
	}

	@Transactional
	@Override
	public void delete(int rno) {
		ReplyVO vo=rMapper.read(rno);
		rMapper.delete(rno);
		bMapper.updateReplycnt(vo.getBno(), -1);
	}
}
