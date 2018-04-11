<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="navbar">
		<div class="navbar-inner">
			<ul class="nav pull-right">

				<li><a href="#"
					class="hidden-phone visible-tablet visible-desktop" role="button">设置</a></li>
				<li id="fat-menu" class="dropdown"><a href="#" role="button"
					class="dropdown-toggle" data-toggle="dropdown"> <i
						class="icon-user"></i>${user.name} <i class="icon-caret-down"></i>
				</a>

					<ul class="dropdown-menu">
						<li><a tabindex="-1" href="${pageContext.request.contextPath }/userGrzx?id=${user.id}">个人中心</a></li>
						<li class="divider"></li>
						<!-- 点击退出重新登入 -->
						<li><a tabindex="-1" href="${pageContext.request.contextPath }/userExit">退出</a></li>
					</ul></li>

			</ul>
			<a class="brand" href="${pageContext.request.contextPath }/userAction_indexs.action"><span
				class="first">无线点餐</span> <span class="second">后台</span></a>
		</div>
	</div>




	<div class="sidebar-nav">
		<form class="search form-inline">
			<input type="text" placeholder="Search...">
		</form>

		<a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i
			class="icon-dashboard"></i>首页</a>
		<ul id="dashboard-menu" class="nav nav-list collapse in">
			<li><a href="${pageContext.request.contextPath }/userIndex">报表</a></li>
			<li><a href="${pageContext.request.contextPath }/userGrzx?id=${user.id}">个人中心</a></li>
		</ul>

		<a href="#table-menu" class="nav-header" data-toggle="collapse"><i
			class="icon-table"></i>餐桌 </a>
		<ul id="table-menu" class="nav nav-list collapse">
			<li><a href="${pageContext.request.contextPath }/tableFindByPage">餐桌管理</a></li>
		</ul>

		<a href="#menu-menu" class="nav-header collapsed"
			data-toggle="collapse"><i class="icon-reorder"></i>菜谱 </a>
		<ul id="menu-menu" class="nav nav-list collapse">
			<li><a href="${pageContext.request.contextPath}/menuFindByPage">菜谱管理</a></li>
		</ul>

		<a href="#order-menu" class="nav-header" data-toggle="collapse"><i
			class="icon-th-large"></i>订单</a>
		<ul id="order-menu" class="nav nav-list collapse">
			<li><a href="${pageContext.request.contextPath}/orderFindByPage">订单管理</a></li>
		</ul>
	</div>
