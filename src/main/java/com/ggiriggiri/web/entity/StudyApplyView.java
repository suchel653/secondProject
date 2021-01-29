package com.ggiriggiri.web.entity;

import java.util.Date;

public class StudyApplyView extends StudyApply{
	private String memberNickname;
	private String studyTitle;
	
	public StudyApplyView() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudyApplyView(int id, int StudyId,String studyTitle, int memberId,String memberNickname, Date regDate, String comment, int resultStatus,
			Date resultDate, int resultChecked) {
		super(id, StudyId, memberId, regDate, comment, resultStatus, resultDate, resultChecked);
		this.memberNickname = memberNickname;
		this.studyTitle = studyTitle;
	}

	public String getMemberNickname() {
		return memberNickname;
	}
	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}
	public String getStudyTitle() {
		return studyTitle;
	}
	public void setStudyTitle(String studyTitle) {
		this.studyTitle = studyTitle;
	}
	
	@Override
	public String toString() {
		return "StudyApplyView [memberNickname=" + memberNickname + ", studyTitle=" + studyTitle + ", toString()="
				+ super.toString() + "]";
	}
	
	

}
