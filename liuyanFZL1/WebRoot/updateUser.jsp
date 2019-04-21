<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<s:debug/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">



</head>

<body>

	<s:form action="updateUser.action" method="post" theme="simple">
		<table width="400" border="1">
			<tr>
				<td>用户编号：</td>
				<td><input value="<s:property value="#request.updateUserView.id" />" readonly="readonly" name="userID"/></td>
			</tr>
			<tr>
				<td>用户姓名：</td>
				<td><input type="text" value="<s:property value="#request.updateUserView.userName" />" name="updateUserName"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="text" value="<s:property value="#request.updateUserView.password" />" name="updatePassword"></td>
			</tr>
			<tr>
				<td>&nbsp; <s:submit value="修改"></s:submit></td>
				<td>&nbsp; <s:reset value="重置"></s:reset></td>
			</tr>
		</table>
	</s:form>


</body>
</html>
