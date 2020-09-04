package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.TradeVO;
import com.example.mapper.TradeMapper;

@Service
public class TradeServiceImpl implements TradeService{
	@Autowired
	TradeMapper mapper;
	
	@Transactional
	@Override
	public void insert(TradeVO vo) {
		//출금일 때
		mapper.insert(vo);
		
		//입금할 때
		vo.setType("0");
		String no=vo.getAno();
		vo.setAno(vo.getTradeNo());
		vo.setTradeNo(no);
		mapper.insert(vo);
		
	}
	

}
