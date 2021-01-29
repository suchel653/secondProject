package com.ggiriggiri.web.entity;

public class StudyFile {
	private int id;
	private int studyId;
	private String name;
	
	public StudyFile() {
		// TODO Auto-generated constructor stub
	}

	public StudyFile(int id, int studyId, String name) {
		
		this.id = id;
		this.studyId = studyId;
		this.name = name;
	}

	public StudyFile(int studyId, String name) {
		this.studyId=studyId;
		this.name = name;
	}

	@Override
	public String toString() {
		return "StudyFile [id=" + id + ", studyId=" + studyId + ", name=" + name + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStudyId() {
		return studyId;
	}

	public void setStudyId(int studyId) {
		this.studyId = studyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
