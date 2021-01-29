package com.ggiriggiri.web.entity;

import java.util.Date;

public class ProjectApplyView extends ProjectApply{
	private String memberNickname;
	private String projectTitle;
	
	public ProjectApplyView() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProjectApplyView(int id, int projectId,String projectTitle, int memberId,String memberNickname, Date regDate, String comment, int resultStatus,
			Date resultDate, int resultChecked) {
		super(id, projectId, memberId, regDate, comment, resultStatus, resultDate, resultChecked);
		this.memberNickname = memberNickname;
		this.projectTitle = projectTitle;
	}
	
	public String getMemberNickname() {
		return memberNickname;
	}
	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}
	public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	@Override
	public String toString() {
		return "ProjectApplyView [memberNickname=" + memberNickname + ", projectTitle=" + projectTitle + ", toString()="
				+ super.toString() + "]";
	}
	
	
	

}
