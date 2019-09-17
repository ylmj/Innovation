<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>统计</title>

</head>
<body>
<form action="" method="post" onsubmit="return check()">
<table>
<tr>
<td>选择统计字段</td>
<td>
<select name="stype" id="stype">
<option value="select">请选择</option>
<option value="Pgrade">平台级别</option><!-- 省级国家级 -->
<option value="district">所属地区</option>
</select>
</td>
<td>选择图表类型</td>
<td>
<select name="type" id="type">
<option value="select">请选择</option>
<option value="pie">饼状图</option>
<option value=""></option>
</select>
</td>
<td><input type="submit" name="submit" value="生成图表"/></td>
</tr>
</table>
<script type="text/javascript">
function check()
{
	var stype=document.getElementById("stype");
	var type=document.getElementById("type");
	if(stype.value=="select")
		{
		stype.focus();
		alert('请选择统计类型',{time:1200});
		return false;
		}
	if(type.value=="select")
	{
	type.focus();
	alert('请选择生成图表类型',{time:1200});
	return false;
	}
	if(type.value=="Pgrade")
		{
		</script>
	   <jsp:include page="imagetable.jsp" flush="true"></jsp:include>
		<script>
		}
	return true;
}
</script>
</form>
</body>
</html>