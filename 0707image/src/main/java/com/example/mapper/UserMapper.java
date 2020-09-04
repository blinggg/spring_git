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
    //÷���̹��� �߰��ϱ�
    public void addAttach(@Param("image") String image, @Param("id") String id);
    //÷���̹��� �����ϱ�
    public void delAttach(String id);
    //÷�ε� �̹��� �ҷ�����
    public List<String> getAttach(String id);
    
}
