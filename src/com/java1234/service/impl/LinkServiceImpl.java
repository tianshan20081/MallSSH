package com.java1234.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.java1234.dao.LinkDao;
import com.java1234.model.Link;
import com.java1234.model.PageBean;
import com.java1234.service.LinkService;
@Component
public class LinkServiceImpl implements LinkService {

	private LinkDao linkDao;
	
	public LinkDao getLinkDao() {
		return linkDao;
	}
	@Resource
	public void setLinkDao(LinkDao linkDao) {
		this.linkDao = linkDao;
	}

	public List<Link> selectLink() {
		return linkDao.selectLink();
	}
	public List<Link> selectAllLink(PageBean pageBean) {
		return linkDao.selectAllLink(pageBean);
	}
	public int linkCount() {
		return linkDao.linkCount();
	}
	public void deleteLink(int linkId) {
		this.linkDao.deleteLink(linkId);
	}
	public void addLink(Link link) {
		this.linkDao.saveLink(link);
	}
	
	
}
