package com.ggiriggiri.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ggiriggiri.web.dao.LanguageDao;
import com.ggiriggiri.web.entity.Language;

@Repository
public class MybatisLanguageDao implements LanguageDao {

	private LanguageDao mapper;

	public MybatisLanguageDao(SqlSession session) {
		mapper = session.getMapper(LanguageDao.class);
	}

	@Override
	public int insert(Language language) {
		return mapper.insert(language);
	}

	@Override
	public int update(Language language) {
		return mapper.update(language);
	}

	@Override
	public int delete(int id) {
		return mapper.delete(id);
	}

	@Override
	public Language get(int id) {
		return mapper.get(id);
	}

	@Override
	public List<Language> getList(int offset, int size) {
		return mapper.getList(offset, size);
	}

}
