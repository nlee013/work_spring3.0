package com.spring.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.dto.CommentDTO;
import com.spring.boot.mapper.CommentMapper;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentMapper mCommentMapper;//BoardMapper DI 의존성 주입

	@Override
	public int commentInsertService(CommentDTO comment) throws Exception {
		return mCommentMapper.commentInsertService(comment);

	}

	@Override
	public int commentUpdateService(CommentDTO comment) throws Exception {
		return mCommentMapper.commentUpdateService(comment);

	}

	@Override
	public int commentDeleteService(int cno) throws Exception {
		  return mCommentMapper.commentDeleteService(cno);

		 
	}

	@Override
	public List<CommentDTO> commentListService() throws Exception {
		 return mCommentMapper.commentListService();
	}

	@Override
	public int commentCount() throws Exception {
		return mCommentMapper.commentCount();

	}
	
	//찾아가는 순서
	//BoardController -> BoardService(Interface) -> BoardServiceImpl(Class) -> BoardMapper(I) -> boardMapper.xml
	
	
	
}
