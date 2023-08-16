package kh.semi.khuniv.notice.model.dto;

public class NoticeVoRes {
//	NOTICE_NO      NOT NULL NUMBER         
//	NOTICE_TITLE   NOT NULL VARCHAR2(300)  
//	NOTICE_CONTENT          VARCHAR2(4000) 
//	NWRITTEN_TIME  NOT NULL TIMESTAMP(6)   
//	WRITER         NOT NULL VARCHAR2(20)  
	
	private String noticeNo;
	private String noticeTitle;
	private String noticeContent;
	private String writer;


	//공지사항 게시판 select One
	public NoticeVoRes(String noticeNo, String noticeTitle, String noticeContent, String writer) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.writer = writer;
	}
	public NoticeVoRes(String noticeTitle, String noticeContent, String noticeNo) {
		super();
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeNo = noticeNo;
	}

	

	@Override
	public String toString() {
		return "NoticeVoRes [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent
				+ ", writer=" + writer + "]";
	}



	public String getNoticeNo() {
		return noticeNo;
	}


	public void setNoticeNo(String noticeNo) {
		this.noticeNo = noticeNo;
	}


	public String getNoticeTitle() {
		return noticeTitle;
	}


	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}


	public String getNoticeContent() {
		return noticeContent;
	}


	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}
	

}