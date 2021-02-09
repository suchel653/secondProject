package com.ggiriggiri.web.entity;

import java.util.Date;

public class StudyCommentView extends StudyComment{

	private String writerNickname;
	public StudyCommentView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudyCommentView(int id, String content, Date regDate, int boardId, int writerId, String writerNickname) {
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
		return "StudyCommentView [writerNickname=" + writerNickname + ", toString()=" + super.toString() + "]";
	}


	
	

}
