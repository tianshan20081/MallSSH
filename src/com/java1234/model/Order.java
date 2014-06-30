package com.java1234.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="db_order")
@SequenceGenerator(name="orderSEQ", sequenceName="orderSEQ")
public class Order implements Serializable{
	private int id;
	private String num;
	private String name;
	private String reallyName;
	private String address;
	private String tel;
	private String setMoney;
	private String post;
	private String bz;
	private int sign;
	private Date createTime;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="orderSEQ")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReallyName() {
		return reallyName;
	}
	public void setReallyName(String reallyName) {
		this.reallyName = reallyName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getSetMoney() {
		return setMoney;
	}
	public void setSetMoney(String setMoney) {
		this.setMoney = setMoney;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public int getSign() {
		return sign;
	}
	public void setSign(int sign) {
		this.sign = sign;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
