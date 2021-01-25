package com.ggiriggiri.web.entity;

public class ContestFile {
	
	private int id;
	private int contestId;
	private String name;

	public ContestFile() {

	}

	public ContestFile(int contestId, String name) {
		super();
		this.contestId = contestId;
		this.name = name;
	}

	public ContestFile(int id, int contestId, String name) {
		super();
		this.id = id;
		this.contestId = contestId;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "ContestFile [id=" + id + ", contestId=" + contestId + ", name=" + name + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getContestId() {
		return contestId;
	}

	public void setContestId(int contestId) {
		this.contestId = contestId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
