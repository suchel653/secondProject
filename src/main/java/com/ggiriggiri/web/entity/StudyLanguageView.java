package com.ggiriggiri.web.entity;

public class StudyLanguageView {
	private int id;
	private int studyId;
	private String languageName;
	
	
	public StudyLanguageView(int id, int studyId, String languageName) {
		
		this.id = id;
		this.studyId = studyId;
		this.languageName = languageName;
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getStudyId() {
		return studyId;
	}


	public void setStudyId(int studyId) {
		this.studyId = studyId;
	}


	public String getLanguageName() {
		return languageName;
	}


	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}





	@Override
	public String toString() {
		return "StudyLanguageView [id=" + id + ", studyId=" + studyId + ", languageName=" + languageName
				+ "]";
	}
	
	
	
	

}
