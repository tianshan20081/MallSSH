package com.java1234.service;

import java.util.List;

import com.java1234.model.BigType;
import com.java1234.model.PageBean;

public interface BigTypeService {

	public List<BigType> selectBigType();
	public List<BigType> selectBigTypeById(int id,PageBean pageBean);
	public int bigTypeCount(int id);
	public int bigTypeCount();
	public BigType selectBigTypeById(int id);
	public List<BigType> selectBigType(PageBean pageBean);
	public void addBigType(BigType bt);
	public void deleteBigType(int id);
}
