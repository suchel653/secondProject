package com.ggiriggiri.web.entity;

import java.util.Date;

public class ProfileProjectView extends ProfileProject{
	private String title;
	private Date startDate;
	private Date endDate;
	private String status;
	
	public ProfileProjectView() {

	}
	
	public ProfileProjectView(int id, int profileId, String content, int projectId,String title,Date startDate, Date endDate, String status) {
		super(id, profileId, content, projectId);
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
