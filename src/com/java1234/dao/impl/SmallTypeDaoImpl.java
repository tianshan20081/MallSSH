package com.java1234.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.java1234.dao.SmallTypeDao;
import com.java1234.model.BigType;
import com.java1234.model.PageBean;
import com.java1234.model.SmallType;

@Component
public class SmallTypeDaoImpl implements SmallTypeDao {
	private HibernateTemplate ht;
	public HibernateTemplate getHibernateTemplate() {
		return ht;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.ht = hibernateTemplate;
	}
	public List<SmallType> selectSmallType() {
		return this.ht.find("from SmallType");
	}

	public int smallTypeCount() {
		return this.ht.find("from SmallType").size();
	}
	public void saveSmallType(SmallType st) {
		this.ht.save(st);
	}
	public void deleteSmallType(int id) {
		Session session = this.ht.getSessionFactory().getCurrentSession();
		Query q = session.createQuery("delete SmallType st where st.id='"+id+"'");
		q.executeUpdate();
	}
	public List<SmallType> selectSmallType(PageBean pageBean) {
		Session session = this.ht.getSessionFactory().getCurrentSession();
		List<SmallType> stList = null; 
		Query q = session.createQuery("from SmallType");
		q.setFirstResult(pageBean.getStart());
		q.setMaxResults(pageBean.getRows());
		stList = q.list();
		return stList;
	}
	
}
