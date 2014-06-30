package com.java1234.service;

import java.util.List;

import com.java1234.model.Order;
import com.java1234.model.OrderDetail;
import com.java1234.model.PageBean;

public interface OrderService {

	public int selectAllOrder();
	public List<Order> selectOrder(String name);
	public List<OrderDetail> checkOrderDetail(String num);
	public Order checkOrder(String num);
	public void addOrder(Order order);
	public List<Order> orderPage(PageBean pageBean);
	public void updateOrder(String orderNum,int sign);
	public void deleteOrder(String orderNum);
	public List<OrderDetail> checkOrderDetailList(String num);
	public void addOrderDetail(OrderDetail od);
}
