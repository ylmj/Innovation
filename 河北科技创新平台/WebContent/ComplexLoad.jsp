<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询</title>
    <link rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="layui/css/layui.css" />
    
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
	#increase,#decrease{
		background:none;
		border:solid black 1px;
		width:20px;
		margin-top:5px;
		cursor:pointer;
		padding:0px;
	}
	#increase:hover,#decrease:hover{
		background-color:#B2D1FF;
		}
	#increase:active,#decrease:active{
		background-color:#BBBBBB;
	}
	#increase:disabled,#decrease:disabled{
		background-color:#FFFFFF;
	}
	#item
	{
		display:flex;
		flex-direction:row;
		justify-content:flex-start;
		align-items:center;
	}
	.ite{
		margin:10px 10px;
		}
</style>
<script src="layui/layui.js"></script>
<script type="text/javascript">
	//加载form模块
	var form;
	
	layui.use('form',function () {
		form = layui.form;
	})
	//加载日期模块
	layui.use('laydate', function(){
		  var laydate = layui.laydate;
		  
		  //执行一个laydate实例
		  laydate.render({
		    elem: '#approval_date' //指定元素
		  });
		  laydate.render({
			    elem: '#approval_date2' //指定元素
			  });
		});
</script>
</head>
<body>
<jsp:include page="inc.jsp" >
		<jsp:param name="op" value="综合查询" />
	</jsp:include> 
	
	<div style="width:80%;margin:10px 10%;height:300px;">
	
	<form id="search" target="results" action="AdminComplexAnswer.jsp" method="post">
	<table style="text-align:center" id="mytable">
		<tr>
		<td><button type="button" id="decrease" onclick="Delete(mytable)">-</button>
		<button type="button" id="increase" onclick="Add(mytable)">+</button>
		</td>
		<td>
		<select name="condition" id="condition">
			<option value="platform_name">平台名称</option>
			<option value="field">技术领域</option>
			<option value="organization.name">依托单位</option>
			<option value="type">依托单位类型</option>
			<option value="faren_name">依托单位法人</option>
			<option value="dean.name">平台主任姓名</option>
			</select>
		</td>
		<td>
		<input type="text" name="value"  value=""/>
		</td>
		<td>
		<select name="style">
		<option value="like">模糊</option>
		<option value="=">精确</option>
		</select>
		</td>
		</tr>
	<tr>
		<td>批准年月:</td>
		<td>从</td>
		<td><input type="text" class="layui-input" name="approval_date" id="approval_date" placeholder="如：1987-05-01" value=""  lay-verify="required|date"/></td>
		<td>到</td>
		<td><input type="text" class="layui-input" name="approval_date2" id="approval_date2" placeholder="如：1987-05-01" value="" lay-verify="required|date"/></td>
        </tr>
	<tr>
		<td>平台级别：</td>
		<td colspan="3">
		<input type="checkbox" name="platform_grade" id="country_grade" value="1" lay-skin="primary"/>&nbsp;&nbsp;国家级&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="checkbox" name="platform_grade" id="province_grade" value="2" lay-skin="primary"/>&nbsp;&nbsp;省级</td>
	</tr>
	<tr>
    <td colspan="4" ><input type="submit" value="查询" class="layui-btn"/></td>
	</tr>
	</table>
	</form>
	<!-- 修改 -->
	<iframe id="result" scrolling="yes" height="100%" width="100%" frameborder="0" name="results">
	</iframe>
	</div>
<script type="text/javascript">
function get_Element(the_ele,the_tag)
{
	the_tag  =  the_tag.toLowerCase();  
	  if(the_ele.tagName.toLowerCase()==the_tag)  
	  return  the_ele;  
	  while(the_ele=the_ele.offsetParent){  
	  if(the_ele.tagName.toLowerCase()==the_tag)  
	  return  the_ele;  
	  }
	  return null;
}
function Add(the_table)
{
	 var  the_row,the_cell;  
	  var  cur_rows=the_table.rows.length;  
	  the_row=cur_rows==null?-1:(cur_rows);  
	  var  i=the_row-3;  
	  var  newrow=the_table.insertRow(i);//得到插入位置  
	  the_cell=newrow.insertCell(0);
	  the_cell.innerHTML=" <select name='con'><option value='and'>并且</option><option value='or'>或者</option><option value='and not'>不含</option></select> ";
	  the_cell=newrow.insertCell(1);  
	  the_cell.innerHTML=" <select name='condition' id='condition'><option value='platform_name'>平台名称</option><option value='field'>技术领域</option><option value='organization.name'>依托单位</option><option value='type'>依托单位类型</option><option value='faren_name'>依托单位法人</option><option value='dean.name'>平台主任姓名</option></select>";  
	  the_cell=newrow.insertCell(2);  
	  the_cell.innerHTML=" <input type='text' name='value'  />";  
	  the_cell=newrow.insertCell(3);  
	  the_cell.innerHTML=" <select name='style'><option value='like'>模糊</option><option value='='>精确</option></select>";  
}
function Delete(the_table)
{
	 var  the_row,the_cell;  
	 var  cur_rows=the_table.rows.length;  
	 the_row=cur_rows==null?-1:(cur_rows);  
	 var  i=the_row-4;  
	 if(i>0)
	 the_table.deleteRow(i);//得到插入位置  
}

</script>
</body>
</html>