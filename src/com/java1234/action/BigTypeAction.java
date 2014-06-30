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
import com.java1234.service.BigTypeService;
import com.java1234.util.PropertiesUtil;
import com.opensymphony.xwork2.ActionSupport;

@Component
public class BigTypeAction extends ActionSupport implements SessionAware,RequestAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	private Map<String, Object> request;
	private int action;
	private BigTypeService bts;
	private int page;
	private BigType bigType;
	private String result;
	private String bigTypeId;
	
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
	public BigTypeService getBts() {
		return bts;
	}
	@Resource
	public void setBts(BigTypeService bts) {
		this.bts = bts;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public BigType getBigType() {
		return bigType;
	}
	public void setBigType(BigType bigType) {
		this.bigType = bigType;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getBigTypeId() {
		return bigTypeId;
	}
	public void setBigTypeId(String bigTypeId) {
		this.bigTypeId = bigTypeId;
	}
	@Override
	public String execute() throws Exception {
		if(action==0) {
			if(bigTypeId!=null) {
				bts.deleteBigType(Integer.parseInt(bigTypeId));
				request.put("result", "ɾ���ɹ�");
				return "bg-bigTypeResult";
			}
			int count = bts.bigTypeCount();
			int rows = Integer.parseInt(PropertiesUtil.getValue("pageSize"));//ÿһҳ�ļ�¼��
			int pageCount = count%rows==0?count/rows:count/rows+1;//��ҳ����
			int currentPage = page; //page;
			PageBean pageBean = new PageBean();
			pageBean.setPage(currentPage);//page��ǰ̨�������ĵ�ǰҳ��
			pageBean.setRows(rows);
			List<BigType> btList = bts.selectBigType(pageBean);
			request.put("count", count);//��������¼
			request.put("pageCount", pageCount);//����ҳ
			request.put("currentPage", currentPage);
			request.put("btList", btList);
			return "bg-bigTypeSelect";
		}
		if(action==1) {
			bigType.setCreateTime(new Date());
			bts.addBigType(bigType);
			request.put("result", "��ӳɹ�");
			return "bg-bigTypeResult";
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
