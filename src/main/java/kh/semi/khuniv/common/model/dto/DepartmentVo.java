package kh.semi.khuniv.common.model.dto;

public class DepartmentVo {
//	DEPARTMENT_NO   NOT NULL VARCHAR2(10)  
//	DEPARTMENT_NAME NOT NULL VARCHAR2(255) 
//	CAPACITY                 VARCHAR2(255) 
	
	private String departmentNo;
	private String departmentName;
	private String capacity;
	
	@Override
	public String toString() {
		return "DepartmentVo [departmentNo=" + departmentNo + ", departmentName=" + departmentName + ", capacity="
				+ capacity + "]";
	}

	public String getDepartmentNo() {
		return departmentNo;
	}

	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	
}
