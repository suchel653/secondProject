package com.ggiriggiri.web.entity;

public class ProfileSkill {
	private int id;
	private int profileId;
	private int skillId;
	private int level;
	
	public ProfileSkill() {

	}

	public ProfileSkill(int id, int profileId, int skillId, int level) {
		super();
		this.id = id;
		this.profileId = profileId;
		this.skillId = skillId;
		this.level = level;
	}

	@Override
	public String toString() {
		return "ProfileSkill [id=" + id + ", profileId=" + profileId + ", skillId=" + skillId + ", level=" + level
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	
}
