<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="exception" class="java.lang.Exception" scope="request"></jsp:useBean>
<jsp:useBean id="err_msg" class="java.lang.String" scope="request"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>错误</title>
</head>
<body>
<h1 style="color:red"><%=err_msg %></h1>
<acticle>
<%if (exception!=null && exception.getMessage() != null){%>
            <%=exception.getMessage()%>
        <%}%>
</acticle>
</body>
</html>