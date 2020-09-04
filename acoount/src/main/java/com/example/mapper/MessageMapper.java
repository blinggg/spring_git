package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.example.domain.MessageVO;

public interface MessageMapper {
    @Select("select now()")
    public String getTime();
    public String getTime2();
    public List<MessageVO> listsend(String id);
    public List<MessageVO> listreceive(String id);
    public void insert(MessageVO vo);
    public MessageVO read(int mid);
    public void updateRead(int mid);
    public void updatesdel(int mid);
}
