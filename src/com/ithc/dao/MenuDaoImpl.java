package com.ithc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ithc.bean.Menu;
import com.ithc.bean.MenuType;
import com.ithc.util.DBUtils;
import com.ithc.util.PageBean;
import com.sun.crypto.provider.RSACipher;

public class MenuDaoImpl implements MenuDao {

	private Connection conn = DBUtils.getConn();
	private int size;
	/**
	 * 查询总记录数
	 */
	public int findBySize() {
		try {
			PreparedStatement ps = conn.prepareStatement("select count(*) from menutbl");
			ResultSet rs = ps.executeQuery();
			rs.next();
			size = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return size;
	}
	/**
	 * 分页查询
	 */
	public List<Menu> findByPage(int pagePresent) {
		
		try {
			PreparedStatement ps = conn.prepareStatement("select id,name,price,pic,remark from menutbl limit ?,?");
			//设置数据库的查询位置
			int init = (pagePresent-1) * PageBean.PAGE_SIZE;
			ps.setInt(1, init);
			//设置每页显示的数量
			ps.setInt(2, PageBean.PAGE_SIZE);
			ResultSet rs = ps.executeQuery();
			List<Menu> list = new ArrayList<Menu>();
			while(rs.next()){
				Menu menu = new Menu();
				menu.setId(rs.getInt("id"));
				menu.setName(rs.getString("name"));
				menu.setPic(rs.getString("pic"));
				menu.setPrice(rs.getString("price"));
				menu.setRemark(rs.getString("remark"));
				list.add(menu);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 添加
	 */
	public int insert(String name, String price, String mtype, String remark, String photo) {
		
		try {
			PreparedStatement ps = conn.prepareStatement("insert into menutbl (typeid,name,price,pic,remark) values (?,?,?,?,?)");
			ps.setInt(1, Integer.parseInt(mtype));
			ps.setString(2, name);
			ps.setString(3, price);
			ps.setString(4, photo);
			ps.setString(5, remark);
			size = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return size;
	}
	
	/**
	 * 根据id修改其余的值
	 */
	@Override
	public int update(int id,String name, String price, String mtype, String remark, String photo) {
		try {
			PreparedStatement ps=conn.prepareStatement("update menutbl set name=?,price=?,typeid=?,remark=?,pic=? where id=?");
			ps.setString(1, name);
			ps.setString(2, price);
			ps.setString(3, mtype);
			ps.setString(4, remark);
			ps.setString(5, photo);
			ps.setInt(6, id);
			size= ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return size;
	}
	/**
	 * 预览
	 */
	@Override
	public Menu findById(int id) {
		try {
			PreparedStatement ps=conn.prepareStatement("SELECT m.`id` ,m.`name`,m.`price`,m.`remark`,m.pic,t.`name`,t.`id` FROM menutbl m ,menutypetbl t WHERE  t.id=m.typeid and m.id=?");
		    ps.setInt(1, id);
		    ResultSet rs=ps.executeQuery();
		    if(rs.next()){
		    	 Menu menu=new Menu();
		    	 MenuType menuType=new MenuType();
		    	 menu.setId(rs.getInt("m.id"));
		    	 menuType.setName(rs.getString("t.name"));
		    	 menuType.setId(rs.getInt("t.id"));
		    	 menu.setMenuType(menuType);
		    	 menu.setName(rs.getString("m.name"));
		    	 menu.setPrice(rs.getString("m.price"));
		    	 menu.setRemark(rs.getString("m.remark"));
		    	 menu.setPic(rs.getString("m.pic"));
		    	 return menu;
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 连表查询
	 */
	@Override
	public boolean select(int id) {
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT  m.id,m.`typeID`,m.`name`,m.`price`,m.`pic`,m.`remark`,o.`id`,o.`menuID`,o.`num`,o.`remark` FROM menutbl m,orderdetailtbl o WHERE m.id =o.`menuID` AND m.id=?");
		    ps.setInt(1, id);
		    ResultSet rs = ps.executeQuery();
			while(rs.next()){
			//如果执行了while循环，说明此设置的此id有外键关联的值，不能删除
			return false;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
	/**
	 * 删除
	 */
	@Override
	public int delete(int id) {
		try {
			PreparedStatement ps = conn.prepareStatement("delete from menutbl where id = ?");
			ps.setInt(1, id);
			size = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return size;
	}
}
