package com.ggiriggiri.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggiriggiri.web.dao.FieldDao;
import com.ggiriggiri.web.entity.Field;
import com.ggiriggiri.web.entity.Project;

@Service
public class FieldServiceImp implements FieldService{
	
	@Autowired
	private FieldDao fieldDao;

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
