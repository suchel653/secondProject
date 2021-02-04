package com.ggiriggiri.web.entity;

import java.util.Date;

public class ProjectCommentView extends ProjectComment{

	private String writerNickname;
	public ProjectCommentView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProjectCommentView(int id, String content, Date regDate, int boardId, int writerId, String writerNickname) {
		super(id, content, regDate, boardId, writerId);
		this.writerNickname = writerNickname;
	}

	public String getWriterNickname() {
		return writerNickname;
	}

	public void setWriterNickname(String writerNickname) {
		this.writerNickname = writerNickname;
	}

	@Override
	public String toString() {
		return "ProjectCommentView [writerNickname=" + writerNickname + ", toString()=" + super.toString() + "]";
	}


	
	

}
