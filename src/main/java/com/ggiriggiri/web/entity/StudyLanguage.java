package com.ggiriggiri.web.entity;

public class StudyLanguage {
	private int id;
	private int studyId;
	private int languageId;
	
	public StudyLanguage(int id, int studyId, int languageId) {
	
		this.id = id;
		this.studyId = studyId;
		this.languageId = languageId;
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

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	@Override
	public String toString() {
		return "StudyLanguage [id=" + id + ", studyId=" + studyId + ", languageId=" + languageId + "]";
	}
	
	
	

}
