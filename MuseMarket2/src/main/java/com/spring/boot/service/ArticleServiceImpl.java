package com.spring.boot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.dto.ArticleDTO;
import com.spring.boot.mapper.ArticleMapper;

@Service("ArticleService")
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private ArticleMapper articleMapper; //BoardMapper 의존성주입
	
	//BoardController -> BoardService(I) -> BoardServiceImpl(C) ->
	//BoardMapper(I) -> boardMapper.xml
	
	
	@Override
	public ArticleDTO getReadData(int prodNo) throws Exception {
		return articleMapper.getReadData(prodNo);
	}

	@Override
	public void updateHitCount(int prodNo) throws Exception {
		articleMapper.updateHitCount(prodNo);
	}

	@Override
	public ArticleDTO getUserId(int userNo) throws Exception {
		return articleMapper.getUserId(userNo);
	}

	@Override
	public int numMax() throws Exception {
		return articleMapper.numMax();
	}

	@Override
	public void insertData(ArticleDTO articleDTO) throws Exception {
		articleMapper.insertData(articleDTO);
	}

	@Override
	public int dataCount() throws Exception {
		return articleMapper.dataCount();
	}

	@Override
	public List<ArticleDTO> listData() throws Exception {
		return articleMapper.listData();
	}

	@Override
	public void deleteData(int num) throws Exception {
		articleMapper.deleteData(num);
	}
	
}
