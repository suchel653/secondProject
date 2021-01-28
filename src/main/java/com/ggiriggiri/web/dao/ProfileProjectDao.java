package com.ggiriggiri.web.dao;

import java.util.List;

import com.ggiriggiri.web.entity.ProfileProjectView;

public interface ProfileProjectDao {

	List<ProfileProjectView> getListByProfileId(int profileId);
}
