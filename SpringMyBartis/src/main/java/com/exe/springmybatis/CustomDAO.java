package com.exe.springmybatis;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;

public class CustomDAO {

	private SqlSessionTemplate sessionTemplate;
	
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		
		this.sessionTemplate = sessionTemplate;
	}
	
	Connection conn = null;
	
	public void insertData(CustomDTO dto) {
		
		//method가 이미 만들어져있음.(library에)
		sessionTemplate.insert("com.exe.custom.insert", dto);//mapper 이름(사용자 정의)
		
	}
	
	//update
	public void updateData(CustomDTO dto) {
		
		sessionTemplate.update("com.exe.custom.update", dto);
	}
	
	//delete
	public void deleteData(int id) {
		
		sessionTemplate.delete("com.exe.custom.delete", id);
	}
	
	public List<CustomDTO> getList(){
		
		List<CustomDTO> lists = sessionTemplate.selectList("com.exe.custom.list");
		
		return lists;
	}
	
	//하나의 데이터 읽어오기 custom만 있으면 된다
	public CustomDTO getReadData(int id){//하나의 데이터니까 괄호 안에도 써준다
		
		CustomDTO dto = sessionTemplate.selectOne("com.exe.custom.listOne", id);
		
		return dto;
	}
	

}
