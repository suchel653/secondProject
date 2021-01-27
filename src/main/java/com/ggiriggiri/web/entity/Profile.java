package com.ggiriggiri.web.entity;

import java.util.Date;
import java.util.List;

public class Profile {
	private int id;
	private int memberId;
	private String title;
	private String introduction;
	private String repositoryLink;
	private String address;
	private String image;
	private Date regDate;
	private Date editDate;
	private List<ProfileSkillView> skillList;
	private List<ProfileLanguageView> languageList;
	private List<ProfileProject> projectList;
	private List<ProfileExperience> experienceList;
	
	public Profile() {
		
	}

	public Profile(int id, int memberId, String title, String introduction, String repositoryLink, String address,
			String image, Date regDate, Date editDate, List<ProfileSkillView> skillList,
			List<ProfileLanguageView> languageList, List<ProfileProject> projectList,
			List<ProfileExperience> experienceList) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.title = title;
		this.introduction = introduction;
		this.repositoryLink = repositoryLink;
		this.address = address;
		this.image = image;
		this.regDate = regDate;
		this.editDate = editDate;
		this.skillList = skillList;
		this.languageList = languageList;
		this.projectList = projectList;
		this.experienceList = experienceList;
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", memberId=" + memberId + ", title=" + title + ", introduction=" + introduction
				+ ", repositoryLink=" + repositoryLink + ", address=" + address + ", image=" + image + ", regDate="
				+ regDate + ", editDate=" + editDate + ", skillList=" + skillList + ", languageList=" + languageList
				+ ", projectList=" + projectList + ", experienceList=" + experienceList + "]";
	}

	public List<ProfileSkillView> getSkillList() {
		return skillList;
	}

	public void setSkillList(List<ProfileSkillView> skillList) {
		this.skillList = skillList;
	}

	public List<ProfileLanguageView> getLanguageList() {
		return languageList;
	}

	public void setLanguageList(List<ProfileLanguageView> languageList) {
		this.languageList = languageList;
	}

	public List<ProfileProject> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<ProfileProject> projectList) {
		this.projectList = projectList;
	}

	public List<ProfileExperience> getExperienceList() {
		return experienceList;
	}

	public void setExperienceList(List<ProfileExperience> experienceList) {
		this.experienceList = experienceList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getRepositoryLink() {
		return repositoryLink;
	}

	public void setRepositoryLink(String repositoryLink) {
		this.repositoryLink = repositoryLink;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getEditDate() {
		return editDate;
	}

	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}
	
	
}
