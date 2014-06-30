package com.java1234.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.java1234.dao.AfficheDao;
import com.java1234.model.Affiche;
import com.java1234.model.PageBean;
import com.java1234.service.AfficheService;

@Component
public class AfficheServiceImpl implements AfficheService{

	private AfficheDao afficheDao;

	public AfficheDao getAfficheDao() {
		return afficheDao;
	}
	@Resource
	public void setAfficheDao(AfficheDao afficheDao) {
		this.afficheDao = afficheDao;
	}
	
	public List<Affiche> allAffiche() {
		return afficheDao.allAffiche();
	}
	public Affiche selectOneAffiche(int id) {
		return afficheDao.selectOneAffiche(id);
	}
	public List<Affiche> afficheSelect(PageBean PageBean) {
		return afficheDao.afficheSelect(PageBean);
	}
	public int afficheCount() {
		return afficheDao.afficheCount();
	}
	public void addAffiche(Affiche a) {
		this.afficheDao.saveAffiche(a);
	}
	public void deleteAffiche(int id) {
		this.afficheDao.deleteAffiche(id);
	}
	public void updateAffiche(Affiche affiche) {
		this.afficheDao.updateAffiche(affiche);
	}
}
