package com.java1234.dao;

import java.util.List;

import com.java1234.model.BigType;
import com.java1234.model.PageBean;
import com.java1234.model.SmallType;

public interface SmallTypeDao {

	public List<SmallType> selectSmallType();
	public int smallTypeCount();
	public void saveSmallType(SmallType bt);
	public void deleteSmallType(int id);
	public List<SmallType> selectSmallType(PageBean pageBean);
}
