package com.ggiriggiri.web.entity;

public class ProjectLanguageView {
	private int id;
	private int projectId;
	private String languageName;
	
	
	public ProjectLanguageView(int id, int projectId, String languageName) {
		
		this.id = id;
		this.projectId = projectId;
		this.languageName = languageName;
		
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





	@Override
	public String toString() {
		return "StudyLanguageView [id=" + id + ", projectId=" + projectId + ", languageName=" + languageName
				+ "]";
	}
	
	
	
	

}
