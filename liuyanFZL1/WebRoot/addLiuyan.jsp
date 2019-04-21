<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
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

<sx:head parseContent="true" />


</head>

<body>

	<s:form action="addLiuyan.action" method="post" theme="simple">
		<table width="500" border="1">
			<tr>
				<td>用户编号：</td>
				<td>&nbsp;<select name="userId" size="1">
						<s:iterator value="listUser_PK" id="uc">
							<option value="${uc.id}">${uc.userName}</option>
						</s:iterator>
				</select>

				</td>
			</tr>
			<tr>
				<td>留言标题：</td>

				<td>&nbsp; <input type="text" name="title"></input>
				</td>
			</tr>
			<tr>
				<td>留言内容：</td>
				<td>&nbsp; <input type="text" name="details"></input>
				</td>
			</tr>
			<tr>
				<td>留言时间：</td>
				<td>&nbsp; <input type="date" name="lydate"></input>

				</td>
			</tr>
			<tr>
				<td>&nbsp; <input type="submit" value="新增"></input>
				</td>
				<td>&nbsp; <input type="reset" value="重置"></input>
				</td>
			</tr>
		</table>

	</s:form>
</body>
</html>
