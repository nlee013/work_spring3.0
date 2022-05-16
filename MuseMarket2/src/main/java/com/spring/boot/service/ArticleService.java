package com.spring.boot.service;

import java.util.List;
import java.util.Map;

import com.spring.boot.dto.ArticleDTO;

public interface ArticleService {

	public ArticleDTO getReadData(int prodNo) throws Exception;
	
	public void updateHitCount(int prodNo) throws Exception;
	
	public ArticleDTO getUserId(int userNo) throws Exception;
	
	public int numMax() throws Exception;
	
	public void insertData(ArticleDTO articleDTO) throws Exception;
	
	public int dataCount() throws Exception;
	
	public List<ArticleDTO> listData() throws Exception;
	
	public void deleteData(int num) throws Exception;

}
