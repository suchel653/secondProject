package com.ggiriggiri.web.dao;

import java.util.List;

import com.ggiriggiri.web.entity.ProfileLanguage;
import com.ggiriggiri.web.entity.ProfileLanguageView;
import com.ggiriggiri.web.entity.ProfileSkill;

public interface ProfileLanguageDao {
	int insert(int profileId, int languageId);

	List<ProfileLanguage> getByProfileId(int profileId);
	List<ProfileLanguageView> getViewListByProfileId(int profileId);
}
