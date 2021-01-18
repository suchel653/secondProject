package com.ggiriggiri.web.entity;

public class Admin {

	private int id;
	private String nickname;
	private String password;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	
	public Admin(int id, String nickname, String password) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", nickname=" + nickname + ", password=" + password + "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
