<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<title>无线点餐后台</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/theme.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/font-awesome/css/font-awesome.css">


<script src="${pageContext.request.contextPath }/js/jquery-1.9.1.min.js"></script>
<script
	src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.js"></script>

<link rel="stylesheet"
	href="${pageContext.request.contextPath }/bootstrap/css/bootstrap-switch.css" />
<script
	src="${pageContext.request.contextPath }/bootstrap/js/bootstrap-switch.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath }/bootstrap/js/jquery-3.1.0.min.js"></script>
<!-- Demo page code -->
<script type="text/javascript">
	$(function() {
		var url = "${pageContext.request.contextPath }/menuTypeAction_findAll.action";
		$.post(url, function(data) {
			
		});
	});
</script>
<style type="text/css">
#line-chart {
	height: 300px;
	width: 800px;
	margin: 0px auto;
	margin-top: 1em;
}

.brand {
	font-family: georgia, serif;
}

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
		<div id="myModal" class="modal hide fade">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h3>警告</h3>
			</div>
			<div class="modal-body">
				<p>你确定要删除吗？</p>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn" data-dismiss="modal" aria-hidden="true">关闭</a>
				<a id="delbtn2" href="${pageContext.request.contextPath}/menuDelete?pageNow=${pNow }&id="+delid class="btn btn-primary"> 确 认</a>
			</div>
		</div>
		<div class="header">
			<h1 class="page-title">菜谱</h1>
		</div>

		<ul class="breadcrumb">
			<li><a
				href="${pageContext.request.contextPath }/menuFindByPage">主页</a>
				<span class="divider">/</span></li>
			<li class="active">菜谱</li>
		</ul>

		<div class="container-fluid">
			<div class="row-fluid">
				<div class="row-fluid">
					<div class="btn-toolbar">
						<a href="${pageContext.request.contextPath }/menuAdd" role="button"
							class="btn btn-primary" data-toggle="modal"> <i
							class="icon-plus"></i> 添 加
						</a>
						<div class="btn-group"></div>
					</div>
					<c:if test="${menuAdd=='yes'}">
						<div class="alert alert-info">
							<button type="button" class="close" data-dismiss="alert">×</button>
							<strong>小提示：</strong> 添加成功！！
						</div>
					</c:if>
					
					<c:if test="${delete=='yes'}">
						<div class="alert alert-info">
							<button type="button" class="close" data-dismiss="alert">×</button>
							<strong>小提示：</strong>不能删除！
						</div>
					</c:if>
					
					<c:if test="${delete=='no'}">
						<div class="alert alert-info">
							<button type="button" class="close" data-dismiss="alert">×</button>
							<strong>小提示：</strong>删除成功！
						</div>
					</c:if>
					

				</div>

				<div class="well">
					<ul class="thumbnails">
						<div class="row-fluid">
							<c:forEach items="${list}" var="menu">

								<li class="span3">
									<div class="thumbnail">
										<img
											src="${pageContext.request.contextPath }/images/${menu.pic}"
											alt="" width="220" height="170">
										<h3>${menu.name}</h3>
										<a
											href="${pageContext.request.contextPath }/menuPre?id=${menu.id}"
											class="btn btn-primary"> 预 览</a> <a class="btn btn-info"
											href="${pageContext.request.contextPath }/menuUpdate?id=${menu.id}">
											<i class="icon-edit icon-white"></i>修改
										</a>
										<button onclick="del(this)" delid="${menu.id}" pNow="${pNow}"
											class="btn btn-danger">
											<i class="icon-trash icon-white"></i> 删除
										</button>

									</div>
								</li>
							</c:forEach>
						</div>
						<div class="page-header"></div>
						<div class="row-fluid">
							<%-- <c:forEach items="${page.beanList}" var="menu" begin="4"  end="8">
                                    
                        <li class="span3">
                            <div class="thumbnail">
                                <img src="${pageContext.request.contextPath }/images/${menu.pic}" alt="" width="220" height="170">
                                <h3>${menu.name}</h3>                             
                                <a href="#" class="btn btn-primary"> 预 览</a>
                                <a  class="btn btn-info" href="/SSMPropertys/update.do?&id=${menu.id}">
                                <i class="icon-edit icon-white"></i>修改
                                </a>
              					<button  onclick="del(this)"  delid="${menu.id}" pNow="${pNow}" class="btn btn-danger">
              					<i class="icon-trash icon-white"></i> 删除
              					</button>
                     
                            </div>
                        </li>
                        </c:forEach> --%>
						</div>
					</ul>
				</div>
				<div class="pagination">
					<ul>
						<c:if test="${pNow > 1}">
							<li><a
								href="${pageContext.request.contextPath}/menuFindByPage?pageNow=${pNow-1}">前一页</a></li>
						</c:if>
						<c:forEach var="i" begin="1" end="${totalPage}">
							<li><a
								href="${pageContext.request.contextPath}/menuFindByPage?pageNow=${i }">${i }</a>
							</li>
						</c:forEach>
						<c:if test="${pNow < totalPage}">
							<li><a
								href="${pageContext.request.contextPath}/menuFindByPage?pageNow=${pNow+1}">后一页</a></li>
						</c:if>
					</ul>
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
		function del(obj) {
			var delid = $(obj).attr("delid");
			var pNow = $(obj).attr("pNow");
			var delurl = "${pageContext.request.contextPath}/menuDelete?pageNow=${pNow }&id=" + delid;
			$("#myModal").modal("show").on("shown", function() {
				$("#delbtn2").attr('href', delurl);
			});
		}
	</script>
	
	<%
	    session.removeAttribute("menuAdd");
		session.removeAttribute("delete");
	%>
</body>
</html>
