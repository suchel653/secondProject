package com.ggiriggiri.web.entity;

import java.util.Date;
import java.util.List;

public class ProjectBoard {
	private int id;
	private int projectId;
	private int writerId;
	private String title;
	private String content;
	private Date regDate;
	
	private List<ProjectCommentView> comment;
	
	public ProjectBoard() {
	}

	
	public ProjectBoard(int id, int projectId, int writerId, Date regDate, String title, String content) {
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

	public int getWriterId() {
		return writerId;
	}

	public void setWriterId(int writerId) {
		this.writerId = writerId;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
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


	public List<ProjectCommentView> getComment() {
		return comment;
	}


	public void setComment(List<ProjectCommentView> comment) {
		this.comment = comment;
	}
	
	
	
}
