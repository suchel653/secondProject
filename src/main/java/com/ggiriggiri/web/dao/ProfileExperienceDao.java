package com.ggiriggiri.web.dao;

import java.util.List;

import com.ggiriggiri.web.entity.ProfileExperience;

public interface ProfileExperienceDao {

	List<ProfileExperience> getListByProfileId(int profileId);

	void insert(int id);
}
