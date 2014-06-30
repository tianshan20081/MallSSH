package com.java1234.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Component;

import com.java1234.model.Goods;
import com.java1234.model.Link;
import com.java1234.model.Manager;
import com.java1234.model.Order;
import com.java1234.model.PageBean;
import com.java1234.service.BigTypeService;
import com.java1234.service.GoodsService;
import com.java1234.service.LinkService;
import com.java1234.service.ManagerService;
import com.java1234.service.OrderService;
import com.java1234.util.PropertiesUtil;
import com.opensymphony.xwork2.ActionSupport;
@Component
public class ManagerAction extends ActionSupport implements SessionAware,RequestAware  {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	private Map<String, Object> request;
	private Manager manager;
	private int action;
	private ManagerService ms;
	private OrderService os;
	private int page;
	private int sign;
	private String orderNum;
	private GoodsService gs;
	private String goodsId;
	private BigTypeService bts;
	private String passwordNext;
	private String result;
	private LinkService ls;
	private String linkId;
	
	
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public ManagerService getMs() {
		return ms;
	}
	@Resource
	public void setMs(ManagerService ms) {
		this.ms = ms;
	}
	public OrderService getOs() {
		return os;
	}
	@Resource
	public void setOs(OrderService os) {
		this.os = os;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSign() {
		return sign;
	}
	public void setSign(int sign) {
		this.sign = sign;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public GoodsService getGs() {
		return gs;
	}
	@Resource
	public void setGs(GoodsService gs) {
		this.gs = gs;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public BigTypeService getBts() {
		return bts;
	}
	@Resource
	public void setBts(BigTypeService bts) {
		this.bts = bts;
	}
	public String getPasswordNext() {
		return passwordNext;
	}
	public void setPasswordNext(String passwordNext) {
		this.passwordNext = passwordNext;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public LinkService getLs() {
		return ls;
	}
	@Resource
	public void setLs(LinkService ls) {
		this.ls = ls;
	}
	public String getLinkId() {
		return linkId;
	}
	public void setLinkId(String linkId) {
		this.linkId = linkId;
	}
	
	@Override
	public String execute() throws Exception {
		if(action==0) {
			Manager currentManager = (Manager) session.get("currentManager");
			if(currentManager==null) {
				currentManager = ms.bgLogin(manager);
				if(currentManager==null) {
					request.put("error", "用户名或密码错误");
					return "bg-land";	
				}
				else {
					session.put("currentManager", currentManager);
					int count = os.selectAllOrder();//所有订单的数目
					int rows = Integer.parseInt(PropertiesUtil.getValue("pageSize"));//每一页的记录数
					int pageCount = count%rows==0?count/rows:count/rows+1;//分页总数
					int currentPage = page; //page;
					PageBean pageBean = new PageBean();
					pageBean.setPage(currentPage);//page是前台传过来的当前页数
					pageBean.setRows(rows);
					List<Order> orderList = os.orderPage(pageBean);
					request.put("count", count);//共几条记录
					request.put("pageCount", pageCount);//共几页
					request.put("currentPage", currentPage);
					request.put("orderList", orderList);
					return "bg-orderSelect";
				}
			}else {
				int count = os.selectAllOrder();//所有订单的数目
				int rows = Integer.parseInt(PropertiesUtil.getValue("pageSize"));//每一页的记录数
				int pageCount = count%rows==0?count/rows:count/rows+1;//分页总数
				int currentPage = page; //page;
				PageBean pageBean = new PageBean();
				pageBean.setPage(currentPage);//page是前台传过来的当前页数
				pageBean.setRows(rows);
				List<Order> orderList = os.orderPage(pageBean);
				request.put("count", count);//共几条记录
				request.put("pageCount", pageCount);//共几页
				request.put("currentPage", currentPage);
				request.put("orderList", orderList);
				return "bg-orderSelect";
			}
		}
		if(action==1) {
			String num = (String) request.get("orderNum");
			if(num!=null) {
				int s = sign;
				this.os.updateOrder(num, s);
				page = 1;
			}
			int count = os.selectAllOrder();//所有订单的数目
			int rows = Integer.parseInt(PropertiesUtil.getValue("pageSize"));//每一页的记录数
			int pageCount = count%rows==0?count/rows:count/rows+1;//分页总数
			int currentPage = page; //page;
			PageBean pageBean = new PageBean();
			pageBean.setPage(currentPage);//page是前台传过来的当前页数
			pageBean.setRows(rows);
			List<Order> orderList = os.orderPage(pageBean);
			request.put("count", count);//共几条记录
			request.put("pageCount", pageCount);//共几页
			request.put("currentPage", currentPage);
			request.put("orderList", orderList);
			return "bg-orderSelect";
		}
		if(action==2) {
			String num = (String) request.get("orderNum");
			if(num!=null) {
				this.os.deleteOrder(num);
				page = 1;
			}
			int count = os.selectAllOrder();//所有订单的数目
			int rows = Integer.parseInt(PropertiesUtil.getValue("pageSize"));//每一页的记录数
			int pageCount = count%rows==0?count/rows:count/rows+1;//分页总数
			int currentPage = page; //page;
			PageBean pageBean = new PageBean();
			pageBean.setPage(currentPage);//page是前台传过来的当前页数
			pageBean.setRows(rows);
			List<Order> orderList = os.orderPage(pageBean);
			request.put("count", count);//共几条记录
			request.put("pageCount", pageCount);//共几页
			request.put("currentPage", currentPage);
			request.put("orderList", orderList);
			return "bg-orderSelect";
		}
		if(action==3) {
			String goodsId =  (String)request.get("goodsId");
			if(goodsId!=null) {
				this.gs.deleteGoods(Integer.parseInt(goodsId));
				page = 1;
			}
			int count = os.selectAllOrder();//所有订单的数目
			int rows = Integer.parseInt(PropertiesUtil.getValue("pageSize"));//每一页的记录数
			int pageCount = count%rows==0?count/rows:count/rows+1;//分页总数
			int currentPage = page; //page;
			PageBean pageBean = new PageBean();
			pageBean.setPage(currentPage);//page是前台传过来的当前页数
			pageBean.setRows(rows);
			List<Goods> bg_goodsList = gs.goodsPage(pageBean);
			request.put("count", count);//共几条记录
			request.put("pageCount", pageCount);//共几页
			request.put("currentPage", currentPage);
			request.put("bg_goodsList", bg_goodsList);
			return "bg-goodSelect";
		}
		if(action==4) {
			String goodsId = (String)request.get("goodsId");
			List<Goods> gList = gs.selectGoodsDetail(Integer.parseInt(goodsId));
			request.put("gList", gList);
			return "bg-goodSelectContent";
		}
		if(action==5) {
			String goodsId =  (String)request.get("goodsId");
			if(goodsId!=null) {
				page = 1;
			}
			int count = os.selectAllOrder();//所有订单的数目
			int rows = Integer.parseInt(PropertiesUtil.getValue("pageSize"));//每一页的记录数
			int pageCount = count%rows==0?count/rows:count/rows+1;//分页总数
			int currentPage = page; //page;
			PageBean pageBean = new PageBean();
			pageBean.setPage(currentPage);//page是前台传过来的当前页数
			pageBean.setRows(rows);
			List<Goods> bg_goodsList = gs.goodsPage(pageBean);
			request.put("count", count);//共几条记录
			request.put("pageCount", pageCount);//共几页
			request.put("currentPage", currentPage);
			request.put("bg_goodsList", bg_goodsList);
			return "bg-goodSelect";
		}
		if(action==6) {
			String pwdNext = (String) request.get("passwordNext");
			manager.setPassword(pwdNext);
			ms.updateManager(manager);
			request.put("result", "密码修改成功");
			return "bg-goodsResult";
		}
		if(action==7) {
			String linId = (String) request.get("linkId");
			if(linId!=null) {
				page = 1;
				ls.deleteLink(Integer.parseInt(linId));
			}
			int count = ls.linkCount();//所有订单的数目
			int rows = Integer.parseInt(PropertiesUtil.getValue("pageSize"));//每一页的记录数
			int pageCount = count%rows==0?count/rows:count/rows+1;//分页总数
			int currentPage = page; //page;
			PageBean pageBean = new PageBean();
			pageBean.setPage(currentPage);//page是前台传过来的当前页数
			pageBean.setRows(rows);
			List<Link> lList = ls.selectAllLink(pageBean);
			request.put("count", count);//共几条记录
			request.put("pageCount", pageCount);//共几页
			request.put("currentPage", currentPage);
			request.put("lList", lList);
			return "bg-linkSelect";
		}
		if(action==8) {
			session.remove("currentManager");
			return "index";
		}
		return null;
	}
	
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
