package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.BoardVO;
import com.example.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	BoardMapper bmapper;
	
	@Transactional
	@Override
	public BoardVO read(int bno) {
		bmapper.updateViewcnt(bno);
		return bmapper.read(bno);
	}

}
