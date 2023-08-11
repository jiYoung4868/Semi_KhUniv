package kh.semi.khuniv.notice.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.khuniv.notice.model.dto.NoticeVo;
import kh.semi.khuniv.notice.model.service.NoticeService;


@WebServlet("/notice")
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	NoticeService service = new NoticeService();
	Map<String, Object> map = null;
	
	String pageNo = request.getParameter("pageNo");
	int currentPage = 1;
	int pageSize = 5;
	if(pageNo != null) {
		try {
			currentPage = Integer.parseInt(pageNo);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} 
	
	}
	map = service.noticeList(currentPage, pageSize);
	
	request.setAttribute("noticeList", map.get("noticeList"));
	
	int pageBlockSize = 5;
	int totalCnt = (Integer)map.get("totalCnt");
	int totalPageNum = totalCnt/pageSize + (totalCnt%pageSize == 0 ? 0:1);
	int startPageNum = 1;

	if((currentPage%pageBlockSize) == 0) {
		startPageNum = ((currentPage/pageBlockSize)-1)*pageBlockSize +1;
	}else {
		startPageNum = ((currentPage/pageBlockSize))*pageBlockSize + 1;
	}
	int endPageNum = (startPageNum + pageBlockSize > totalPageNum) ? totalPageNum : startPageNum + pageBlockSize-1;
	request.setAttribute("totalPageNum", totalPageNum);
	request.setAttribute("startPageNum", startPageNum);
	request.setAttribute("endPageNum", endPageNum);
	request.setAttribute("currentPage", currentPage);
	
	System.out.println("[jy] NoticeListServlet.doGet.tsec: " + totalPageNum + startPageNum + endPageNum + currentPage);
	request.getRequestDispatcher("/WEB-INF/view/notice/list.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}



//List<NoticeVo> result = new NoticeService().noticeList();
//request.setAttribute("noticeList", result);
//request.getRequestDispatcher("WEB-INF/view/notice/list.jsp").forward(request, response);
