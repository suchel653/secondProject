package com.ggiriggiri.web.entity;

public class StudyLanguageView {
	private int id;
	private int studyId;
	private String languageName;
	private String languageImg;
	
	
	public StudyLanguageView(int id, int studyId, String languageName, String languageImg) {
		
		this.id = id;
		this.studyId = studyId;
		this.languageName = languageName;
		this.languageImg = languageImg;
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


	public String getLanguageImg() {
		return languageImg;
	}


	public void setLanguageImg(String languageImg) {
		this.languageImg = languageImg;
	}


	@Override
	public String toString() {
		return "StudyLanguageView [id=" + id + ", studyId=" + studyId + ", languageName=" + languageName
				+ ", languageImg=" + languageImg + "]";
	}
	
	
	
	

}
