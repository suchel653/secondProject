package com.ggiriggiri.web.service;

import com.ggiriggiri.web.entity.Profile;

public interface ProfileService {
	int insert(Profile profile);
	int update(Profile profile);
	int delete(int id);
	
	Profile get(int id);
}
