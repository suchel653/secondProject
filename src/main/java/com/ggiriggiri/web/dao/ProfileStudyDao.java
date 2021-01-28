package com.ggiriggiri.web.dao;

import java.util.List;

import com.ggiriggiri.web.entity.ProfileStudyView;

public interface ProfileStudyDao {

	List<ProfileStudyView> getListByProfileId(int profileId);
}
