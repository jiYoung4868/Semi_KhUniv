package kh.semi.khuniv.common.model.dto;

public class ClassVo {
//	CLASS_NO      NOT NULL VARCHAR2(10) 
//	CLASS_NAME    NOT NULL VARCHAR2(60) 
//	DEPARTMENT_NO NOT NULL VARCHAR2(10) 
	
	private String classNo;
	private String className;
	private String departmentNo; //tb department
	
	@Override
	public String toString() {
		return "ClassVo [classNo=" + classNo + ", className=" + className + ", departmentNo=" + departmentNo + "]";
	}

	public String getClassNo() {
		return classNo;
	}

	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getDepartmentNo() {
		return departmentNo;
	}

	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}
	
	
}
