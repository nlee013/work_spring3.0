package com.spring.boot.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.spring.boot.dto.LoginDTO;
import com.spring.boot.dto.UsersDTO;

@Mapper
public interface UsersMapper {
	
	//1.로그인
	
	public LoginDTO login(LoginDTO dto) throws Exception;
	
	
	//2.회원가입
	public int write(UsersDTO dto) throws Exception;

	//3.아이디 중복 체크
	int userIdChk(UsersDTO dto) throws Exception;
	
}
