package com.ggiriggiri.web.dao;

import java.util.List;

import com.ggiriggiri.web.entity.Field;

public interface FieldDao {

	int insert(Field field);

	int update(Field field);

	int delete(int id);

	Field get(int id);
	
	List<Field> getList();

	List<Field> getList(int offset, int size);

	int deleteAll(int[] ids);

}
