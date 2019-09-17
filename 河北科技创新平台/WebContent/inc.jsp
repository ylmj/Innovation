<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<%if(request.getParameter("op")!=null) 
{%>
<h2 align="center">用户<%=request.getParameter("op") %>功能</h2>
<% }%>
<a href="Admin.jsp">用户列表</a>
<a href="AdminDean.jsp">平台主任</a>
<a href="AdminOrganization.jsp">依托单位</a>
<a href="AdminClassicif.jsp">分类浏览</a>
<a href="ComplexLoad.jsp">综合查询</a>
<a href="imagetable.jsp">国省统计</a>
<a href="bar.jsp">提交状态统计</a>
<hr width="100%" color="blue"/>