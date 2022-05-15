package com.spring.boot.service;

import java.util.List;

import com.spring.boot.dto.CommRipDTO;

public interface CommRipService {

//	public void insertData(CommRipDTO dto) throws Exception;//insert
//	
//	public int getDataCount(String searchKey, String searchValue) throws Exception;//댓글 개수
//	
//	public List<CommRipDTO> getList(int start, int end, String searchKey, String searchValue) throws Exception;//댓글 목록 조회
//	
//	public CommRipDTO getReadData(int crNo) throws Exception;//댓글 삭제 처리에 메서드 사용예정
//	
//	public void updateData(CommRipDTO dto) throws Exception;
//	
//	public void deleteData(int crNo) throws Exception;
//	
//	public void deleteComment(int crNo) throws Exception;

	public boolean registerComment(CommRipDTO dto) throws Exception;
	
	public boolean deleteComment(int crNo) throws Exception;
	
	public List<CommRipDTO> getCommentList(CommRipDTO dto, int start, int end, String searchKey, String searchValue) throws Exception;
	
}
