package com.java1234.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.java1234.dao.OrderDao;
import com.java1234.model.Goods;
import com.java1234.model.Order;
import com.java1234.model.OrderDetail;
import com.java1234.model.PageBean;
@Component
public class OrderDaoImpl implements OrderDao {

	private HibernateTemplate ht;
	public HibernateTemplate getHibernateTemplate() {
		return ht;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.ht = hibernateTemplate;
	}
	@SuppressWarnings("unchecked")
	public List<Order> selectOrder(String name) {
		return this.ht.find("from Order o where o.name='"+name+"'");
	}
	public List<OrderDetail> checkOrderDetail(String num) {
		Session s = this.ht.getSessionFactory().getCurrentSession();
		List<OrderDetail> orderDetailList = s.createQuery("from OrderDetail od where od.orderNumber='"+num+"'").list();
		return orderDetailList;
	}
	public void insertOrder(Order order) {
		this.ht.save(order);
	}
	public int selectAllOrder() {
		return this.ht.find("from Order").size();
	}
	@SuppressWarnings("unchecked")
	public List<Order> orderPage(PageBean pageBean) {
		Session session = this.ht.getSessionFactory().getCurrentSession();
		List<Order> orderList = null; 
		Query q = session.createQuery("from Order");
		q.setFirstResult(pageBean.getStart());
		q.setMaxResults(pageBean.getRows());
		orderList = q.list();
		return orderList;
	}
	public void updateOrder(String orderNum,int sign) {
		Session session = this.ht.getSessionFactory().getCurrentSession();
		Query q = session.createQuery("update Order o set sign='"+sign+"' where o.num='"+orderNum+"'");
		q.executeUpdate();
	}
	public void deleteOrder(String orderNum) {
		Session session = this.ht.getSessionFactory().getCurrentSession();
		Query q = session.createQuery("delete Order o where o.num='"+orderNum+"'");
		q.executeUpdate();
	}
	public Order checkOrder(String num) {
		Session s = this.ht.getSessionFactory().getCurrentSession();
		List<Order> orderList = s.createQuery("from Order o where o.num='"+num+"'").list();
		Order order = orderList.get(0);
		return order;
	}
	
	public List<OrderDetail> checkOrderDetailList(String num) {
		return this.ht.find("from OrderDetail od where od.orderNumber='"+num+"'");
	}
	public void insertOrderDetail(OrderDetail od) {
		this.ht.save(od);
	}

}
