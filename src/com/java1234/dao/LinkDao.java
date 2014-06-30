package com.java1234.dao;

import java.util.List;

import com.java1234.model.Link;
import com.java1234.model.PageBean;

public interface LinkDao {
	public List<Link> selectLink();
	public List<Link> selectAllLink(PageBean pageBean);
	public int linkCount();
	public void deleteLink(int linkId);
	public void saveLink(Link link);
}
