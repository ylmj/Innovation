<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 欢迎退出界面表头 -->
<%@ page import="com.basic.model.User" %>
<link rel="stylesheet" href="layui/css/layui.css" />
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<link rel="stylesheet" type="text/css" href="layui/css/modules/code.css"/>
<script type="text/javascript" src="js/StandardIndustrialClassificationCodes.js"></script>
<script type="text/javascript" src="layui/layui.js"></script>
<script type="text/javascript" src="layui/layui.all.js"></script>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<div style="color:red; text-align:right; border-bottom:1px solod #000;">
<!-- <script type="text/javascript" src="js/SimpleTree.js" ></script> -->
<!--     <link rel="stylesheet" type="text/css" href="css/SimpleTree.css"/> -->
<%
	//获取session中保存的用户
	User user= (User)session.getAttribute("loginUser") ;
%>
 欢迎[<%=user.getUsername() %>]使用该系统&nbsp;&nbsp;
 <a href="<%=request.getContextPath() %>/Logout.jsp">退出系统</a>&nbsp;&nbsp;
 
 
</div>