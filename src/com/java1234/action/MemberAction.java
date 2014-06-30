package com.java1234.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Component;

import com.java1234.model.Member;
import com.java1234.model.Order;
import com.java1234.model.PageBean;
import com.java1234.service.MemberService;
import com.java1234.util.PropertiesUtil;
import com.opensymphony.xwork2.ActionSupport;

@Component
public class MemberAction extends ActionSupport implements SessionAware,RequestAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int action;
	private Member member;
	private MemberService memberService;
	private String error;
	private Map<String, Object> session;
	private Map<String, Object> request;
	private int id;
	private int page;
	private String memberId;
	
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public MemberService getMemberService() {
		return memberService;
	}
	@Resource
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String execute() throws Exception{
		
		if(action==0) {
			if(memberService.memberRegister(member.getName())==null) {
				memberService.addMember(member);
				request.put("error", "�û�ע��ɹ�");
			}else {
				request.put("error", "�û��Ѵ��ڣ�������ע��");
			}
			return "register";
		}
		if(action==1) {
			Member currentMember = memberService.memberLogin(member);
			if(currentMember!=null) {
				request.put("error", "��¼�ɹ���3����Զ���ת");
				session.put("currentMember", currentMember);
			}else {
				request.put("error", "�û������������");
			}
			return "login";
		}
		if(action==2) {
			session.remove("currentMember");
			request.put("error", "ע���ɹ�");
			return "logOut";
		}
		if(action==3) {
			Member form = null;
			form = memberService.selectMember(member.getName());
			if(form!=null) {
				request.put("form", form);
			}
			return "fg-Two";
		}
		if(action==4) {
			Member form = null;
			form = memberService.selectFind(member.getName(), member.getResult());
			if(form!=null) {
				request.put("form", form);
			}
			return "fg-three";
		}
		if(action==5) {
			Member m = null;
			m = memberService.findMemberById(member.getId());
			m.setPassword(member.getPassword());
			this.memberService.changeMember(m);
			request.put("change", true);
			return "fg-four";
		}
		if(action==6) {
			if(session.get("currentMember")==null){
				request.put("error", "���ȵ���!");
				return "index";
			}
			return "fg-updateMember";
		}
		if(action==7) {
			int id = (Integer) request.get("id");
			Member m = null;
			m = memberService.findMemberById(id);
			m.setPassword(member.getPassword());
			this.memberService.changeMember(m);
			request.put("error", "�����޸ĳɹ�");
			return "updateMember";
		}
		if(action==8) {
			if(memberId!=null) {
				memberService.deleteMember(Integer.parseInt(memberId));
				page=1;
			}
			int count = memberService.selectAllMember();//���ж�������Ŀ
			int rows = Integer.parseInt(PropertiesUtil.getValue("pageSize"));//ÿһҳ�ļ�¼��
			int pageCount = count%rows==0?count/rows:count/rows+1;//��ҳ����
			int currentPage = page; //page;
			PageBean pageBean = new PageBean();
			pageBean.setPage(currentPage);//page��ǰ̨�������ĵ�ǰҳ��
			pageBean.setRows(rows);
			List<Member> memberList = memberService.memberPage(pageBean);
			request.put("count", count);//��������¼
			request.put("pageCount", pageCount);//����ҳ
			request.put("currentPage", currentPage);
			request.put("memberList", memberList);
			return "bg-selectMember";
		}
		if(action==9) {
			Member member = memberService.findMemberById(id);
			request.put("member", member);
			return "bg-selectContent";
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
