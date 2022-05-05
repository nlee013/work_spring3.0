package com.spring.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.dto.QaContactDTO;
import com.spring.boot.mapper.ContactMapper;


@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactMapper contactMapper;//BoardMapper DI 의존성 주입
	
	@Override
	public int maxNum() throws Exception {
		return contactMapper.maxNum();
	}

	@Override
	public void insertData(QaContactDTO dto) throws Exception {
		contactMapper.insertData(dto);
	}

	@Override
	public int getDataCount(String searchKey, String searchValue) throws Exception {
		return contactMapper.getDataCount(searchKey, searchValue);
	}

	@Override
	public List<QaContactDTO> getList(int start, int end, String searchKey, String searchValue) throws Exception {
		return contactMapper.getList(start, end, searchKey, searchValue);
	}

	@Override
	public QaContactDTO getReadData(int qa_conNo) throws Exception {
		return contactMapper.getReadData(qa_conNo);
	}

	@Override
	public void updateHitCount(int qa_conNo) throws Exception {
		contactMapper.updateHitCount(qa_conNo);

	}

	@Override
	public void updateData(QaContactDTO dto) throws Exception {
		contactMapper.updateData(dto);

	}

	@Override
	public void deleteData(int qa_conNo) throws Exception {
		contactMapper.deleteData(qa_conNo);

	}
	
	

	
	//찾아가는 순서
	//BoardController -> BoardService(Interface) -> BoardServiceImpl(Class) -> BoardMapper(I) -> boardMapper.xml
	
	
	
}
