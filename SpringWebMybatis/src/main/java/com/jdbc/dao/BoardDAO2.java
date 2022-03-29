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
	
	//num�� �ִ밪
	public int getMaxNum() {
		
		int maxNum = 0;
		
		maxNum = sessionTemplate.selectOne("com.boardMapper.maxNum");
		
		return maxNum;
		
	}
	
	// �Է�
	public void insertData(BoardDTO dto) {
		
		sessionTemplate.insert("com.boardMapper.insertData", dto);
		
	}
	
	// ��ü ������ ���� + �˻�â
	public int getDataCount(String searchKey, String searchValue) {
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("searchKey", searchKey);
		params.put("searchValue", searchValue);
		
		int totalCount = sessionTemplate.selectOne("com.boardMapper.getDataCount", params);	
		
		return totalCount;
	}
	
	// ��ü������
	public List<BoardDTO> getLists(int start, int end, String searchKey, String searchValue){
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("start", start);
		params.put("end", end);
		params.put("searchKey", searchKey);
		params.put("searchValue", searchValue);
		
		List<BoardDTO> lists = sessionTemplate.selectList("com.boardMapper.getList", params);
		
		return lists;
	}
	
	// num���� ��ȸ�� �Ѱ��� ������
		public BoardDTO getReadData(int num){
		
			BoardDTO dto = sessionTemplate.selectOne("com.boardMapper.getReadData", num);
			
			return dto;
			
		}
		
		//��ȸ�� ����
		public void updateHitCount(int num) {
			
			sessionTemplate.update("com.boardMapper.updateHitCount", num);
			
		}
		
		//����
		public void updateData(BoardDTO dto) {
			
			sessionTemplate.update("com.boardMapper.updateData", dto);
			
		}
		
		//����
		public void deleteData(int num) {
			
			sessionTemplate.delete("com.boardMapper.deleteData", num);
			
		}
		
}
