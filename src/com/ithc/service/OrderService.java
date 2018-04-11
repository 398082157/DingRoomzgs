package com.ithc.service;

import java.util.List;

import com.ithc.bean.Menu;
import com.ithc.bean.Order;

public interface OrderService {
	/**
	 * 查询总记录数
	 * @return
	 */
	int findBySize();
	/**
	 * 分页查询
	 * @param pagePresent
	 * @return
	 */
	List<Order> findByPage(int pagePresent);
	/**
	 * 用id查询
	 * @param id
	 * @return
	 */
}
