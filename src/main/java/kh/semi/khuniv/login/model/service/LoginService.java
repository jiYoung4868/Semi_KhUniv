package kh.semi.khuniv.login.model.service;

import java.sql.Connection;

import kh.semi.khuniv.login.model.dao.LoginDao;

import static kh.semi.khuniv.common.jdbc.JdbcTemplate.*;

public class LoginService {
	private LoginDao dao = new LoginDao();
	
	public String sLogin (String studentNo) {
		String result = null;
		Connection conn = getConnectionKh();
		result = dao.sLogin(conn, studentNo);
		close(conn);
		return result;
	}
	public String pLogin (String professorNo) {
		String result = null;
		Connection conn = getConnectionKh();
		result = dao.pLogin(conn, professorNo);
		close(conn);
		return result;
	}
}
