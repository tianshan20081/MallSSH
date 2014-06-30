package com.java1234.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Component;

import com.java1234.model.BigType;
import com.java1234.model.Cart;
import com.java1234.model.Goods;
import com.java1234.model.Order;
import com.java1234.model.OrderDetail;
import com.java1234.model.PageBean;
import com.java1234.model.SmallType;
import com.java1234.service.BigTypeService;
import com.java1234.service.GoodsService;
import com.java1234.service.SmallTypeService;
import com.java1234.util.PropertiesUtil;
import com.opensymphony.xwork2.ActionSupport;
@Component
public class GoodsAction extends ActionSupport implements SessionAware,RequestAware{
	private Map<String, Object> session;
	private Map<String, Object> request;
	private GoodsService goodsService;
	private int no;
	private int id;
	private int bigTypeId;
	private BigTypeService bigTypeService;
	private int page;
	private PageBean pageBean;
	private int action;
	private int goodsId;
	private Cart cart;
	private int g_id;
	private GoodsService gs;
	private int mark;
	private int free;
	private String result;
	private SmallTypeService sts;
	private Goods goods;
	private int smallTypeId;
	private String num;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBigTypeId() {
		return bigTypeId;
	}
	public void setBigTypeId(int bigTypeId) {
		this.bigTypeId = bigTypeId;
	}
	public GoodsService getGoodsService() {
		return goodsService;
	}
	@Resource
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	public BigTypeService getBigTypeService() {
		return bigTypeService;
	}
	@Resource
	public void setBigTypeService(BigTypeService bigTypeService) {
		this.bigTypeService = bigTypeService;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public PageBean getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public int getG_id() {
		return g_id;
	}
	public void setG_id(int g_id) {
		this.g_id = g_id;
	}
	public GoodsService getGs() {
		return gs;
	}
	@Resource
	public void setGs(GoodsService gs) {
		this.gs = gs;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public int getFree() {
		return free;
	}
	public void setFree(int free) {
		this.free = free;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public SmallTypeService getSts() {
		return sts;
	}
	@Resource
	public void setSts(SmallTypeService sts) {
		this.sts = sts;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public int getSmallTypeId() {
		return smallTypeId;
	}
	public void setSmallTypeId(int smallTypeId) {
		this.smallTypeId = smallTypeId;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
	@Override
	public String execute() throws Exception {
		if(action==0) {
			int goodsId = (Integer) request.get("goodsId");
			List<Goods> gList = gs.selectGoodsDetail(goodsId);
			request.put("gList", gList);
			return "bg-goodsFreePirce";
		}
		if(action==1) {
			int mark = (Integer) request.get("mark");
			int free = (Integer) request.get("free");
			int goodsId = (Integer) request.get("goodsId");
			Goods goods = gs.selectGoodsDetail(goodsId).get(0);
			goods.setMark(mark);
			goods.setFreePrice(free);
			gs.updateGodos(goods);
			request.put("result", "特价设置成功");
			request.put("goodsId",goodsId);
			return "bg-goodsResult";
		}
		if(action==2) {
			List<BigType> btList = this.bigTypeService.selectBigType();
			List<SmallType> stList = this.sts.selectSmallType();
			request.put("btList", btList);
			request.put("stList", stList);
			return "bg-goodInsert";
		}
		if(action==3) {
			this.goodsService.addGoods(goods);
			request.put("result", "商品添加成功");
			return "bg-goodsResult";
		}
		if(action==4) {
			int bId = (Integer) request.get("bigTypeId");
			int count = gs.selectGoodsDetailCount(bId);
			int rows = Integer.parseInt(PropertiesUtil.getValue("pageSize"));//每一页的记录数
			int pageCount = count%rows==0?count/rows:count/rows+1;//分页总数
			int currentPage = page; //page;
			PageBean pageBean = new PageBean();
			pageBean.setPage(currentPage);//page是前台传过来的当前页数
			pageBean.setRows(rows);
			List<Goods> gList = gs.selectGoodsDetail(bigTypeId,pageBean);
			request.put("count", count);//共几条记录
			request.put("pageCount", pageCount);//共几页
			request.put("currentPage", currentPage);
			request.put("gList", gList);
			return "bg-goodSelectBig";
		}
		if(action==5) {
			int sId = (Integer) request.get("smallTypeId");
			int count = gs.selectGoodsDetailCount2(sId);
			int rows = Integer.parseInt(PropertiesUtil.getValue("pageSize"));//每一页的记录数
			int pageCount = count%rows==0?count/rows:count/rows+1;//分页总数
			int currentPage = page; //page;
			PageBean pageBean = new PageBean();
			pageBean.setPage(currentPage);//page是前台传过来的当前页数
			pageBean.setRows(rows);
			List<Goods> gList = gs.selectGoodsDetail2(smallTypeId,pageBean);
			request.put("count", count);//共几条记录
			request.put("pageCount", pageCount);//共几页
			request.put("currentPage", currentPage);
			request.put("gList", gList);
			return "bg-goodSelectSmall";
		}
		if(action==6) {
			
		}
		return null;
	}
	public String goodsDetail() throws Exception {
		int no = (Integer) request.get("no");
		request.put("no", no);
		int id = (Integer) request.get("id");
		Goods goods = goodsService.selectGoodsDetail(id).get(0);
		request.put("goods", goods);
		return "goodsDetail";
	}
	
	public String selectBigTypeById() throws Exception {
		int bigTypeId = (Integer) request.get("bigTypeId");
		request.put("bigTypeId", bigTypeId);
		int count = bigTypeService.bigTypeCount(bigTypeId);//根据ID拿到所有该类型的总数
		int rows = Integer.parseInt(PropertiesUtil.getValue("pageSize"));//每一页的记录数
		int pageCount = count%rows==0?count/rows:count/rows+1;//分页总数
		int currentPage = page;
		pageBean = new PageBean();
		pageBean.setPage(currentPage);//page是前台传过来的当前页数
		pageBean.setRows(rows);
		List<BigType> goodsBybigTypeList = bigTypeService.selectBigTypeById(bigTypeId,pageBean);
		request.put("count", count);//共几条记录
		request.put("pageCount", pageCount);//共几页
		request.put("currentPage", currentPage);
		session.put("goodsBybigTypeList", goodsBybigTypeList);
		return "selectBigType";
	}
	
	public String selectFreeGoods() throws Exception {
		int rows = Integer.parseInt(PropertiesUtil.getValue("pageSize"));
		int currentPage = page;
		pageBean = new PageBean();
		pageBean.setPage(currentPage);//page是前台传过来的当前页数
		pageBean.setRows(rows);
		List<Goods> freeGoodsList = goodsService.selectFreeGoods(pageBean);
		int count = freeGoodsList.size();
		int pageCount = count%rows==0?count/rows:count/rows+1;
		request.put("currentPage", currentPage);
		request.put("count", count);
		request.put("pageCount", pageCount);
		return "freeGoods";
	}
	
	
	public String selectNewGoods() {
		List<Goods> newGoodsList = goodsService.selectNewGoods();
		request.put("newGoodsList", newGoodsList);
		return "newGoods";
	}

	public String goodSelectOne() {
		Goods goods = goodsService.selectGoodsDetail(goodsId).get(0);
		request.put("goods", goods);
		return "fg-goodSelectOne";
	}
	
	public String cartAdd(){
		int sum;
		ArrayList goodsIdList = (ArrayList) session.get("goodsIdList");
		if(goodsIdList==null) {
			goodsIdList = new ArrayList();
			goodsIdList.add(g_id);
		}else {
			goodsIdList = (ArrayList) session.get("goodsIdList");
			goodsIdList.add(g_id);
		}
		session.put("goodsIdList", goodsIdList);
		Goods goods = goodsService.selectGoodsDetail(g_id).get(0);
		cart = new Cart();
		cart.setId(goods.getId());
		cart.setGoodsName(goods.getGoodsName());
		cart.setNumber(1);
		if(goods.getFreePrice() == 0) {
			cart.setPrice(goods.getNowPrice());
		}
		else {
			cart.setPrice(goods.getFreePrice());
		}
		if(session.get("sum")==null) {
			sum = 0;
		}else {
			sum = (Integer) session.get("sum");
		}
		sum = sum + cart.getNumber()*cart.getPrice();
		session.put("sum", sum);
		if(session.get("cartList")==null){
			List<Cart> cartList = new ArrayList<Cart>();
			cartList.add(cart);
			session.put("cartList", cartList);				
		}else{
			@SuppressWarnings("unchecked")
			List<Cart> cartList = (List<Cart>)session.get("cartList");
			cartList.add(cart);
			session.put("cartList", cartList);	
		}
		return "cartAdd";
	}
	
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
