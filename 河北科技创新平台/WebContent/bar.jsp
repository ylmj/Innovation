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
<title>提交状态统计</title>
</head>
<body>
<jsp:include page="inc.jsp" >
		<jsp:param name="op" value="提交状态统计" />
	</jsp:include>
<%
       request.setCharacterEncoding("UTF-8");
       String namecount[]={"",""};

    	     Connection connection=DBUtil.getConnection();
             PreparedStatement preparedStatement=null;
     		 ResultSet resultSet=null;
         
             String sql="select count(*) from  platform_info a " +
                          "inner join dean on a.Pdeanid = dean.id " +
                          "JOIN organization ON a.Porganizationid=organization.id "+
                          "JOIN user1 ON a.Puserid=user1.id group by Pstatus";  
             preparedStatement=connection.prepareStatement(sql);
 			 resultSet=preparedStatement.executeQuery();
 			 int i=0;
             while(resultSet.next())
             {
                 namecount[i]=resultSet.getString(1);
                 i++;
             } 
%>
<input  type="hidden" value="<%=namecount[0]%>" id="提交"/>
<input type="hidden" value="<%=namecount[1]%>" id="未提交"/>
<div id="canvasDiv" style="height:400px"></div>
<script type="text/javascript" src="js/echarts.js"></script>
<script type="text/javascript">
window.onload=function(){
	var canvasDiv=echarts.init(document.getElementById('canvasDiv'));
	var data1=document.getElementById("提交");
	var data2=document.getElementById("未提交");
option = {
	    xAxis: {
	        type: 'category',
	        data: ['提交', '未提交']
	    },
	    yAxis: {
	        type: 'value'
	    },
	    series: [{
	        data: [1,2],
	        type: 'bar'
	    }]
	};
canvasDiv.setOption(option);
}
</script>
</body>
</html>