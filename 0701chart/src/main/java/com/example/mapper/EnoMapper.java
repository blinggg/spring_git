package com.example.mapper;

import com.example.domain.EnoVO;

public interface EnoMapper {
	public int enrollCount(String scode);
	public void insert(EnoVO vo);
	public void delete(EnoVO vo);
	public void update(EnoVO vo);
	public int read(EnoVO vo);
}
