package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.domain.AccountVO;

public interface AccountMapper {
	public List<AccountVO> list();
	public AccountVO read(String ano);
	public void update(@Param("ano") String ano, @Param("amount") Double amount);
	public List<AccountVO> userList(String id); 
}
