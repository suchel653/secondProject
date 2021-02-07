package com.ggiriggiri.web.entity;


import java.util.Date;
import java.util.List;

public class Study {
	private int id;
    private String title;
    private String content;
    private int limitNumber;
    private int leaderId;
    private Date startDate;
    private Date endDate;
    private String requirement;
    private int statusId;
    private int fieldId;
    private Date regDate;
    private String image;
    
    
   
    private List<StudyLanguageView> language;
    private List<StudySkillView> skill;
    private List<StudyFile> files;
    

    public Study() {
		// TODO Auto-generated constructor stub
	}

	public Study(int id, String title, String content, int limitNumber, int leaderId, Date startDate, Date endDate,
			String requirement, int statusId, Date regDate, String image, int filedId) {
		
		this.id = id;
		this.title = title;
		this.content = content;
		this.limitNumber = limitNumber;
		this.leaderId = leaderId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.requirement = requirement;
		this.statusId = statusId;
		this.regDate = regDate;
		this.image = image;
		
	}



	public Study(int id, String title, String content, Date startDate, Date endDate, int limitNumber,
			String image, String requirement, int fieldId,int leaderId) {
		
		this.id = id;
		this.title = title;
		this.content = content;
		this.limitNumber = limitNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.requirement = requirement;
		this.fieldId = fieldId;
		this.image = image;
		this.leaderId = leaderId;
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

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
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




	

	public List<StudyLanguageView> getLanguage() {
		return language;
	}

	public void setLanguage(List<StudyLanguageView> language) {
		this.language = language;
	}
	
	



	public int getFieldId() {
		return fieldId;
	}

	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
	}

	public List<StudySkillView> getSkill() {
		return skill;
	}

	public void setSkill(List<StudySkillView> skill) {
		this.skill = skill;
	}
	
	



	public List<StudyFile> getFiles() {
		return files;
	}

	public void setFiles(List<StudyFile> files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "Study [id=" + id + ", title=" + title + ", content=" + content + ", limitNumber=" + limitNumber
				+ ", leaderId=" + leaderId + ", startDate=" + startDate + ", endDate=" + endDate + ", requirement="
				+ requirement + ", statusId=" + statusId + ", fieldId=" + fieldId + ", regDate=" + regDate + ", image="
				+ image + ", language=" + language + ", skill=" + skill + ", files=" + files + "]";
	}


	
	

}
