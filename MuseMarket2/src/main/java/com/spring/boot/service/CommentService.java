package com.spring.boot.service;

import java.util.List;

import com.spring.boot.dto.CommRipDTO;
import com.spring.boot.dto.CommentDTO;
import com.spring.boot.dto.CommuDTO;

public interface CommentService {

	public int maxNum() throws Exception;
	
	public List<CommentDTO> getList(int start, int end, String searchKey, String searchValue) throws Exception;
    
	public int getDataCount(String searchKey, String searchValue) throws Exception;

	public CommuDTO getReadData(int commuNo) throws Exception;

	public void updateR(CommuDTO dto) throws Exception;
	
	public void deleteData(int commuNo) throws Exception;


	
}
