package com.ithc.bean;

import java.io.Serializable;

public class Order implements Serializable{
	private static final long serialVersionUID = 1L;

	/**
	 * 
Create Table

CREATE TABLE `ordertbl` (
  `id` int(11) NOT NULL,
 
  `OrderTime` varchar(128) DEFAULT NULL,
  `UserID` int(11) DEFAULT NULL,
  `personNum` int(11) DEFAULT NULL,
  `idPay` int(11) DEFAULT NULL,
  `remark` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK49924DB0A75EB9E1` (`TableID`),
  CONSTRAINT `FK49924DB0A75EB9E1` FOREIGN KEY (`TableID`) REFERENCES `tabletbl` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

 `TableID` int(11) DEFAULT NULL,
	 */
	private int id;
	
	private String orderTime;
	
	private int userId;
	
	private int idPay;
	
	private String remark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getIdPay() {
		return idPay;
	}

	public void setIdPay(int idPay) {
		this.idPay = idPay;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderTime=" + orderTime + ", userId=" + userId + ", idPay=" + idPay + ", remark="
				+ remark + "]";
	}

	public Order() {
	}
}
