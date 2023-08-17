package kh.semi.khuniv.login.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.ibatis.session.SqlSession;

import kh.semi.khuniv.login.model.dto.LoginVo;
import kh.semi.khuniv.professor.model.dto.ProfessorVo;
import kh.semi.khuniv.student.model.dto.StudentVo;

import static kh.semi.khuniv.common.jdbc.JdbcTemplate.*;

public class LoginDao {

	public LoginVo sLogin(SqlSession session, StudentVo vo) {
		System.out.println("[jy] LoginDao.sLogin studentVo:" + vo);
		LoginVo result = session.selectOne("khUniv.studentLogin", vo);
		System.out.println("[jy] LoginDao.sLogin return: " + result);
		return result;
	}

	public LoginVo pLogin(SqlSession session, ProfessorVo vo) {
		System.out.println("[jy] LoginDao.pLogin vo:" + vo);
		LoginVo result= session.selectOne("khUniv.professorLogin", vo);
		System.out.println("[jy] LoginDao.pLogin return: " + result);
		return result;
	}
}
