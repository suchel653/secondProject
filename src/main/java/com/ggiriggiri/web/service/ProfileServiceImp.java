package com.ggiriggiri.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggiriggiri.web.dao.ProfileDao;
import com.ggiriggiri.web.entity.Profile;

@Service
public class ProfileServiceImp implements ProfileService{
	
	@Autowired
	private ProfileDao profileDao;
	
	@Override
	public int insert(Profile profile) {
		// TODO Auto-generated method stub
		System.out.println("서비스");
		return profileDao.insert(profile);
	}

	@Override
	public int update(Profile profile) {
		// TODO Auto-generated method stub
		return profileDao.update(profile);
	}

	@Override
	public Profile get(int id) {
		// TODO Auto-generated method stub
		return profileDao.get(id);
	}

}
