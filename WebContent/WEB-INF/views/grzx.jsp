<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<script src="${pageContext.request.contextPath }/js/jquery-1.7.2.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.js"></script>


<!-- Demo page code -->

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

	<%@ include file="/WEB-INF/views/pages.jsp" %>


	<!-- 内容 开始 -->
	<div class="content">

		<div class="header">

			<h1 class="page-title">个人中心</h1>
		</div>

		<ul class="breadcrumb">
				<!-- /DingRoom  点击这个主页回到登入时的显示页面，页面所有的请求都经过后台-->
			<li><a href="${pageContext.request.contextPath }/userIndex">主页</a> <span
				class="divider">/</span></li>
			<li class="active">个人中心</li>
		</ul>

		<div class="container-fluid">
			<div class="row-fluid">

				<form id="tab" action="${pageContext.request.contextPath }/userRefresh" method="post">
					<div class="btn-toolbar">
						<button class="btn btn-primary">
							<i class="icon-save"></i> 保存
						</button>
					</div>
					<div class="well">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#home" data-toggle="tab">基本资料</a></li>
							<li><a href="#profile" data-toggle="tab">密码更改</a></li>
						</ul>
						<div id="myTabContent" class="tab-content">
							<div class="tab-pane active in" id="home">
								<label>用户编号</label> 
								<input name="id" type="text" value="${user.id}" class="input-xlarge uneditable-input" onfocus="this.blur()"> 
								<label>用户名</label> 
								<input name="username" type="text" value="${user.username}" class="input-xlarge"> 
								<label>真实姓名</label> 
								<input name="name" type="text" value="${user.name}" class="input-xlarge"> 
								<label>性别</label> 
								<input name="gender" type="text" value="${user.gender}" class="input-xlarge"> 
								<label>权限</label> 
								<input name="permission" type="text" value="${user.permission}" class="input-xlarge"> 
								<label>备注</label> 
								<input name="remark" type="text" value="${user.remark}" class="input-xlarge">
				</form>
				${up }
			</div>
			<div class="tab-pane fade" id="profile">
				<form id="tab2" action="${pageContext.request.contextPath }/userUpdatePassword"
					method="post">
					<input type="hidden" name="id" value="${user.id}">
					<%-- <input type="hidden" name="username" value="${user.username}">
					<input type="hidden" name="name" value="${user.name}">
					<input type="hidden" name="gender" value="${user.gender}">
					<input type="hidden" name="permission" value="${user.permission}">
					<input type="hidden" name="remark" value="${user.remark}"> --%>
					<label>新密码</label> <input name="password" type="password"
						class="input-xlarge">
					<div>
						<button class="btn btn-primary">更改</button>
					</div>
				</form>
			</div>
		</div>

	</div>

	<footer>
	<hr>
	<p class="pull-right">
		&copy; 2013.8 <a href="http://www.52itstyle.com" target="_blank">
			shun_fzll</a>
	</p>
	</footer>

	</div>
	</div>
	</div>
	<script type="text/javascript">
		$("[rel=tooltip]").tooltip();
		$(function() {
			$('.demo-cancel-click').click(function() {
				return false;
			});
		});
	</script>
	
	<%
		session.removeAttribute("up");
	%>
	
</body>
</html>
