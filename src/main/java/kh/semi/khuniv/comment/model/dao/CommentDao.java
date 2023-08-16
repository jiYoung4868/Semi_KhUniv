package kh.semi.khuniv.comment.model.dao;

import static kh.semi.khuniv.common.jdbc.JdbcTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kh.semi.khuniv.comment.model.dto.CommentVo;

public class CommentDao {
	
	public List<CommentVo> commentList(Connection conn, String noticeNo) {
	System.out.println("[jy] CommentDao.commentList.noticeNo: " + noticeNo);
	List<CommentVo> result = new ArrayList<CommentVo>();

	String query = "SELECT COMMENTER, COMMENT_CONTENT, CWRITTEN_TIME FROM \"COMMENT\" WHERE NOTICE_NO= ?";

	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, noticeNo);
		rs = pstmt.executeQuery();
		while (rs.next() == true) {
			System.out.println("[jy] commentList.rs:" + rs);
			CommentVo cvo = new CommentVo(rs.getString("COMMENTER"), rs.getString("COMMENT_CONTENT"),
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
}
