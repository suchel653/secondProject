package com.ggiriggiri.web.dao.mybatis;

import java.util.List;

import com.ggiriggiri.web.dao.FieldDao;
import com.ggiriggiri.web.entity.Field;
import com.ggiriggiri.web.entity.Project;

public class MybatisFieldDao implements FieldDao{

	@Override
	public int insert(Field field) {
		return 0;
	}

	@Override
	public int update(Field field) {
		return 0;
	}

	@Override
	public int delete(int id) {
		return 0;
	}

	@Override
	public Project get(int id) {
		return null;
	}

	@Override
	public List<Field> getList(int page, int size, String field, String query) {
		return null;
	}

	@Override
	public int getCount(String field, String query) {
		return 0;
	}

}
