package com.java1234.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Component;

import com.java1234.model.Link;
import com.java1234.model.PageBean;
import com.java1234.service.LinkService;
import com.java1234.util.PropertiesUtil;
import com.opensymphony.xwork2.ActionSupport;

@Component
public class LinkAction extends ActionSupport implements SessionAware,RequestAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	private Map<String, Object> request;
	private int action;
	private LinkService ls;
	private Link link;
	private int page;
	
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
	public LinkService getLs() {
		return ls;
	}
	@Resource
	public void setLs(LinkService ls) {
		this.ls = ls;
	}
	public Link getLink() {
		return link;
	}
	public void setLink(Link link) {
		this.link = link;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	@Override
	public String execute() throws Exception {
		if(action==0) {
			//int p = (Integer) request.get("page");
			ls.addLink(link);
			int count = ls.linkCount();//���ж�������Ŀ
			int rows = Integer.parseInt(PropertiesUtil.getValue("pageSize"));//ÿһҳ�ļ�¼��
			int pageCount = count%rows==0?count/rows:count/rows+1;//��ҳ����
			int currentPage = page; //page;
			PageBean pageBean = new PageBean();
			pageBean.setPage(currentPage);//page��ǰ̨�������ĵ�ǰҳ��
			pageBean.setRows(rows);
			List<Link> lList = ls.selectAllLink(pageBean);
			request.put("count", count);//��������¼
			request.put("pageCount", pageCount);//����ҳ
			request.put("currentPage", currentPage);
			request.put("lList", lList);
			System.out.println(link);
			return "bg-linkSelect";
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

