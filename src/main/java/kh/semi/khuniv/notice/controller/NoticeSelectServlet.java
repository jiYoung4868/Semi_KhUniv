package kh.semi.khuniv.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.khuniv.notice.model.dto.NoticeVo;
import kh.semi.khuniv.notice.model.service.NoticeService;

/**
 * Servlet implementation class NoticeSelectServlet
 */
@WebServlet("/selectnotice")
public class NoticeSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String noticeNo = request.getParameter("noticeNo");
		System.out.println("[jy] NoticeSelectServlet.doGet.noticeNo: "+ noticeNo);
		NoticeService service = new NoticeService();
		NoticeVo vo = service.selectOne(noticeNo);
		if(vo != null) {
			request.setAttribute("nvo", vo);
			request.getRequestDispatcher("/WEB-INF/view/notice/show.jsp").forward(request, response);
		}

	}
}