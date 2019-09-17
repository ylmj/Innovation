<%@page import="com.basic.dao.UserDao"%>
<%@page import="com.basic.model.User"%>
<%@page import="java.util.List"%>
<%@page import="com.basic.util.Pager" %>
<%@page import="com.basic.model.Organization" %>
<%@page import="com.basic.model.Platform" %>
<%@page import="com.basic.dao.UserDao" %>
<%@page import="com.basic.dao.OrganizationDao"%>
<%@page import="com.basic.dao.PlatformDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户展示页面</title>
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
	UserDao userDao = new UserDao();
	Pager pager=userDao.load(content);
	//获得pager中保存的list集合
	List<User> users = pager.getDatas();
	//获取登录用户
	User loginuser = (User)session.getAttribute("loginUser");
%>
<body>
	<jsp:include page="inc.jsp" >
		<jsp:param name="op" value="名查询" />
	</jsp:include>
	<table class="layui-table tab middle_self">
	<!-- align="center" border="1" width="900"  -->
		<tr>
			<form action="Admin.jsp" method="post">
				<td colspan="8">
					请输入用户名（user）查询: &nbsp;
					<input type="text" name="content" size="70" class="tb_input" /> &nbsp;
					</td>
					<td>
					<input type="submit" value="搜索" style="text-align: center;" class="layui-btn layui-btn-lg layui-btn-normal"/>
				</td>
			</form>
		</tr>
		
		<tr>
			<td>用户编号</td>
			<td>用户名称</td>
			<td>用户密码</td>
			<td>平台名称</td>
			<td>平台编号</td>
			<td>批准年月</td>
			<td>批准文号</td>
			<td>技术领域</td>
			<!-- <td colspan="2">用户操作</td> -->
		</tr>
		<%
			for( User user1 : users ){
		%>
		<tr>
			<td> <a href="AdminFind.jsp?userId=<%=user1.getId() %>"><%=user1.getId() %></a></td>
			<td> <%=user1.getUsername() %></td>
			<td> <%=user1.getPassword() %></td>
			<td> <%=user1.getPlatformName() %></td>
			<td> <%=user1.getPlatformNo()%></td>
			<td> <%=user1.getApprovalDate() %></td>
			<td> <%=user1.getApprovalNum() %></td>
			<td> <%=user1.getField() %></td>
			
		</tr> 
		<%
			}
		%>
		
		<!-- 设置分页的页码 -->
		<tr>
			<td colspan="8" align="center">
				<jsp:include page="pager.jsp">
					<jsp:param name="items" value="<%=pager.getTotalRecord() %>" />
				</jsp:include>
			</td>
		</tr>
		
		
	</table>
</body>
</html>