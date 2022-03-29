package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;

import com.jdbc.dto.BoardDTO;


public class BoardDAO2 {
	
	private SqlSessionTemplate sessionTemplate;
	
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) throws Exception {
		
		this.sessionTemplate = sessionTemplate;
	}

	Connection conn = null;
	
	//num의 최대값
	public int getMaxNum() {
		
		int maxNum = 0;
		
		maxNum = sessionTemplate.selectOne("com.boardMapper.maxNum");
		
		return maxNum;
		
	}
	
	// 입력
	public void insertData(BoardDTO dto) {
		
		sessionTemplate.insert("com.boardMapper.insertData", dto);
		
	}
	
	// 전체 데이터 개수 + 검색창
	public int getDataCount(String searchKey, String searchValue) {
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("searchKey", searchKey);
		params.put("searchValue", searchValue);
		
		int totalCount = sessionTemplate.selectOne("com.boardMapper.getDataCount", params);	
		
		return totalCount;
	}
	
	// 전체데이터
	public List<BoardDTO> getLists(int start, int end, String searchKey, String searchValue){
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("start", start);
		params.put("end", end);
		params.put("searchKey", searchKey);
		params.put("searchValue", searchValue);
		
		List<BoardDTO> lists = sessionTemplate.selectList("com.boardMapper.getList", params);
		
		return lists;
	}
	
	// num으로 조회한 한개의 데이터
		public BoardDTO getReadData(int num){
		
			BoardDTO dto = sessionTemplate.selectOne("com.boardMapper.getReadData", num);
			
			return dto;
			
		}
		
		//조회수 증가
		public void updateHitCount(int num) {
			
			sessionTemplate.update("com.boardMapper.updateHitCount", num);
			
		}
		
		//수정
		public void updateData(BoardDTO dto) {
			
			sessionTemplate.update("com.boardMapper.updateData", dto);
			
		}
		
		//삭제
		public void deleteData(int num) {
			
			sessionTemplate.delete("com.boardMapper.deleteData", num);
			
		}
		
}
