package com.ggiriggiri.web.dao;

import java.util.List;

import com.ggiriggiri.web.entity.Field;
import com.ggiriggiri.web.entity.Project;

public interface FieldDao {
	
	int insert(Field field);
	int update(Field field);
	int delete(int id);
	
	Project get(int id);
	
	List<Field> getList(int page, int size, String field, String query);
	
	int getCount(String field, String query);

}
