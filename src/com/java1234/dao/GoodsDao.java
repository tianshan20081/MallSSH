package com.java1234.dao;

import java.util.List;

import com.java1234.model.Goods;
import com.java1234.model.Order;
import com.java1234.model.PageBean;

public interface GoodsDao {

	public List<Goods> selectGoodsNumber();
	public List<Goods> selectMarkByZero();
	public List<Goods> selectMarkByOne();
	public List<Goods> selectGoodsDetail(int id,PageBean pageBean);
	public List<Goods> selectGoodsDetail2(int id,PageBean pageBean);
	public List<Goods> selectGoodsDetail(int id);
	public int selectGoodsDetailCount(int id);
	public List<Goods> selectNewGoods();
	public List<Goods> selectFreeGoods(PageBean pageBean);
	public List<Goods> goodsPage(PageBean pageBean);
	public void deleteGoods(int goodsId);
	public void updateGodos(Goods g);
	public void saveGoods(Goods g);
	public int selectGoodsDetailCount2(int id);
	
}
