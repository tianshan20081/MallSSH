package com.java1234.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.java1234.dao.GoodsDao;
import com.java1234.model.BigType;
import com.java1234.model.Goods;
import com.java1234.model.Order;
import com.java1234.model.PageBean;
@Component
public class GoodsDaoImpl implements GoodsDao{

	private HibernateTemplate ht;
	public HibernateTemplate getHibernateTemplate() {
		return ht;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.ht = hibernateTemplate;
	}

	@SuppressWarnings("unchecked")
	public List<Goods> selectGoodsNumber() {
		Session s = this.ht.getSessionFactory().getCurrentSession();
		Query q = s.createQuery("from Goods");
		return q.list();
	}
	public List<Goods> selectMarkByZero() {
		return this.ht.find("from Goods g where g.mark=0");
	}
	public List<Goods> selectMarkByOne() {
		return this.ht.find("from Goods g where g.mark=1");
	}
	public List<Goods> selectGoodsDetail(int id) {
		List<Goods> goodsList = this.ht.find("from Goods g where g.id='"+id+"'");
		return goodsList;
	}
	public int selectGoodsDetailCount(int id) {
		return this.ht.find("from Goods g where g.bigType.id='"+id+"'").size();
		 
	}
	public List<Goods> selectNewGoods() {
		return this.ht.find("from Goods g order by g.createTime");
	}
	public List<Goods> selectFreeGoods(PageBean pageBean) {
		Session session = this.ht.getSessionFactory().getCurrentSession();
		List<Goods> freeGoodsList = null; 
		Query q = session.createQuery("from Goods g where g.mark=1");
		q.setFirstResult(pageBean.getStart());
		q.setMaxResults(pageBean.getRows());
		freeGoodsList = q.list();
		return freeGoodsList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Goods> goodsPage(PageBean pageBean) {
		Session session = this.ht.getSessionFactory().getCurrentSession();
		List<Goods> goodsList = null; 
		Query q = session.createQuery("from Goods");
		q.setFirstResult(pageBean.getStart());
		q.setMaxResults(pageBean.getRows());
		goodsList = q.list();
		return goodsList;
	}
	public void deleteGoods(int goodsId) {
		Session session = this.ht.getSessionFactory().getCurrentSession();
		Query q = session.createQuery("delete Goods g where g.id='"+goodsId+"'");
		q.executeUpdate();
	}
	public void updateGodos(Goods g) {
		Session session = this.ht.getSessionFactory().getCurrentSession();
		Query q = session.createQuery("update Goods g set mark='"+g.getMark()+"',freePrice='"+g.getFreePrice()+"' where g.id='"+g.getId()+"'");
		q.executeUpdate();		
	}
	public void saveGoods(Goods g) {
		this.ht.save(g);
	}
	public List<Goods> selectGoodsDetail(int id, PageBean pageBean) {
		Session session = this.ht.getSessionFactory().getCurrentSession();
		List<Goods> gList = null; 
		Query q = session.createQuery("from Goods g where g.bigType.id='"+id+"'");
		q.setFirstResult(pageBean.getStart());
		q.setMaxResults(pageBean.getRows());
		gList = q.list();
		return gList;
	}

	public int selectGoodsDetailCount2(int id) {
		return this.ht.find("from Goods g where g.smallType.id='"+id+"'").size();
		 
	}
	
	public List<Goods> selectGoodsDetail2(int id, PageBean pageBean) {
		Session session = this.ht.getSessionFactory().getCurrentSession();
		List<Goods> gList = null; 
		Query q = session.createQuery("from Goods g where g.smallType.id='"+id+"'");
		q.setFirstResult(pageBean.getStart());
		q.setMaxResults(pageBean.getRows());
		gList = q.list();
		return gList;
	}
}
