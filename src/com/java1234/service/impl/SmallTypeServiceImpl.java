package com.java1234.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.java1234.dao.SmallTypeDao;
import com.java1234.model.PageBean;
import com.java1234.model.SmallType;
import com.java1234.service.SmallTypeService;

@Component
public class SmallTypeServiceImpl implements SmallTypeService {

	private SmallTypeDao std;
	
	public SmallTypeDao getStd() {
		return std;
	}
	@Resource
	public void setStd(SmallTypeDao std) {
		this.std = std;
	}


	public List<SmallType> selectSmallType() {
		return std.selectSmallType();
	}
	public int smallTypeCount() {
		return std.smallTypeCount();
	}
	public void addSmallType(SmallType bt) {
		this.std.saveSmallType(bt);
	}
	public void deleteSmallType(int id) {
		this.std.deleteSmallType(id);
	}
	public List<SmallType> selectSmallType(PageBean pageBean) {
		return this.std.selectSmallType(pageBean);
	}

}
