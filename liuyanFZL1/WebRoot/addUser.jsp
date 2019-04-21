<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
  </head>
  
  <body>
    <form action="addUser.action" method="post" >
       <table width="300" border="0" >
		<tr>
		   <td>用户名：</td>
		    <td><input type="text" name="username"></td>
		</tr>
		<tr>
		   <td>密码：</td>
		    <td><input type="password" name="password"></td>
		</tr>
		<tr>
		   <td><input type="submit" value="新增"></td>
		    <td><input type="reset" value="重置"></td>
		</tr>
		</table>
		
		</form>
  </body>
</html>
