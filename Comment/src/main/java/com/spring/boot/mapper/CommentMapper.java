package com.spring.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.boot.dto.CommRipDTO;
import com.spring.boot.dto.CommentDTO;

@Mapper
public interface CommentMapper {

	public int commentCount() throws Exception;
	 
    // ´ñ±Û ¸ñ·Ï
    public List<CommentDTO> commentList() throws Exception;
 
    // ´ñ±Û ÀÛ¼º
    public int commentInsert(CommentDTO comment) throws Exception;
    
    // ´ñ±Û ¼öÁ¤
    public int commentUpdate(CommentDTO comment) throws Exception;
 
    // ´ñ±Û »èÁ¦
    public int commentDelete(int cno) throws Exception;


}
