package com.spring.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.spring.boot.dto.CommentDTO;

@Mapper
public interface CommentMapper {

	    // 댓글 개수
	    public int commentCount() throws Exception;
	 
	    // 댓글 목록
	    public List<CommentDTO> commentList() throws Exception;
	 
	    // 댓글 작성
	    public int commentInsert(CommentDTO comment) throws Exception;
	    
	    // 댓글 수정
	    public int commentUpdate(CommentDTO comment) throws Exception;
	 
	    // 댓글 삭제
	    public int commentDelete(int cno) throws Exception;


	
}
