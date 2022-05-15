package com.spring.boot.dao;

import java.util.List;

import com.spring.boot.dto.CommRipDTO;

public interface ReplyDAO {
	
	public List<CommRipDTO> list(int commuNo);    //댓글의 목록
    
    public int count(int commuNo);            //댓글의 갯수
    
    public void create(CommRipDTO dto);        //댓글의 작성
 
    public void reply_update(CommRipDTO dto);        //댓글의 수정
 
    public void reply_delete(int crNo);        //댓글의 삭제

}
