package com.ithc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ithc.bean.MenuType;
import com.ithc.util.DBUtils;

public class MenuTypeDaoImpl implements MenuTypeDao {

	Connection conn = DBUtils.getConn();
	/**
	 * 查询所有
	 */
	public List<MenuType> selectAll() {
		try {
			PreparedStatement ps = conn.prepareStatement("select id,name from menutypetbl");
			ResultSet rs = ps.executeQuery();
			List<MenuType> list = new ArrayList<MenuType>();
			while(rs.next()){
				MenuType menuType = new MenuType();
				menuType.setId(rs.getInt("id"));
				menuType.setName(rs.getString("name"));
				list.add(menuType);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<MenuType> select() {
		try {
			PreparedStatement ps = conn.prepareStatement("select id,name from menutypetbl ");
			ResultSet rs = ps.executeQuery();
			List<MenuType> list=new ArrayList<MenuType>();
			while(rs.next()){
				MenuType menuType=new MenuType();
				menuType.setId(rs.getInt("id"));
				menuType.setName(rs.getString("name"));
				list.add(menuType);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
