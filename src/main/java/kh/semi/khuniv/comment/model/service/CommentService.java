package kh.semi.khuniv.comment.model.service;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kh.semi.khuniv.comment.model.dao.CommentDao;
import kh.semi.khuniv.comment.model.dto.CommentVo;
import kh.semi.khuniv.comment.model.dto.CommentVoRes;
import kh.semi.khuniv.common.mybatis.MyBatisTemplate;

import static kh.semi.khuniv.common.jdbc.JdbcTemplate.*;

public class CommentService {
	private CommentDao dao = new CommentDao();

	// 공지사항 댓글 리스트
	public List<CommentVo> commentList(String noticeNo) {
		List<CommentVo> result = null;
		SqlSession session = MyBatisTemplate.getSqlSession();
		result = dao.commentList(session, noticeNo);
		session.close();
		return result;
	}
	
	// 공지사항 댓글 추가
	public int insert(CommentVoRes vo) {
		int result = 0;
		SqlSession session = MyBatisTemplate.getSqlSession();
		result = dao.insert(session, vo);
		session.close();
		return result;
	}
	
	// 공지사항 댓글 삭제
	public int delete(String commentNo) {
		int result = 0;
	SqlSession session = MyBatisTemplate.getSqlSession();
		result = dao.delete(session, commentNo);
		session.close();
		return result;
	}
}
