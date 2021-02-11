package com.ggiriggiri.web.entity;

public class ProfileSkillView extends ProfileSkill{

	private String skillName;
	
	public ProfileSkillView() {
		// TODO Auto-generated constructor stub
	}

	public ProfileSkillView(int id, int profileId, int skillId, int level, String skillName) {
		super(id, profileId, skillId, level);
		this.skillName = skillName;
	}

	public ProfileSkillView(String skillName) {
		this.skillName = skillName;
	}

	@Override
	public String toString() {
		return "ProfileSkillView [skillName=" + skillName + "]";
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	
	
}
