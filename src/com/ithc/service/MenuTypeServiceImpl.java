package com.ithc.service;

import java.util.List;

import com.ithc.bean.MenuType;
import com.ithc.dao.MenuTypeDao;
import com.ithc.dao.MenuTypeDaoImpl;

public class MenuTypeServiceImpl implements MenuTypeService {
    private MenuTypeDao menuTypeDao=new MenuTypeDaoImpl();
    /**
	 * 查询所有
	 */
    @Override
	public List<MenuType> selectAll() {
		
    	return menuTypeDao.selectAll();
	}
	@Override
	public  List<MenuType>  select() {
		return menuTypeDao.select();
	}

}
