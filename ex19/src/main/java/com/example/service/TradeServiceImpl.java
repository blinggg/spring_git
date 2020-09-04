package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.TradeVO;
import com.example.mapper.AccountMapper;
import com.example.mapper.TradeMapper;

@Service
public class TradeServiceImpl implements TradeService{

	@Autowired
	TradeMapper mapper;
	@Autowired
	AccountMapper amapper;
	
	@Transactional
	@Override
	public void insert(TradeVO vo) {
		//출금
		mapper.insert(vo);
		amapper.update(vo.getAno(), vo.getAmount() * -1);
		//입금
		vo.setType("0");
		String no=vo.getAno();
		String tradeNo=vo.getTradeNo();
		
		vo.setAno(vo.getTradeNo());
		vo.setTradeNo(no);
		mapper.insert(vo);
		amapper.update(tradeNo, vo.getAmount());
	}

}
