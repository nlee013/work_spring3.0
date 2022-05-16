package com.spring.boot.service;

import com.spring.boot.dto.LoginDTO;
import com.spring.boot.dto.UsersDTO;

public interface UsersService {
	
		//1.로그인
		public LoginDTO login(LoginDTO dto) throws Exception;
		
		//2.회원가입
		public void write(UsersDTO dto) throws Exception;

		//3.유저아이디 중복 체크
		boolean isUserId(UsersDTO dto) throws Exception;
	
}
