package kh.semi.khuniv.notice.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kh.semi.khuniv.common.mybatis.MyBatisTemplate;
import kh.semi.khuniv.notice.model.dao.NoticeDao;
import kh.semi.khuniv.notice.model.dto.NoticeVo;
import kh.semi.khuniv.notice.model.dto.NoticeVoRes;

import static kh.semi.khuniv.common.jdbc.JdbcTemplate.*;

public class NoticeService {
	private NoticeDao dao = new NoticeDao();
	
// 공지사항 게시판 리스트
//	public List<NoticeVo> noticeList(){
//		List<NoticeVo> result=null;
//		Connection conn = getConnectionKh();
//		result = dao.noticeList(conn);
//		close(conn);
//		return result;
//	}
// 공지사항 게시글 추가
	public int insert(NoticeVo vo) {
		int result = 0;
		SqlSession session = MyBatisTemplate.getSqlSession();
		result = dao.insert(session, vo);
		session.close();
		return result;
	}
// 공지사항 게시글 삭제
	public int delete(String noticeNo) {
		int result = 0;
//		setAutoCommit(connse, false);
		SqlSession session = MyBatisTemplate.getSqlSession();
		result = dao.deleteC(session, noticeNo);
		result = dao.deleteN(session, noticeNo);
//		if(result!=1) {
//			rollback(conn);
//		}
		session.close();
		return result;
	}
// 공지사항 게시글 선택
	public NoticeVoRes selectOne(String noticeNo) {
		NoticeVoRes result = null;
		SqlSession session = MyBatisTemplate.getSqlSession();
		result = dao.selectOne(session, noticeNo);
		session.close();
		return result;
	}

// 공지사항 페이징 처리
	public Map<String, Object> noticeList(int currentPage, int pageSize){
		Connection conn = getConnectionKh();
		int totalCnt= dao.getTotalCount(conn);
		List<NoticeVo> result = dao.noticeList(conn, currentPage, pageSize, totalCnt);
		close(conn);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalCnt", totalCnt);
		map.put("noticeList", result);
		return map;
	}
	public int getTotalCount() {
		Connection conn = getConnectionKh();
		int result = dao.getTotalCount(conn);
		close(conn);
		return result;
		
	}
	
// 공지사항 게시글 수정
	public int edit(NoticeVoRes vo) {
		int result = 0;
		SqlSession session = MyBatisTemplate.getSqlSession();
		result = dao.edit(session, vo);
		session.close();
		return result;
	}
	
}
