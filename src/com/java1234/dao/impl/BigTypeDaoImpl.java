package com.java1234.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.java1234.dao.BigTypeDao;
import com.java1234.model.BigType;
import com.java1234.model.Link;
import com.java1234.model.PageBean;

@Component
public class BigTypeDaoImpl implements BigTypeDao {
	private HibernateTemplate ht;
	public HibernateTemplate getHibernateTemplate() {
		return ht;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.ht = hibernateTemplate;
	}
	
	public List<BigType> selectBigType() {
		return this.ht.find("from BigType");
	}
	
	@SuppressWarnings("unchecked")
	public List<BigType> selectBigTypeById(int id,PageBean pageBean) {
		Session session = this.ht.getSessionFactory().getCurrentSession();
		List<BigType> bigTypeList = null; 
		Query q = session.createQuery("from Goods g where g.bigType.id ='"+id+"'");
		q.setFirstResult(pageBean.getStart());
		q.setMaxResults(pageBean.getRows());
		bigTypeList = q.list();
		return bigTypeList;
	}
	
	public int bigTypeCount(int id) {
		return this.ht.find("from Goods g where g.bigType.id='"+id+"'").size();
	}
	public BigType selectBigTypeById(int id) {
		Session session = this.ht.getSessionFactory().getCurrentSession();
		List<BigType> bigTypeList = null; 
		bigTypeList = session.createQuery("from BigType bt where bt.id ='"+id+"'").list();
		BigType bt = bigTypeList.get(0);
		return bt;
	}
	public List<BigType> selectBigType(PageBean pageBean) {
		Session session = this.ht.getSessionFactory().getCurrentSession();
		List<BigType> btList = null; 
		Query q = session.createQuery("from BigType");
		q.setFirstResult(pageBean.getStart());
		q.setMaxResults(pageBean.getRows());
		btList = q.list();
		return btList;
	}
	public int bigTypeCount() {
		return this.ht.find("from BigType").size();
	}
	public void saveBigType(BigType bt) {
		this.ht.save(bt);
	}
	public void deleteBigType(int id) {
		Session session = this.ht.getSessionFactory().getCurrentSession();
		Query q = session.createQuery("delete BigType bt where bt.id='"+id+"'");
		q.executeUpdate();
	}
	
	public String getBigName(int bigId) {
		BigType bt = (BigType) this.ht.find("from BigType bt where bt.id='"+bigId+"'").get(0);
		return bt.getBigName();
	}
}
