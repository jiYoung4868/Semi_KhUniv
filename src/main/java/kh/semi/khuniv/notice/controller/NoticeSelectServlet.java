package kh.semi.khuniv.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.khuniv.comment.model.dto.CommentVo;
import kh.semi.khuniv.comment.model.service.CommentService;
import kh.semi.khuniv.notice.model.dto.NoticeVo;
import kh.semi.khuniv.notice.model.dto.NoticeVoRes;
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
		System.out.println("[jy] NoticeSelectServlet.doGet.noticeNo: " + noticeNo);
		
		NoticeService service = new NoticeService();
		NoticeVoRes vo = service.selectOne(noticeNo);
		CommentService cservice = new CommentService();
		List<CommentVo> cvo = cservice.commentList(noticeNo);
		
		if (vo != null) {
			request.setAttribute("nvo", vo);
			request.setAttribute("cvo", cvo);
			request.getRequestDispatcher("/WEB-INF/view/notice/show.jsp").forward(request, response);
		}

	}

}

//protected void doGet(HttpServletRequest request, HttpServletResponse response)
//		throws ServletException, IOException {

//	String noticeNo = request.getParameter("noticeNo");
//	System.out.println("[jy] NoticeSelectServlet.doGet.noticeNo: "+ noticeNo);
//	NoticeService service = new NoticeService();
//	NoticeVoRes vo = service.selectOne(noticeNo);
//	
//	List<CommentVo> commentList = new CommentService().commentList(noticeNo);
//	if(vo != null) {
//		request.setAttribute("cvo", vo);
//		request.setAttribute("commentList", commentList);
//		request.getRequestDispatcher("/WEB-INF/view/notice/show.jsp").forward(request, response);
//	}