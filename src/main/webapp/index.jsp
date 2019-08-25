<!-- 注:web.xml的web-app_2_4.xsd默认isELIgnored="false" 但之前的版本isELIgnored="true"  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% request.setAttribute("path", request.getContextPath());%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
	window.onload= function(){
		var list = "${list }";
		if(list == ""){
			document.getElementById('queryUser3').submit();
		} 
	};
	//请求json,返回json 
	function requestJson(){
		//将key-value的形式转换成json格式的字符串
		var user = JSON.stringify({
			userNo:520,
			userName:'雷瑞铧',
			userSex:1,
			userAge:18,	
			userPhone:'13133830879',	
			userQQ:'875962087'		
		});
		$.ajax({
			url:"${path }/user/requestJson.action",
			data:user,
			type:"post",
			contentType:"application/json;charset=UTF-8",//当传递json数据的时候配置此参数
			dataType:"json",
			success:function(data){
				console.log(data);
			}
		});
	}
	//请求key-value,返回json
	function requestKeyValue(){
		//将key-value的形式转换成json格式
		var user = {
			userNo:520,
			userName:'雷瑞铧',
			userSex:1,
			userAge:18,	
			userPhone:'13133830879',	
			userQQ:'875962087'		
		};
		$.ajax({
			url:"${path }/user/requestKeyValue.action",
			data:user,
			type:"post",
			contentType:'application/x-www-form-urlencoded; charset=utf-8',//默认的类型
			dataType:"json",
			success:function(data){
				console.log(data);
			}
		});
	}
