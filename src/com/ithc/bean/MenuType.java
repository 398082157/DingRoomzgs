package com.ithc.bean;

import java.io.Serializable;

public class MenuType implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 
Create Table

CREATE TABLE `menutypetbl` (
  `id` int(11) NOT NULL,
  `name` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk

	 */
	//编号
	private int id;
	//菜品
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "MenuType [id=" + id + ", name=" + name + "]";
	}
	public MenuType() {
	}
	
	
}
