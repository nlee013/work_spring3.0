package com.spring.boot.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.spring.boot.dto.CommRipDTO;

@Repository        //dao 빈 설정
public class ReplyDAOImpl implements ReplyDAO {
 
    @JacksonInject        //의존관계를 주입함
    SqlSession sqlSession;

	@Override
	public List<CommRipDTO> list(int commuNo) {
		  return sqlSession.selectList("reply.getReplyList", commuNo);
	}

	@Override
	public int count(int commuNo) {
		return 0;
	}

	@Override
	public void create(CommRipDTO dto) {
		 sqlSession.insert("reply.insertReply", dto);
	}

	@Override
	public void reply_update(CommRipDTO dto) {
		 sqlSession.update("reply.updateReply", dto);
	}

	@Override
	public void reply_delete(int crNo) {
		sqlSession.delete("reply.deleteReply", crNo);
	}
    
    
    
}
 