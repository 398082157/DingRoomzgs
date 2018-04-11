package com.ithc.dao;

import java.util.List;

import com.ithc.bean.Order;;

public interface OrderDao {
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
}
