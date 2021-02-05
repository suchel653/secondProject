package com.ggiriggiri.web.dao;

import com.ggiriggiri.web.entity.Profile;

public interface ProfileDao {
	int insert(Profile profile);
	int update(Profile profile);
	int delete(int id);
	
	Profile get(int id);
}
