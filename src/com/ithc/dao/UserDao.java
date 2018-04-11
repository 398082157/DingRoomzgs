package com.ithc.dao;

import com.ithc.bean.User;

public interface UserDao {
	/**
	 * 登入
	 * @param name
	 * @param password
	 * @param permission
	 * @return
	 */
	User login(String name, String password, int permission);
	/**
	 * 修改基本信息
	 * @param id
	 * @param username
	 * @param name
	 * @param gender
	 * @param permission
	 * @param remark
	 * @return
	 */
	int refresh(int id, String username, String name, String gender, int permission, String remark);
	/**
	 * 用id查询
	 * @param id
	 * @return
	 */
	User findById(int id);
	/**
	 * 根据id修改密码
	 * @param id
	 * @param password
	 * @return
	 */
	int updatePassword(int id, String password);

}
