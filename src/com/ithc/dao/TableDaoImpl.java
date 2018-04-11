package com.ithc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ithc.bean.Table;
import com.ithc.util.DBUtils;
import com.ithc.util.PageBean;

public class TableDaoImpl implements TableDao {
	Connection conn = DBUtils.getConn();
	private int size;
	/**
	 * 查询总记录数
	 */
	public int findBySize() {
		try {
			PreparedStatement ps = conn.prepareStatement("select count(*) from tabletbl");
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
	public List<Table> findByPage(int pagePresent) {
		List<Table> list = new ArrayList<Table>();
		try {
			PreparedStatement ps = conn.prepareStatement("select id,ord_id,num,flag,description from tabletbl limit ?,?");
			//计算数据库查询位置
			int page = (pagePresent-1)*PageBean.PAGE_SIZE;
			ps.setInt(1,page);
			ps.setInt(2, PageBean.PAGE_SIZE);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Table table = new Table();
				table.setId(rs.getInt("id"));
				table.setOrd_id(rs.getInt("ord_id"));
				table.setFlag(rs.getString("flag"));
				table.setNum(rs.getString("num"));
				table.setDescription(rs.getString("description"));
				list.add(table);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 添加一张桌子
	 */
	public int insert(String num) {
		
		try {
			PreparedStatement ps = conn.prepareStatement("insert into tabletbl (num) values (?)");
			ps.setString(1, num);
			size = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return size;
	}
	/**
	 * 用id查询
	 */
	public Table findById(int id) {
		
		try {
			PreparedStatement ps = conn.prepareStatement("select id,ord_id,num,flag,description "
					+ "from tabletbl where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				Table table = new Table();
				table.setId(rs.getInt("id"));
				table.setOrd_id(rs.getInt("ord_id"));
				table.setFlag(rs.getString("flag"));
				table.setNum(rs.getString("num"));
				table.setDescription(rs.getString("description"));
				return table;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据id修改其余的值
	 */
	public int update(int id, int oid, String num, String flag, String description) {
		
		try {
			PreparedStatement ps = conn.prepareStatement("update tabletbl set ord_id=?,num=?,flag=?,"
					+ "description=? where id = ?");
			ps.setInt(1, oid);
			ps.setString(2, num);
			ps.setString(3, flag);
			ps.setString(4, description);
			ps.setInt(5, id);
			size = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return size;
	}
	/**
	 * 连表查询
	 */
	public boolean select(int id) {
		StringBuffer sb = new StringBuffer();
		sb.append("select ");
		sb.append("t.id,t.ord_id,t.num,t.flag,t.description,o.id,o.orderTime,o.userId,o.idPay,o.remark ");
		sb.append("from ");
		sb.append("tabletbl t,ordertbl o ");
		sb.append("where t.id = o.tableID and t.id = ?");
		
		try {
			PreparedStatement ps = conn.prepareStatement(sb.toString());
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
	public int delete(int id) {
		try {
			PreparedStatement ps = conn.prepareStatement("delete from tabletbl where id = ?");
			ps.setInt(1, id);
			size = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return size;
	}
}
