package com.ggiriggiri.web.entity;

import java.util.Date;
import java.util.List;

public class Project {
	private int id;
	private String title;
	private String content; 
	private int limitNumber;
	private Date startDate;
	private Date endDate;
	private String leaderId;
	private String requirement;
	private Date regDate;
	private int statusId;
	private int fieldId;
	private String image;
	private List<ProjectLanguageView> languages;
	private List<ProjectSkillView> skills;
	
	public Project() {
		this(0,null,null,0,null,null,null,null,null,0,0,null);
	}

	public Project(int id, String title, String content, int limitNumber, Date startDate, Date endDate, String leaderId,
			String requirement, Date regDate, int statusId, int fieldId,String image) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.limitNumber = limitNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.leaderId = leaderId;
		this.requirement = requirement;
		this.regDate = regDate;
		this.statusId = statusId;
		this.fieldId = fieldId;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getLimitNumber() {
		return limitNumber;
	}

	public void setLimitNumber(int limitNumber) {
		this.limitNumber = limitNumber;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(String leaderId) {
		this.leaderId = leaderId;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getFieldId() {
		return fieldId;
	}

	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<ProjectLanguageView> getLanguages() {
		return languages;
	}
	public void setLanguages(List<ProjectLanguageView> languages) {
		this.languages = languages;
	}

	public List<ProjectSkillView> getSkills() {
		return skills;
	}

	public void setSkills(List<ProjectSkillView> skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", title=" + title + ", content=" + content + ", limitNumber=" + limitNumber
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", leaderId=" + leaderId + ", requirement="
				+ requirement + ", regDate=" + regDate + ", statusId=" + statusId + ", fieldId=" + fieldId + ", image="
				+ image + ", languages=" + languages + ", skills=" + skills + "]";
	}
	
	
	
}
