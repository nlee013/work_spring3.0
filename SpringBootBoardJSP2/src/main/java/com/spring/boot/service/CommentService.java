package com.spring.boot.service;

import java.util.List;

import com.spring.boot.dto.CommentDTO;

public interface CommentService {
	    
	    public List<CommentDTO> commentListService() throws Exception;      
	   	    
	    public int commentInsertService(CommentDTO comment) throws Exception;	
	    
	    public int commentUpdateService(CommentDTO comment) throws Exception;	    
	  
	    public int commentDeleteService(int cno) throws Exception;
	
}
