package com.ggiriggiri.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggiriggiri.web.dao.FieldDao;
import com.ggiriggiri.web.entity.Field;

@Repository
public class MybatisFieldDao implements FieldDao {

	private FieldDao mapper;

	@Autowired
	public MybatisFieldDao(SqlSession session) {
		mapper = session.getMapper(FieldDao.class);
	}

	@Override
	public int insert(Field field) {
		return mapper.insert(field);
	}

	@Override
	public int update(Field field) {
		return mapper.update(field);
	}

	@Override
	public int delete(int id) {
		return mapper.delete(id);
	}

	@Override
	public Field get(int id) {
		return mapper.get(id);
	}

	@Override
	public List<Field> getList() {
		return mapper.getList();
	}

	@Override
	public List<Field> getList(int offset, int size) {
		return mapper.getList(offset, size);
	}

	@Override
	public int deleteAll(int[] ids) {
		return mapper.deleteAll(ids);
	}

	@Override
	public int getCount() {
		return mapper.getCount();
	}

}
