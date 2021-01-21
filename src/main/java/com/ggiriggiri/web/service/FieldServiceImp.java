package com.ggiriggiri.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggiriggiri.web.dao.FieldDao;
import com.ggiriggiri.web.entity.Field;

@Service
public class FieldServiceImp implements FieldService {

	@Autowired
	private FieldDao fieldDao;

	@Override
	public int insert(Field field) {
		return fieldDao.insert(field);
	}

	@Override
	public int update(Field field) {
		return fieldDao.update(field);
	}

	@Override
	public int delete(int id) {
		return fieldDao.delete(id);
	}

	@Override
	public Field get(int id) {
		return fieldDao.get(id);
	}

	@Override
	public List<Field> getList(int page, int size) {

		int offset = (page - 1) * 10;

		return fieldDao.getList(offset, size);
	}

	@Override
	public int deleteAll(int[] ids) {

		int result = fieldDao.deleteAll(ids);

		return result;
	}

	@Override
	public int insertList(List<Field> list) {
		int result = 0;
		
		for(Field f : list) {
			fieldDao.insert(f);
			result++;
		}
		return result;
	}

	@Override
	public int updateList(List<Field> list) {
		int result = 0;
		
		for(Field f : list) {
			fieldDao.update(f);
			result++;
		}
		return result;
	}

}
