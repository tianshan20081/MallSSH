package com.java1234.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.java1234.model.Affiche;
import com.java1234.model.BigType;
import com.java1234.model.Goods;
import com.java1234.model.Link;
import com.java1234.service.AfficheService;
import com.java1234.service.BigTypeService;
import com.java1234.service.GoodsService;
import com.java1234.service.LinkService;
import com.opensymphony.xwork2.ActionSupport;

@Component
@Scope("prototype")
public class IndexAction extends ActionSupport implements SessionAware,RequestAware  {

	private Map<String, Object> session;
	private Map<String, Object> request;
	private List<Affiche> allAffiche = new ArrayList<Affiche>();
	private AfficheService afficheService;
	private List<Goods> allGoods = new ArrayList<Goods>();
	private List<Goods> nowGoodsList = new ArrayList<Goods>();
	private List<Goods> freeGoodsList = new ArrayList<Goods>();
	private GoodsService goodsService;
	private List<Link> linkList = new ArrayList<Link>();
	private LinkService linkService;
	private List<BigType> bigTypeList = new ArrayList<BigType>(); 
	private BigTypeService bigTypeService;
	
	public AfficheService getAfficheService() {
		return afficheService;
	}
	@Resource
	public void setAfficheService(AfficheService afficheService) {
		this.afficheService = afficheService;
	}
	public GoodsService getGoodsService() {
		return goodsService;
	}
	@Resource
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	public LinkService getLinkService() {
		return linkService;
	}
	@Resource
	public void setLinkService(LinkService linkService) {
		this.linkService = linkService;
	}
	public BigTypeService getBigTypeService() {
		return bigTypeService;
	}
	@Resource
	public void setBigTypeService(BigTypeService bigTypeService) {
		this.bigTypeService = bigTypeService;
	}
	
	public String execute(){
		allAffiche = afficheService.allAffiche();
		allGoods = goodsService.selectGoodsNumber();
		nowGoodsList = goodsService.selectMarkByZero();
		freeGoodsList = goodsService.selectMarkByOne();
		linkList = linkService.selectLink();
		bigTypeList = bigTypeService.selectBigType();
		session.put("allAffiche", allAffiche);
		session.put("allGoods", allGoods);
		session.put("nowGoodsList", nowGoodsList);
		session.put("freeGoodsList", freeGoodsList);
		session.put("linkList", linkList);
		session.put("bigTypeList", bigTypeList);
		return "index";
	}
	
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
