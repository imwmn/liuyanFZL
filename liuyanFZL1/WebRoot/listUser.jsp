<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>

<s:debug />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">



</head>

<table width="500" border="1">
	<tr>
		<td>用户编号</td>
		<td>用户名</td>
		<td>密码</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<s:iterator value="listUser" id="user">
		<tr>
			<td><s:property value="#user.id" /></td>
			<td><s:property value="#user.userName" /></td>
			<td><s:property value="#user.password" /></td>
			<td><a
				href="updateUserView.action?updateUserView.id=<s:property value="#user.id"/>
				">修改</a></td>
			<td><a
				href="deleteUser.action?deleteUser.id=<s:property value="#user.id"/>
				"
				onclick="if(confirm('确定删除该信息吗？'))
	          return true;
	   else 
	             return false;
	   
				">删除
			</a></td>
		</tr>
	</s:iterator>
</table>


<body>



</body>
</html>
