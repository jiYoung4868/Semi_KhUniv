package kh.semi.khuniv.login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.khuniv.login.model.dto.LoginVo;
import kh.semi.khuniv.login.model.service.LoginService;
import kh.semi.khuniv.professor.model.dto.ProfessorVo;
import kh.semi.khuniv.student.model.dto.StudentVo;



/**
 * Servlet implementation class loginDoServlet
 */
@WebServlet("/login.do")
public class LoginDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginService service =  new LoginService();
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[jy] login.slogin post");
		
		String who = request.getParameter("who");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		LoginVo result = null;  
		String sendUrl = request.getContextPath();
		
		if(who.equals("s")) {
			StudentVo vo = new StudentVo(id, pwd);
			result = service.sLogin(vo);
		}else {
			ProfessorVo vo = new ProfessorVo(id, pwd);
			result = service.pLogin(vo);
		}
		System.out.println("[jy] service.login result:" + result);
		if(result != null) {
			System.out.println("[jy] 로그인 성공");
			request.getSession().setAttribute("msg", result.getMemberName()+"님 반갑습니다.");
			request.getSession().setAttribute("loginId", result);
			response.sendRedirect(sendUrl + "/lmain");
		} else {
			System.out.println("[jy] 로그인 실패");
			request.getSession().setAttribute("msg", "로그인 실패하였습니다.\n 아이디와 패스워드를 확인해주세요.");
			response.sendRedirect(sendUrl + "/lmain");
		}

		
	}


	private void alert(String string) {
		// TODO Auto-generated method stub
		
	}

}
