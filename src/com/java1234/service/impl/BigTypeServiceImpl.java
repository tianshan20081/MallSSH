package com.java1234.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.java1234.dao.BigTypeDao;
import com.java1234.model.BigType;
import com.java1234.model.PageBean;
import com.java1234.service.BigTypeService;
@Component
public class BigTypeServiceImpl implements BigTypeService {

	private BigTypeDao bigTypeDao;
	
	public BigTypeDao getBigTypeDao() {
		return bigTypeDao;
	}
	@Resource
	public void setBigTypeDao(BigTypeDao bigTypeDao) {
		this.bigTypeDao = bigTypeDao;
	}

	public List<BigType> selectBigType() {
		return bigTypeDao.selectBigType();
	}
	public List<BigType> selectBigTypeById(int id,PageBean pageBean) {
		return bigTypeDao.selectBigTypeById(id,pageBean);
	}
	public int bigTypeCount(int id) {
		return bigTypeDao.bigTypeCount(id);
	}
	public BigType selectBigTypeById(int id) {
		return bigTypeDao.selectBigTypeById(id);
	}
	public int bigTypeCount() {
		return bigTypeDao.bigTypeCount();
	}
	public List<BigType> selectBigType(PageBean pageBean) {
		return bigTypeDao.selectBigType(pageBean);
	}
	public void addBigType(BigType bt) {
		this.bigTypeDao.saveBigType(bt);
	}
	public void deleteBigType(int id) {
		this.bigTypeDao.deleteBigType(id);
	}

}
