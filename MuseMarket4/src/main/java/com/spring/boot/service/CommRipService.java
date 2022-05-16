package com.spring.boot.service;

import java.util.List;
import com.spring.boot.dto.CommRipDTO;

public interface CommRipService {
		
	public int maxNum() throws Exception;
	
	public void insertReply(CommRipDTO dto) throws Exception;
	
	public List<CommRipDTO> getReplyList(int commuNo, int start, int end, String searchKey, String searchValue) throws Exception;
	
	public int getDataCount(String searchKey, String searchValue) throws Exception;
	
	public CommRipDTO getReadData(int crNo) throws Exception;
	
	public void updateReply(CommRipDTO dto) throws Exception;
	
	public void deleteReply(int crNo) throws Exception;

	
}
