package com.spring.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.dto.CommRipDTO;
import com.spring.boot.mapper.CommRipMapper;

@Service("CommRipService")
public class CommRipServiceImpl implements CommRipService{

	@Autowired
	private CommRipMapper commripMapper;//commripMapper DI 의존성 주입

	@Override
	public int maxNum() throws Exception {
		return commripMapper.maxNum();
	}

	@Override
	public void insertReply(CommRipDTO dto) throws Exception {
		commripMapper.insertReply(dto);
	}

	@Override
	public int getDataCount(String searchKey, String searchValue) throws Exception {
		return commripMapper.getDataCount(searchKey, searchValue);
	}

	@Override
	public CommRipDTO getReadData(int crNo) throws Exception {
		return commripMapper.getReadData(crNo);
	}

	@Override
	public void updateReply(CommRipDTO dto) throws Exception {
		commripMapper.updateReply(dto);
	}

	@Override
	public void deleteReply(int crNo) throws Exception {
		commripMapper.deleteReply(crNo);
	}

	@Override
	public List<CommRipDTO> getReplyList(int commuNo, int start, int end, String searchKey, String searchValue)
			throws Exception {
		return commripMapper.getReplyList(commuNo, start, end, searchKey, searchValue);
	}

}
