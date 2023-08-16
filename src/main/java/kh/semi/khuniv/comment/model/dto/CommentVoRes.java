package kh.semi.khuniv.comment.model.dto;

public class CommentVoRes {
//	COMMENT_NO      NOT NULL NUMBER         
//	CWRITTEN_TIME   NOT NULL TIMESTAMP(6)   
//	NOTICE_NO       NOT NULL NUMBER         
//	COMMENTER       NOT NULL VARCHAR2(300)  
//	COMMENT_CONTENT NOT NULL VARCHAR2(1000)
	
	private String commenter;
	private String commentContent;
	private String noticeNo;
	
	// 공지사항 댓글 작성
	public CommentVoRes(String commenter, String commentContent, String noticeNo) {
		super();
		this.commenter = commenter;
		this.commentContent = commentContent;
		this.noticeNo = noticeNo;
	}
	@Override
	public String toString() {
		return "CommentVoRes [commenter=" + commenter + ", commentContent=" + commentContent + ", noticeNo=" + noticeNo
				+ "]";
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
	public String getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(String noticeNo) {
		this.noticeNo = noticeNo;
	}
	
	
}
