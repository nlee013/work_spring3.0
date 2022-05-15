package com.spring.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.dto.BoardDTO;
import com.spring.boot.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper boardMapper;//BoardMapper DI 의존성 주입
	
	//찾아가는 순서
	//BoardController -> BoardService(Interface) -> BoardServiceImpl(Class) -> BoardMapper(I) -> boardMapper.xml
	
	@Override
	public int maxNum() throws Exception {
		
		return boardMapper.maxNum();
	}

	@Override
	public void insertData(BoardDTO dto) throws Exception {
		
		boardMapper.insertData(dto);
	}

	@Override
	public int getDataCount(String searchKey, String searchValue) throws Exception {
		
		return boardMapper.getDataCount(searchKey, searchValue);
	}

	@Override
	public BoardDTO getReadData(int num) throws Exception {
		
		return boardMapper.getReadData(num);
	}

	@Override
	public List<BoardDTO> getList(int start, int end, String searchKey, String searchValue) throws Exception {
		
		return boardMapper.getList(start, end, searchKey, searchValue);
	}

	@Override
	public void updateHitCount(int num) throws Exception {
		
		boardMapper.updateHitCount(num);
	}

	@Override
	public void updateData(BoardDTO dto) throws Exception {
		
		boardMapper.updateData(dto);
	}

	@Override
	public void deleteData(int num) throws Exception {
		
		boardMapper.deleteData(num);
	}
	
	
}
