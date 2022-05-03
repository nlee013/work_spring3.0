package com.spring.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.dto.CommuDTO;
import com.spring.boot.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper boardMapper;//BoardMapper DI 의존성 주입

	@Override
	public int maxNum() throws Exception {
		
		return boardMapper.maxNum();
	}

	@Override
	public void insertData(CommuDTO dto) throws Exception {
		
		boardMapper.insertData(dto);
		
	}

	@Override
	public int getDataCount(String searchKey, String searchValue) throws Exception {
		
		return boardMapper.getDataCount(searchKey, searchValue);
	}

	@Override
	public List<CommuDTO> getList(int start, int end, String searchKey, String searchValue) throws Exception {
		
		return boardMapper.getList(start, end, searchKey, searchValue);
	}

	@Override
	public CommuDTO getReadData(int commuNo) throws Exception {
		
		return boardMapper.getReadData(commuNo);
	}

	@Override
	public void updateHitCount(int commuNo) throws Exception {
		boardMapper.updateHitCount(commuNo);
	}

	@Override
	public void updateData(CommuDTO dto) throws Exception {
		
		boardMapper.updateData(dto);
	}

	@Override
	public void deleteData(int commuNo) throws Exception {
		
		boardMapper.deleteData(commuNo);
	}
	
	//찾아가는 순서
	//BoardController -> BoardService(Interface) -> BoardServiceImpl(Class) -> BoardMapper(I) -> boardMapper.xml
	
	
	
}
