package com.ggiriggiri.web.dao;

import java.util.List;

import com.ggiriggiri.web.entity.ProfileSkill;
import com.ggiriggiri.web.entity.ProfileSkillView;

public interface ProfileSkillDao {
	int insert(int profileId, int skillId);
	int update(int profileId, int skillId, int level);
	List<ProfileSkill> getByProfileId(int profileId);
	List<ProfileSkillView> getViewListByProfileId(int profileId);
	
}
