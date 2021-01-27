package com.ggiriggiri.web.entity;

public class ProfileSkill {
	private int id;
	private int profileId;
	private int skillId;
	
	public ProfileSkill() {

	}

	public ProfileSkill(int id, int profileId, int skillId) {
		super();
		this.id = id;
		this.profileId = profileId;
		this.skillId = skillId;
	}

	@Override
	public String toString() {
		return "ProfileSkill [id=" + id + ", profileId=" + profileId + ", skillId=" + skillId + "]";
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
	
}
