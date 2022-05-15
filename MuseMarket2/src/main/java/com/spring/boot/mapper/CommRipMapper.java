package com.spring.boot.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.spring.boot.dto.CommRipDTO;

@Mapper
public interface CommRipMapper {

	public int maxNum() throws Exception;
	
	public void insertReply(CommRipDTO dto) throws Exception;
	
	public List<CommRipDTO> getReplyList(int commuNo, int start, int end, String searchKey, String searchValue) throws Exception;
    
	public int getDataCount(String searchKey, String searchValue) throws Exception;

	public CommRipDTO getReadData(int crNo) throws Exception;

	public void updateReply(CommRipDTO dto) throws Exception;
	
	public void deleteReply(int crNo) throws Exception;

}
