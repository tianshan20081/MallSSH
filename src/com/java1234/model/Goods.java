package com.java1234.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="db_goods")
@SequenceGenerator(name="goodsSEQ", sequenceName="goodsSEQ")
public class Goods implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String goodsName;
	private String goodsFrom;
	private String introduce;
	private Date createTime;
	private int nowPrice;
	private int freePrice;
	private String picture;
	private int mark;
	private int num;
	private BigType bigType;
	private SmallType smallType;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="goodsSEQ")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsFrom() {
		return goodsFrom;
	}
	public void setGoodsFrom(String goodsFrom) {
		this.goodsFrom = goodsFrom;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getNowPrice() {
		return nowPrice;
	}
	public void setNowPrice(int nowPrice) {
		this.nowPrice = nowPrice;
	}
	
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getFreePrice() {
		return freePrice;
	}
	public void setFreePrice(int freePrice) {
		this.freePrice = freePrice;
	}
	@ManyToOne
	@JoinColumn(name="bigId")
	public BigType getBigType() {
		return bigType;
	}
	public void setBigType(BigType bigType) {
		this.bigType = bigType;
	}
	
	@ManyToOne
	@JoinColumn(name="smallId")
	public SmallType getSmallType() {
		return smallType;
	}
	public void setSmallType(SmallType smallType) {
		this.smallType = smallType;
	}
	
}
