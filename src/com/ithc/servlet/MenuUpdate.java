package com.ithc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ithc.bean.Menu;
import com.ithc.bean.MenuType;
import com.ithc.service.MenuService;
import com.ithc.service.MenuServiceImpl;
import com.ithc.service.MenuTypeService;
import com.ithc.service.MenuTypeServiceImpl;
import com.sun.beans.editors.IntegerEditor;
import com.sun.media.sound.RealTimeSequencerProvider;

@WebServlet("/menuUpdate")
public class MenuUpdate extends HttpServlet{
	private MenuService menuService = new MenuServiceImpl();
	private MenuTypeService menuTypeService=new MenuTypeServiceImpl(); 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tid = req.getParameter("id");
		int id=Integer.parseInt(tid);
		Menu menu=menuService.findById(id);
		List<MenuType> list = menuTypeService.select();
		HttpSession session = req.getSession();
		session.setAttribute("model",menu);
		session.setAttribute("menutypelist", list);
		req.getRequestDispatcher("WEB-INF/views/menu/menuEdit.jsp").forward(req, resp);
//		//菜名
//		String name = req.getParameter("name");
//		//价格
//		String price = req.getParameter("price");
//		//外键值
//		String mtype = req.getParameter("menutypes");
//		//备注
//		String remark = req.getParameter("remark");
//		//图片名
//		String photo = req.getParameter("photo");
//		String tid = req.getParameter("id");
//		int id = Integer.parseInt(tid);
//		//修改值
//		int code = MenuService.update(id,name,price,mtype,remark,photo);
//		session = req.getSession();
//		if(code == 1){
//			//获取总页数,把总页数传递给分页查询的当前页
//			String pageNow = req.getParameter("pageNow");
//			session.setAttribute("updMenu", "yes");
//			resp.sendRedirect("menuFindByPage?pageNow="+pageNow);
//		}
	}
}

