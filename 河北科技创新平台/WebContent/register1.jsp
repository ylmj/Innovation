<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>河北科技创新平台注册</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="layui/css/layui.css">
<script type="text/javascript" src="layui/layui.css"></script>
<script type="text/javascript">
function formCheck(){
	var pass1=document.getElementById("pass1").value;
	var pass2=document.getElementById("pass2").value;
	if(pass1!=pass2)
		{
		alert("两次密码输入不一致");
		return false;
		}
	return true;
}

</script>
</head>
<body>
<form action="Register" method="post" class="layui-form" onsubmit="return formCheck()">
	<table class="layui-table" id="reg_tb" lay-skin="nob" style="background-color:rgba(255,255,255,a);">
		<thread>
			<tr>
			   <td colspan="3" style="text-align:center;">用户注册</td>
			</tr>
		</thread>
		<tr>
            <td align="right" width="30%">用户名：</td>
            <td><input class="layui-input" name="username" type="text" required/></td>
            <td></td>
        </tr>
        <tr>
            <td align="right">密码：</td>
            <td><input class="layui-input" type="password" name="pass1" id="pass1" value="" required /></td>
            <td></td>
        </tr>
        <tr>
            <td align="right">再次输入密码：</td>
            <td><input class="layui-input" type="password" name="pass2" id="pass2" value=""required/></td>
            <td></td>
        </tr>
        <tr>
            <td align="right">平台名称：</td>
            <td><input class="layui-input" type="text" name="platform_name" id="platform_name" value="" required/></td>
            <td></td>
        </tr>
        <tr>
            <td align="right">平台编号：</td>
            <td><input class="layui-input" type="text" name="platform_no" id="platform_no" value="" required/></td>
            <td></td>
        </tr>
        <tr>
            <td align="right">批准年月：</td>
            <td><input class="layui-input" type="text" name="approval_date" id="approval_date" value="" required/></td>
            <td></td>
        </tr>
        <tr>
            <td align="right">批准文号：</td>
            <td><input class="layui-input" type="text" name="approval_number" id="approval_number" value="" required/></td>
            <td></td>
        </tr>
        <tr>
            <td align="right">技术领域：</td>
            <td><input class="layui-input" type="text" name="field" id="field" value="" required/></td>
            <td></td>
        </tr>
        <tr>
            <td align="center" colspan="3"><input class="layui-btn layui-btn-normal" type="submit" value="注册"/></td>
        </tr>
	</table>
</form>
</body>
</html>