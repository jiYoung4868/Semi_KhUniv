package kh.semi.khuniv.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.khuniv.notice.dto.NoticeVo;
import kh.semi.khuniv.notice.dto.model.service.NoticeService;

/**
 * Servlet implementation class NoticeDoServlet
 */
@WebServlet("/newnotice.do")
public class NoticeDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NoticeService service = new NoticeService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("[jy] NoticeInsert.dopost");
		String nTitle = request.getParameter("nTitle");
		String nContent= request.getParameter("nContent");
		String nWriter = "P084"; //TODO 로그인 id로 설정 예정
				
		int result = service.insert(new NoticeVo(nTitle, nContent, nWriter));
		
		response.sendRedirect(request.getContextPath() + "/notice");
	}

}
