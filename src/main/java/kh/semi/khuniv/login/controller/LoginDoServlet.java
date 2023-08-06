package kh.semi.khuniv.login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.khuniv.common.model.dto.ProfessorVo;
import kh.semi.khuniv.login.model.service.LoginService;
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
		String pwd = request.getParameter("pwd"); //입력받은 pwd
		String result = null;  //  db저장된 pwd
		String sendUrl = request.getContextPath();
		
		if(who.equals("s")) {
			result = service.sLogin(id);
			System.out.println("[jy] service.sLogin id:" + id);
		}else {
			result = service.pLogin(id);
		}
		if(result != null && pwd.equals(result)) {
			System.out.println("[jy] 로그인 성공");
//			request.setAttribute("loginId", mid);
//			request.getSession().setAttribute("successFailMsg", "로그인성공");
//			request.getSession().setAttribute("SsLoginId", mid);
//			sendUrl += "/board/list"; 
		} else {
			System.out.println("[jy] 로그인 실패");
		}
		response.sendRedirect(sendUrl + "/lmain");
		
	}

}
