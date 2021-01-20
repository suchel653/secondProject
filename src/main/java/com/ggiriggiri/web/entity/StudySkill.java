package com.ggiriggiri.web.entity;

public class StudySkill {
	private int id;
	private int studyId;
	private int skillId;
	public StudySkill(int id, int studyId, int skillId) {
		
		this.id = id;
		this.studyId = studyId;
		this.skillId = skillId;
	}
	@Override
	public String toString() {
		return "StudySkill [id=" + id + ", studyId=" + studyId + ", skillId=" + skillId + "]";
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
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	
	
	
	

}
