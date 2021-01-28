package com.ggiriggiri.web.entity;

public class ProfileExperience {
	private int id;
	private int profileId;
	private String content;
	private String date;
	
	public ProfileExperience() {

	}
	
	public ProfileExperience(int id, int profileId, String content, String date) {
		this.id = id;
		this.profileId = profileId;
		this.content = content;
		this.date = date;
	}

	@Override
	public String toString() {
		return "ProfileExperience [id=" + id + ", profileId=" + profileId + ", content=" + content + ", date=" + date + "]";
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
