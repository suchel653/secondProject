package com.ggiriggiri.web.entity;

import java.util.Date;

public class ProfileStudyView extends ProfileStudy{
	private String title;
	private Date startDate;
	private Date endDate;
	private String status;
	
	public ProfileStudyView() {

	}

	public ProfileStudyView(int id, int profileId, String content, int studyId,String title,Date startDate,Date endDate,String status) {
		super(id, profileId, content, studyId);
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}	

	@Override
	public String toString() {
		return "ProfileStudyView [title=" + title + ", startDate=" + startDate + ", endDate=" + endDate + ", status="
				+ status + "]";
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
