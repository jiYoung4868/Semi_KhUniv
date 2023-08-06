package kh.semi.khuniv.common.model.dto;

public class ProfessorVo {
//	PROFESSOR_NO    NOT NULL VARCHAR2(20) 
//	PROFESSOR_NAME  NOT NULL VARCHAR2(40) 
//	PROFESSOR_PHONE          VARCHAR2(20) 
//	PROFESSOR_LEVEL NOT NULL VARCHAR2(20) 
//	DEPARTMENT_NO   NOT NULL VARCHAR2(10) 
//	PROFESSOR_PWD   NOT NULL VARCHAR2(50) 
	
	private String professorNo;
	private String professorName;
	private String professorPhone;
	private String professorLevel; //tb professor_level
	private String departmentNo; //tb department
	private String professorPwd;
	
	//login 용 생성자	
	public ProfessorVo(String professorNo, String professorPwd) {
		super();
		this.professorNo = professorNo;
		this.professorPwd = professorPwd;
	}

	@Override
	public String toString() {
		return "ProfessorVo [professorNo=" + professorNo + ", professorName=" + professorName + ", professorPhone="
				+ professorPhone + ", professorLevel=" + professorLevel + ", departmentNo=" + departmentNo
				+ ", professorPwd=" + professorPwd + "]";
	}

	public String getProfessorNo() {
		return professorNo;
	}

	public void setProfessorNo(String professorNo) {
		this.professorNo = professorNo;
	}

	public String getProfessorName() {
		return professorName;
	}

	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}

	public String getProfessorPhone() {
		return professorPhone;
	}

	public void setProfessorPhone(String professorPhone) {
		this.professorPhone = professorPhone;
	}

	public String getProfessorLevel() {
		return professorLevel;
	}

	public void setProfessorLevel(String professorLevel) {
		this.professorLevel = professorLevel;
	}

	public String getDepartmentNo() {
		return departmentNo;
	}

	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}

	public String getProfessorPwd() {
		return professorPwd;
	}

	public void setProfessorPwd(String professorPwd) {
		this.professorPwd = professorPwd;
	} 
	
	
	
}
