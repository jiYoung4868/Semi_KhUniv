package kh.semi.khuniv.notice.dto.model;


import static kh.semi.khuniv.common.jdbc.JdbcTemplate.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kh.semi.khuniv.notice.dto.NoticeVo;

public class NoticeDao {
	
	// 공지사항 게시판 리스트
	public List<NoticeVo> noticeList(Connection conn){
		System.out.println("[jy] noticeList");
		List<NoticeVo> result = new ArrayList<NoticeVo>();
		
		String query = "SELECT NOTICE_NO, NOTICE_TITLE, NWRITTEN_TIME, WRITER FROM NOTICELIST";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			System.out.println("[jy] noticeList.rs:" + rs);
			while (rs.next() == true) {
				NoticeVo nvo = new NoticeVo(
						rs.getString("NOTICE_NO"),
						rs.getString("NOTICE_TITLE"),
						rs.getString("NWRITTEN_TIME"),
						rs.getString("WRITER")
						);
					result.add(nvo);
			}
		}catch (Exception e) {
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
}
