package com.java1234.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.java1234.dao.ManagerDao;
import com.java1234.model.Manager;
import com.java1234.service.ManagerService;
@Component
public class ManagerServiceImpl implements ManagerService {

	private ManagerDao md;
	
	public ManagerDao getMd() {
		return md;
	}
	@Resource
	public void setMd(ManagerDao md) {
		this.md = md;
	}

	public Manager bgLogin(Manager m) {
		return md.bgLogin(m);
	}
	public void updateManager(Manager m) {
		this.md.updateManager(m);
	}

}
