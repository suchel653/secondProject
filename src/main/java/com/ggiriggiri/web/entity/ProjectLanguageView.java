package com.ggiriggiri.web.entity;

public class ProjectLanguageView {
	private int id;
	private int projectId;
	private int languageId;
	private String languageName;
	private String image;
	

	public ProjectLanguageView() {
	}

	public ProjectLanguageView(int id, int projectId, String languageName, String image) {
		this.id = id;
		this.projectId = projectId;
		this.languageName = languageName;
		this.image = image;
	}

	

	public ProjectLanguageView(int id, int projectId, int languageId, String languageName, String image) {
		this.id = id;
		this.projectId = projectId;
		this.languageId = languageId;
		this.languageName = languageName;
		this.image = image;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getprojectId() {
		return projectId;
	}


	public void setprojectId(int projectId) {
		this.projectId = projectId;
	}


	public String getLanguageName() {
		return languageName;
	}


	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "StudyLanguageView [id=" + id + ", projectId=" + projectId + ", languageName=" + languageName
				+ "]";
	}
	
	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}
	

}
