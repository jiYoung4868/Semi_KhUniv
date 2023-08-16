package kh.semi.khuniv.comment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.khuniv.comment.model.dto.CommentVo;
import kh.semi.khuniv.login.model.dto.LoginVo;

/**
 * Servlet implementation class NewCommentServlet
 */
@WebServlet("/newcomment.do")
public class NewCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		request.getRequestDispatcher("WEB-INF/view/notice/show.jsp").forward(request, response);
//
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//insert 
		System.out.println("[jy] CommentInsert.dopost");
		String commentContent = request.getParameter("commentContent");
		LoginVo vo = (LoginVo)request.getSession().getAttribute("loginId");
		int result = service.insert(new CommentVo(noticeNo, vo.getMemberId(), commentContent, cWrittenTime));
	
		response.sendRedirect(request.getContextPath()+ "/selectnotice?noticeNo=" + noticeNo);
	}

}

//http://localhost:8090/khUniv/selectnotice?noticeNo=2