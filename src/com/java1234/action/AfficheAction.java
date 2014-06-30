package com.java1234.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Component;

import com.java1234.model.Affiche;
import com.java1234.model.Link;
import com.java1234.model.PageBean;
import com.java1234.service.AfficheService;
import com.java1234.util.PropertiesUtil;
import com.opensymphony.xwork2.ActionSupport;

@Component
public class AfficheAction extends ActionSupport implements SessionAware,RequestAware{
	private Map<String, Object> session;
	private Map<String, Object> request;
	private Affiche affiche;
	private AfficheService afficheService;
	private int action;
	private int page;
	private String result;
	private String afficheId;
	private int no;
	
	public AfficheService getAfficheService() {
		return afficheService;
	}
	@Resource
	public void setAfficheService(AfficheService afficheService) {
		this.afficheService = afficheService;
	}
	public Affiche getAffiche() {
		return affiche;
	}
	public void setAffiche(Affiche affiche) {
		this.affiche = affiche;
	}
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
	public String getAfficheId() {
		return afficheId;
	}
	public void setAfficheId(String afficheId) {
		this.afficheId = afficheId;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	@Override
	public String execute() throws Exception {
		if(action==0) {
			if(afficheId!=null) {
				if(no==1) {
					afficheService.deleteAffiche(Integer.parseInt(afficheId));
					request.put("result", "删除成功");
					return "bg-afficheResult";
				}
				if(no==2) {
					Affiche a = afficheService.selectOneAffiche(Integer.parseInt(afficheId));
					a.setName(affiche.getName());
					a.setContent(affiche.getContent());
					afficheService.updateAffiche(a);
					request.put("result", "修改成功");
					return "bg-afficheResult";
				}
			}
			int count = afficheService.afficheCount();
			int rows = Integer.parseInt(PropertiesUtil.getValue("pageSize"));//每一页的记录数
			int pageCount = count%rows==0?count/rows:count/rows+1;//分页总数
			int currentPage = page; //page;
			PageBean pageBean = new PageBean();
			pageBean.setPage(currentPage);//page是前台传过来的当前页数
			pageBean.setRows(rows);
			List<Affiche> aList = afficheService.afficheSelect(pageBean);
			request.put("count", count);//共几条记录
			request.put("pageCount", pageCount);//共几页
			request.put("currentPage", currentPage);
			request.put("aList", aList);
			return "bg-afficheSelect";
		}
		if(action==1) {
			afficheService.addAffiche(affiche);
			request.put("result", "设置成功");
			return "bg-afficheResult";
		}
		if(action==2) {
			Affiche affiche = afficheService.selectOneAffiche(Integer.parseInt(afficheId));
			request.put("affiche", affiche);
			return "bg-afficheContent";
		}
		if(action==3) {
			Affiche affiche = afficheService.selectOneAffiche(Integer.parseInt(afficheId));
			request.put("affiche", affiche);
			return "bg-afficheUpdate";
		}
		if(action==4) {
			Affiche oneAffiche = afficheService.selectOneAffiche(affiche.getId());
			request.put("oneAffiche", oneAffiche);
			return "oneAffiche";
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
