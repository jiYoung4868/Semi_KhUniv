package kh.semi.khuniv.notice.dto;

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
