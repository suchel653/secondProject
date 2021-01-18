package com.ggiriggiri.web.entity;

import java.util.Date;

public class Project {
	private int id; 
	private String title; 
	private String content; 
	private int limitNumber; 
	private String leaderId; 
	private Date startDate; 
	private Date endDate;
	private String requirement; 
	private int status;
	private Date regDate; 
	private String image;
	private int fieldId;
	
	public Project() {
		this(0,null,null,0,null,null,null,null,0,null,null,0);
	}

	public Project(int id, String title, String content, int limitNumber, String leaderId, Date startDate, Date endDate,
			String requirement, int status, Date regDate, String image, int fieldId) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.limitNumber = limitNumber;
		this.leaderId = leaderId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.requirement = requirement;
		this.status = status;
		this.regDate = regDate;
		this.image = image;
		this.fieldId = fieldId;
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

	public String getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(String leaderId) {
		this.leaderId = leaderId;
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

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getFieldId() {
		return fieldId;
	}

	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", title=" + title + ", content=" + content + ", limitNumber=" + limitNumber
				+ ", leaderId=" + leaderId + ", startDate=" + startDate + ", endDate=" + endDate + ", requirement="
				+ requirement + ", status=" + status + ", regDate=" + regDate + ", image=" + image + ", fieldId="
				+ fieldId + "]";
	}
	
	
}
