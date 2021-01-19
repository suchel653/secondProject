package com.ggiriggiri.web.entity;

import java.sql.Date;
import java.util.List;

public class Study {
	private int id;
    private String title;
    private String content;
    private int limitNumber;
    private int leaderId;
    private Date starDate;
    private Date endDate;
    private String requirement;
    private int status;
    private Date regDate;
    private String image;
    private int filedId;
    
    private List<Language> language;
    

    public Study() {
		// TODO Auto-generated constructor stub
	}

	public Study(int id, String title, String content, int limitNumber, int leaderId, Date starDate, Date endDate,
			String requirement, int status, Date regDate, String image, int filedId) {
		
		this.id = id;
		this.title = title;
		this.content = content;
		this.limitNumber = limitNumber;
		this.leaderId = leaderId;
		this.starDate = starDate;
		this.endDate = endDate;
		this.requirement = requirement;
		this.status = status;
		this.regDate = regDate;
		this.image = image;
		this.filedId = filedId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getLimitNumber() {
		return limitNumber;
	}

	public void setLimitNumber(int limitNumber) {
		this.limitNumber = limitNumber;
	}

	public int getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(int leaderId) {
		this.leaderId = leaderId;
	}

	public Date getStarDate() {
		return starDate;
	}

	public void setStarDate(Date starDate) {
		this.starDate = starDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getFiledId() {
		return filedId;
	}

	public void setFiledId(int filedId) {
		this.filedId = filedId;
	}
	
	

	public List<Language> getLanguage() {
		return language;
	}

	public void setLanguage(List<Language> language) {
		this.language = language;
	}
	

	@Override
	public String toString() {
		return "Study [id=" + id + ", title=" + title + ", content=" + content + ", limitNumber=" + limitNumber
				+ ", leaderId=" + leaderId + ", starDate=" + starDate + ", endDate=" + endDate + ", requirement="
				+ requirement + ", status=" + status + ", regDate=" + regDate + ", image=" + image + ", filedId="
				+ filedId + "]";
	}
	

}
