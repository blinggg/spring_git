package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.example.domain.AccountVO;

public interface AccountMapper {
    @Select("select now()")
    public String getTime();
    public String getTime2();
    public List<AccountVO> list();
    public AccountVO read(String ano);
}
