package kh.semi.khuniv.notice.model.dto;

public class NoticeVo {
//	NOTICE_NO      NOT NULL NUMBER         
//	NOTICE_TITLE   NOT NULL VARCHAR2(300)  
//	NOTICE_CONTENT          VARCHAR2(4000) 
//	NWRITTEN_TIME  NOT NULL TIMESTAMP(6)   
//	WRITER         NOT NULL VARCHAR2(20)  
	
	private String noticeNo;
	private String noticeTitle;
	private String noticeContent;
	private String nWRittenTime;
	private String writer; //tb professor
	
	//공지사항 게시판 리스트
	public NoticeVo() {
		super();
	}
	
	public NoticeVo(String noticeNo, String noticeTitle, String nWRittenTime, String writer) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.nWRittenTime = nWRittenTime;
		this.writer = writer;
	}
	
	//공지사항 게시글 추가
	public NoticeVo(String noticeTitle, String noticeContent, String writer) {
		super();
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "NoticeVo [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent
				+ ", nWRittenTime=" + nWRittenTime + ", writer=" + writer + "]";
		
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

	public String getnWRittenTime() {
		return nWRittenTime;
	}

	public void setnWRittenTime(String nWRittenTime) {
		this.nWRittenTime = nWRittenTime;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	
}
