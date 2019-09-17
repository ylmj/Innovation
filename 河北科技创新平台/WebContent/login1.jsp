<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>河北科技创新平台登录</title>
<link rel="stylesheet" href="css/style.css">              
</head>
<body>
<h1 style="text-align:center">河北科技创新平台登录</h1>
<div id="loginbox">
	<form action="Login" style="text-align:center;" method="post">
	<input type="text" class="logininput" name="username" style="margin-top:90px;background-image:url('images/person.jpg')" placeholder="用户名称" required>
	<br>
	<input type="password" class="logininput" name="password" style="margin-top:10px;background-image:url('images/password.jpg')" placeholder="密码" required>
	<br>
	<div class="logininput" style="margin-left:auto;margin-right:auto;margin-top:20px;">
                <input id="pass" type="checkbox" class="checkbox" name="remberpass" style="float:left">
                <label for="pass" style="position: relative;right: 40px;">记住密码</label>
                <input type="submit" class="loginbutton" value="登陆" style="float:right">
    </div>
    <br>
    <h6><a href="register.jsp">没有账号，点击注册</a></h6>
	</form>
</div>
</body>
</html>