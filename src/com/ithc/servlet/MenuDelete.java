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


@WebServlet("/menuDelete")
public class MenuDelete extends HttpServlet{
	private  MenuService menuService=new MenuServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
	//获取删除的id
		String tid=req.getParameter("id");
		int id=Integer.parseInt(tid);
		//获取删除数据的那一页
		String pageNow=req.getParameter("pageNow");
		
		boolean menu=menuService.select(id);
		if(menu){
			//说明可以删除
			int  code=menuService.delete(id);
			if(code ==1 ){	
				session.setAttribute("delete", "no");
				//删除成功，重新回到原页面
				resp.sendRedirect("menuFindByPage?pageNow="+pageNow);
				
			}
		}
		else{
				//不能删除
				
				session.setAttribute("delete", "yes");
				//删除失败，重新回到原页面
				resp.sendRedirect("menuFindByPage?pageNow="+pageNow);
			}		
		}

}
