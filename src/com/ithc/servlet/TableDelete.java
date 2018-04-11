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

@WebServlet("/tableDelete")
public class TableDelete extends HttpServlet{
    private  TableService tableService=new TableServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //获取删除的id
		String tid=req.getParameter("id");
		int id=Integer.parseInt(tid);
		//获取删除数据的那一页
		String pageNow=req.getParameter("pageNow");
		boolean table=tableService.select(id);
		if(table){
			//说明可以删除
			int code =tableService.delete(id);
			if(code == 1 ){
				//删除成功，重新回到原页面
				resp.sendRedirect("tableFindByPage?pageNow="+pageNow);
			}
		}else{
			//不能删除
			HttpSession session=req.getSession();
			session.setAttribute("delete", "yes");
			//删除失败，重新回到原页面
			resp.sendRedirect("tableFindByPage?pageNow="+pageNow);
		}

	}

}
