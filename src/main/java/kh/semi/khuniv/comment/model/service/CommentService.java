package kh.semi.khuniv.comment.model.service;

import java.sql.Connection;
import java.util.List;

import kh.semi.khuniv.comment.model.dao.CommentDao;
import kh.semi.khuniv.comment.model.dto.CommentVo;

import static kh.semi.khuniv.common.jdbc.JdbcTemplate.*;

public class CommentService {
	private CommentDao dao = new CommentDao();

	// 공지사항 댓글 리스트
	public List<CommentVo> commentList(String noticeNo) {
		List<CommentVo> result = null;
		Connection conn = getConnectionKh();
		result = dao.commentList(conn, noticeNo);
		close(conn);
		return result;
	}
}
