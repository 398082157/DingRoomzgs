package com.ithc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ithc.bean.Table;
import com.ithc.service.TableService;
import com.ithc.service.TableServiceImpl;
@WebServlet("/tableEdit")
public class TableEdit extends HttpServlet{
	private TableService tableService = new TableServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取编号
		String tid = req.getParameter("id");
		int id = Integer.parseInt(tid);
		//用编号去查询
		Table table  = tableService.findById(id);
		if(table != null){
			HttpSession session = req.getSession();
			session.setAttribute("table",table);
			req.getRequestDispatcher("WEB-INF/views/table/tableEdit.jsp").forward(req, resp);
		}
	}
}
