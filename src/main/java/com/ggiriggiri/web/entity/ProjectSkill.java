package com.ggiriggiri.web.entity;

public class ProjectSkill {

	private int id;
	private int projectId;
	private int skillId;
	
	public ProjectSkill() {
	}
	
	public ProjectSkill(int id, int projectId, int skillId) {
		this.id = id;
		this.projectId = projectId;
		this.skillId = skillId;
	}


	public ProjectSkill(int projectId, int skillId) {
		this.projectId = projectId;
		this.skillId = skillId;
	}

	@Override
	public String toString() {
		return "ProjectSkill [id=" + id + ", projectId=" + projectId + ", skillId=" + skillId + "]";
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

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	
	
}
