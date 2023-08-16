package kh.semi.khuniv.comment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.khuniv.comment.model.dto.CommentVo;
import kh.semi.khuniv.comment.model.dto.CommentVoRes;
import kh.semi.khuniv.comment.model.service.CommentService;
import kh.semi.khuniv.login.model.dto.LoginVo;

/**
 * Servlet implementation class NewCommentServlet
 */
@WebServlet("/newcomment.do")
public class NewCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommentService service = new CommentService();
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		request.getRequestDispatcher("WEB-INF/view/notice/show.jsp").forward(request, response);
//
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("[jy] CommentInsert.dopost");
		String commentContent = request.getParameter("comment");
		String noticeNo = request.getParameter("noticeNo");
		LoginVo vo = (LoginVo)request.getSession().getAttribute("loginId");
		String commenter = vo.getMemberId();
		int result = service.insert(new CommentVoRes(commenter, commentContent, noticeNo));
	
		response.sendRedirect(request.getContextPath()+ "/selectnotice?noticeNo=" + noticeNo);
		// redirect 에서 noticeNO 번호를 받아오고 싶은데 어디서 받아와야할지 모르겠음
	}

}

//http://localhost:8090/khUniv/selectnotice?noticeNo=2