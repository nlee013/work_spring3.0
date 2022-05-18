package com.spring.boot.service;

import java.util.List;

import com.spring.boot.dto.UsersDTO;

public interface UsersService {
	
		//1.로그인
		public UsersDTO login(UsersDTO dto) throws Exception;
		
		//2.회원가입
		public void write(UsersDTO dto) throws Exception;

		//3.유저아이디 중복 체크
		boolean isUserId(UsersDTO dto) throws Exception;
	
		//mypage
		public UsersDTO getReadData(int userNo) throws Exception;
		
		public int getDataCount() throws Exception;

		public List<UsersDTO> getList() throws Exception;

		public void updateData(UsersDTO dto) throws Exception;		
}
