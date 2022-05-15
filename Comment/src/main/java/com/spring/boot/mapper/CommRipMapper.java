package com.spring.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.boot.dto.CommRipDTO;

@Mapper
public interface CommRipMapper {

	public int maxNum() throws Exception;
	
	public int insertData(CommRipDTO dto) throws Exception;//insert
	
	public int getDataCount(String searchKey, String searchValue) throws Exception;//댓글 개수
	
	public List<CommRipDTO> getList(int start, int end, String searchKey, String searchValue) throws Exception;//댓글 목록 조회
	
	public CommRipDTO getReadData(int crNo) throws Exception;//댓글 삭제 처리에 메서드 사용예정
	
	public int updateData(CommRipDTO dto) throws Exception;
	
	public void deleteData(int crNo) throws Exception;
	
	public int deleteComment(int crNo) throws Exception;
}
