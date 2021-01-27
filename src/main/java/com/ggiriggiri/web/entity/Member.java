package com.ggiriggiri.web.entity;

import java.util.Date;

public class Member {
	private int id;
	private String email;
	private String nickname;
	private String password;
	private Date regDate;
	private Profile profile;
	
	public Member() {
	}
	
	public Member(int id, String email, String nickname, String password, Date regDate, Profile profile) {
		super();
		this.id = id;
		this.email = email;
		this.nickname = nickname;
		this.password = password;
		this.regDate = regDate;
		this.profile = profile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", email=" + email + ", nickname=" + nickname + ", password=" + password
				+ ", regDate=" + regDate + ", profile=" + profile + "]";
	}

	
	
}
