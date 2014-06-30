package com.java1234.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Component;

import com.java1234.model.BigType;
import com.java1234.model.PageBean;
import com.java1234.model.SmallType;
import com.java1234.service.BigTypeService;
import com.java1234.service.SmallTypeService;
import com.java1234.util.PropertiesUtil;
import com.opensymphony.xwork2.ActionSupport;

@Component
public class SmallTypeAction extends ActionSupport implements SessionAware,RequestAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	private Map<String, Object> request;
	private int action;
	private int page;
	private String result;
	private SmallTypeService sts;
	private BigTypeService bts;
	private SmallType smallType;
	private String smallTypeId;
	
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
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
	public BigTypeService getBts() {
		return bts;
	}
	@Resource
	public void setBts(BigTypeService bts) {
		this.bts = bts;
	}
	public SmallType getSmallType() {
		return smallType;
	}
	public void setSmallType(SmallType smallType) {
		this.smallType = smallType;
	}
	public String getSmallTypeId() {
		return smallTypeId;
	}
	public void setSmallTypeId(String smallTypeId) {
		this.smallTypeId = smallTypeId;
	}
	
	@Override
	public String execute() throws Exception {
		if(action==0) {
			if(smallTypeId!=null) {
				sts.deleteSmallType(Integer.parseInt(smallTypeId));
				request.put("result", "删除成功");
				return "bg-smallTypeResult";
			}
			int count = sts.smallTypeCount();
			int rows = Integer.parseInt(PropertiesUtil.getValue("pageSize"));//每一页的记录数
			int pageCount = count%rows==0?count/rows:count/rows+1;//分页总数
			int currentPage = page; //page;
			PageBean pageBean = new PageBean();
			pageBean.setPage(currentPage);//page是前台传过来的当前页数
			pageBean.setRows(rows);
			List<SmallType> stList = sts.selectSmallType(pageBean);
			request.put("count", count);//共几条记录
			request.put("pageCount", pageCount);//共几页
			request.put("currentPage", currentPage);
			request.put("stList", stList);
			return "bg-smallTypeSelect";
		}
		if(action==1) {
			smallType.setCreateTime(new Date());
			sts.addSmallType(smallType);
			request.put("result", "添加成功");
			return "bg-smallTypeResult";
		}
		if(action==2) {
			List<BigType> btList = bts.selectBigType();
			request.put("btList", btList);
			return "bg-smallTypeInsert";
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
