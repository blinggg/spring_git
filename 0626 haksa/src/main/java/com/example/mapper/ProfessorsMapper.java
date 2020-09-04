package com.example.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.example.domain.ProfessorsVO;

public interface ProfessorsMapper {
   
    public List<ProfessorsVO> list();
    public List<HashMap<String, Object>> slist(String pcode);
    public List<HashMap<String, Object>> clist(String pcode);
}
