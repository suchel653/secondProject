package com.ggiriggiri.web.entity;

import java.util.Date;

public class ProjectBoardView extends ProjectBoard {

	private String writerNickname;
	private int cmtCnt;
	public ProjectBoardView() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProjectBoardView(int id, int projectId, int writerId,String writerNickname, Date regDate, String title, String content, int cmtCnt) {
		super(id, projectId, writerId, regDate, title, content);
		this.writerNickname = writerNickname;
		this.cmtCnt = cmtCnt;
	}
	public String getWriterNickname() {
		return writerNickname;
	}
	public void setWriterNickname(String writerNickname) {
		this.writerNickname = writerNickname;
	}
	public int getCmtCnt() {
		return cmtCnt;
	}
	public void setCmtCnt(int cmtCnt) {
		this.cmtCnt = cmtCnt;
	}
	@Override
	public String toString() {
		return "ProjectBoardView [writerNickname=" + writerNickname + ", cmtCnt=" + cmtCnt + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
}
