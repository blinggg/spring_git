package com.example.mapper;

import java.util.ArrayList;

import com.example.domain.Criteria;
import com.example.domain.ReplyVO;

public interface ReplyMapper {
	//����Ʈ ���
	public ArrayList<ReplyVO> list(Criteria cri);
	//���
	public void insert(ReplyVO vo);
	//����
	public void delete(int rno);
	//�б�
	public ReplyVO read(int rno);
	//update
	public void update(ReplyVO vo);
	//�Ѱ���
	public int total();
}
