package com.ggiriggiri.web.entity;

public class ProjectComment {
	private int id;
	private String content;
	private String regDate;
	private int projectId;
	private String writerId;
	
	public ProjectComment() {
		this(0,null,null,0,null);
	}

	public ProjectComment(int id, String content, String regDate, int projectId, String writerId) {
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

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	
	
}
