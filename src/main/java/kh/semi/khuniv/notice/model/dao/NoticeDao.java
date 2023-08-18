package kh.semi.khuniv.notice.model.dao;

import static kh.semi.khuniv.common.jdbc.JdbcTemplate.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kh.semi.khuniv.notice.model.dto.NoticeVo;
import kh.semi.khuniv.notice.model.dto.NoticeVoRes;

public class NoticeDao {

	// 공지사항 게시글 추가
	public int insert(SqlSession session, NoticeVo vo) {
		System.out.println("[jy] NoticeDao.insert.vo:" + vo);
		int result = session.insert("khUniv.noticeInsert", vo);
		System.out.println("[jy] NoticeDao.insert.result: " + result);
		return result;
	}

	// 공지사항 게시글 삭제
	public int deleteC(SqlSession session, String noticeNo) {
		System.out.println("[jy] NoticeDao.deleteC.noticeNo");
		int result = session.delete("khUniv.noticeDeleteC", noticeNo);
		System.out.println("[jy] NoticeDao.deleteC.result: " + result);
		return result;
	}

	public int deleteN(SqlSession session, String noticeNo) {
		System.out.println("[jy] NoticeDao.deleteN.noticeNo");
		int result = session.delete("khUniv.noticeDeleteN", noticeNo);
		System.out.println("[jy] NoticeDao.deleteN.result: " + result);
		return result;
	}

	// 공지사항 게시글 선택
	public NoticeVoRes selectOne(SqlSession session, String noticeNo) {
		System.out.println("[jy] NoticeDao.selectOne.noticeNo: " + noticeNo);
		NoticeVoRes result = session.selectOne("khUniv.noticeSelectOne", noticeNo);
		System.out.println("[jy] NoticeDao.selectOne.result: " + result);
		return result;
	}

	// 공지사항 리스트 + 페이징 처리
	public int getTotalCount(Connection conn) {
		System.out.println("[jy] NoticeDao.getTotalCount");
		int result = 0;
		String query = "SELECT COUNT(*) CNT FROM NOTICE";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnectionKh();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("cnt");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("[jy] NoticeDao.getTotalCount.result: " + result);
		return result;
	}

	public List<NoticeVo> noticeList(Connection conn, int currentPage, int pageSize, int totalCnt) {
		List<NoticeVo> result = new ArrayList<NoticeVo>();
		String query = "SELECT * " + "FROM " + "    (SELECT TB1.*, ROWNUM NRN " + "    FROM"
				+ "        (SELECT NOTICE_NO, NOTICE_TITLE, NWRITTEN_TIME, WRITER" + "        FROM NOTICELIST"
				+ "        ORDER BY NOTICE_NO ASC) TB1) TB2 WHERE NRN BETWEEN ? AND ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int startRownum = 0;
		int endRownum = 0;
		startRownum = (currentPage - 1) * pageSize + 1;
		endRownum = ((currentPage * pageSize) > totalCnt) ? totalCnt : (currentPage * pageSize);

		System.out.println("[jy] NoticeDao.noticeList.totalCnt/startRownum/endRownum: " + totalCnt + "/" + startRownum
				+ "/" + endRownum);
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRownum);
			pstmt.setInt(2, endRownum);
			rs = pstmt.executeQuery();

			while (rs.next() == true) {
				NoticeVo vo = new NoticeVo();
				vo.setNoticeNo(rs.getString("NOTICE_NO"));
				vo.setNoticeTitle(rs.getString("NOTICE_TITLE"));
				vo.setnWrittenTime(rs.getString("NWRITTEN_TIME"));
				vo.setWriter(rs.getString("WRITER"));

				result.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("[jy] NoticeDao.noticeList.result: " + result);
		return result;
	}

//	 공지사항 게시글 수정
	public int edit(SqlSession session, NoticeVoRes vo) {
		System.out.println("[jy] NoticeDao.edit.vo: " + vo);
		int result = session.update("khUniv.noticeEdit", vo);
		System.out.println("[jy] NoticeDao.edit.result: " + result);
		return result;
	}

}

//// 공지사항 게시판 리스트
//public List<NoticeVo> noticeList(Connection conn) {
//	System.out.println("[jy] NoticeDao.noticeList");
//	List<NoticeVo> result = new ArrayList<NoticeVo>();
//
//	String query = "SELECT NOTICE_NO, NOTICE_TITLE, NWRITTEN_TIME, WRITER FROM NOTICELIST";
//
//	PreparedStatement pstmt = null;
//	ResultSet rs = null;
//
//	try {
//		pstmt = conn.prepareStatement(query);
//		rs = pstmt.executeQuery();
//		System.out.println("[jy] noticeList.rs:" + rs);
//		while (rs.next() == true) {
//			NoticeVo nvo = new NoticeVo(rs.getString("NOTICE_NO"), rs.getString("NOTICE_TITLE"),
//					rs.getString("NWRITTEN_TIME"), rs.getString("WRITER"));
//			result.add(nvo);
//		}
//	} catch (Exception e) {
//		e.printStackTrace();
//
//	} finally {
//		close(rs);
//		close(pstmt);
//	}
//	System.out.println("[jy] noticeList.return: " + result);
//	return result;
//}
