package com.java1234.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.java1234.dao.MemberDao;
import com.java1234.model.Member;
import com.java1234.model.PageBean;
import com.java1234.service.MemberService;

@Component
public class MemberServiceImpl implements MemberService {

	private MemberDao memberDao;
	
	public MemberDao getMemberDao() {
		return memberDao;
	}
	@Resource 
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	
	public Member memberRegister(String name) {
		return memberDao.memberRegister(name);
	}
	public Member memberLogin(Member member) {
		return memberDao.memberLogin(member);
	}
	public void addMember(Member member) {
		 this.memberDao.saveMember(member);
	}
	public Member selectMember(String name) {
		return memberDao.selectMember(name);
	}
	public Member selectFind(String name, String result) {
		return memberDao.selectFind(name, result);
	}
	public Member findMemberById(int id) {
		return memberDao.findMemberById(id);
	}
	public void changeMember(Member m) {
		this.memberDao.changeMember(m);
	}
	public List<Member> selectMember() {
		return this.memberDao.selectMember();
	}
	public int selectAllMember() {
		return this.memberDao.selectAllMember();
	}
	public List<Member> memberPage(PageBean pageBean) {
		return this.memberDao.memberPage(pageBean);
	}
	public void deleteMember(int id) {
		this.memberDao.deleteMember(id);
	}
	
}
