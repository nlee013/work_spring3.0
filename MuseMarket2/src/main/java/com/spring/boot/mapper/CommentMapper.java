package com.spring.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.boot.dto.CommRipDTO;
import com.spring.boot.dto.CommentDTO;

@Mapper
public interface CommentMapper {

	public int commentCount() throws Exception;
	 
    // ��� ���
    public List<CommentDTO> commentList() throws Exception;
 
    // ��� �ۼ�
    public int commentInsert(CommentDTO comment) throws Exception;
    
    // ��� ����
    public int commentUpdate(CommentDTO comment) throws Exception;
 
    // ��� ����
    public int commentDelete(int cno) throws Exception;


}
