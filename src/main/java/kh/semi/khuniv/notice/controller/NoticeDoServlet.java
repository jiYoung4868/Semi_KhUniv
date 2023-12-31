package kh.semi.khuniv.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.khuniv.login.model.dto.LoginVo;
import kh.semi.khuniv.notice.model.dto.NoticeVo;
import kh.semi.khuniv.notice.model.service.NoticeService;

/**
 * Servlet implementation class NoticeDoServlet
 */
@WebServlet("/newnotice.do")
public class NoticeDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NoticeService service = new NoticeService();
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("[jy] NoticeInsert.dopost");
		String nTitle = request.getParameter("nTitle");
		String nContent= request.getParameter("nContent");
		LoginVo vo = (LoginVo)request.getSession().getAttribute("loginId");
				
		int result = service.insert(new NoticeVo(nTitle, nContent, vo.getMemberId()));
		
		response.sendRedirect(request.getContextPath() + "/notice");
	}

}
