package com.ithc.service;

import java.util.List;

import com.ithc.bean.Menu;
import com.ithc.bean.Order;
import com.ithc.dao.MenuDao;
import com.ithc.dao.MenuDaoImpl;
import com.ithc.dao.OrderDao;
import com.ithc.dao.OrderDaoImpl;

public class OrderServiceImpl implements OrderService {
	private OrderDao orderDao=new OrderDaoImpl();
	
	/**
	 * 查询总记录数
	 */
	@Override
	public int findBySize() {
		return orderDao.findBySize();
	}

	/**
	 * 分页查询
	 */
	@Override
	public List<Order> findByPage(int pagePresent) {
		return orderDao.findByPage(pagePresent);
	}


}
