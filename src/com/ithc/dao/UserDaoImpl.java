package com.ithc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ithc.bean.User;
import com.ithc.util.DBUtils;
/**
 * 持久层
 * @author 李某人
 * motto   学习就像和尚诵经
 * cell-phone number 13437278267
 */
public class UserDaoImpl implements UserDao {
	Connection conn = DBUtils.getConn();
	private int code;
	/**
	 * 登入
	 */
	public User login(String name, String password, int permission) {
		try {
			PreparedStatement ps = conn.prepareStatement("select id,username,password,name,gender,permission,"
					+ "remark from usertbl where username = ? and password = ? and permission = ?");
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setInt(3, permission);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setPermission(rs.getInt("permission"));
				user.setRemark(rs.getString("remark"));
				user.setGender(rs.getString("gender"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 修改基本信息
	 */
	public int refresh(int id, String username, String name, String gender, int permission, String remark) {
		
		try {
			PreparedStatement ps = conn.prepareStatement("update usertbl set username=?,name=?,gender=?,permission=?,"
					+ "remark=? where id = ?");
			ps.setString(1, username);
			ps.setString(2, name);
			ps.setString(3, gender);
			ps.setInt(4, permission);
			ps.setString(5, remark);
			ps.setInt(6, id);
			code = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return code;
	}
	/**
	 * 用id查询
	 */
	public User findById(int id) {
		try {
			PreparedStatement ps = conn.prepareStatement("select id,username,password,name,gender,permission"
					+ ",remark from usertbl where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setPermission(rs.getInt("permission"));
				user.setRemark(rs.getString("remark"));
				user.setGender(rs.getString("gender"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据id修改密码
	 */
	public int updatePassword(int id, String password) {
		
		try {
			PreparedStatement ps = conn.prepareStatement("update usertbl set password = ? where id = ?");
			ps.setString(1, password);
			ps.setInt(2, id);
			code =	ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return code;
	}

}
