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

@WebServlet("/tableInsert")
public class TableInsert   extends HttpServlet {
	TableService tableService=new  TableServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //获取添加桌子的人数
	String num=req.getParameter("num");
	//获取总页数
	String tPage=req.getParameter("pageNow");
	//添加一张桌子
	int code=tableService.insert(num);
	if(code ==1){
		HttpSession session=req.getSession();
		session.setAttribute("addtable", "yes");
		//添加成功之后重新查询
		resp.sendRedirect("tableFindByPage?pageNow="+tPage);
	 }
   }
}
