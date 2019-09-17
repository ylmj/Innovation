<%@ page import="com.basic.util.DBUtil" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
    <jsp:useBean id="dean" class="com.basic.model.Dean" scope="page"/>
    <jsp:useBean id="organization" class="com.basic.model.Organization" scope="page"/>
    <jsp:useBean id="platform" class="com.basic.model.Platform" scope="page"/>
    <jsp:useBean id="user" class="com.basic.model.User" scope="page"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="inc.jsp" >
		<jsp:param name="op" value="国省统计" />
	</jsp:include>
<%
       request.setCharacterEncoding("UTF-8");
       String submit="",stype="";
       String namecount[]={"","","",""};
       String name[]={"","","",""};

    	     Connection connection=DBUtil.getConnection();
             PreparedStatement preparedStatement=null;
     		 ResultSet resultSet=null;
         
             stype=request.getParameter("stype");
             String sql="select Pgrade ,count(*) from  platform_info a " +
                          "inner join dean on a.Pdeanid = dean.id " +
                          "JOIN organization ON a.Porganizationid=organization.id "+
                          "JOIN user1 ON a.Puserid=user1.id group by Pgrade";  
             preparedStatement=connection.prepareStatement(sql);
 			 resultSet=preparedStatement.executeQuery();
 			 int i=0;
             while(resultSet.next())
             {
            	 name[i]=resultSet.getString(1);
                 namecount[i]=resultSet.getString(2);
                 i++;
       }
%>
<input type="hidden" value="<%=namecount[0]%>" id="国家级" name="国家级"/>
<input type="hidden" value="<%=namecount[1]%>" id="省级" name="省级"/>
<input type="hidden" value="<%=namecount[2]%>" id="两者" name="两者"/>
<div id="canvasDiv" style="height:400px"></div>
<script type="text/javascript" src="js/echarts.js"></script>
<script type="text/javascript">
window.onload=function(){
var canvasDiv=echarts.init(document.getElementById('canvasDiv'));
var data1=document.getElementById("国家级");
var data2=document.getElementById("省级");
var data3=document.getElementById("两者");
option = {
	    tooltip: {
	        trigger: 'item',
	        formatter: "{a} <br/>{b}: {c} ({d}%)"
	    },
	    legend: {
	        orient: 'vertical',
	        x: 'left',
	        data:['国家级','省级','两者']
	    },
	    series: [
	        {
	            name:'分布占比',
	            type:'pie',
	            radius: ['50%', '70%'],
	            avoidLabelOverlap: false,
	            label: {
	                normal: {
	                    show: false,
	                    position: 'center'
	                },
	                emphasis: {
	                    show: true,
	                    textStyle: {
	                        fontSize: '30',
	                        fontWeight: 'bold'
	                    }
	                }
	            },
	            labelLine: {
	                normal: {
	                    show: false
	                }
	            },
	            data:[
	            	{value:data1.value,name:'国家级'},
	            	{value:data2.value,name:'省级'},
	            	{value:data3.value,name:'两者'}
	            	]
	        }
	    ]
	};
 canvasDiv.setOption(option);
};
</script>
</body>
</html>