package com.example.mapper;

import java.util.List;
import com.example.domain.TradeVO;

public interface TradeMapper {
	public void insert(TradeVO vo);
	//특정 거래계좌에 대한 목록
	public List<TradeVO> list(String ano);
	
	
}
