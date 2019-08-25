<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% request.setAttribute("path", request.getContextPath());%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆界面</title>
</head>
<body>
	<form action="${path }/user/login.action" method="post">
		<table align="center">
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="userName" /></td>
				<td></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password" /></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="登陆" /> <input type="reset"
					value="重置" /></td>
				<td></td>
			</tr>
		</table>
	</form>
</body>
</html>