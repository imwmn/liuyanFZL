<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-dojo-tags" prefix="sx"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<sx:head parseContent="true" />
<s:debug />


</head>

<body>

	<s:form action="updateLiuyan.action" method="post" theme="simple">
		<table width="500" border="1">
			<tr>
				<td>留言编号：</td>
				<td>&nbsp; <input name="id" value="<s:property value="#request.findByIdLiuyan.id"/>" 
				readonly>
			
				</td>
			</tr>
			<tr>
				<td>用户名称：</td>
				<td>&nbsp; <input name="username" value="<s:property value="#request.findByIdLiuyan.user.userName" />"readonly>
				</td>
			</tr>
			<tr>
				<td>留言标题：</td>
				<td>&nbsp; <input name="title" value="<s:property value="#request.findByIdLiuyan.title" />">
				</td>
			</tr>
			<tr>
				<td>留言内容：</td>
				<td>&nbsp; <input name="details" value="<s:property value="#request.findByIdLiuyan.details" />">
				</td>
			</tr>
			<tr>
				<td>留言时间：</td>
				<td>&nbsp; <input type="date" name="lyDate" value="<s:property value="#request.findByIdLiuyan.lyDate" />">

				</td>
			</tr>
			<tr>
				<td>&nbsp; <s:submit value="修改"></s:submit>
				</td>
				<td>&nbsp; <s:reset value="重置"></s:reset>
				</td>
			</tr>
		</table>
	</s:form>


</body>
</html>
