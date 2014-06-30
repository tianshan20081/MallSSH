package com.java1234.dao;

import java.util.List;

import com.java1234.model.BigType;
import com.java1234.model.PageBean;

public interface BigTypeDao {

	public List<BigType> selectBigType();
	public List<BigType> selectBigTypeById(int id,PageBean pageBean);
	public int bigTypeCount(int id);
	public BigType selectBigTypeById(int id);
	public int bigTypeCount();
	public List<BigType> selectBigType(PageBean pageBean);
	public void saveBigType(BigType bt);
	public void deleteBigType(int id);
}
