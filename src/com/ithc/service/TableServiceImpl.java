package com.ithc.service;

import java.util.List;

import com.ithc.bean.Table;
import com.ithc.dao.TableDao;
import com.ithc.dao.TableDaoImpl;

public class TableServiceImpl implements TableService {
	private TableDao tableDao = new TableDaoImpl();
	/**
	 * 查询总记录数
	 */
	public int findBySize() {
		return tableDao.findBySize();
	}
	/**
	 * 分页查询
	 */
	public List<Table> findByPage(int pagePresent) {
		return tableDao.findByPage(pagePresent);
	}
	/**
	 * 添加一张桌子
	 */
	public int insert(String num) {
		
		return tableDao.insert(num);
	}
	/**
	 * 用id查询
	 */
	public Table findById(int id) {
		return tableDao.findById(id);
	}
	/**
	 * 根据id修改其余的值
	 */
	public int update(int id, int oid, String num, String flag, String description) {
		return tableDao.update(id,oid,num,flag,description);
	}
	@Override
	public boolean select(int id) {
		return tableDao.select(id);
	}
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return tableDao.delete(id);
	}
}
