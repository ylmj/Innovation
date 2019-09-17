<%@page import="com.basic.dao.OrganizationDao"%>
<%@page import="com.basic.model.Organization"%>
<%@page import="com.basic.model.User"%>
<%@page import="java.util.List"%>
<%@page import="com.basic.util.Pager" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>依托单位展示页面</title>
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
	OrganizationDao organizationDao = new OrganizationDao();
	Pager pager=organizationDao.load(content);
	//获得pager中保存的list集合
	List<Organization> organizations = pager.getDatas();
	//获取登录用户
	User loginuser = (User)session.getAttribute("loginUser");
%>
<body>
	<jsp:include page="inc.jsp" >
		<jsp:param name="op" value="依托单位查询" />
	</jsp:include>
	<table class="layui-table tab middle_self">
		<tr>
			<form action="AdminOrganization.jsp" method="post">
				<td colspan="8">
					请输入依托单位（organization）查询: &nbsp;
					<input type="text" name="content" size="70" class="tb_input" /> &nbsp;
					</td>
					<td>
					<input type="submit" value="搜索" style="text-align: center;" class="layui-btn layui-btn-lg layui-btn-normal"/>
				</td>
			</form>
		</tr>
		
		<tr>
			<td>依托单位编号</td>
			<td>姓名</td>
			<td>依托单位组织代码</td>
			<td>依托单位法人姓名</td>
			<td>办公电话</td>
			<td>类型</td>
		</tr>
		<%
			for(Organization organization:organizations)
			{
		%>
		<tr>
			<td> <a href="AdminFind.jsp?organizationId=<%=organization.getId() %>"><%=organization.getId() %></a></td>
			<td> <%=organization.getName() %></td>
			<td> <%=organization.getUsci()%></td>
			<td> <%=organization.getFarenName() %></td>
			<td> <%=organization.getTelephone()%></td>
			<td> <%=organization.getType()%></td>
			
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