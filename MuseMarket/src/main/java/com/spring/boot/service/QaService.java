package com.spring.boot.service;

import java.util.List;

import com.spring.boot.dto.CommuDTO;
import com.spring.boot.dto.QaUploadDTO;

public interface QaService {

	public int maxNum() throws Exception;
	
	public void insertData(QaUploadDTO dto) throws Exception;
	
	public int getDataCount(String searchKey, String searchValue) throws Exception;
	
	public List<QaUploadDTO> getList(int start, int end, String searchKey, String searchValue) throws Exception;
	
	public QaUploadDTO getReadData(int qa_upNo) throws Exception;
	
	public void updateHitCount(int qa_upNo) throws Exception;
	
	public void updateData(QaUploadDTO dto) throws Exception;
	
	public void deleteData(int qa_upNo) throws Exception;
	
}
