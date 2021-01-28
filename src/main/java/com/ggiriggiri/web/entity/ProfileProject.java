package com.ggiriggiri.web.entity;

public class ProfileProject {
	private int id;
	private int profileId;
	private String content;
	private int projectId;
	
	public ProfileProject() {

	}

	public ProfileProject(int id, int profileId, String content, int projectId) {
		this.id = id;
		this.profileId = profileId;
		this.content = content;
		this.projectId = projectId;
	}

	@Override
	public String toString() {
		return "ProfileProject [id=" + id + ", profileId=" + profileId + ", content=" + content + ", projectId="
				+ projectId + "]";
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

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
}
