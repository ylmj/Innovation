<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@page import="com.basic.dao.PlatformDao" %>
<%@page import="com.basic.util.Pager" %>
<%@page import="java.util.List"%>
<%@page import="com.basic.model.Platform" %>
<%@page import="com.basic.model.User" %>
<link rel="stylesheet" href="layui/css/layui.css" />
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<link rel="stylesheet" type="text/css" href="layui/css/modules/code.css"/>
<script type="text/javascript" src="js/StandardIndustrialClassificationCodes.js"></script>
<script type="text/javascript" src="layui/layui.js"></script>
<script type="text/javascript" src="layui/layui.all.js"></script>
<title>分类浏览结果</title>
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
String[] district=request.getParameterValues("district");

PlatformDao platformdao=new PlatformDao();
Pager pager=platformdao.loadPlatformClassification(district);
//获得pager中保存的list集合
 List<Platform> platforms = pager.getDatas();
System.out.println(platforms.isEmpty());
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
			<td> <a href="AdminFind.jsp?platformId=<%=platform.getId() %>"><%=platform.getId() %></a>
			
		
			</td>
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