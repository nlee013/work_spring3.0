package com.spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.dto.LoginDTO;
import com.spring.boot.dto.UsersDTO;
import com.spring.boot.mapper.UsersMapper;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	private UsersMapper mapper;

	@Override
	public LoginDTO login(LoginDTO dto) throws Exception {
		return mapper.login(dto);
	}

	@Override
	public void write(UsersDTO dto) throws Exception {
		mapper.write(dto);
	}

	@Override
	public boolean isUserId(UsersDTO dto) throws Exception {
		int userIdCount = mapper.userIdChk(dto);
		return 0 < userIdCount;
	}

}
