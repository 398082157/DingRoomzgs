package com.ithc.dao;

import java.util.List;

import com.ithc.bean.Menu;
import com.ithc.bean.Table;

public interface MenuDao {
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
	List<Menu> findByPage(int pagePresent);
	/**
	 * 添加
	 * @param name
	 * @param price
	 * @param mtype
	 * @param remark
	 * @param photo
	 * @return
	 */
	int insert(String name, String price, String mtype, String remark, String photo);
	
//	int update(int id, String name, String price, String mtype, String remark, String photo);
    
	/**
	 * 用id去查询
	 * @param id
	 * @return
	 */
	Menu findById(int id);
//	int update(String name, String price, String mtype, String remark, String photo);
	int update(int id, String name, String price, String mtype, String remark, String photo);
	boolean select(int id);
	int delete(int id);
}
