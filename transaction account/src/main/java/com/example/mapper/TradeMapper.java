package com.example.mapper;

import java.util.List;

import com.example.domain.TradeVO;

public interface TradeMapper {
	public void insert(TradeVO vo);
	public List<TradeVO> list(String ano);
}
