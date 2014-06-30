package com.java1234.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="db_smallType")
@SequenceGenerator(name="smallTypeSEQ", sequenceName="smallTypeSEQ")
public class SmallType  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String smallName;
	private Date createTime;
	private BigType bigType;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="smallTypeSEQ")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSmallName() {
		return smallName;
	}
	public void setSmallName(String smallName) {
		this.smallName = smallName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@ManyToOne
	@JoinColumn(name="bigId")
	public BigType getBigType() {
		return bigType;
	}
	public void setBigType(BigType bigType) {
		this.bigType = bigType;
	}
	
}
