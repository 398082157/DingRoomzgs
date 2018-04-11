<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
  <head>
    <title>无线点餐后台</title>
    
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap-select.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/font-awesome/css/font-awesome.css">
    

	<script src="${pageContext.request.contextPath }/js/jquery-1.9.1.min.js"></script>
    <script src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath }/bootstrap/js/bootstrap-select.js"></script>
    <script src="${pageContext.request.contextPath }/bootstrap/js/bootstrap-file-input.js"></script>
   
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
    
       <%@ include file="/WEB-INF/views/pages.jsp"%>
    
    <!-- 内容 开始 -->
<div class="content">
        
        <div class="header">
            <h1 class="page-title">菜谱</h1>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="${pageContext.request.contextPath }/menuFindByPage">主页</a> <span class="divider">/</span></li>
            <li class="active">菜谱</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
            <div class="page-header" ></div> 
            <div class="row-fluid">
            <div class="span1"></div>
            	<div class="span5">
					<h1>${model.name}</h1>
					<img src="${pageContext.request.contextPath }/images/${model.pic}" alt="" width="220" height="170">	
               </div>
               <div class="span6">  	
					<h2>
					<span class="label"> 价 格 : </span> 
					<span class="label label-success" >  ${model.price}</span>
					</h2>
					<h2>
					<span class="label"> 类 型 : </span>
					<span class="label label-success">${model.menuType.name }</span>
					</h2>
					
					<%-- <select id="mySelect" name="menuType.id"  class="selectpicker show-tick"  data-size="4"  disabled>
						<c:forEach items="${menutypelist}" var="mtt">
						<c:if test="${menu.menutypetbl.id==mtt.id}">
						<option  value="${mtt.id}"  selected="selected">${mtt.name}</option>
						</c:if>
  						<c:if test="${menu.menutypetbl.id!=mtt.id}">
						<option  value="${mtt.id}"  >${mtt.name}</option>
						</c:if>
  						</c:forEach>
					</select> --%>
					<h2>
					<span class="label"> 备 注 : </span> 
					</h2>
					<p class="text-success">${model.remark}</p>
				
					
               </div>
			
               </div>
               <div class="form-actions">
								
								<a href="${pageContext.request.contextPath }/menuFindByPage?pageNow=${pNow}">
								<input type="button" class="btn" value="返  回">
							  </a>
				</div>

			<footer>
			<hr>
			<p class="pull-right">
				&copy; 2013.8 <a href="#" target="_blank"> shun_fzll</a>
			</p>
			</footer>
            </div>
        </div>
    </div>




			<script type="text/javascript">
			$('.selectpicker').selectpicker({
			      style: 'btn-info',
			      size: 4
			  });
			  
			$(document).ready(function(){ 
			$('#mySelect').change(function(){ 
			//alert($(this).children('option:selected').val()); 
			var p1=$(this).children('option:selected').val();//这就是selected的值 
			//改变隐藏域中的值
			$('#menutype').val(p1);
			//var p2=$('#menutype').val();
			//alert(p2)
			}) 
			}) 	
			$('input[type=file]').bootstrapFileInput();
		$('.file-inputs').bootstrapFileInput();		
			</script>
  </body>
</html>
