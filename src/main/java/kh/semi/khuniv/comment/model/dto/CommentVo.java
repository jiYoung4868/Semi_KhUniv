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

	public CommentVo() {
		super();
	}

	// 공지사항 댓글 작성
	public CommentVo(String commenter, String commentContent) {
		super();
		this.commenter = commenter;
		this.commentContent = commentContent;
	}

	// 공지사항 댓글 리스트
	public CommentVo(String cWrittenTime, String commenter, String commentContent) {
		super();
		this.cWrittenTime = cWrittenTime;
		this.commenter = commenter;
		this.commentContent = commentContent;
	}

	public CommentVo(String commentNo, String cWrittenTime, String noticeNo, String commenter, String commentContent) {
		super();
		this.commentNo = commentNo;
		this.cWrittenTime = cWrittenTime;
		this.noticeNo = noticeNo;
		this.commenter = commenter;
		this.commentContent = commentContent;
	}

	@Override
	public String toString() {
		return "CommentVo [commentNo=" + commentNo + ", cWrittenTime=" + cWrittenTime + ", noticeNo=" + noticeNo
				+ ", commenter=" + commenter + ", commentContent=" + commentContent + "]";
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
