<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'left.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <table width="200" border="0">
		<tr>
	<td><a href="addUserView.action" target="right">新增用户</a></td>
</tr><tr>
<td><a href="listUser.action" target="right">查看所有用户</a></td></tr>
<tr>
<td><a href="addLiuyanView.action" target="right">新增留言</a></td>
</tr>
<tr>
	<td><a href="listLiuyan.action" target="right">查看所有留言</a></td>
</tr><tr>
<td><a href="#" target="right">登录</a></td>
</tr>
</table>

  </body>
</html>
