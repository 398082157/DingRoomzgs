package com.ithc.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class Table implements Serializable{
	/**
	 * Create Table

CREATE TABLE `tabletbl` (
  `id` int(11) NOT NULL,桌号
  `Ord_id` int(11) DEFAULT NULL,订单号
  `num` varchar(128) DEFAULT NULL,人数
  `flag` varchar(128) DEFAULT NULL,描述
  `description` varchar(128) DEFAULT NULL,餐桌状态
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
	 */
	//桌号
	private int id;
	//订单号
	private int ord_id;
	//人数
	private String num;
	//描述
	private String flag;
	//餐桌状态
	private String description;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrd_id() {
		return ord_id;
	}
	public void setOrd_id(int ord_id) {
		this.ord_id = ord_id;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Table() {
	}
	@Override
	public String toString() {
		return "Table [id=" + id + ", ord_id=" + ord_id + ", num=" + num + ", flag=" + flag + ", description="
				+ description + "]";
	}
}
