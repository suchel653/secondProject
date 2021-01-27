package com.ggiriggiri.web.dao;

import java.util.List;

import com.ggiriggiri.web.entity.ProfileProject;

public interface ProfileProjectDao {

	List<ProfileProject> getListByProfileId(int profileId);
}
