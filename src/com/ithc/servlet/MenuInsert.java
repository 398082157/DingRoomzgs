package com.ithc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ithc.service.MenuService;
import com.ithc.service.MenuServiceImpl;
import com.sun.net.httpserver.HttpServer;
@WebServlet("/menuInsert")
public class MenuInsert extends HttpServlet{
	private MenuService MenuService = new MenuServiceImpl();
	private HttpSession session;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//菜名
			String name = req.getParameter("name");
			//价格
			String price = req.getParameter("price");
			//外键值
			String mtype = req.getParameter("menutypes");
			//备注
			String remark = req.getParameter("remark");
			//图片名
			String photo = req.getParameter("photo");
			//添加值
			int code = MenuService.insert(name,price,mtype,remark,photo);
			session = req.getSession();
			if(code == 1){
				//获取总页数,把总页数传递给分页查询的当前页
				String pageNow = req.getParameter("pageNow");
				session.setAttribute("menuAdd", "yes");
				resp.sendRedirect("menuFindByPage?pageNow="+pageNow);
			}else{
				//添加失败时
				session.setAttribute("menuAdd", "no");
				req.getRequestDispatcher("WEB-INF/views/menu/menuAdd.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			//添加失败时
			session.setAttribute("menuAdd", "no");
			req.getRequestDispatcher("WEB-INF/views/menu/menuAdd.jsp").forward(req, resp);
		}
		
		
	}

	
}
