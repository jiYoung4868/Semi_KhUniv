package kh.semi.khuniv.login.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kh.semi.khuniv.login.model.dto.LoginVo;
import kh.semi.khuniv.professor.model.dto.ProfessorVo;
import kh.semi.khuniv.student.model.dto.StudentVo;

import static kh.semi.khuniv.common.jdbc.JdbcTemplate.*;

public class LoginDao {

	public LoginVo sLogin(Connection conn, StudentVo vo) {
		System.out.println("[jy] LoginDao.sLogin studentVo:" + vo);

		LoginVo result = null;
		String query = "SELECT STUDENT_NAME FROM STUDENT WHERE STUDENT_NO = ?  AND STUDENT_PWD = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getStudentNo());
			pstmt.setString(2, vo.getStudentPwd());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = new LoginVo(vo.getStudentNo(), rs.getString("STUDENT_NAME"), 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("[jy] LoginDao.sLogin return: " + result);
		return result;
	}

	public LoginVo pLogin(Connection conn, ProfessorVo vo) {
		System.out.println("[jy] LoginDao.pLogin vo:" + vo);

		LoginVo result= null;
		String query = "SELECT PROFESSOR_NAME FROM PROFESSOR WHERE PROFESSOR_NO = ? and PROFESSOR_PWD=? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getProfessorNo());
			pstmt.setString(2, vo.getProfessorPwd());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = new LoginVo(vo.getProfessorNo(), rs.getString("PROFESSOR_NAME"), 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("[jy] LoginDao.pLogin return: " + result);
		return result;
	}
}
