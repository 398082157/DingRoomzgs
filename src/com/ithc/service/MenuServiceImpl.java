package com.ithc.service;

import java.util.List;

import com.ithc.bean.Menu;
import com.ithc.dao.MenuDao;
import com.ithc.dao.MenuDaoImpl;

public class MenuServiceImpl implements MenuService {
	 private MenuDao menuDao=new MenuDaoImpl();

	 /**
		 * 查询总记录数
		 */
	@Override
	public int findBySize() {
		return menuDao.findBySize();
	}

	/**
	 * 分页查询
	 */
	@Override
	public List<Menu> findByPage(int pagePresent) {
		return menuDao.findByPage(pagePresent);
	}

	/**
	 * 添加
	 */
	@Override
	public int insert(String name, String price, String mtype, String remark, String photo) {
		return menuDao.insert(name,price,mtype,remark,photo);
	}

	

	@Override
	public Menu findById(int id) {
		 return menuDao.findById(id);
	}

	@Override
	public int update(int id,String name, String price, String mtype, String remark, String photo) {
		return menuDao.update(id,name, price, mtype, remark, photo);
		
	}

	@Override
	public boolean select(int id) {
		return menuDao.select(id);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return menuDao.delete(id);
	}


}
