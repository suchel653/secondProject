package com.ggiriggiri.web.dao;

import java.util.List;

import com.ggiriggiri.web.entity.ProfileSkillView;

public interface ProfileSkillDao {
	
	List<ProfileSkillView> getViewListByProfileId(int profileId);
}
