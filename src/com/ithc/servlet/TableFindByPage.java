package com.ithc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ithc.bean.Table;
import com.ithc.service.TableService;
import com.ithc.service.TableServiceImpl;
import com.ithc.util.PageBean;

@WebServlet("/tableFindByPage")
public class TableFindByPage extends HttpServlet{
	
	TableService tableService = new TableServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PageBean pageBean = new PageBean();
		//获取总记录数
		int count = tableService.findBySize();
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
		List<Table> list = tableService.findByPage(pagePresent);
		//把查询出来的值存入session
		HttpSession session = req.getSession();
		session.setAttribute("list", list);
		//存入当前页
		session.setAttribute("pNow", pagePresent);
		//获取总页数
		int pageTotal = pageBean.getPageTotal();
		//存入总页数
		session.setAttribute("totalPage", pageTotal);
		//转发WEB-INF/views/table/table.jsp
		req.getRequestDispatcher("WEB-INF/views/table/table.jsp").forward(req, resp);
	}
	
	

}
