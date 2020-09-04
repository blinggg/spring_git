package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.example.domain.UserVO;

public interface UserMapper {
    public List<UserVO> list();
    public UserVO read(String id);
    public void insert(UserVO vo);
    public void delete(String id);
    public void update(UserVO vo);
    //첨부이미지 추가하기
    public void addAttach(@Param("image") String image, @Param("id") String id);
    //첨부이미지 삭제하기
    public void delAttach(String id);
    //첨부된 이미지 불러오기
    public List<String> getAttach(String id);
    
}
