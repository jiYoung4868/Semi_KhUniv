package kh.semi.khuniv.login.model.dto;

public class LoginVo {
	
	private String memberId;
	private String memberName;
	private int memberType;
	
	
	public LoginVo() {
		super();
	}
	
	public LoginVo(String memberId, String memberName, int memberType) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberType = memberType;
	}
	@Override
	public String toString() {
		return "LoginVo [memberId=" + memberId + ", memberName=" + memberName + ", memberType=" + memberType + "]";
	}
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public int getMemberType() {
		return memberType;
	}
	public void setMemberType(int memberType) {
		this.memberType = memberType;
	}
	
	
	
}
