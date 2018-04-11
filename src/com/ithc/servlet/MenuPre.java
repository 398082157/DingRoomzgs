package com.ithc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ithc.bean.Menu;
import com.ithc.service.MenuService;
import com.ithc.service.MenuServiceImpl;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

@WebServlet("/menuPre")
public class MenuPre extends HttpServlet{
	private MenuService menuService = new MenuServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取编号
		String tid = req.getParameter("id");
		 HttpSession session=req.getSession();
		int id = Integer.parseInt(tid);
		//用编号去查询
		Menu menu  = menuService.findById(id);
		if(menu != null){
		session.setAttribute("model",menu);
		req.getRequestDispatcher("WEB-INF/views/menu/menuPre.jsp").forward(req, resp);
	}

 }
}
