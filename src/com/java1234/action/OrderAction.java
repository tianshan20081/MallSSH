package com.java1234.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Component;

import com.java1234.model.Cart;
import com.java1234.model.Goods;
import com.java1234.model.Member;
import com.java1234.model.Order;
import com.java1234.model.OrderDetail;
import com.java1234.service.OrderService;
import com.opensymphony.xwork2.ActionSupport;

@Component
public class OrderAction extends ActionSupport implements SessionAware,RequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	private Map<String, Object> request;
	private OrderService os;
	private int action;
	private Order order;
	private String orderNumber;
	private int page;
	private String orderNum;
	
	
	public OrderService getOs() {
		return os;
	}
	@Resource
	public void setOs(OrderService os) {
		this.os = os;
	}
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	
	
	@Override
	public String execute() throws Exception {
		if(action==1) {
			if(session.get("currentMember")==null){
				request.put("error", "请先登入!");
				return "index";
			}
			Member m = (Member) session.get("currentMember");
			List<Order> orderList = os.selectOrder(m.getName());
			request.put("orderList", orderList);
			return "orderDetail";
		}
		if(action==2) {
			int sum=0;
			Member m = (Member) session.get("currentMember");
			List<Order> orderList = os.selectOrder(m.getName());
			List<OrderDetail> odList = os.checkOrderDetail(orderNumber);
			for(int i=0;i<odList.size();i++) {
				sum = sum + odList.get(i).getPrice();
			}
			request.put("sum", sum);
			request.put("orderList", orderList);
			request.put("odList", odList);
			return "orderDetail2";
		}
		if(action==3) {
			Order o = new Order();
			o.setNum(order.getNum());
			o.setName(order.getName());
			o.setReallyName(order.getReallyName());
			o.setAddress(order.getAddress());
			o.setCreateTime(new Date());
			o.setTel(order.getTel());
			o.setSetMoney(order.getSetMoney());
			o.setPost(order.getPost());
			o.setBz(order.getBz());
			o.setSign(0);
			os.addOrder(o);
			@SuppressWarnings("unchecked")
			List<Cart> cartList = (List<Cart>) session.get("cartList");
			int j = 0,i;
			int goodsId = 0;
			for(i=0;i<cartList.size();i++) {
				OrderDetail od = new OrderDetail();
				Cart cart = cartList.get(i);
				od.setOrderNumber(order.getNum());
				od.setPrice(cart.getPrice());
				od.setNum(1);
				ArrayList goodsIdList = (ArrayList) session.get("goodsIdList");
				if(goodsIdList!=null) {
					goodsId = (java.lang.Integer) goodsIdList.get(j++);
				}
				Goods goods=new Goods();
				goods.setId(goodsId);
				od.setGoods(goods);
				os.addOrderDetail(od);
			}
			return "checkOutOrder";
		}
		if(action==4) {
			String num = (String) request.get("orderNum");
			Order order = os.checkOrder(num);
			List<OrderDetail> orderDetailList = os.checkOrderDetailList(num);
			request.put("order", order);
			request.put("orderDetailList", orderDetailList);
			return "bg-orderContent";
		}
		if(action==5) {
			if(session.get("currentMember")==null){
				request.put("error", "请先登入!");
				return "index";
			}
			return "cart_see";
		}
		return null;
	}
	
	
	private int Integer(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
