package com.java1234.service;

import java.util.List;

import com.java1234.model.PageBean;
import com.java1234.model.SmallType;

public interface SmallTypeService {
	public List<SmallType> selectSmallType();
	public int smallTypeCount();
	public void addSmallType(SmallType bt);
	public void deleteSmallType(int id);
	public List<SmallType> selectSmallType(PageBean pageBean);
}
