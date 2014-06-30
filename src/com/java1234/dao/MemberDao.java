package com.java1234.dao;

import java.util.List;

import com.java1234.model.Member;
import com.java1234.model.PageBean;

public interface MemberDao {

	public Member memberRegister(String name);
	public Member memberLogin(Member member);
	public void saveMember(Member member);
	public Member selectMember(String name);
	public Member selectFind(String name,String result);
	public Member findMemberById(int id);
	public void changeMember(Member m);
	public List<Member> selectMember();
	public int selectAllMember();
	public List<Member> memberPage(PageBean pageBean);
	public void deleteMember(int id);
}
