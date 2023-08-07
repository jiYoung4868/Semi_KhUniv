package kh.semi.khuniv.student.model.dto;

public class StudentVo {
//	STUDENT_NO      NOT NULL VARCHAR2(20)  
//	STUDENT_NAME    NOT NULL VARCHAR2(40)  
//	STUDENT_PHONE   NOT NULL VARCHAR2(20)  
//	STUDENT_ADDRESS          VARCHAR2(200) 
//	DEPARTMENT_NO   NOT NULL VARCHAR2(10)  
//	STUDENT_PWD     NOT NULL VARCHAR2(50)  
	
	private String studentNo;
	private String studentName;
	private String studentPhone;
	private String studentAddress;
	private String departmentNo; //tb department
	private String studentPwd;
	
//login 용 생성자
	public StudentVo(String studentNo, String studentPwd) {
		super();
		this.studentNo = studentNo;
		this.studentPwd = studentPwd;
	}
	
	@Override
	public String toString() {
		return "StudentVo [studentNo=" + studentNo + ", studentName=" + studentName + ", studentPhone=" + studentPhone
				+ ", studentAddress=" + studentAddress + ", departmentNo=" + departmentNo + ", studentPwd=" + studentPwd
				+ "]";
	}
	
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentPhone() {
		return studentPhone;
	}
	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	public String getDepartmentNo() {
		return departmentNo;
	}
	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}
	public String getStudentPwd() {
		return studentPwd;
	}
	public void setStudentPwd(String studentPwd) {
		this.studentPwd = studentPwd;
	}
	
	
}
