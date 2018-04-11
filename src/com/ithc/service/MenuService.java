package com.ithc.service;

import java.util.List;

import com.ithc.bean.Menu;
import com.ithc.bean.Table;

public interface MenuService {
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
	 * 用id查询
	 * @param id
	 * @return
	 */
	Menu findById(int id);
	/**
	 * 添加
	 * @param name
	 * @param price
	 * @param mtype
	 * @param remark
	 * @param photo
	 * @return
	 */
	int insert(String name,String price,String mtype,String remark,String photo);
	/**
	 * 根据id修改其余的值
	 * @param name
	 * @param price
	 * @param mtype
	 * @param remark
	 * @param photo
	 * @return
	 */
//	int update(int id,String name,String price,String mtype,String remark,String photo);
	/**
	 * 根据id修改其余的值
	 * @param id 
	 * @param name
	 * @param price
	 * @param mtype
	 * @param remark
	 * @param photo
	 * @return
	 */
//	int update(String name, String price, String mtype, String remark, String photo);
	int update(int id, String name, String price, String mtype, String remark, String photo);
	boolean select(int id);
	int delete(int id);
}
