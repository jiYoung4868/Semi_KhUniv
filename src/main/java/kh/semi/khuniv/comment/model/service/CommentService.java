package kh.semi.khuniv.comment.model.service;

import java.sql.Connection;
import java.util.List;

import kh.semi.khuniv.comment.model.dao.CommentDao;
import kh.semi.khuniv.comment.model.dto.CommentVo;
import kh.semi.khuniv.comment.model.dto.CommentVoRes;

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
	
	// 공지사항 댓글 추가
	public int insert(CommentVoRes vo) {
		int result = 0;
		Connection conn = getConnectionKh();
		result = dao.insert(conn, vo);
		close(conn);
		return result;
	}
}
