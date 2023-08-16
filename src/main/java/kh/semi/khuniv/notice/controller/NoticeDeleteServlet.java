package kh.semi.khuniv.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.khuniv.notice.model.service.NoticeService;

/**
 * Servlet implementation class NoticeDeleteServlet
 */
@WebServlet("/delnotice")
public class NoticeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String noticeNo = request.getParameter("noticeNo");
		System.out.println("[jy] NoticeDeleteServlet.doPost.noticeNo: " + noticeNo);
		NoticeService service = new NoticeService();
		int result = service.delete(noticeNo);
		System.out.println("[jy] NoticeDeleteServlet.doPost.result: " + result);
		response.sendRedirect(request.getContextPath() + "/notice");
		
	}

}

