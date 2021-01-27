package com.ggiriggiri.web.entity;

import java.util.Date;

public class ProjectComment {
	private int id;
	private String content;
	private Date regDate;
	private int projectId;
	private int writerId;
	
	public ProjectComment() {
		// TODO Auto-generated constructor stub
	}
	
	

	public ProjectComment(int id, String content, Date regDate, int projectId, int writerId) {
		this.id = id;
		this.content = content;
		this.regDate = regDate;
		this.projectId = projectId;
		this.writerId = writerId;
	}



	@Override
	public String toString() {
		return "ProjectComment [id=" + id + ", content=" + content + ", regDate=" + regDate + ", projectId=" + projectId
				+ ", writerId=" + writerId + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getWriterId() {
		return writerId;
	}

	public void setWriterId(int writerId) {
		this.writerId = writerId;
	}
	
	
}
