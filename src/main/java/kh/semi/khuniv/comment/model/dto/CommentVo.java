package kh.semi.khuniv.comment.model.dto;

public class CommentVo {
//			COMMENT_NO      NOT NULL NUMBER         
//			CWRITTEN_TIME   NOT NULL TIMESTAMP(6)   
//			NOTICE_NO       NOT NULL NUMBER         
//			COMMENTER       NOT NULL VARCHAR2(300)  
//			COMMENT_CONTENT NOT NULL VARCHAR2(1000) 

	private String commentNo;
	private String cWrittenTime;
	private String noticeNo; // tb notice
	private String commenter;
	private String commentContent;


	// 공지사항 댓글 리스트
	public CommentVo(String commenter, String commentContent, String cWrittenTime) {
		super();
		this.commenter = commenter;
		this.commentContent = commentContent;
		this.cWrittenTime = cWrittenTime;
	}

	@Override
	public String toString() {
		return "CommentVo [commentNo=" + commentNo + ", commenter=" + commenter + ", noticeNo=" + noticeNo + ", commentContent="
				+ commentContent + ", cWrittenTime=" +cWrittenTime + "]";
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

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
}
