package com.ggiriggiri.web.entity;

public class ProfileLanguage {
	private int id;
	private int profileId;
	private int languagerId;
	private int level;

	public ProfileLanguage() {

	}

	public ProfileLanguage(int id, int profileId, int languagerId, int level) {
		super();
		this.id = id;
		this.profileId = profileId;
		this.languagerId = languagerId;
		this.level = level;
	}

	@Override
	public String toString() {
		return "ProfileLanguage [id=" + id + ", profileId=" + profileId + ", languagerId=" + languagerId + ", level="
				+ level + "]";
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

	public int getLanguagerId() {
		return languagerId;
	}

	public void setLanguagerId(int languagerId) {
		this.languagerId = languagerId;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	
	
}
