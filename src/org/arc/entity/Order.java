package org.arc.entity;

import java.util.Date;

/**
 * @author Mrruan  E-mail:qkmc@outlook.com
 * @version 创建时间：2017年10月28日 下午5:02:56
 */
public class Order {
	private int orderId;
	private int orderNumber;
	private Date creTime;
	private int fertA;
	private int fertB;
	private int fertC;
	private int crePersonId;
	
	public Order() {
		super();
	}
	
	public Order(int orderId, int orderNumber, Date creTime, int fertA,
			int fertB, int fertC, int crePersonId) {
		super();
		this.orderId = orderId;
		this.orderNumber = orderNumber;
		this.creTime = creTime;
		this.fertA = fertA;
		this.fertB = fertB;
		this.fertC = fertC;
		this.crePersonId = crePersonId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Date getCreTime() {
		return creTime;
	}
	public void setCreTime(Date creTime) {
		this.creTime = creTime;
	}
	public int getFertA() {
		return fertA;
	}
	public void setFertA(int fertA) {
		this.fertA = fertA;
	}
	public int getFertB() {
		return fertB;
	}
	public void setFertB(int fertB) {
		this.fertB = fertB;
	}
	public int getFertC() {
		return fertC;
	}
	public void setFertC(int fertC) {
		this.fertC = fertC;
	}
	public int getCrePersonId() {
		return crePersonId;
	}
	public void setCrePersonId(int crePersonId) {
		this.crePersonId = crePersonId;
	}
	
}
