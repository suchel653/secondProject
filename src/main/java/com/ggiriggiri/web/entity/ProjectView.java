package com.ggiriggiri.web.entity;

import java.util.Date;

public class ProjectView extends Project{
	private String leaderName;
	private String fieldName;
	private String statusName;
	private int memberCount;
	public ProjectView() {
		super();
	}

	
	public ProjectView(int id, String title, String content, int limitNumber, Date startDate, Date endDate,
			int leaderId, String requirement, Date regDate, int statusId, int fieldId, String image, String leaderName,
			String fieldName, String statusName, int memberCount) {
		super(id, title, content, limitNumber, startDate, endDate, leaderId, requirement, regDate, statusId, fieldId,
				image);
		this.leaderName = leaderName;
		this.fieldName = fieldName;
		this.statusName = statusName;
		this.memberCount = memberCount;
	}





	public String getLeaderName() {
		return leaderName;
	}

	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}


	public int getMemberCount() {
		return memberCount;
	}


	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}


	@Override
	public String toString() {
		return "ProjectView [leaderName=" + leaderName + ", fieldName=" + fieldName + ", statusName=" + statusName
				+ "]";
	}

	
}
