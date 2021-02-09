package com.ggiriggiri.web.entity;

import java.util.Date;

public class StudyComment {
	private int id;
	private String content;
	private Date regDate;
	private int boardId;
	private int writerId;
	
	public StudyComment() {
		// TODO Auto-generated constructor stub
	}
	
	

	public StudyComment(int id, String content, Date regDate, int boardId, int writerId) {
		this.id = id;
		this.content = content;
		this.regDate = regDate;
		this.boardId = boardId;
		this.writerId = writerId;
	}



	@Override
	public String toString() {
		return "StudyComment [id=" + id + ", content=" + content + ", regDate=" + regDate + ", boardId=" + boardId
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

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public int getWriterId() {
		return writerId;
	}

	public void setWriterId(int writerId) {
		this.writerId = writerId;
	}
	
	
}
