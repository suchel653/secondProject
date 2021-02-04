package com.ggiriggiri.web.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ggiriggiri.web.dao.ProfileDao;
import com.ggiriggiri.web.entity.Profile;

public class ProfileServiceImp implements ProfileService{
	
	@Autowired
	private ProfileDao profileDao;
	
	@Override
	public int insert(Profile profile) {
		return profileDao.insert(profile);
	}

	@Override
	public int update(Profile profile) {
		return profileDao.update(profile);
	}

	@Override
	public int delete(int id) {
		return profileDao.delete(id);
	}

	@Override
	public Profile get(int id) {
		return null;
	}

}
