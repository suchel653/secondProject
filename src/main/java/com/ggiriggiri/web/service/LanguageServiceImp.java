package com.ggiriggiri.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggiriggiri.web.dao.LanguageDao;
import com.ggiriggiri.web.entity.Language;

@Service
public class LanguageServiceImp implements LanguageService {

	@Autowired
	private LanguageDao languageDao;

	@Override
	public int insert(Language language) {
		return languageDao.insert(language);
	}

	@Override
	public int update(Language language) {
		return languageDao.insert(language);
	}

	@Override
	public int delete(int id) {
		return languageDao.delete(id);
	}

	@Override
	public Language get(int id) {
		return languageDao.get(id);
	}

	@Override
	public List<Language> getList(int page, int size) {
		
		int offset = (page - 1) * size;
		
		return languageDao.getList(offset, size);
	}

	@Override
	public int deleteAll(int[] ids) {
		
		int result = languageDao.deleteAll(ids);
		
		return result;
	}

	@Override
	public int insertList(List<Language> list) {
		int result = 0;
		for(Language l : list) {
			languageDao.insert(l);
			result++;
		}
		return result;
	}

	@Override
	public int updateList(List<Language> list) {
		int result = 0;
		for(Language l : list) {
			languageDao.update(l);
			result++;
		}
		return result;
	}

	@Override
	public int getCount() {
		return languageDao.getCount();
	}

	@Override
	public List<Language> getList() {
		return languageDao.getList();
	}

}
