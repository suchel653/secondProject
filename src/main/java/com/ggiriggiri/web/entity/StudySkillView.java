package com.ggiriggiri.web.entity;

public class StudySkillView extends StudySkill{
	private String skillName;
	public StudySkillView(int id, int studyId, String skillName) {
		super(id,studyId,0);
		this.skillName=skillName;
	}
	public int getId() {
		return super.getId();
	}
	public void setId(int id) {
		super.setId(id);
	}
	public int getStudyId() {
		return super.getStudyId();
	}
	public void setStudyId(int studyId) {
		super.setStudyId(studyId);
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	@Override
	public String toString() {
		return super.toString()+" skillName=" + skillName + "]";
	}
}
