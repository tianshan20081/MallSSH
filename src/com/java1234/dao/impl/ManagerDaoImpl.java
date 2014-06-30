package com.java1234.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.java1234.dao.ManagerDao;
import com.java1234.model.Manager;
@Component
public class ManagerDaoImpl implements ManagerDao {

	private HibernateTemplate ht;
	public HibernateTemplate getHibernateTemplate() {
		return ht;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.ht = hibernateTemplate;
	}
	
	public Manager bgLogin(Manager man) {
		Manager manager = null;
		Session s = this.ht.getSessionFactory().getCurrentSession();
		Query q = s.createQuery("from Manager m where m.acount='"+man.getAcount()+"' and m.password='"+man.getPassword()+"'");
		List<Manager> managerList = q.list();
		if(managerList.size()>0) {
			manager = managerList.get(0);
		}
		return manager;
	}
	public void updateManager(Manager m) {
		Session session = this.ht.getSessionFactory().getCurrentSession();
		Query q = session.createQuery("update Manager m set password='"+m.getPassword()+"' where m.acount='"+m.getAcount()+"'");
		q.executeUpdate();	
	}

}
