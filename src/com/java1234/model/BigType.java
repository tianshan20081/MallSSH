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
@Table(name="db_bigtype")
@SequenceGenerator(name="bigTypeSEQ", sequenceName="bigTypeSEQ")
public class BigType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String bigName;
	private Date createTime;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bigTypeSEQ")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBigName() {
		return bigName;
	}
	public void setBigName(String bigName) {
		this.bigName = bigName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
