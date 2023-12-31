package kh.semi.khuniv.login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = (String)request.getSession().getAttribute("msg");
		if(msg!=null) {
		request.getSession().removeAttribute("msg");
		request.setAttribute("msg", msg);
		}
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}
}
