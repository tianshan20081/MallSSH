package com.java1234.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.java1234.dao.GoodsDao;
import com.java1234.model.Goods;
import com.java1234.model.PageBean;
import com.java1234.service.GoodsService;
@Component
public class GoodsServiceImpl implements GoodsService{

	private GoodsDao goodsDao;
	
	public GoodsDao getGoodsDao() {
		return goodsDao;
	}
	@Resource
	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}


	public List<Goods> selectGoodsNumber() {
		return goodsDao.selectGoodsNumber();
	}
	public List<Goods> selectMarkByZero() {
		return goodsDao.selectMarkByZero();
	}
	public List<Goods> selectMarkByOne() {
		return goodsDao.selectMarkByOne();
	}
	public List<Goods> selectGoodsDetail(int id) {
		return goodsDao.selectGoodsDetail(id);
	}
	public List<Goods> selectNewGoods() {
		return goodsDao.selectNewGoods();
	}
	public List<Goods> selectFreeGoods(PageBean pageBean) {
		return goodsDao.selectFreeGoods(pageBean);
	}
	public List<Goods> goodsPage(PageBean pageBean) {
		return goodsDao.goodsPage(pageBean);
	}
	public void deleteGoods(int goodsId) {
		this.goodsDao.deleteGoods(goodsId);
	}
	public void updateGodos(Goods g) {
		this.goodsDao.updateGodos(g);
	}
	public void addGoods(Goods g) {
		this.goodsDao.saveGoods(g);
	}
	public int selectGoodsDetailCount(int id) {
		return goodsDao.selectGoodsDetailCount(id);
	}
	public List<Goods> selectGoodsDetail(int id, PageBean pageBean) {
		return goodsDao.selectGoodsDetail(id, pageBean);
	}
	public int selectGoodsDetailCount2(int id) {
		return goodsDao.selectGoodsDetailCount2(id);
	}
	public List<Goods> selectGoodsDetail2(int id, PageBean pageBean) {
		return goodsDao.selectGoodsDetail2(id, pageBean);
	}

}
