package com.ggiriggiri.web.entity;

public class ProfileStudy {
	private int id;
	private int profileId;
	private String content;
	private int studyId;
	
	public ProfileStudy() {

	}
	
	public ProfileStudy(int id, int profileId, String content, int studyId) {
		this.id = id;
		this.profileId = profileId;
		this.content = content;
		this.studyId = studyId;
	}

	@Override
	public String toString() {
		return "ProfileStudy [id=" + id + ", profileId=" + profileId + ", content=" + content + ", studyId=" + studyId
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
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public int getStudyId() {
		return studyId;
	}
	
	public void setStudyId(int studyId) {
		this.studyId = studyId;
	}
	
}
