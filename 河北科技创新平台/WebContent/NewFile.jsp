<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script  language="javascript">  //以下控制增加一行
  function  get_Element(the_ele,the_tag){  
  the_tag  =  the_tag.toLowerCase();  
  if(the_ele.tagName.toLowerCase()==the_tag)  
  return  the_ele;  
  while(the_ele=the_ele.offsetParent){  
  if(the_ele.tagName.toLowerCase()==the_tag)  
  return  the_ele;  
  }  
  return(null);  
  }  

  function  add_Row(the_table)  {  
  var  the_row,the_cell;  
  var  cur_rows=the_table.rows.length;  
  the_row=cur_rows==null?-1:(cur_rows);  
  var  i=the_row-1;  
  var  newrow=the_table.insertRow(i);//得到插入位置  
  the_cell=newrow.insertCell(0);  
  the_cell.innerHTML=" <center  >"+i;  
  the_cell=newrow.insertCell(1);  
  the_cell.innerHTML=" <center  > <input  name=\"A\"  type=text  size=13>";  
  the_cell=newrow.insertCell(2);  
  the_cell.innerHTML=" <center  > <input  name=\"B\"  type=text  size=13    >";  
 the_cell=newrow.insertCell(3);  
  the_cell.innerHTML=" <center  > <input  name=\"C\"  type=text  size=13    >";  
 the_cell=newrow.insertCell(4);  
  the_cell.innerHTML=" <center  > <input  name=\"D\"  type=text  size=13    >";  
   the_cell=newrow.insertCell(5);  
   the_cell.innerHTML=" <center  > <input  name=\"E\"  type=text  size=13  >  ";  
   the_cell=newrow.insertCell(6);  
   the_cell.innerHTML=" <center  > <a href=#  onclick=del_row(myTable)>删除 </a>";  //删除一行
    }  

  function  del_row(the_table){  
    var  the_cell;  
  the_cell=get_Element(event.srcElement,"td");  
  var  index=the_cell.parentElement.rowIndex;  
  if(the_cell==null)  return;  
  if(the_table.rows.length==1)  return;  
  the_table.deleteRow(index);  
  }  
  </script>  
  </head>  
  <body  >          
<table    id="myTable"  width="100%"  border="1"  cellpadding="4"  cellspacing="1"  >  
  <tr  class="TdContent">  
      <td  > <div  align="center">序号 </div> </td>  
      <td  > <div  align="center">A </div> </td>  
      <td  > <div  align="center">B </div> </td>  
      <td  > <div  align="center">C </div> </td>
      <td  > <div align="center">D</div></td>
      <td  > <p align="center">E</p></td>
      <td align="center"  >删除</td>  
  </tr>  
  <tr  class="TdContent">  
      <td> <div  align="center">1 </div> </td>  
      <td> <div  align="center">  
          <input  name="A"  type="text"  size="13"  >  
      </div> </td>  
      <td> <div  align="center">  
          <input  name="B"  type="text"  size="13"  >  
      </div> </td>  
      <td>  
          <div  align="center">  
              <input  name="C"  type="text"  size="13"  >  
          </div> </td>
      <td><div  align="center">  
              <input  name="D"  type="text"  size="13"  >  
          </div></td>
      <td><div  align="center">  
              <input  name="E"  type="text"  size="13"  >  
          </div></td>
      <td>&nbsp;</td>  
  </tr>  
  <tr  class="TdContent">  
      <td  colspan="7"  align="center"> <input    type="button"  value="添加一行"      class="ButtonStyle"  onClick="add_Row(myTable)"> </td>  
  </tr>  
</table>    
</body>
</html>