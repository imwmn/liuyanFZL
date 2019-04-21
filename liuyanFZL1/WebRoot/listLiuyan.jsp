<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">


<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<s:debug />

</head>

<body>

	<table width="700" border="1">
		<tr>
			<td>留言编号</td>
			<td>留言用户姓名</td>
			<td>留言日期</td>
			<td>留言标题</td>
			<td>留言内容</td>
			<td>&nbsp</td>
			<td>&nbsp</td>
		</tr>
		<s:iterator value="#request.findAll" id="ly">
			<tr>
				<td><s:property value="#ly.id" /></td>
				<td><s:property value="#ly.user.userName" /></td>
				<td><s:property value="#ly.lyDate" /></td>
				<td><s:property value="#ly.title" /></td>
				<td><s:property value="#ly.details" /></td>
				<td><a
					href="updateLiuyanView.action?updateLiuyanView.id=<s:property value="#ly.id"/>">修改</a></td>
				<td><a href="deleteLiuyan.action?deleteLiuyan.id=<s:property value="#ly.id"/>"   onClick=" if(confirm('确定删除该信息吗？'))
			        {return true;}
			else 
					{  return false;}
			      
		              " >删除</a></td>
	           </tr>
	     </s:iterator>
           </table>
  
  
  </body>
</html>
