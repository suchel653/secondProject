package com.ggiriggiri.web.entity;

import java.util.Date;

public class ProjectApply {
	private int id; 
	private int projectId;
	private int memberId; 
	private Date regDate; 
	private String comment; 
	private int resultStatus; 
	private Date resultDate;
	
	public ProjectApply() {
	}
	
	

	public ProjectApply(int id, int projectId, int memberId, Date regDate, String comment, int resultStatus,
			Date resultDate) {
		this.id = id;
		this.projectId = projectId;
		this.memberId = memberId;
		this.regDate = regDate;
		this.comment = comment;
		this.resultStatus = resultStatus;
		this.resultDate = resultDate;
	}


	@Override
	public String toString() {
		return "ProjectApply [id=" + id + ", projectId=" + projectId + ", memberId=" + memberId + ", regDate=" + regDate
				+ ", comment=" + comment + ", resultStatus=" + resultStatus + ", resultDate=" + resultDate + "]";
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(int resultStatus) {
		this.resultStatus = resultStatus;
	}

	public Date getResultDate() {
		return resultDate;
	}

	public void setResultDate(Date resultDate) {
		this.resultDate = resultDate;
	}

	
}
