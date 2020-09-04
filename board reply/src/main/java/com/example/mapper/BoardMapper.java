package com.example.mapper;

import java.util.ArrayList;
import com.example.domain.*;

public interface BoardMapper {
	//����Ʈ ���
	public ArrayList<BoardVO> list(Criteria cri);
	//�Է�
	public void insert(BoardVO vo);
	//�б�
	public BoardVO read(int bno);
	//������Ʈ
	public void update(BoardVO vo);
	//����
	public void delete(int bno);
	//�����Ͱ���
	public int totalCount(Criteria cri);
}
