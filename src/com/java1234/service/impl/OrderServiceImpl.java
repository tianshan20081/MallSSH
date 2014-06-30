package com.java1234.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.java1234.dao.OrderDao;
import com.java1234.model.Order;
import com.java1234.model.OrderDetail;
import com.java1234.model.PageBean;
import com.java1234.service.OrderService;
@Component
public class OrderServiceImpl implements OrderService {
	private OrderDao orderDao;

	public OrderDao getOrderDao() {
		return orderDao;
	}
	@Resource
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public List<Order> selectOrder(String name) {
		return orderDao.selectOrder(name);
	}
	public List<OrderDetail> checkOrderDetail(String num) {
		return orderDao.checkOrderDetail(num);
	}
	public void addOrder(Order order) {
		this.orderDao.insertOrder(order);
	}
	public int selectAllOrder() {
		return this.orderDao.selectAllOrder();
	}
	public List<Order> orderPage(PageBean pageBean) {
		return this.orderDao.orderPage(pageBean);
	}
	public void updateOrder(String orderNum,int sign) {
		this.orderDao.updateOrder(orderNum,sign);
	}
	public void deleteOrder(String orderNum) {
		this.orderDao.deleteOrder(orderNum);
	}
	public Order checkOrder(String num) {
		return orderDao.checkOrder(num);
	}
	public List<OrderDetail> checkOrderDetailList(String num) {
		return orderDao.checkOrderDetailList(num);
	}
	public void addOrderDetail(OrderDetail od) {
		this.orderDao.insertOrderDetail(od);
	}

}
