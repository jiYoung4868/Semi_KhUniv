package kh.semi.khuniv.professor.model.dto;

public class ProfessorLevelVo {
//	PROFESSOR_LEVEL NOT NULL VARCHAR2(20) 
	private String professorLevel;

	@Override
	public String toString() {
		return "ProfessorLevelVo [professorLevel=" + professorLevel + "]";
	}

	public String getProfessorLevel() {
		return professorLevel;
	}

	public void setProfessorLevel(String professorLevel) {
		this.professorLevel = professorLevel;
	}

}
