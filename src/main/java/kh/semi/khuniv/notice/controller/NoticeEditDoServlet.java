package kh.semi.khuniv.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.khuniv.notice.model.dto.NoticeVoRes;
import kh.semi.khuniv.notice.model.service.NoticeService;

/**
 * Servlet implementation class NoticeEditDoServlet
 */
@WebServlet("/editnotice.do")
public class NoticeEditDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NoticeService service = new NoticeService();
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("[jy] NoticeEdit.dopost");
		String nTitle = request.getParameter("nTitle");
		String nContent = request.getParameter("nContent");
		String noticeNo = request.getParameter("noticeNo");
		
		int result = service.edit(new NoticeVoRes(nTitle, nContent, noticeNo));
		
		response.sendRedirect(request.getContextPath() + "/selectnotice?noticeNo=" + noticeNo);
	}

}
