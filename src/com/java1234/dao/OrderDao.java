package com.java1234.dao;

import java.util.List;

import com.java1234.model.Order;
import com.java1234.model.OrderDetail;
import com.java1234.model.PageBean;

public interface OrderDao {

	public int selectAllOrder();
	public List<Order> orderPage(PageBean pageBean);
	public List<Order> selectOrder(String name);
	public List<OrderDetail> checkOrderDetail(String num);
	public List<OrderDetail> checkOrderDetailList(String num);
	public Order checkOrder(String num);
	public void insertOrder(Order order);
	public void updateOrder(String orderNum,int sign);
	public void deleteOrder(String orderNum);
	public void insertOrderDetail(OrderDetail od);
}
