/**
 * 用于注册表单的交互
 */
/*函数判断不能全相同*/
function findStr(str,n){
	var tmp=0;
	for(var i=0;i<str.length;i++)
		{
		if(str.charAt(i)==n)
			{
			tmp++;
			}
		}
	return tmp;
}

function getLength(str){
	return str.replace(/[^\x00-xff]/g,"xx").length;
	}
var i=0;
window.onload=function(){
	
	var ainput=document.getElementsByTagName('input');
	var username=ainput[0];//用户名
	var platform_name=ainput[1];//平台名称
	var platform_num=ainput[2];//平台编号
	var approval_date=ainput[3];//批准年月
	var approval_code=ainput[4];//批准文号
	var field=ainput[5];//技术领域
	var password=ainput[6];//密码
	var password2=ainput[7];//密码确认
	
	var ap=document.getElementsByTagName('p');
	var user_msg=ap[0];
	var name_msg=ap[1];
	var num_msg=ap[2];
	var date_msg=ap[3];
	var code_msg=ap[4];
	var field_msg=ap[5];
	var password_msg=ap[6];
	var password2_msg=ap[7];
	
	var name_length=0;
	var re=/[^\w\u4e00-\u9fa5]/g;
	
	//用户名
	username.onfocus=function(){
		user_msg.style.display="block";
		user_msg.innerHTML='<i>推荐使用中文</i>';
	}
	
	username.onkeyup=function(){
		
		user_msg.style.display="block";
		user_length=getLength(this.value);
		if(user_length==0)
			{
			user_msg.style.display="none";
			}
		else
			{
			user_msg.innerHTML='<i>'+user_length+'个字符</i>'
			}
	}
	username.onblur=function Rusername(){
		var re=/[^\w\u4e00-\u9fa5]/g;
		if(re.test(this.value))
			{
			user_msg.innerHTML='<i style="color:red;">含有非法字符</i>';
			}
		else if(this.value=="")
			{
			user_msg.innerHTML='<i style="color:red;">不能为空</i>';
			}
		else if(name_length>25)
			{
			user_msg.innerHTML='<i style="color:red;">超过25个字符</i>';
			}
		else
			{
			user_msg.innerHTML="<i></i>✔";
			i++;
				return true;
			}
		return false;
	}
	
	//平台名称
	platform_name.onfocus=function(){
		name_msg.style.display="block";
		name_msg.innerHTML='<i>推荐使用中文</i>'
	}
	
	platform_name.onkeyup=function(){
		
		name_msg.style.display="block";
		name_length=getLength(this.value);
		if(name_length==0)
			{
			name_msg.style.display="none";
			}
		else
			{
			name_msg.innerHTML='<i>'+name_length+'个字符</i>'
			}
	}
	platform_name.onblur=function RplatformName(){
		var re=/[^\w\u4e00-\u9fa5]/g;
		if(re.test(this.value))
			{
			name_msg.innerHTML='<i style="color:red;">含有非法字符</i>';
			}
		else if(this.value=="")
			{
			name_msg.innerHTML='<i style="color:red;">不能为空</i>';
			}
		else if(name_length>25)
			{
			name_msg.innerHTML='<i style="color:red;">超过25个字符</i>';
			}
		else
			{
			name_msg.innerHTML="<i></i>✔";
			i++;
				return true;
			}
		return false;
	}
	platform_num.onfocus=function(){
		num_msg.style.display="block";
		num_msg.innerHTML='<i>一个汉字为两个字节，不多于25个</i>'
	}
	
	platform_num.onkeyup=function(){
		
		num_msg.style.display="block";
		num_length=getLength(this.value);
		if(num_length==0)
			{
			num_msg.style.display="none";
			}
		else
			{
			num_msg.innerHTML='<i>'+num_length+'个字符</i>'
			}
	}
	platform_num.onblur=function Rplatform_num(){
		var re=/[^\w\u4e00-\u9fa5]/g;
		if(re.test(this.value))
			{
			num_msg.innerHTML='<i style="color:red;">含有非法字符</i>';
			}
		else if(this.value=="")
			{
			num_msg.innerHTML='<i style="color:red;">不能为空</i>';
			}
		else if(num_length>25)
			{
			num_msg.innerHTML='<i style="color:red;">超过25个字符</i>';
			}
		else
			{
			num_msg.innerHTML="<i></i>✔"
				i++;
				return true;
			}
		return false;
	}
	approval_date.onblur=function Rplatform_date(){
		var rdate=/\d{4}-\d{2}/g;
		if((!rdate.test(this.value))&&(this.value.length!=7))
			{
			date_msg.innerHTML='<i style="color:red;">格式错误，如1998-02</i>';
			}
		else if(this.value=="")
		{
		date_msg.innerHTML='<i style="color:red;">不能为空</i>';
		}
		else
		{
			i++;
		date_msg.innerHTML="<i></i>✔"
		}

	}
	approval_code.onfocus=function(){
		code_msg.style.display="block";
		code_msg.innerHTML='<i>无非法字符</i>'
	}
	
	approval_code.onkeyup=function(){
		
		code_msg.style.display="block";
		code_length=getLength(this.value);
		if(code_length==0)
			{
			code_msg.style.display="none";
			}
		else
			{
			code_msg.innerHTML='<i>'+code_length+'个字符</i>'
			}
	}
	approval_code.onblur=function Rapproval_code(){
		var re=/[^\w\u4e00-\u9fa5]/g;
		if(re.test(this.value))
			{
			code_msg.innerHTML='<i style="color:red;">含有非法字符</i>';
			}
		else if(this.value=="")
			{
			code_msg.innerHTML='<i style="color:red;">不能为空</i>';
			}
		else if(code_length>25)
			{
			code_msg.innerHTML='<i style="color:red;">超过25个字符</i>';
			}
		else
			{
			code_msg.innerHTML="<i></i>✔"
				i++;
			return true;
			}
		return false;
	}
	field.onfocus=function(){
		field_msg.style.display="block";
		field_msg.innerHTML='<i>推荐使用中文</i>'
	}
	
	field.onkeyup=function(){
		
		field_msg.style.display="block";
		field_length=getLength(this.value);
		if(field_length==0)
			{
			field_msg.style.display="none";
			}
		else
			{
			field_msg.innerHTML='<i>'+field_length+'个字符</i>'
			}
	}
	field.onblur=function Rfiled(){
		var re=/[^\w\u4e00-\u9fa5]/g;
		if(re.test(this.value))
			{
			field_msg.innerHTML='<i style="color:red;">含有非法字符</i>';
			}
		else if(this.value=="")
			{
			field_msg.innerHTML='<i style="color:red;">不能为空</i>';
			}
		else if(field_length>25)
			{
			field_msg.innerHTML='<i style="color:red;">超过25个字符</i>';
			}
		else
			{
			field_msg.innerHTML="<i></i>✔"
				i++;
				return true;
			}
		return false;
	}
	password.onfocus=function(){
		password_msg.style.display="block";
		password_msg.innerHTML='<i>6-16个字符,请使用混合密码方式</i>'
	}
	
	password.onkeyup=function checkpass(){
		if(this.value.length>5)
			{
			password_msg.innerHTML='<i style="color:red">弱</i>';
			password2.removeAttribute("disabled");
			password2_msg.style.display="block";
			}
		else
			{
			password_msg.innerHTML='';
			password2.setAttribute("disabled");
			password2_msg.style.display="none";
			}
		if(this.value.length>10)
			{
			password_msg.innerHTML='<i style="color:red">强</i>';
			}
	}
	password.onblur=function Rpassword1(){
		var ren=/[^\d]/g;	
		var rep=/[^a-zA-Z]/g;
		var m=findStr(password.value,password.value[0]);
		if(this.value=="")
			{
			password_msg.innerHTML='<i style="color:red">不能为空</i>';
			}
		else if(m==this.value.length)
			{
			password_msg.innerHTML='<i style="color:red">不能使用相同字符</i>';
			}
		else if(this.value.length>16)
			{
			password_msg.innerHTML='<i style="color:red">超过16个字符</i>';
			}
		else if(this.value.length<6)
			{
			password_msg.innerHTML='<i style="color:red">少于6个字符</i>';
			}
		else if(!ren.test(this.value))
			{
			password_msg.innerHTML='<i style="color:red">不能全是数字</i>';
			}
		else if(!rep.test(this.value))
			{
			password_msg.innerHTML='<i style="color:red">不能全是字母</i>';
			}
		else
			{
			password_msg.innerHTML='<i></i>✔';
			i++;
			return true;
			}
			return false;
	}
	
	password2.onblur=function Rpassword2(){
		if(this.value!=password.value)
			{
			password2_msg.innerHTML='<i style="color:red;">两次输入密码不一致</i>';
			}
		else
			{
			password2_msg.innerHTML="<i></i>✔";
			i++;
				return true;
			}
		return false;
	}
	   
}
function check()
{
	   if(i>=8) 
		  {
		  return true;
		  }
	   return false;
}