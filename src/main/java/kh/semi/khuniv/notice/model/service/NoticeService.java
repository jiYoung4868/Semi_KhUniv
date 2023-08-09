package kh.semi.khuniv.notice.model.service;

import java.sql.Connection;
import java.util.List;

import kh.semi.khuniv.notice.model.dao.NoticeDao;
import kh.semi.khuniv.notice.model.dto.NoticeVo;

import static kh.semi.khuniv.common.jdbc.JdbcTemplate.*;

public class NoticeService {
	private NoticeDao dao = new NoticeDao();
	
// 공지사항 게시판 리스트
	public List<NoticeVo> noticeList(){
		List<NoticeVo> result=null;
		Connection conn = getConnectionKh();
		result = dao.noticeList(conn);
		close(conn);
		return result;
	}
// 공지사항 게시글 추가
	public int insert(NoticeVo vo) {
		int result = 0;
		Connection conn = getConnectionKh();
		result = dao.insert(conn, vo);
		close(conn);
		return result;
	}
// 공지사항 게시글 삭제
	public int delete(String noticeNo) {
		int result = 0;
		Connection conn = getConnectionKh();
		result = dao.delete(conn, noticeNo);
		close(conn);
		return result;
	}
//공지사항 게시글 선택
	public NoticeVo selectOne(String noticeNo) {
		NoticeVo result = null;
		Connection conn = getConnectionKh();
		result = dao.selectOne(conn, noticeNo);
		close(conn);
		return result;
	}
	
}
