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
		
		//method�� �̹� �����������.(library��)
		sessionTemplate.insert("com.exe.custom.insert", dto);//mapper �̸�(����� ����)
		
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
	
	//�ϳ��� ������ �о���� custom�� ������ �ȴ�
	public CustomDTO getReadData(int id){//�ϳ��� �����ʹϱ� ��ȣ �ȿ��� ���ش�
		
		CustomDTO dto = sessionTemplate.selectOne("com.exe.custom.listOne", id);
		
		return dto;
	}
	

}
