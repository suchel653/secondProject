package com.ggiriggiri.web.entity;

import java.util.Date;

public class StudyView extends Study{
	private String leaderName;
	private String fieldName;
	private String statusName;
	public StudyView() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudyView(int id, String title, String content, int limitNumber, int leaderId, Date startDate, Date endDate,
			String requirement, int statusId, Date regDate, String image, int filedId, String leaderName, String fieldName, String statusName) {
		super(id, title, content, limitNumber, leaderId, startDate, endDate, requirement, statusId, regDate, image, filedId);
		this.leaderName = leaderName;
		this.fieldName = fieldName;
		this.statusName = statusName;
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
	
	
	
	
}
