package com.ggiriggiri.web.entity;

public class ProjectBoard {
	private int id;
	private int projectId;
	private String writerId;
	private String regDate;
	private String title;
	private String content;
	
	public ProjectBoard() {
		this(0,0,null,null,null,null);
	}

	
	public ProjectBoard(int id, int projectId, String writerId, String regDate, String title, String content) {
		this.id = id;
		this.projectId = projectId;
		this.writerId = writerId;
		this.regDate = regDate;
		this.title = title;
		this.content = content;
	}
	
	


	@Override
	public String toString() {
		return "ProjectBoard [id=" + id + ", projectId=" + projectId + ", writerId=" + writerId + ", regDate=" + regDate
				+ ", title=" + title + ", content=" + content + "]";
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

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
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
	
	
}
