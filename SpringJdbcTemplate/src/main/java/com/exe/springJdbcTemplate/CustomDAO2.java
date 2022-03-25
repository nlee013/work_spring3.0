package com.exe.springJdbcTemplate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class CustomDAO2 {

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
		
		this.namedJdbcTemplate = namedJdbcTemplate;
	}
	
	Connection conn = null;
	
	//spring의 jdbc
	public void insertData(CustomDTO dto) {
		
		StringBuilder sql = new StringBuilder();
		/*
		 * sql.append("insert into custom (id, name, age) values (?, ?, ?)");
		 * 
		 * jdbcTemplate.update(sql.toString(), dto.getId(), dto.getName(),
		 * dto.getAge());
		 */
		
		//NamedParameterJdbcTemplate
		//?가 아니라 : 사용
		sql.append("insert into custom (id, name, age) values (:id, :name, :age) ");
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		
		params.addValue("id", dto.getId());
		params.addValue("name", dto.getName());
		params.addValue("age", dto.getAge());
		
		namedJdbcTemplate.update(sql.toString(), params);
		
	}

	//update
	//buffer보다 builder가 더 빠르다
	public void updateData(CustomDTO dto) {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("update custom set name=? , age=? where id=?");
		
		jdbcTemplate.update(sql.toString(),
				dto.getName(), dto.getAge(), dto.getId());
	}
	
	//delete
	public void deleteData(int id) {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("delete custom where id=?");
		
		jdbcTemplate.update(sql.toString(),id);

	}

	
	public List<CustomDTO> getList(){
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("select id, name, age from custom");
		
		//sql.toString()는 문자화 시킨 것 
		List<CustomDTO> lists = jdbcTemplate.query(sql.toString(),
				
				//RowMapper 얘가 반복문이다.
				new RowMapper<CustomDTO>() {
					
					//아래 얘가 method니까
					//ResultSet rs에 데이터(표?)
					//index 번호는 int rowNum로 들어옴
					public CustomDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						//하나 꺼내서 dto에 넣어두고 list에 넣어두고 이런식으로
						//반복
						CustomDTO dto = new CustomDTO();
						
						dto.setId(rs.getInt("id"));
						dto.setName(rs.getString("name"));
						dto.setAge(rs.getInt("age"));
						
						return dto;
					}
		});
		
		return lists;
	}
	
	//하나의 데이터 읽어오기 custom만 있으면 된다
	public CustomDTO getReadData(int id){//하나의 데이터니까 괄호 안에도 써준다
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("select id, name, age from custom where id=?");
		
		CustomDTO dtoOne = jdbcTemplate.queryForObject(sql.toString(),
								new RowMapper<CustomDTO>(){
			
				public CustomDTO mapRow(ResultSet rs, int rowNum)
						throws SQLException{
				
					CustomDTO dto = new CustomDTO();
					
					dto.setId(rs.getInt("id"));
					dto.setName(rs.getString("name"));
					dto.setAge(rs.getInt("age"));
					
					return dto;
			}
				
		}, id);//얘까지 인수 3개다.
		
		return dtoOne;
	}
	
}
