package com.ggiriggiri.web.entity;

public class ProfileProject {
	private int id;
	private int profileId;
	private String name;
	
	public ProfileProject() {

	}

	public ProfileProject(int id, int profileId, String name) {
		super();
		this.id = id;
		this.profileId = profileId;
		this.name = name;
	}

	@Override
	public String toString() {
		return "ProfileProject [id=" + id + ", profileId=" + profileId + ", name=" + name + "]";
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
