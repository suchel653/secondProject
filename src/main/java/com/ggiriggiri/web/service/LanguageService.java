package com.ggiriggiri.web.service;

import java.util.List;

import com.ggiriggiri.web.entity.Language;

public interface LanguageService {

	int insert(Language language);

	int update(Language language);

	int delete(int id);

	Language get(int id);

	List<Language> getList(int page, int size);

	int deleteAll(int[] ids);

	int insertList(List<Language> list);

	int updateList(List<Language> list);

}
