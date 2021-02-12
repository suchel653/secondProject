package com.ggiriggiri.web.entity;

public class ProfileLanguageView extends ProfileLanguage{

	private String languageName;
	private String image;

	public ProfileLanguageView() {
		// TODO Auto-generated constructor stub
	}

	public ProfileLanguageView(int id, int profileId, int languagerId, int level, String languageName, String image) {
		super(id, profileId, languagerId, level);
		this.languageName = languageName;
		this.image = image;
	}

	public ProfileLanguageView(String languageName, String image) {
		this.languageName = languageName;
		this.image = image;
	}

	@Override
	public String toString() {
		return "ProfileLanguageView [languageName=" + languageName + ", image=" + image + "]";
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
}
