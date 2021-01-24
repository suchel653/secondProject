package com.ggiriggiri.web.service;

import java.util.List;

import com.ggiriggiri.web.entity.Field;
import com.ggiriggiri.web.entity.Project;

public interface FieldService {

	int insert(Field field);

	int update(Field field);

	int delete(int id);

	Field get(int id);
	
	List<Field> getList();

	List<Field> getList(int page, int size);

	int deleteAll(int[] ids);

	int insertList(List<Field> list);

	int updateList(List<Field> list);

	int getCount();

}
