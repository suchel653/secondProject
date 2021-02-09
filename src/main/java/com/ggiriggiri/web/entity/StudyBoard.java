package com.ggiriggiri.web.entity;

import java.util.Date;
import java.util.List;

public class StudyBoard {
	private int id;
	private int studyId;
	private int writerId;
	private String title;
	private String content;
	private Date regDate;
	
	
	public StudyBoard() {
	}

	
	public StudyBoard(int id, int studyId, int writerId, Date regDate, String title, String content) {
		this.id = id;
		this.studyId = studyId;
		this.writerId = writerId;
		this.regDate = regDate;
		this.title = title;
		this.content = content;
	}
	

	@Override
	public String toString() {
		return "StudyBoard [id=" + id + ", studyId=" + studyId + ", writerId=" + writerId + ", regDate=" + regDate
				+ ", title=" + title + ", content=" + content + "]";
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStudyId() {
		return studyId;
	}

	public void setStudyId(int studyId) {
		this.studyId = studyId;
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


	
	
	
}
