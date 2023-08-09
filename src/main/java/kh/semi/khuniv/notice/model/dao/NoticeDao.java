package kh.semi.khuniv.notice.model.dao;

import static kh.semi.khuniv.common.jdbc.JdbcTemplate.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kh.semi.khuniv.notice.model.dto.NoticeVo;

public class NoticeDao {

	// 공지사항 게시판 리스트
	public List<NoticeVo> noticeList(Connection conn) {
		System.out.println("[jy] NoticeDao.noticeList");
		List<NoticeVo> result = new ArrayList<NoticeVo>();

		String query = "SELECT ROWNUM NOTICE_NO, NOTICE_TITLE, NWRITTEN_TIME, WRITER FROM NOTICELIST";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			System.out.println("[jy] noticeList.rs:" + rs);
			while (rs.next() == true) {
				NoticeVo nvo = new NoticeVo(rs.getString("NOTICE_NO"), rs.getString("NOTICE_TITLE"),
						rs.getString("NWRITTEN_TIME"), rs.getString("WRITER"));
				result.add(nvo);
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("[jy] noticeList.return: " + result);
		return result;
	}

	// 공지사항 게시글 추가
	public int insert(Connection conn, NoticeVo vo) {
		System.out.println("[jy] NoticeDao.insert.vo:" + vo);
		int result = 0;
		String query = "INSERT INTO NOTICE VALUES (NOTICE_SEQ.NEXTVAL, ? , ? , default, ? )";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getNoticeTitle());
			pstmt.setString(2, vo.getNoticeContent());
			pstmt.setString(3, vo.getWriter());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("[jy] NoticeDao.insert.result: " + result);
		return result;
	}

	// 공지사항 게시글 삭제
	public int delete(Connection conn, String noticeNo) {

		System.out.println("[jy] NoticeDao.delete.noticeNo");
		int result = 0;
		String query = "DELETE FROM NOTICE WHERE NOTICE_NO = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, noticeNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("[jy] NoticeDao.delete.result: " + result);
		return result;

	}

	// 공지사항 게시글 선택
	public NoticeVo selectOne(Connection conn, String noticeNo) {
		System.out.println("[jy] NoticeDao.selectOne.noticeNo: " + noticeNo);
		NoticeVo result = null;
		String query = "SELECT NOTICE_TITLE, NOTICE_CONTENT, NOTICE_NO FROM NOTICE WHERE NOTICE_NO = ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, noticeNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = new NoticeVo(rs.getString("NOTICE_NO"), rs.getString("NOTICE_TITLE"),
						rs.getString("NOTICE_CONTENT"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);

		}
		System.out.println("[jy] NoticeDao.selectOne,result: " + result);
		return result;
	}
}
