<%@page import="com.basic.dao.DeanDao"%>
<%@page import="com.basic.model.Dean"%>
<%@page import="com.basic.model.User" %>
<%@page import="java.util.List"%>
<%@page import="com.basic.util.Pager" %>
<%@page import="com.basic.model.Platform" %>
<%@page import="com.basic.dao.UserDao" %>
<%@page import="com.basic.dao.PlatformDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>平台院长展示页面</title>
<style type="text/css">
	a:link{
		color:#0cc;
		text-decoration: none;
	}
	a:visited{
		color:#0cc;
		text-decoration: underline;
	}
	a:hover{
		color:#c00;
		text-decoration: none;
		position: relative;
		top:1px;
		left:1px;
	}
	a:active{
		color:#00f;
		text-decoration: none;
	}
</style>
</head>
<%
//筛选
	String content = request.getParameter("content");
	if(content == null || "".equals(content)){
		content = "";
	}
	DeanDao deanDao = new DeanDao();
	Pager pager=deanDao.load(content);
	//获得pager中保存的list集合
	List<Dean> deans = pager.getDatas();
	//获取登录用户
	User loginuser = (User)session.getAttribute("loginUser");
%>
<body>
	<jsp:include page="inc.jsp" >
		<jsp:param name="op" value="平台主任查询" />
	</jsp:include>
	<table class="layui-table tab middle_self">
		<tr>
			<form action="AdminDean.jsp" method="post">
				<td colspan="10">
					请输入平台院长（dean）查询: &nbsp;
					<input type="text" name="content" size="70" class="tb_input" /> &nbsp;
					</td>
					<td>
					<input type="submit" value="搜索" style="text-align: center;" class="layui-btn layui-btn-lg layui-btn-normal"/>
				</td>
			</form>
		</tr>
		
		<tr>
			<td>平台主任编号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>出生年月</td>
			<td>职称</td>
			<td>学历</td>
			<td>学位</td>
			<td>电话</td>
			<td>手机号码</td>
			<td>电子邮箱</td>
			
		</tr>
		<%
			for( Dean dean: deans ){
		%>
		<tr>
			<td> <a href="AdminFind.jsp?deanId=<%=dean.getId() %>"><%=dean.getId() %></a></td>
			<td> <%=dean.getName() %></td>
			<td> <%=dean.getSex()%></td>
			<td> <%=dean.getDate() %></td>
			<td> <%=dean.getMajor()%></td>
			<td> <%=dean.getEducation()%></td>
			<td> <%=dean.getDegree() %></td>
			<td> <%=dean.getTelephone() %></td>
			<td> <%=dean.getMobilephone() %></td>
			<td><%=dean.getEmail() %></td>
			
			
		</tr>
		<%
			}
		%>
		
		<!-- 设置分页的页码 -->
		
		<tr>
			<td colspan="10" align="center">
				<jsp:include page="pager.jsp">
					<jsp:param name="items" value="<%=pager.getTotalRecord() %>" />
				</jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>