package kh.semi.khuniv.comment.model.dao;

import static kh.semi.khuniv.common.jdbc.JdbcTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kh.semi.khuniv.comment.model.dto.CommentVo;
import kh.semi.khuniv.comment.model.dto.CommentVoRes;

public class CommentDao {
	
	// 공지사항 댓글 리스트
	public List<CommentVo> commentList(Connection conn, String noticeNo) {
	System.out.println("[jy] CommentDao.commentList.noticeNo: " + noticeNo);
	List<CommentVo> result = new ArrayList<CommentVo>();

	String query = "SELECT NOTICE_NO, COMMENT_NO, MEMBER_NAME, COMMENT_CONTENT, CWRITTEN_TIME FROM CMEMBER WHERE NOTICE_NO= ?";

	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, noticeNo);
		rs = pstmt.executeQuery();
		while (rs.next() == true) {
			System.out.println("[jy] commentList.rs:" + rs);
			CommentVo cvo = new CommentVo(rs.getString("NOTICE_NO"), rs.getString("COMMENT_NO"), rs.getString("MEMBER_NAME"), rs.getString("COMMENT_CONTENT"),
					rs.getString("CWRITTEN_TIME"));
			result.add(cvo);
		}
	} catch (Exception e) {
		e.printStackTrace();

	} finally {
		close(rs);
		close(pstmt);
	}
	System.out.println("[jy] commentList.return: " + result);
	return result;
}
	
	// 공지사항 댓글 추가
	public int insert(Connection conn, CommentVoRes vo) {
		System.out.println("[jy] CommentDao.insert.vo: " + vo);
		int result = 0;
		String query = "INSERT INTO \"COMMENT\" VALUES (COMMENT_SEQ.NEXTVAL, default , ? , ?, ? )";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getNoticeNo());
			pstmt.setString(2, vo.getCommenter());
			pstmt.setString(3, vo.getCommentContent());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("[jy] CommentDao.insert.result: " + result);
		return result;
	}
	
	// 공지사항 댓글 삭제
	public int delete(Connection conn, String commentNo) {
		System.out.println("[jy] CommentDao.delete.commentNo");
		int result = 0;
		String query = "DELETE FROM \"COMMENT\" WHERE COMMENT_NO = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, commentNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("[jy] CommentDao.delete.result" + result);
		return result;
	}
}
