package com.ithc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ithc.service.TableService;
import com.ithc.service.TableServiceImpl;
@WebServlet("/tableUpdate")
public class TableUpdate extends HttpServlet {

	private TableService tableService=new TableServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String tid = req.getParameter("id");
		int id = Integer.parseInt(tid);
		String toid = req.getParameter("ord_id");
		int oid = Integer.parseInt(toid);
		String num = req.getParameter("num");
		String flag = req.getParameter("flag");
		String description = req.getParameter("description");
		//根据id去修改其余的几项值
		int code = tableService.update(id,oid,num,flag,description);
		if(code == 1){
			//修改成功
			resp.sendRedirect("tableEdit?id="+id);
		}
	}
	
	
	
	

}