</script>
<body>
	<form id="queryUser3" action="${path }/user/queryUser3.action"
		method="post">
		<table align="center">
			<tr>
				<td>姓名:<input type="text" name="userName" /></td>
				<td><input type="submit" value="查询" /></td>
			</tr>
		</table>
	</form>
	<h3 align="center">用户列表</h3>
	<form action="${path }/user/deleteUserByManyUserNo.action"
		method="post">
		<table align="center" style="width: 70%; text-align: center;">
			<thead>
				<tr>
					<th>选择</th>
					<th>序号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>年龄</th>
					<th>手机号码</th>
					<th>QQ号</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="list">
					<tr>
						<td>
							<input type="checkbox" name="userNoArray"
							value="${list.userNo }">
						</td>
						<td>${list.userNo }</td>
						<td>${list.userName }</td>
						<c:choose>
							<c:when test="${list.userSex == 1}">
								<td>男</td>
							</c:when>
							<c:otherwise>
								<td>女</td>
							</c:otherwise>
						</c:choose>
						<td>${list.userAge }</td>
						<td>${list.userPhone }</td>
						<td>${list.userQQ }</td>
						<td>
							<a href="${path }/user/queryUser4.action?muser.userNo=${list.userNo }">修改</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="8"><input type="submit" value="批量删除"></td>
				</tr>
			</tfoot>
		</table>
	</form>

	<hr />
	<!-- ********************************************************************** -->
	<div style="width: 50%; float: left">
		<h3 align="center">修改用户</h3>
		<form id="updateUser" action="${path }/user/updateUser.action"
			method="post">
			<input type="hidden" name="nowDate" value="2018-9-9 9:9:9"> <input
				type="hidden" name="userNo" value="${user.userNo }">
			<table align="center">
				<tr>
					<td>姓&nbsp;&nbsp;名:</td>
					<td><input type="text" name="userName"
						value="${user.userName }"></td>
				</tr>
				<tr>
					<td>性&nbsp;&nbsp;别:</td>
					<td><c:if test="${user.userSex == 1}">
							<input type="radio" value="1" name="userSex" checked="checked">男
						<input type="radio" value="2" name="userSex">女
					</c:if> <c:if test="${user.userSex == 2}">
							<input type="radio" value="1" name="userSex">男
						<input type="radio" value="2" name="userSex" checked="checked">女
					</c:if> <c:if test="${user.userSex == null}">
							<input type="radio" value="1" name="userSex" checked="checked">男
						<input type="radio" value="2" name="userSex">女
					</c:if></td>
				</tr>
				<tr>
					<td>年&nbsp;&nbsp;龄:</td>
					<td><input type="text" name="userAge" value="${user.userAge }"
						maxlength="3"></td>
				</tr>
				<tr>
					<td>手机号码:</td>
					<td><input type="text" name="userPhone"
						value="${user.userPhone }" maxlength="11"></td>
				</tr>
				<tr>
					<td>QQ&nbsp;&nbsp;号:</td>
					<td><input type="text" name="userQQ" value="${user.userQQ }"
						maxlength="15"></td>
				</tr>
				<tfoot>
					<tr>
						<td></td>
						<td><input type="submit" value="提交" /> <input type="reset"
							value="重置" /></td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
	<h3 align="center">增加用户</h3>
	<form action="${path }/user/insertUser.action" method="post">
		<table align="center">
			<tr>
				<td>姓&nbsp;&nbsp;名:</td>
				<td><input type="text" name="userName"></td>
			</tr>
			<tr>
				<td>性&nbsp;&nbsp;别:</td>
				<td><input type="radio" value="1" name="userSex"
					checked="checked">男 <input type="radio" value="2"
					name="userSex">女</td>
			</tr>
			<tr>
				<td>年&nbsp;&nbsp;龄:</td>
				<td><input type="text" name="userAge"></td>
			</tr>
			<tr>
				<td>手机号码:</td>
				<td><input type="text" name="userPhone"></td>
			</tr>
			<tr>
				<td>QQ&nbsp;&nbsp;号:</td>
				<td><input type="text" name="userQQ"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="提交" /> <input type="reset"
					value="重置" /></td>
			</tr>
		</table>
	</form>


	<hr>
	<!-- ******************************************************************* -->

	<h3 align="center">批量增加用户</h3>
	<form action="${path }/user/insertManyUser.action" method="post">
		<table align="center" style="width: 60%; text-align: center;">
			<tr>
				<th>行数</th>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>手机号码</th>
				<th>QQ号</th>
			</tr>
			<c:forEach begin="0" end="1" var="i">
				<tr>
					<td>${i+1 }</td>
					<td><input type="text" name="muserList[${i }].userName"
						value="${muserList[i].userName }" size="10px" /></td>
					<td><select name="muserList[${i }].userSex">
							<option value="1" selected="selected">男</option>
							<option value="2">女</option>
					</select></td>
					<td><input type="text" name="muserList[${i }].userAge"
						value="${muserList[i].userAge }" size="10px" /></td>
					<td><input type="text" name="muserList[${i }].userPhone"
						value="${muserList[i].userPhone }" size="10px" /></td>
					<td><input type="text" name="muserList[${i }].userQQ"
						value="${muserList[i].userQQ }" size="10px" /></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="6"><input type="submit" value="批量增加" /></td>
			</tr>
		</table>
	</form>
	<hr>
	<!-- ******************************************************************* -->
	<h3 align="center">上传文件</h3>
	<form action="${path }/user/fileUpload.action" method="post"
		enctype="multipart/form-data">
		<table align="center">
			<tr>
				<td><input type="file" name="file" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="上传图片" /></td>
			</tr>
			<tr>
				<td>
					<c:if test="${imageURL != null}">
						<img src="/image/${imageURL }" width="300px" height="400px">
					</c:if>
				</td>
			</tr>
		</table>
	</form>
	<hr>
	<!-- ******************************************************************* -->
	<h3 align="center">测试Json交互</h3>
	<form action="${path }/user/restful/1" method="post">
		<table align="center">
			<tr>
				<td>
					<input type="button" onclick="requestJson();" value="Json串测试"> 
					<input type="button" onclick="requestKeyValue();" value="key-value测试"> 
					<input type="submit" value="restful的支持测试">
				</td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript" src="${path }/js/jquery-1.7.1.js"></script>
</html>
