//package com.spring.boot.service;
//
//import java.util.Collections;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.spring.boot.dto.CommRipDTO;
//import com.spring.boot.dto.CommentDTO;
//import com.spring.boot.mapper.CommRipMapper;
//import com.spring.boot.mapper.CommentMapper;
//import com.spring.boot.mapper.CommuMapper;
//
//@Service("CommentService")
//public class CommentServiceImpl implements CommentService{
//
//	@Autowired
//	private CommentMapper commentMapper;//commuMapper DI 의존성 주입
//
//	@Override
//	public List<CommentDTO> commentListService() throws Exception {
//		  return commentMapper.commentList();
//
//		  
//	}
//
//	@Override
//	public int commentInsertService(CommentDTO comment) throws Exception {
//		 return commentMapper.commentInsert(comment);
//
//		
//	}
//
//	@Override
//	public int commentUpdateService(CommentDTO comment) throws Exception {
//		   return commentMapper.commentUpdate(comment);
//
//	} 
//
//	@Override
//	public int commentDeleteService(int cno) throws Exception {
//		return commentMapper.commentDelete(cno);
//
//	}
//
//	//찾아가는 순서
//	//BoardController -> BoardService(Interface) -> BoardServiceImpl(Class) -> BoardMapper(I) -> boardMapper.xml
//	
//	
//}
