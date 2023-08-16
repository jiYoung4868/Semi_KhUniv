package kh.semi.khuniv.login.model.service;

import java.sql.Connection;

import kh.semi.khuniv.login.model.dao.LoginDao;
import kh.semi.khuniv.login.model.dto.LoginVo;
import kh.semi.khuniv.professor.model.dto.ProfessorVo;
import kh.semi.khuniv.student.model.dto.StudentVo;

import static kh.semi.khuniv.common.jdbc.JdbcTemplate.*;

public class LoginService {
	private LoginDao dao = new LoginDao();
	
	public LoginVo sLogin (StudentVo vo) {
		LoginVo result = null;
		Connection conn = getConnectionKh();
		result = dao.sLogin(conn, vo);
		close(conn);
		return result;
	}
	public LoginVo pLogin (ProfessorVo vo) {
		LoginVo result = null;
		Connection conn = getConnectionKh();
		result = dao.pLogin(conn, vo);
		close(conn);
		return result;
	}
}
