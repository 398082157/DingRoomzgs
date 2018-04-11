package com.ithc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ithc.bean.MenuType;
import com.ithc.service.MenuTypeService;
import com.ithc.service.MenuTypeServiceImpl;

@WebServlet("/menuAdd")
public class MenuAdd extends HttpServlet{
private MenuTypeService menuTypeService =new MenuTypeServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//查询menutypetbl里面的值
		List<MenuType> list=menuTypeService.selectAll();
		HttpSession session=req.getSession();
		session.setAttribute("menutypelist", list);
		//转发到menu.jsp
		req.getRequestDispatcher("WEB-INF/views/menu/menuAdd.jsp").forward(req, resp);
	}

}
