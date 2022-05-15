package com.spring.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.dto.CommuDTO;
import com.spring.boot.dto.QaUploadDTO;
import com.spring.boot.mapper.CommuMapper;
import com.spring.boot.mapper.QaMapper;

@Service
public class QaServiceImpl implements QaService{
	
	@Autowired
	private QaMapper qaMapper;//BoardMapper DI 의존성 주입

	@Override
	public int maxNum() throws Exception {
		
		return qaMapper.maxNum();
		
	}

	@Override
	public void insertData(QaUploadDTO dto) throws Exception {
		
		qaMapper.insertData(dto);
		
	}

	@Override
	public int getDataCount(String searchKey, String searchValue) throws Exception {
		
		return qaMapper.getDataCount(searchKey, searchValue);
		
	}

	@Override
	public List<QaUploadDTO> getList(int start, int end, String searchKey, String searchValue) throws Exception {
		
		return qaMapper.getList(start, end, searchKey, searchValue);
		
	}

	@Override
	public QaUploadDTO getReadData(int qa_upNo) throws Exception {
		
		return qaMapper.getReadData(qa_upNo);
		
	}

	@Override
	public void updateHitCount(int qa_upNo) throws Exception {
		
		qaMapper.updateHitCount(qa_upNo);
	}

	@Override
	public void updateData(QaUploadDTO dto) throws Exception {
		
		qaMapper.updateData(dto);
	}

	@Override
	public void deleteData(int qa_upNo) throws Exception {
		
		qaMapper.deleteData(qa_upNo);
	}

	
	//찾아가는 순서
	//BoardController -> BoardService(Interface) -> BoardServiceImpl(Class) -> BoardMapper(I) -> boardMapper.xml
	
	
	
}
