package com.java1234.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.java1234.dao.LinkDao;
import com.java1234.model.Link;
import com.java1234.model.Order;
import com.java1234.model.PageBean;
@Component
public class LinkDaoImpl implements LinkDao {

	private HibernateTemplate ht;
	public HibernateTemplate getHibernateTemplate() {
		return ht;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.ht = hibernateTemplate;
	}
	
	public List<Link> selectLink() {
		return this.ht.find("from Link");
	}
	public List<Link> selectAllLink(PageBean pageBean) {
		Session session = this.ht.getSessionFactory().getCurrentSession();
		List<Link> linkList = null; 
		Query q = session.createQuery("from Link");
		q.setFirstResult(pageBean.getStart());
		q.setMaxResults(pageBean.getRows());
		linkList = q.list();
		return linkList;
	}
	public int linkCount() {
		return this.ht.find("from Link").size();
	}
	public void deleteLink(int linkId) {
		Session session = this.ht.getSessionFactory().getCurrentSession();
		Query q = session.createQuery("delete Link l where l.id='"+linkId+"'");
		q.executeUpdate();
	}
	public void saveLink(Link link) {
		this.ht.save(link);
	}

}
