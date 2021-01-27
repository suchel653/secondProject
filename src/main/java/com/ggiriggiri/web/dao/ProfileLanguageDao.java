package com.ggiriggiri.web.dao;

import java.util.List;

import com.ggiriggiri.web.entity.ProfileLanguageView;

public interface ProfileLanguageDao {

	List<ProfileLanguageView> getViewListByProfileId(int profileId);
}
