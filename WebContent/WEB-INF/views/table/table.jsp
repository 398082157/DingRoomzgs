<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
  <head>
    <title>科帮网无线点餐后台</title>
    
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/font-awesome/css/font-awesome.css">
    

	<script src="${pageContext.request.contextPath }/js/jquery-1.9.1.min.js"></script>
    <script src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.js"></script>
   
    <link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap-switch.css" />
    <script src="${pageContext.request.contextPath }/bootstrap/js/bootstrap-switch.js"></script>


    <!-- Demo page code -->

    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
    </style>

    
  </head>
  <body class=""> 
  <!--<![endif]-->
    
       <%@ include file="/WEB-INF/views/pages.jsp" %>
    
    <!-- 内容 开始 -->
 <div class="content">
        
        <!-- 提示框1 -->
					 	<div id="myModal" class="modal hide fade">
					  <div class="modal-header">
					    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					    <h3>警告</h3>
					  </div>
					  <div  class="modal-body">
					    <p>你确定要删除吗？</p>
					  </div>
					  <div class="modal-footer">
								<a href="#" class="btn"  data-dismiss="modal" aria-hidden="true">关闭</a>
    							<a id="delbtn2"  href="${pageContext.request.contextPath}/tableDelete?pageNow=${pNow }&id="+delid class="btn btn-primary"> 确  认</a>
					  </div>
					</div>
       	 <!-- 提示框2 -->
					 	<div id="addModal" class="modal hide fade">
					  <div class="modal-header">
					    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					    <h3>请输入桌子最大容纳人数：</h3>
					  </div>
					  <div  class="modal-body">
					  <form action="${pageContext.request.contextPath }/tableInsert" method="Get">
					    <input type="text" name="num"  class="input-block-level">
					    <!--添加人数的时候传递总页数  -->
					    <input type="hidden" name="pageNow" value="${totalPage }">
					  </div>
					  <div class="modal-footer">
								<a href="#" class="btn"  data-dismiss="modal" aria-hidden="true">取 消</a>
    							<button type="submit" class="btn btn-primary">添 加</button>
					  </div>
					    </form>
					</div>
          
        <div class="header">
            
            <h1 class="page-title">餐桌</h1>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="${pageContext.request.contextPath }/tableFindByPage">餐桌</a> <span class="divider">/</span></li>
            <li class="active">餐桌查询</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
        <div class="row-fluid">
<div class="btn-toolbar">
	<a href="#addModal" role="button" class="btn btn-primary" data-toggle="modal">
	<i class="icon-plus"></i> 添 加</a>
  <div class="btn-group">
  </div>
</div>
 <c:if test="${addtable=='yes'}">

    <div class="alert alert-info">
        <button type="button" class="close" data-dismiss="alert">×</button>
        <strong>小提示：</strong> 添加成功!!!
    </div>
        </c:if> 
 <c:if test="${delete=='yes'}">

    <div class="alert alert-info">
        <button type="button" class="close" data-dismiss="alert">×</button>
        <strong>小提示：</strong> 与此项有关的数据未清除干净!!!
    </div>
        </c:if> 
</div>
<div class="well">
    <table class="table table-striped table-bordered bootstrap-datatable datatable">
      <thead>
        <tr>
          <th>桌号</th>
          <th>订单号</th>
          <th>人数</th>
          <th>描述</th>
          <th>餐桌状态</th>
          <th>操作</th>
          <th style="width: 26px;"></th>
        </tr>
      </thead>
      <tbody>
      <c:forEach items="${list}" var="tbl">
        <tr>
          <td>${tbl.id}</td>
          <td>${tbl.ord_id}</td>
          <td>${tbl.num}</td>
          <td>${tbl.description}</td>
          <td>
          		<c:if test="${tbl.flag==1}">
            	<div id="${tbl.id}"  class="make-switch" data-on-label="空闲" data-off-label="满座" >
            	 <input  type="checkbox" checked ">
          		 </div>
             	</c:if>
             	<c:if test="${tbl.flag==0}">
            	<div id="${tbl.id}"  class="make-switch" data-on-label="空闲" data-off-label="满座" >
             	<input type="checkbox" >
           		</div>
            	 </c:if>
          </td>
          <td>
               <a  class="btn btn-info" href="${pageContext.request.contextPath }/tableEdit?id=${tbl.id}"><i class="icon-edit icon-white"></i>修改</a>
              <!-- <form action="/SSMPropertys/delete.do" method="Get">
               -->
               <button  onclick="del(this)"  delid="${tbl.id}" pNow="${pNow}" class="btn btn-danger"><i class="icon-trash icon-white"></i> 删除</button>
               <!-- </form>
              pNow="${pNow}"
               -->
       </td>  
        </tr>
        </c:forEach>
      </tbody>
    </table>
</div>
 <div class="pagination">
    <ul>
    	<c:if test="${pNow > 1}">
        <li><a href="${pageContext.request.contextPath }/tableFindByPage?pageNow=${pNow-1}">前一页</a></li>
    	</c:if>
        <c:forEach var="i" begin="1" end="${totalPage}">
        <li>
        <a href="${pageContext.request.contextPath }/tableFindByPage?pageNow=${i }">${i }</a>
        </li>
        </c:forEach>
        <c:if test="${pNow < totalPage}">
        <li><a href="${pageContext.request.contextPath }/tableFindByPage?pageNow=${pNow+1}">后一页</a></li>
        </c:if>
    </ul>
</div>            
                  <footer>
                        <hr>
                        <p class="pull-right">&copy; 2013.8 <a href="#" target="_blank"> shun_fzll</a></p>
                    </footer>
            </div>
        </div>
    </div>
                    
                    

    <script type="text/javascript">

/*
$(document).ready(function(){
 $("#delbtn").click(function(){
    var delid=$("#delbtn").attr("delid");
    $("#myModal").modal("show").on("shown", function () {
    	var delurl="/SSMPropertys/TableServlet?delid="+delid;
    		$("#delbtn2").attr('href',delurl);
    	});
  });
  
});
  */
  
      var 	xmlhttp;
        $('.make-switch').on('switch-change', function (e, data){
	//创建xmlHttp  
	createXMLHttpRequest();

	var url="/ServletProJect/TableServlet?tid="+$(this).attr('id');
	
	xmlhttp.onreadystatechange=state_Change;  
	xmlhttp.open("POST",url,true);  
	xmlhttp.send(null);  
	})


function createXMLHttpRequest() {
	if (window.XMLHttpRequest)
	  {// code for IE7, Firefox, Opera, etc.
	  xmlhttp=new XMLHttpRequest();
	  }
	else if (window.ActiveXObject)
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
}

//处理返回结果
function state_Change()  
{  
 if(xmlhttp.readyState==4)  
 {  
  if(xmlhttp.status==200)  
  {  
	  
  }  
 }  
}
  
  
  
function del(obj){
	var delid=$(obj).attr("delid");
	var pNow=$(obj).attr("pNow");
	var delurl="${pageContext.request.contextPath}/tableDelete?pageNow=${pNow }&id="+delid;
	$("#myModal").modal("show").on("shown", function () {
		$("#delbtn2").attr('href',delurl);
	});
}


    </script>
    
    <%
    	/* 页面刷新，清除提示xin'xi */
    	session.removeAttribute("delete");
    	session.removeAttribute("addtable");
    %>
    
  </body>
</html>
