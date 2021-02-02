package com.ggiriggiri.web.entity;

public class StudyLanguageView extends StudyLanguage{
	private String languageName;
	private String image;
	public StudyLanguageView(int id, int studyId, String languageName ,String image) {
		super(id,studyId,0);
		this.languageName=languageName;
		this.image=image;
	}
	public int getId() {
		return super.getId();
	}
	public void setId(int id) {
		super.setId(id);
	}
	public int getStudyId() {
		return super.getStudyId();
	}
	public void setStudyId(int studyId) {
		super.setStudyId(studyId);
	}
	public String getLanguageName() {
		return languageName;
	}
	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return super.toString()+" languageName=" + languageName + "]";
	}
}
