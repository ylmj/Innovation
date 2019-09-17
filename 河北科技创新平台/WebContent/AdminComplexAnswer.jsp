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
<title>综合查询结果</title>
<link rel="stylesheet" href="layui/css/layui.css" />
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<link rel="stylesheet" type="text/css" href="layui/css/modules/code.css"/>
<script type="text/javascript" src="js/StandardIndustrialClassificationCodes.js"></script>
<script type="text/javascript" src="layui/layui.js"></script>
<script type="text/javascript" src="layui/layui.all.js"></script>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
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
String[] con=request.getParameterValues("con");
String[] condition=request.getParameterValues("condition");
String[] values=request.getParameterValues("value");
String[] style=request.getParameterValues("style");
String approval_date=request.getParameter("approval_date");
String approval_date2=request.getParameter("approval_date2");
String[] platform_grade=request.getParameterValues("platform_grade");
int grade_value=0;
if(platform_grade!=null)
{
	for(String s:platform_grade)
	{
		grade_value+=Integer.parseInt(s);
	}
}
System.out.println(grade_value);
if(!"".equals(values[0])||grade_value!=0||(!"".equals(approval_date)&&!"".equals(approval_date2)))
{
Pager<Platform> pager=null;
PlatformDao platformDao=new PlatformDao();
System.out.println("进入查询");
List<Platform> platforms=platformDao.loadPlatform(condition,values,style,con, approval_date, approval_date2, grade_value);
System.out.println("查询出来");
System.out.println("跳转页面");

//获得pager中保存的list集合
%>
<body>
	<div>
    <label class="lab_title" style="margin-left: 10%;">查询结果:</label>
    </div>
    <table class="layui-table tab middle_self">	
		<tr>
			<td>平台信息编号</td>
			<td>用户名称</td>
			<td>平台编号</td>
			<td>平台名称</td>
			<td>批准年号</td>
			<td>批准文号</td>
			<td>依托单位组织代码</td>
			<td>依托单位类型</td>
			<td>平台主任姓名</td>
			<td>状态</td>
			
		</tr>
		<%
			for( Platform platform: platforms ){
		%>
		<tr>
			<td> <a href="AdminFind.jsp?platformId=<%=platform.getId() %>"><%=platform.getId() %></a></td>
			<td> <%=platform.getUser().getUsername() %></td>
			<td> <%=platform.getUser().getPlatformNo() %></td>
			<td> <%=platform.getUser().getPlatformName() %></td>
			<td> <%=platform.getUser().getApprovalDate() %></td>
			<td> <%=platform.getUser().getApprovalNum()%></td>
			<td> <%=platform.getOrganization().getUsci() %></td>
			<td> <%=platform.getOrganization().getType() %></td>
			<td> <%=platform.getDean().getName() %></td>
			<td> <% if(platform.getStatus()==1){ %>保存
			     <%}else {%>提交<%}%>
			</td>
		</tr>
		<%
			}
		%>
	</table>
	<%} %>
</body>
</html>