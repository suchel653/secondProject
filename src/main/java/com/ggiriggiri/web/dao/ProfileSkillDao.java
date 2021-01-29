package com.ggiriggiri.web.dao;

import java.util.List;

import com.ggiriggiri.web.entity.ProfileSkillView;
import com.ggiriggiri.web.entity.ProjectSkill;

public interface ProfileSkillDao {
	
	
	List<ProfileSkillView> getViewListByProfileId(int profileId);
}
