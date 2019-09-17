<%@page import="com.basic.model.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分类浏览</title>
</head>
<%
//筛选
	User loginuser = (User)session.getAttribute("loginUser");
%>
<body>
<jsp:include page="inc.jsp" >
		<jsp:param name="op" value="分类浏览" />
</jsp:include>
<iframe src="ClassificationCheckbox.jsp" name="visit" width="20%" height="500px" frameborder="0"></iframe>
<iframe src="AdminClassicificationResult.jsp" name="result" width="79%" height="500px" frameborder="0"></iframe>
<!-- scrolling="no" 是否显示滚动条 -->


</body>
</html>