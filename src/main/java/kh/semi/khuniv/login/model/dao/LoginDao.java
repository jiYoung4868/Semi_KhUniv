package kh.semi.khuniv.login.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static kh.semi.khuniv.common.jdbc.JdbcTemplate.*;

public class LoginDao {

	public String sLogin(Connection conn, String studentNo) {
		System.out.println("[jy] LoginDao.sLogin studentNo:" + studentNo);

		String result = null;
		String query = "SELECT STUDENT_PWD FROM STUDENT WHERE STUDENT_NO = ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, studentNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getString("STUDENT_PWD");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("[jy] LoginDao.sLogin return: " + result);
		return result;
	}

	public String pLogin(Connection conn, String professorNo) {
		System.out.println("[jy] LoginDao.pLogin professorNo:" + professorNo);

		String result= null;
		String query = "SELECT PROFESSOR_PWD FROM PROFESSOR WHERE PROFESSOR_NO = ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, professorNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getString("PROFESSOR_PWD");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("[jy] LoginDao.pLogin return: " + result);
		return result;
	}
}
