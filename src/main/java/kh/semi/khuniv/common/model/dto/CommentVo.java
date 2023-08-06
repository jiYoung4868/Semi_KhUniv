package kh.semi.khuniv.common.model.dto;

public class CommentVo {
//	COMMENT_NO    NOT NULL NUMBER        
//	CWRITTEN_TIME NOT NULL TIMESTAMP(6)  
//	NOTICE_NO     NOT NULL NUMBER        
//	COMMENTER     NOT NULL VARCHAR2(300)
	
	private String commentNo;
	private String cWrittenTime;
	private String noticeNo; //tb notice
	private String commenter;
	
	@Override
	public String toString() {
		return "CommentVo [commentNo=" + commentNo + ", cWrittenTime=" + cWrittenTime + ", noticeNo=" + noticeNo
				+ ", commenter=" + commenter + "]";
		
	}
	public String getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(String commentNo) {
		this.commentNo = commentNo;
	}
	public String getcWrittenTime() {
		return cWrittenTime;
	}
	public void setcWrittenTime(String cWrittenTime) {
		this.cWrittenTime = cWrittenTime;
	}
	public String getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(String noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getCommenter() {
		return commenter;
	}
	public void setCommenter(String commenter) {
		this.commenter = commenter;
	}
	
}
