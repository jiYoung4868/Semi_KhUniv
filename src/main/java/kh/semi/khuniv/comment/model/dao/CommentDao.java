package kh.semi.khuniv.comment.model.dao;

import static kh.semi.khuniv.common.jdbc.JdbcTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kh.semi.khuniv.comment.model.dto.CommentVo;
import kh.semi.khuniv.comment.model.dto.CommentVoRes;


public class CommentDao {
	
	// 공지사항 댓글 리스트
	public List<CommentVo> commentList(SqlSession session, String noticeNo) {
	System.out.println("[jy] CommentDao.commentList.noticeNo: " + noticeNo);
	List<CommentVo> result = session.selectList("khUniv.commentList", noticeNo);
	System.out.println("[jy] commentList.return: " + result);
	return result;
}
	
	// 공지사항 댓글 추가
	public int insert(SqlSession session, CommentVoRes vo) {
		System.out.println("[jy] CommentDao.commentInsert.vo: " + vo);
		int result = session.insert("khUniv.commentInsert", vo);
		System.out.println("[jy] CommentDao.insert.result: " + result);
		return result;
	}
	
	// 공지사항 댓글 삭제
	public int delete(SqlSession session, String commentNo) {
		System.out.println("[jy] CommentDao.delete.commentNo: " + commentNo);
		int result = session.delete("khUniv.commentDelete", commentNo);
		System.out.println("[jy] CommentDao.delete.result" + result);
		return result;
	}
}
