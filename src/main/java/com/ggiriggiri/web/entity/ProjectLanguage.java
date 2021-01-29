package com.ggiriggiri.web.entity;

public class ProjectLanguage {

	private int id;
	private int projectId;
	private int languageId;
	
	public ProjectLanguage() {
		this(0,0,0);
	}

	public ProjectLanguage(int id, int projectId, int languageId) {
		this.id = id;
		this.projectId = projectId;
		this.languageId = languageId;
	}

	public ProjectLanguage(int projectId, int languageId) {
		this.projectId = projectId;
		this.languageId = languageId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	@Override
	public String toString() {
		return "ProjectLanguage [id=" + id + ", projectId=" + projectId + ", languageId=" + languageId + "]";
	}
	
}