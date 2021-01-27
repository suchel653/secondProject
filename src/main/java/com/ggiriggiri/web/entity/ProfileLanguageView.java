package com.ggiriggiri.web.entity;

public class ProfileLanguageView extends ProfileLanguage{

	private String languageName;

	public ProfileLanguageView() {
		// TODO Auto-generated constructor stub
	}

	public ProfileLanguageView(int id, int profileId, int languagerId,String languageName) {
		super(id, profileId, languagerId);
		this.languageName = languageName;
	}

	public ProfileLanguageView(String languageName) {
		this.languageName = languageName;
	}

	@Override
	public String toString() {
		return "ProfileLanguageView [languageName=" + languageName + "]";
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	
	
}
