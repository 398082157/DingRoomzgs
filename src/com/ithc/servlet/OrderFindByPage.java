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
import com.ithc.service.OrderService;
import com.ithc.util.PageBean;

@WebServlet("/orderFindByPage")
public class OrderFindByPage  extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//分页，设置两个值
				PageBean pageBean=new PageBean();
		       
		       //获取总记录数
		       int count =OrderService.findBySize();
		       //设置总记录数
		       pageBean.setPageCount(count);
		       //设置当前页
		       try {
					//从页面获取当前页
					String tid = req.getParameter("pageNow");
					int id = Integer.parseInt(tid);
					pageBean.setPagePresent(id);
				} catch (Exception e) {
				}
		     //获取当前页
		     		int pagePresent =  pageBean.getPagePresent();
		     		//去数据库分页查询
		     		List<Menu> list = OrderService.findByPage(pagePresent);
		     		//把查询出来的值存入session
		     		HttpSession session = req.getSession();
		     		session.setAttribute("list", list);
		     		//存入当前页
		     		session.setAttribute("pNow", pagePresent);
		     		System.out.println(pagePresent);
		     		//获取总页数
		     		int pageTotal = pageBean.getPageTotal();
		     		//存入总页数
		     		session.setAttribute("totalPage", pageTotal);
		     		//转发WEB-INF/views/table/table.jsp
		     		req.getRequestDispatcher("WEB-INF/views/menu/order.jsp").forward(req, resp);
		//req.getRequestDispatcher("WEB-INF/views/oder/order.jsp").forward(req, resp);
	}
}
