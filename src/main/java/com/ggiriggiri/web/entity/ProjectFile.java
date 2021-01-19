package com.ggiriggiri.web.entity;

public class ProjectFile {
	private int id;
	private int projectId;
	private String name;
	
	public ProjectFile() {
		this(0,0,null);
	}

	public ProjectFile(int id, int projectId, String name) {
		this.id = id;
		this.projectId = projectId;
		this.name = name;
	}

	@Override
	public String toString() {
		return "ProjectFile [id=" + id + ", projectId=" + projectId + ", name=" + name + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
