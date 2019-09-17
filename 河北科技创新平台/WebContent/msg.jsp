<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="msg" class="java.lang.String" scope="request"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>提示信息</title>
<link rel="stylesheet" href="layui/css/layui.css"/>
<script type="text/javascript" src="layui/layui.js"></script>
</head>
<body>
<script>
layui.use("layer",function()
{
	var layer=layui.layer;
	layer.open(<%=msg%>);
	})
</script>

</body>
</html>