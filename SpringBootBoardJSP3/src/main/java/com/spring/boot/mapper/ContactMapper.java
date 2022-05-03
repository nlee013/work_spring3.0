package com.spring.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.boot.dto.QaContactDTO;

@Mapper
public interface ContactMapper {

	public int maxNum() throws Exception;
		
	public void insertData(QaContactDTO dto) throws Exception;
	
	public int getDataCount(String searchKey, String searchValue) throws Exception;
	
	public List<QaContactDTO> getList(int start, int end, String searchKey, String searchValue) throws Exception;
	
	public QaContactDTO getReadData(int qa_conNo) throws Exception;
	
	public void updateHitCount(int qa_conNo) throws Exception;
	
	public void updateData(QaContactDTO dto) throws Exception;
	
	public void deleteData(int qa_conNo) throws Exception;
	
}
