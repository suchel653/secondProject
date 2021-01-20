package com.ggiriggiri.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggiriggiri.web.dao.ContestDao;
import com.ggiriggiri.web.dao.ContestFileDao;
import com.ggiriggiri.web.dao.ContestImageDao;
import com.ggiriggiri.web.entity.Contest;

@Service
public class ContestServiceImp implements ContestService{

	@Autowired
	private ContestDao contestDao;
	@Autowired
	private ContestImageDao contestImgDao;
	@Autowired
	private ContestFileDao contestFileDao;
	
	@Override
	public int insert(Contest contest) {

		int result = contestDao.insert(contest);
		
		return result;
	}

	@Override
	public int update(Contest contest) {

		int result = contestDao.update(contest);
		
		return 0;
	}

	@Override
	public int delete(int id) {

		int result = contestDao.delete(id);
		
		return 0;
	}

	@Override
	public Contest get(int id) {

		Contest c = contestDao.get(id);
		
		return c;
	}

	@Override
	public List<Contest> getList(int page, int size, String field, String query) {
		
		int offset = size*(page-1);
		
		List<Contest> list = contestDao.getList(offset, size, field, query);
		
		for(Contest c : list) {
			c.setContestFiles(contestFileDao.getList(c.getId()));
			c.setContestImages(contestImgDao.getList(c.getId()));
		}
				
		return list;
	}

	@Override
	public int getCount(String field, String query) {

		int count = contestDao.getCount(field, query);
		
		return count;
	}

}
