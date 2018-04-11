package com.ithc.bean;

import java.io.Serializable;

public class OrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * CREATE TABLE `orderdetailtbl` (
  `id` int(11) NOT NULL,
  `menuID` int(11) DEFAULT NULL,
  `orderID` int(11) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `remark` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK383C4A3F2BCE9471` (`menuID`),
  KEY `FK383C4A3F3AEC29E1` (`orderID`),
  CONSTRAINT `FK383C4A3F2BCE9471` FOREIGN KEY (`menuID`) REFERENCES `menutbl` (`id`),
  CONSTRAINT `FK383C4A3F3AEC29E1` FOREIGN KEY (`orderID`) REFERENCES `ordertbl` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

	 */
	private int id;
	private int num;
	private String remark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", num=" + num + ", remark=" + remark + "]";
	}
	public OrderDetail() {
	}
}
