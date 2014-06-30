package com.java1234.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.java1234.dao.AfficheDao;
import com.java1234.model.Affiche;
import com.java1234.model.Goods;
import com.java1234.model.PageBean;

@Component
public class AfficheDaoImpl implements AfficheDao {
	private HibernateTemplate ht;
	public HibernateTemplate getHibernateTemplate() {
		return ht;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.ht = hibernateTemplate;
	}

	public List<Affiche> allAffiche() {
		return this.ht.find("from Affiche a");
	}
	public Affiche selectOneAffiche(int id) {
		Affiche affiche = null;
		List<Affiche> a = this.ht.find("from Affiche a where a.id='"+id+"'");
		if(a.size()>0) {
			affiche = a.get(0);
		}
		return affiche;
	}
	public List<Affiche> afficheSelect(PageBean pageBean) {
		Session session = this.ht.getSessionFactory().getCurrentSession();
		List<Affiche> afficheList = null; 
		Query q = session.createQuery("from Affiche");
		q.setFirstResult(pageBean.getStart());
		q.setMaxResults(pageBean.getRows());
		afficheList = q.list();
		return afficheList;
	}
	public int afficheCount() {
		return this.ht.find("from Affiche").size();
	}
	public void saveAffiche(Affiche a) {
		this.ht.save(a);
	}
	public void deleteAffiche(int id) {
		Session session = this.ht.getSessionFactory().getCurrentSession();
		Query q = session.createQuery("delete Affiche a where a.id='"+id+"'");
		q.executeUpdate();
	}
	public void updateAffiche(Affiche a) {
		Session session = this.ht.getSessionFactory().getCurrentSession();
		Query q = session.createQuery("update Affiche a set name='"+a.getName()+"',content='"+a.getContent()+"' where a.id='"+a.getId()+"'");
		q.executeUpdate();	
	}
}
