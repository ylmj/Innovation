<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="layui/css/layui.css" />
<style type="text/css">
	*{margin: 0;padding: 0}
	body{font-size: 12px;font-family: "宋体","微软雅黑";}
	ul,li{list-style: none;}
	a:link,a:visited{text-decoration: none;color: #fff;}
	a:hover{color: #000;}
	.list{width: 210px;border-bottom:solid 1px #316a91;margin:40px auto 0 auto;}
	.list ul li{background-color:#467ca2; border:solid 1px #316a91; border-bottom:0;}
	.list ul li a{padding-left: 10px;color: #fff; font-size:12px; display: block; font-weight:bold; height:36px;line-height: 36px;position: relative;
	}
	.list ul li a:hover{padding-left: 10px;color: #000; font-size:12px; display: block; font-weight:bold; height:36px;line-height: 36px;position: relative;
	}
	.list ul li .inactive{ background:url(images/off.png) no-repeat 184px center;}
	.list ul li .inactives{background:url(images/on.png) no-repeat 184px center;} 
	.list ul li ul{display: none;}
	.list ul li ul li { border-left:0; border-right:0; background-color:#6196bb; border-color:#467ca2;}
	.list ul li ul li ul{display: none;}
	.list ul li ul li a{ padding-left:20px;}
	.list ul li ul li ul li { background-color:#d6e6f1; border-color:#6196bb; }
	.last{ background-color:#d6e6f1; border-color:#6196bb; }
	.list ul li ul li ul li a{ color:#316a91; padding-left:30px;}
</style>
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
		$('.inactive').click(function(){
			if($(this).siblings('ul').css('display')=='none'){
				$(this).parent('li').siblings('li').removeClass('inactives');
				$(this).addClass('inactives');
				$(this).siblings('ul').slideDown(100).children('li');
				if($(this).parents('li').siblings('li').children('ul').css('display')=='block'){
					$(this).parents('li').siblings('li').children('ul').parent('li').children('a').removeClass('inactives');
					$(this).parents('li').siblings('li').children('ul').slideUp(100);

				}
			}else{
				//控制自身变成+号
				$(this).removeClass('inactives');
				//控制自身菜单下子菜单隐藏
				$(this).siblings('ul').slideUp(100);
				//控制自身子菜单变成+号
				$(this).siblings('ul').children('li').children('ul').parent('li').children('a').addClass('inactives');
				//控制自身菜单下子菜单隐藏
				$(this).siblings('ul').children('li').children('ul').slideUp(100);

				//控制同级菜单只保持一个是展开的（-号显示）
				$(this).siblings('ul').children('li').children('a').removeClass('inactives');
			}
		})
	});
	</script>
</head>
<body>
<form action="AdminClassicificationResult.jsp" method="get" id="result" target="result">
	<div class="list" style="float:left">
		<ul class="yiji">
		<li style="background-color:#009688"><input type="submit" value="查询" class="layui-btn"/></li>
			<li><a href="#" class="inactive">河北省</a>
				<ul style="display: none">
					<li><a href="#" class="inactive active">石家庄市</a>
						<ul>
							<li><a href="AdminClassicificationResult.jsp?district=130102" target="result"><input type="checkbox" name="district" value="130102" >长安区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130104" target="result"><input type="checkbox" name="district" value="130104" >桥西区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130105" target="result"><input type="checkbox" name="district" value="130105" >新华区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130107" target="result"><input type="checkbox" name="district" value="130107" >井陉矿区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130108" target="result"><input type="checkbox" name="district" value="130108" >裕华区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130109" target="result"><input type="checkbox" name="district" value="130109" >藁城区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130110" target="result"><input type="checkbox" name="district" value="130110" >鹿泉区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130111" target="result"><input type="checkbox" name="district" value="130111" >栾城区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130121" target="result"><input type="checkbox" name="district" value="130121" >井陉县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130123" target="result"><input type="checkbox" name="district" value="130123" >正定县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130125" target="result"><input type="checkbox" name="district" value="130125" >行唐县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130126" target="result"><input type="checkbox" name="district" value="130126" >灵寿县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130127" target="result"><input type="checkbox" name="district" value="130127" >高邑县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130128" target="result"><input type="checkbox" name="district" value="130128" >深泽县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130129" target="result"><input type="checkbox" name="district" value="130129" >赞皇县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130130" target="result"><input type="checkbox" name="district" value="130130" >无极县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130131" target="result"><input type="checkbox" name="district" value="130131" >平山县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130132" target="result"><input type="checkbox" name="district" value="130132" >元氏县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130133" target="result"><input type="checkbox" name="district" value="130133" >赵县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130181" target="result"><input type="checkbox" name="district" value="130181" >辛集市</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130183" target="result"><input type="checkbox" name="district" value="130183" >晋州市</a></li>	
							<li><a href="AdminClassicificationResult.jsp?district=130184" target="result"><input type="checkbox" name="district" value="130184" >新乐市</a></li>							
						</ul>
					</li> 
					<li><a href="#" class="inactive active">唐山市</a>   
						<ul>
							<li><a href="AdminClassicificationResult.jsp?district=130202" target="result"><input type="checkbox" name="district" value="130202" >路南区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130203" target="result"><input type="checkbox" name="district" value="130203" >路北区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130204" target="result" ><input type="checkbox" name="district" value="130204" >古冶区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130205" target="result"><input type="checkbox" name="district" value="130205" >开平区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130207" target="result"><input type="checkbox" name="district" value="130207" >丰南区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130208" target="result"><input type="checkbox" name="district" value="130208" >丰润区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130209" target="result"><input type="checkbox" name="district" value="130209" >曹妃甸区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130223" target="result"><input type="checkbox" name="district" value="130223" >滦县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130224" target="result"><input type="checkbox" name="district" value="130224" >滦南县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130225" target="result"><input type="checkbox" name="district" value="130225" >乐亭县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130227" target="result"><input type="checkbox" name="district" value="130227" >迁西县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130229" target="result"><input type="checkbox" name="district" value="130229" >玉田县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130281" target="result"><input type="checkbox" name="district" value="130281" >遵化市</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130283" target="result"><input type="checkbox" name="district" value="130283" >迁安市</a></li>
						</ul>
					</li> 
					<li><a href="#" class="inactive active">秦皇岛市</a>   
						<ul>
							<li><a href="AdminClassicificationResult.jsp?district=130302" target="result"><input type="checkbox" name="district" value="130302" >海港区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130303" target="result"><input type="checkbox" name="district" value="130303" >山海关区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130304" target="result"><input type="checkbox" name="district" value="130304" >北戴河区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130306" target="result"><input type="checkbox" name="district" value="130306" >抚宁区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130321" target="result"><input type="checkbox" name="district" value="130321" >青龙满族自治县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130322" target="result"><input type="checkbox" name="district" value="130322" >昌黎县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130324" target="result"><input type="checkbox" name="district" value="130324" >卢龙县</a></li>
						</ul>
					</li> 
					<li><a href="#" class="inactive active">邯郸市</a>   
						<ul>
							<li><a href="AdminClassicificationResult.jsp?district=130402" target="result"><input type="checkbox" name="district" value="130402" >邯山区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130403" target="result"><input type="checkbox" name="district" value="130403" >丛台区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130404" target="result"><input type="checkbox" name="district" value="130404" >复兴区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130406" target="result"><input type="checkbox" name="district" value="130406" >峰峰矿区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130407" target="result"><input type="checkbox" name="district" value="130407" >肥乡区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130408" target="result"><input type="checkbox" name="district" value="130408" >永年区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130423" target="result"><input type="checkbox" name="district" value="130423" >临漳区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130424" target="result"><input type="checkbox" name="district" value="130424" >成安县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130425" target="result"><input type="checkbox" name="district" value="130425" >大名县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130426" target="result"><input type="checkbox" name="district" value="130426" >涉县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130427" target="result"><input type="checkbox" name="district" value="130427" >磁县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130430" target="result"><input type="checkbox" name="district" value="130430" >邱县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130431" target="result"><input type="checkbox" name="district" value="130431" >鸡泽县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130432" target="result"><input type="checkbox" name="district" value="130432" >广平县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130433" target="result"><input type="checkbox" name="district" value="130433" >馆陶县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130434" target="result"><input type="checkbox" name="district" value="130434" >魏县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130435" target="result"><input type="checkbox" name="district" value="130435" >曲周县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130481" target="result"><input type="checkbox" name="district" value="130481" >武安市</a></li>
						</ul>
					</li> 
					<li><a href="#" class="inactive active">邢台市</a>   
						<ul>
							<li><a href="AdminClassicificationResult.jsp?district=130502" target="result"><input type="checkbox" name="district" value="130502" >桥东区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130503" target="result"><input type="checkbox" name="district" value="130503" >桥西区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130521" target="result"><input type="checkbox" name="district" value="130521" >邢台县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130522" target="result"><input type="checkbox" name="district" value="130522" >临城县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130523" target="result"><input type="checkbox" name="district" value="130523" >内丘县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130524" target="result"><input type="checkbox" name="district" value="130524" >柏乡县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130525" target="result"><input type="checkbox" name="district" value="130525" >隆尧县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130526" target="result"><input type="checkbox" name="district" value="130526" >任县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130527" target="result"><input type="checkbox" name="district" value="130527" >南和县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130528" target="result"><input type="checkbox" name="district" value="130528" >宁晋县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130529" target="result"><input type="checkbox" name="district" value="130529" >巨鹿县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130530" target="result"><input type="checkbox" name="district" value="130530" >新河县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130531" target="result"><input type="checkbox" name="district" value="130531" >广宗县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130532" target="result"><input type="checkbox" name="district" value="130532" >平乡县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130533" target="result"><input type="checkbox" name="district" value="130533" >威县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130534" target="result"><input type="checkbox" name="district" value="130534" >清河县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130535" target="result"><input type="checkbox" name="district" value="130535" >临西县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130581" target="result"><input type="checkbox" name="district" value="130581" >南宫市</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130582" target="result"><input type="checkbox" name="district" value="130582" >沙河县</a></li>
						</ul>
					</li> 
					<li><a href="#" class="inactive active">保定市</a>   
						<ul>
							<li><a href="AdminClassicificationResult.jsp?district=130602" target="result"><input type="checkbox" name="district" value="130602" >竞秀区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130606" target="result"><input type="checkbox" name="district" value="130606" >莲池区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130607" target="result"><input type="checkbox" name="district" value="130607" >满城区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130608" target="result"><input type="checkbox" name="district" value="130608" >清苑区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130609" target="result"><input type="checkbox" name="district" value="130609" >徐水区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130623" target="result"><input type="checkbox" name="district" value="130623" >涞水区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130624" target="result"><input type="checkbox" name="district" value="130624" >阜平区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130626" target="result"><input type="checkbox" name="district" value="130626" >定兴县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130627" target="result"><input type="checkbox" name="district" value="130627" >唐县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130628" target="result"><input type="checkbox" name="district" value="130628" >高阳县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130629" target="result"><input type="checkbox" name="district" value="130629" >容城县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130630" target="result"><input type="checkbox" name="district" value="130630" >涞源县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130631"target="result"><input type="checkbox" name="district" value="130631" >望都县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130632" target="result"><input type="checkbox" name="district" value="130632" >安新县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130633" target="result"><input type="checkbox" name="district" value="130633" >易县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130634" target="result"><input type="checkbox" name="district" value="130634" >曲阳县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130635" target="result"><input type="checkbox" name="district" value="130635" >蠡县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130636" target="result"><input type="checkbox" name="district" value="130636" >顺平县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130637" target="result"><input type="checkbox" name="district" value="130637" >博野县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130638" target="result"><input type="checkbox" name="district" value="130638" >雄县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130681" target="result"><input type="checkbox" name="district" value="130681" >涿州市</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130682" target="result"><input type="checkbox" name="district" value="130682" >定州市</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130683" target="result"><input type="checkbox" name="district" value="130683" >安国市</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130684" target="result"><input type="checkbox" name="district" value="130684" >高碑店市</a></li>
						</ul>
					</li> 
					<li><a href="#" class="inactive active">张家口市</a>   
						<ul>
							<li><a href="AdminClassicificationResult.jsp?district=130702" target="result"><input type="checkbox" name="district" value="130702" >桥东区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130703" target="result"><input type="checkbox" name="district" value="130703" >桥西区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130705" target="result"><input type="checkbox" name="district" value="130705" >宣化区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130706" target="result"><input type="checkbox" name="district" value="130706" >下花园区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130708" target="result"><input type="checkbox" name="district" value="130708" >万全区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130709" target="result"><input type="checkbox" name="district" value="130709" >崇礼县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130722" target="result"><input type="checkbox" name="district" value="130722" >张北县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130723" target="result"><input type="checkbox" name="district" value="130723" >康保县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130724" target="result"><input type="checkbox" name="district" value="130724" >沽源县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130725" target="result"><input type="checkbox" name="district" value="130725" >尚义县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130726" target="result"><input type="checkbox" name="district" value="130726" >蔚县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130727" target="result"><input type="checkbox" name="district" value="130727" >阳原县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130728" target="result"><input type="checkbox" name="district" value="130728" >怀安县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130730" target="result"><input type="checkbox" name="district" value="130730" >怀来县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130731" target="result"><input type="checkbox" name="district" value="130731" >逐鹿县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130732" target="result"><input type="checkbox" name="district" value="130732" >赤城县</a></li>
						</ul>
					</li> 
					<li><a href="#" class="inactive active">承德市</a>   
						<ul>
							<li><a href="AdminClassicificationResult.jsp?district=130802" target="result"><input type="checkbox" name="district" value="130802" >双桥区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130803" target="result"><input type="checkbox" name="district" value="130803" >双滦区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130804" target="result"><input type="checkbox" name="district" value="130804" >鹰手营子矿区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130821" target="result"><input type="checkbox" name="district" value="130821" >承德县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130822" target="result"><input type="checkbox" name="district" value="130822" >兴隆县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130824" target="result"><input type="checkbox" name="district" value="130824" >滦平县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130825" target="result"><input type="checkbox" name="district" value="130825" >隆化县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130826" target="result"><input type="checkbox" name="district" value="130826" >丰宁满族自治县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130827" target="result"><input type="checkbox" name="district" value="130827" >宽城满族自治县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130828" target="result"><input type="checkbox" name="district" value="130828" >围城满族蒙古族自治县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130881" target="result"><input type="checkbox" name="district" value="130881" >平泉市</a></li>
						</ul>
					</li> 
					<li><a href="#" class="inactive active">沧州市</a>   
						<ul>
							<li><a href="AdminClassicificationResult.jsp?district=130902" target="result"><input type="checkbox" name="district" value="130902" >新华区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130903" target="result"><input type="checkbox" name="district" value="130903" >运河区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130921" target="result"><input type="checkbox" name="district" value="130921" >沧县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130922" target="result"><input type="checkbox" name="district" value="130922" >青县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130923" target="result"><input type="checkbox" name="district" value="130923" >东光县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130924" target="result"><input type="checkbox" name="district" value="130924" >海兴县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130925" target="result"><input type="checkbox" name="district" value="130925" >盐山县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130926" target="result"><input type="checkbox" name="district" value="130926" >肃宁县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130927" target="result"><input type="checkbox" name="district" value="130927" >南皮县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130928" target="result"><input type="checkbox" name="district" value="130928" >吴桥县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130929" target="result"></a><input type="checkbox" name="district" value="130929" >献县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130930" target="result"><input type="checkbox" name="district" value="130930" >孟村回族自治县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130981" target="result"><input type="checkbox" name="district" value="130981" >泊头市</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130982" target="result"><input type="checkbox" name="district" value="130982" >任丘市</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130983" target="result"><input type="checkbox" name="district" value="130983" >黄骅市</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=130984" target="result"><input type="checkbox" name="district" value="130984" >河间市</a></li>
						</ul>
					</li> 
					<li><a href="#" class="inactive active">廊坊市</a>   
						<ul>
							<li><a href="AdminClassicificationResult.jsp?district=131002" target="result"><input type="checkbox" name="district" value="131002" >安次区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=131003" target="result"><input type="checkbox" name="district" value="131003" >广阳区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=131022" target="result"><input type="checkbox" name="district" value="131022" >固安县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=131023" target="result"><input type="checkbox" name="district" value="131023" >永清县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=131024" target="result"><input type="checkbox" name="district" value="131024" >香河县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=131025" target="result"><input type="checkbox" name="district" value="131025" >大城县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=131026" target="result"><input type="checkbox" name="district" value="131026" >永安县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=131028" target="result"><input type="checkbox" name="district" value="131028" >大厂回族自治县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=131081" target="result"><input type="checkbox" name="district" value="131081" >霸州市</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=131082" target="result"><input type="checkbox" name="district" value="131082" >三河市</a></li>
						</ul>
					</li> 
					<li><a href="#" class="inactive active">衡水市</a>   
						<ul>
							<li><a href="AdminClassicificationResult.jsp?district=131102" target="result"><input type="checkbox" name="district" value="131102" >桃城区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=131103" target="result"><input type="checkbox" name="district" value="131103" >冀州区</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=131121" target="result"><input type="checkbox" name="district" value="131121" >枣强县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=131122" target="result"><input type="checkbox" name="district" value="131122" >武邑县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=131123" target="result"><input type="checkbox" name="district" value="131123" >武强县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=131124" target="result"><input type="checkbox" name="district" value="131124" >饶阳县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=131125" target="result"><input type="checkbox" name="district" value="131125" >安平县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=131126" target="result"><input type="checkbox" name="district" value="131126" >故城县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=131127" target="result"><input type="checkbox" name="district" value="131127" >景县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=131128" target="result"><input type="checkbox" name="district" value="131128" >阜城县</a></li>
							<li><a href="AdminClassicificationResult.jsp?district=131182" target="result"><input type="checkbox" name="district" value="131182" >深州市</a></li>
						</ul>
				</ul>
			</li>
		</ul>
	</div>
	</form>
</body>
</html>