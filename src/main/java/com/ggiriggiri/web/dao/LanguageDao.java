package com.ggiriggiri.web.dao;

import java.util.List;

import com.ggiriggiri.web.entity.Language;

public interface LanguageDao {

	int insert(Language language);

	int update(Language language);

	int delete(int id);

	Language get(int id);

	List<Language> getList(int offset, int size);

	int deleteAll(int[] ids);

}
