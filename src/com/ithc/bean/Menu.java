package com.ithc.bean;

import java.io.Serializable;

public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
Create Table

CREATE TABLE `menutbl` (
  `id` int(11) NOT NULL,
  `typeID` int(11) DEFAULT NULL,
  `name` varchar(128) DEFAULT NULL,
  `price` varchar(128) DEFAULT NULL,
  `pic` varchar(128) DEFAULT NULL,
  `remark` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK38A5B9FFAA26CD92` (`typeID`),
  CONSTRAINT `FK38A5B9FFAA26CD92` FOREIGN KEY (`typeID`) REFERENCES `menutypetbl` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

	 */
	//编号
	private int id;
	
	//外键(菜系) 粤菜.湘菜.川菜.鲁菜.苏菜.徽菜.浙菜.闽菜 
	private MenuType menuType;
	//菜名
	private String name;
	
	//价格
	private String price;
	
	//图片名字
	private String pic;
	
	//备注
	private String remark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MenuType getMenuType() {
		return menuType;
	}

	public void setMenuType(MenuType menuType) {
		this.menuType = menuType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", menuType=" + menuType + ", name=" + name + ", price=" + price + ", pic=" + pic
				+ ", remark=" + remark + "]";
	}

	public Menu() {
	}
	
}
