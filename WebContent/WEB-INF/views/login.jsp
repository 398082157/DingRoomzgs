<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>无线点餐 后台登陆</title>
	
    
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/font-awesome/css/font-awesome.css">

	<script src="${pageContext.request.contextPath }/js/jquery-1.7.2.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.js"></script>
   
	<style type="text/css">
  

      .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color:  #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }
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
    <script type="text/javascript">
  	//防止页面后退
 	history.pushState(null, null, document.URL);
	window.addEventListener('popstate', function () {
 	 history.pushState(null, null, document.URL);
	});
/* window.history.back(1); */
/* self.location='login.jsp';  */

    </script>
	

  </head>
  
  <body class="">
    <div class="navbar">
        <div class="navbar-inner">
                <ul class="nav pull-right">
                    
                </ul>
                <a class="brand" href="index.jsp"><span class="first">无线点餐</span> <span class="second">系统</span></a>
        </div>
    </div>
    <div class="container" style="margin-top:100px">
      <form class="form-signin" action="${pageContext.request.contextPath }/userLogin" method="post">
         <div class="page-header">
          <h2>无线点餐系统</h2>
        </div>
        ${msg  }
        <input type="text" class="input-block-level" placeholder="用户名"  name="username">
        <input type="password" class="input-block-level" placeholder="密码"  name="password">
        <input type="text" class="input-block" placeholder="请输入验证码" name="codeName">
       <img id="vId" onclick="this.src='${pageContext.request.contextPath }/vCode?id='+Math.random()" alt="" src="${pageContext.request.contextPath }/vCode">
        <button class="btn  btn-primary" type="submit">登陆</button>
      </form>
         <hr>
            <p class="pull-right">&copy; 2017.10 <a href="#" target="_blank"> eat</a></p>
        </footer>
	<%-- <jsp:forward page="/WEB-INF/views/order/order.jsp"></jsp:forward> --%>
	<%-- <jsp:forward page="/WEB-INF/views/order/orderPre.jsp"></jsp:forward> --%>
    </div> 
    
    <%
    	session.removeAttribute("msg");
    %>
    
    
  </body>
</html>
