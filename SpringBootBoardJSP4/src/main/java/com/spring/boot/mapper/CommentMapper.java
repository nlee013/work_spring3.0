package com.spring.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.spring.boot.dto.CommentDTO;

@Mapper
public interface CommentMapper {

	 public int commentCount() throws Exception;

	public List<CommentDTO> commentListService() throws Exception;      
	    
    public int commentInsertService(CommentDTO comment) throws Exception;	
    
    public int commentUpdateService(CommentDTO comment) throws Exception;	    
  
    public int commentDeleteService(int cno) throws Exception;


	
}
