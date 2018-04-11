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


@WebServlet("/menuUpdatesave")
public class MenuUpdateSave extends HttpServlet{
	private MenuService menuService=new MenuServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pic;
		//编号
		String mid=req.getParameter("id");
		int id=Integer.parseInt(mid);
		//菜名
		String name = req.getParameter("name");
		//价格
		String price = req.getParameter("price");
		//外键值
		String mtypeId = req.getParameter("typeId");
		//备注
		String remark = req.getParameter("remark");
		//图片名
		String photo = req.getParameter("photo");
		
		String img = req.getParameter("pic");
		if(photo==""){
			pic=img;
		}else{
			pic=photo;
		}
		
		//修改值
		int code = menuService.update(id,name,price,mtypeId,remark,pic);
	//	System.out.println(code);
//		System.out.println(id);
//		System.out.println(name);
//		System.out.println(price);
//		System.out.println(mtypeId);
//		System.out.println(remark);
//		System.out.println(photo);
	//	System.out.println(tid);
		HttpSession session = req.getSession();
		session = req.getSession();
		if(code == 1){
			//获取总页数,把总页数传递给分页查询的当前页
			String pageNow = req.getParameter("pageNow");
			//session.setAttribute("updMenu", "yes");
			resp.sendRedirect("menuFindByPage?pageNow="+pageNow);
		}
	}

}
