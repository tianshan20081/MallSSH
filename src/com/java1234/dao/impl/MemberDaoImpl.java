package com.java1234.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.java1234.dao.MemberDao;
import com.java1234.model.Member;
import com.java1234.model.Order;
import com.java1234.model.PageBean;

@Component
public class MemberDaoImpl implements MemberDao {

	private HibernateTemplate ht;
	public HibernateTemplate getHibernateTemplate() {
		return ht;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.ht = hibernateTemplate;
	}

	@SuppressWarnings("unchecked")
	public Member memberRegister(String name) {
		Member member = null;
		List<Member> memberList = this.ht.find("from Member m where m.name=?",new String[]{name});
		if(memberList.size()>0){
			member = memberList.get(0);
		}
		return member;
	}
	
	public Member memberLogin(Member member) {
		Member currentMember = null;
		@SuppressWarnings("unchecked")
		List<Member> memberList = this.ht.find("from Member m where m.name=? and m.password=?",
				new String[]{member.getName(),member.getPassword()});
		
		if(memberList.size()>0) {
			currentMember = memberList.get(0);
		}
		return currentMember;
	}
	public void saveMember(Member member) {
		this.ht.save(member);
	}
	
	public Member selectMember(String name) {
		Member member = null;
		List<Member> memberList = this.ht.find("from Member m where m.name=?",new String[]{name});
		if(memberList.size()>0){
			member = memberList.get(0);
		}
		return member;
	}
	public Member selectFind(String name, String result) {
		Member member = null;
		@SuppressWarnings("unchecked")
		List<Member> memberList = this.ht.find("from Member m where m.name=? and m.result=?",
				new String[]{name,result});
		if(memberList.size()>0) {
			member = memberList.get(0);
		}
		return member;
	}
	public Member findMemberById(int id) {
		Member member = null;
		List<Member> memberList = this.ht.find("from Member m where m.id='"+id+"'");
		if(memberList.size()>0){
			member = memberList.get(0);
		}
		return member;
	}
	public void changeMember(Member m) {
		this.ht.update(m);
	}
	public List<Member> selectMember() {
		return this.ht.find("from Member");
	}
	public int selectAllMember() {
		int count = this.ht.find("from Member").size();
		return count;
	}
	public List<Member> memberPage(PageBean pageBean) {
		Session session = this.ht.getSessionFactory().getCurrentSession();
		List<Member> memberList = null; 
		Query q = session.createQuery("from Member");
		q.setFirstResult(pageBean.getStart());
		q.setMaxResults(pageBean.getRows());
		memberList = q.list();
		return memberList;
	}
	public void deleteMember(int id) {
		Session session = this.ht.getSessionFactory().getCurrentSession();
		Query q = session.createQuery("delete Member m where m.id='"+id+"'");
		q.executeUpdate();
	}
}
