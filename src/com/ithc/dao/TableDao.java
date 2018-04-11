package com.ithc.dao;

import java.util.List;

import com.ithc.bean.Table;

public interface TableDao {
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
	List<Table> findByPage(int pagePresent);
	/**
	 * 添加一张桌子
	 * @param num
	 * @return
	 */
	int insert(String num);
	/**
	 * 用id查询
	 * @param id
	 * @return
	 */
	Table findById(int id);
	/**
	 * 根据id修改其余的值
	 * @param id
	 * @param oid
	 * @param num
	 * @param flag
	 * @param description
	 * @return
	 */
	int update(int id, int oid, String num, String flag, String description);
	/**
	 * 连表查询
	 * @param id
	 * @return
	 */
	boolean select(int id);
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	int delete(int id);
}