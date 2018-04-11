package com.ithc.service;

import com.ithc.bean.User;
import com.ithc.dao.UserDao;
import com.ithc.dao.UserDaoImpl;
import com.ithc.util.Permission;
/**
 * 业务层
 * @author 李某人
 * motto   学习就像和尚诵经
 * cell-phone number 13437278267
 */
public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();
	/**
	 * 登入
	 */
	public User login(String name, String password) {
		
		return userDao.login(name,password,Permission.getPermission());
	}
	/**
	 * 修改基本信息
	 */
	public int refresh(int id, String username, String name, String gender, int permission, String remark) {
		return userDao.refresh(id,username,name,gender,permission,remark);
	}
	/**
	 * 用id查询
	 */
	public User findById(int id) {
		return userDao.findById(id);
	}
	/**
	 * 根据id修改密码
	 */
	public int updatePassword(int id, String password) {
		
		return userDao.updatePassword(id,password);
	}

}
