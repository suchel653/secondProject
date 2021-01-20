package com.ggiriggiri.web.entity;

public class StudySkillView {
	private int id;
	private int studyId;
	private int skillName;
	
	
	
	
	public StudySkillView(int id, int studyId, int skillName) {
	
		this.id = id;
		this.studyId = studyId;
		this.skillName = skillName;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public int getStudyId() {
		return studyId;
	}




	public void setStudyId(int studyId) {
		this.studyId = studyId;
	}




	public int getSkillName() {
		return skillName;
	}




	public void setSkillName(int skillName) {
		this.skillName = skillName;
	}




	@Override
	public String toString() {
		return "StudySkillView [id=" + id + ", studyId=" + studyId + ", skillName=" + skillName + "]";
	}
	
	
	
	
	

}
