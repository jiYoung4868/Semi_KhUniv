package kh.semi.khuniv.comment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.khuniv.comment.model.service.CommentService;

/**
 * Servlet implementation class CommentDeleteServlet
 */
@WebServlet("/delcomment.do")
public class CommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String commentNo = request.getParameter("commentNo");
		String noticeNo = request.getParameter("noticeNo");
		System.out.println("[jy] CommentDeleteServlet.dopost.commentNo: " + commentNo);
		System.out.println("[jy] CommentDeleteServlet.dopost.noticeNo: " + noticeNo);
		CommentService service = new CommentService();
		int result = service.delete(commentNo);
		System.out.println("[jy] CommentDeleteServlet.dopost.result: " + result);
		
		response.sendRedirect(request.getContextPath()+ "/selectnotice?noticeNo=" + noticeNo);
		
	}

}
