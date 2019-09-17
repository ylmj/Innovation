<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="layui/css/layui.css" />
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<link rel="stylesheet" type="text/css" href="layui/css/modules/code.css"/>
<script type="text/javascript" src="js/StandardIndustrialClassificationCodes.js"></script>
<script type="text/javascript" src="layui/layui.js"></script>
<script type="text/javascript" src="layui/layui.all.js"></script>
<title>分类浏览</title>
<style type="text/css">
a:{
/* target:"right"; */
}
</style>
</head>
<body>
<div>
<ul id="demo" >
</ul>
</div>
</body>
<script type="text/javascript">
layui.use(['layer','tree','form'],function(){
	checkbox:true
	var layer=layui.layer
/* 	,$layui.jquery */;
layui.tree({
	  elem: '#demo' //传入元素选择器
	  ,checkbox:true
	  ,target:'result'
	/*   ,url:'AdminClassificationResult.jsp?district='+JSON.stringify(item.id) */
	 /* ,click: function(item){ //点击节点回调  
		  href:'AdminClassificationResult.jsp?district='+JSON.stringify(item.id)
				  //跳转问题待解决
	 layer.msg('当前节名称：'+ item.name + '<br>全部参数：'+ JSON.stringify(item.id));  
	  console.log(item);  
	 }  */
	  ,nodes: [{ //节点
	    name: '河北省'
	    ,spread:true//结点是否展开
	    ,children: [{
	      name: '石家庄市'
	      ,children:[{
	    	  name: '长安区'
	    	  ,id: 130102
	         ,href: 'AdminClassicificationResult.jsp?district=130102'
	    	  /* ,alias: 'weidu' 命令别名  */
	      },{
	    	  name: '桥西区'
		      ,id: 130104
		      ,href: 'AdminClassicificationResult.jsp?district=130104'
	      },{
	    	  name: '新华区'
		      ,id: 130105
		      ,href: 'AdminClassicificationResult.jsp?district=130105'
	      },{
	    	  name:'井陉矿区'
	    	  ,id:130107
	    	  ,href:'AdminClassicificationResult.jsp?district=130107'
	      },{
	    	  name:'裕华区'
		      ,id:130108
		      ,href:'AdminClassicificationResult.jsp?district=130108'
	      },{
	    	  name:'藁城区'
	    	  ,id:130109
	    	  ,href:'AdminClassicificationResult.jsp?district=130109'
	      },{
	    	  name:'鹿泉区'
	    	  ,id:130110
	    	  ,href:'AdminClassicificationResult.jsp?district=130110'
	      },{
	    	  name:'栾城区'
	    	  ,id:130111
	    	  ,href:'AdminClassicificationResult.jsp?district=130111'
	      },{
	    	  name:'井陉县'
	    	  ,id:130121
	    	  ,href:'AdminClassicificationResult.jsp?district=130121'
	      },{
	    	  name:'正定县'
	    	  ,id:130123
	    	  ,href:'AdminClassicificationResult.jsp?district=130123'
	      },{
	    	  name:'行唐县'
	    	  ,id:130125
	    	  ,href:'AdminClassicificationResult.jsp?district=130125'
	      },{
	    	  name:'灵寿县'
	    	  ,id:130126
	    	  ,href:'AdminClassicificationResult.jsp?district=130126'
	      },{
	    	  name:'高邑县'
	    	  ,id:130127
	    	  ,href:'AdminClassicificationResult.jsp?district=130127'
	      },{
	    	  name:'深泽县'
	    	  ,id:130128
	    	  ,href:'AdminClassicificationResult.jsp?district=130128'
	      },{
	    	  name:'赞皇县'
	    	  ,id:130129
	    	  ,href:'AdminClassicificationResult.jsp?district=130129'
	      },{
	    	  name:'无极县'
	    	  ,id:130130
	    	  ,href:'AdminClassicificationResult.jsp?district=130130'
	      },{
	    	  name:'平山县'
	    	  ,id:130131
	    	  ,href:'AdminClassicificationResult.jsp?district=130131'
	      },{
	    	  name:'元氏县'
	    	  ,id:130132
	    	  ,href:'AdminClassicificationResult.jsp?district=130132'
	      },{
	    	  name:'赵县'
	    	  ,id:130133
	    	  ,href:'AdminClassicificationResult.jsp?district=130133'
	      },{
	    	  name:'辛集市'
	    	  ,id:130181
	    	  ,href:'AdminClassicificationResult.jsp?district=130181'
	      },{
	    	  name:'晋州市'
	    	  ,id:130183
	    	  ,href:'AdminClassicificationResult.jsp?district=130183'
	      },{
	    	  name:'新乐市'
	    	  ,id:130184
	    	  ,href:'AdminClassicificationResult.jsp?district=130184'
	      }]
	    },{
	      name: '唐山市'
	    	  ,children:[{
		    	  name: '路南区'
		    	  ,id: 130202
		    	  ,href: 'AdminClassicificationResult.jsp?district=130202'
		    	  /* ,alias: 'weidu' 命令别名  */
		      },{
		    	  name: '路北区'
			      ,id: 130203
			      ,href: 'AdminClassicificationResult.jsp?district=130203'
		      },{
		    	  name: '古冶区'
			      ,id: 130204
			      ,href: 'AdminClassicificationResult.jsp?district=130204'
		      },{
		    	  name:'开平区'
		    	  ,id:130205
		    	  ,href:'AdminClassicificationResult.jsp?district=130205'
		      },{
		    	  name:'丰南区'
			      ,id:130207
			      ,href:'AdminClassicificationResult.jsp?district=130207'
		      },{
		    	  name:'丰润区'
		    	  ,id:130208
		    	  ,href:'AdminClassicificationResult.jsp?district=130208'
		      },{
		    	  name:'曹妃甸区'
		    	  ,id:130209
		    	  ,href:'AdminClassicificationResult.jsp?district=130209'
		      },{
		    	  name:'滦县'
		    	  ,id:130223
		    	  ,href:'AdminClassicificationResult.jsp?district=130223'
		      },{
		    	  name:'滦南县'
		    	  ,id:130224
		    	  ,href:'AdminClassicificationResult.jsp?district=130224'
		      },{
		    	  name:'乐亭县'
		    	  ,id:130225
		    	  ,href:'AdminClassicificationResult.jsp?district=130225'
		      },{
		    	  name:'迁西县'
		    	  ,id:130227
		    	  ,href:'AdminClassicificationResult.jsp?district=130227'
		      },{
		    	  name:'玉田县'
		    	  ,id:130229
		    	  ,href:'AdminClassicificationResult.jsp?district=130229'
		      },{
		    	  name:'遵化市'
		    	  ,id:130281
		    	  ,href:'AdminClassicificationResult.jsp?district=130281'
		      },{
		    	  name:'迁安市'
		    	  ,id:130283
		    	  ,href:'AdminClassicificationResult.jsp?district=130283'
		      }]
	    },{
	      name: '秦皇岛市'
	    	  ,children:[{
		    	  name: '海港区'
		    	  ,id: 130302
		    	  ,href: 'AdminClassicificationResult.jsp?district=130302'
		    	  /* ,alias: 'weidu' 命令别名  */
		      },{
		    	  name: '山海关区'
			      ,id: 130303
			      ,href: 'AdminClassicificationResult.jsp?district=130303'
		      },{
		    	  name: '北戴河区'
			      ,id: 130304
			      ,href: 'AdminClassicificationResult.jsp?district=130304'
		      },{
		    	  name:'抚宁区'
		    	  ,id:130306
		    	  ,href:'AdminClassicificationResult.jsp?district=130306'
		      },{
		    	  name:'青龙满族自治县'
			      ,id:130321
			      ,href:'AdminClassicificationResult.jsp?district=130321'
		      },{
		    	  name:'昌黎县'
		    	  ,id:130322
		    	  ,href:'AdminClassicificationResult.jsp?district=130322'
		      },{
		    	  name:'卢龙县'
		    	  ,id:130324
		    	  ,href:'AdminClassicificationResult.jsp?district=130324'
		      }]
	    },{
	      name:  '邯郸市'
	    	  ,children:[{
		    	  name: '邯山区'
		    	  ,id: 130402
		    	  ,href: 'AdminClassicificationResult.jsp?district=130402'
		    	  /* ,alias: 'weidu' 命令别名  */
		      },{
		    	  name: '丛台区'
			      ,id: 130403
			      ,href: 'AdminClassicificationResult.jsp?district=130403'
		      },{
		    	  name: '复兴区'
			      ,id: 130404
			      ,href: 'AdminClassicificationResult.jsp?district=130404'
		      },{
		    	  name:'峰峰矿区'
		    	  ,id:130406
		    	  ,href:'AdminClassicificationResult.jsp?district=130406'
		      },{
		    	  name:'肥乡区'
			      ,id:130407
			      ,href:'AdminClassicificationResult.jsp?district=130407'
		      },{
		    	  name:'永年区'
		    	  ,id:130408
		    	  ,href:'AdminClassicificationResult.jsp?district=130408'
		      },{
		    	  name:'临漳县'
		    	  ,id:130423
		    	  ,href:'AdminClassicificationResult.jsp?district=130423'
		      },{
		    	  name:'成安县'
		    	  ,id:130424
		    	  ,href:'AdminClassicificationResult.jsp?district=130424'
		      },{
		    	  name:'大名县'
		    	  ,id:130425
		    	  ,href:'AdminClassicificationResult.jsp?district=130425'
		      },{
		    	  name:'涉县'
		    	  ,id:130426
		    	  ,href:'AdminClassicificationResult.jsp?district=130426'
		      },{
		    	  name:'磁县'
		    	  ,id:130427
		    	  ,href:'AdminClassicificationResult.jsp?district=130427'
		      },{
		    	  name:'邱县'
		    	  ,id:130430
		    	  ,href:'AdminClassicificationResult.jsp?district=130430'
		      },{
		    	  name:'鸡泽县'
		    	  ,id:130431
		    	  ,href:'AdminClassicificationResult.jsp?district=130431'
		      },{
		    	  name:'广平县'
		    	  ,id:130432
		    	  ,href:'AdminClassicificationResult.jsp?district=130432'
		      },{
		    	  name:'馆陶县'
			     ,id:130433
			     ,href:'AdminClassicificationResult.jsp?district=130433'
			  },{
			     name:'魏县'
			     ,id:130434
			     ,href:'AdminClassicificationResult.jsp?district=130434'
			  },{
			    name:'曲周县'
			    ,id:130435
			    ,href:'AdminClassicificationResult.jsp?district=130435'
			  },{
			    name:'武安市'
			    ,id:130481
			    ,href:'AdminClassicificationResult.jsp?district=130481'
			  }]
	    },{
	      name:  '邢台市'
	    	  ,children:[{
		    	  name: '桥东区'
		    	  ,id: 130502
		    	  ,href: 'AdminClassicificationResult.jsp?district=130502'
		    	  /* ,alias: 'weidu' 命令别名  */
		      },{
		    	  name: '桥西区'
			      ,id: 130503
			      ,href: 'AdminClassicificationResult.jsp?district=130503'
		      },{
		    	  name: '邢台县'
			      ,id: 130521
			      ,href: 'AdminClassicificationResult.jsp?district=130521'
		      },{
		    	  name:'临城县'
		    	  ,id:130522
		    	  ,href:'AdminClassicificationResult.jsp?district=130522'
		      },{
		    	  name:'内丘县'
			      ,id:130523
			      ,href:'AdminClassicificationResult.jsp?district=130523'
		      },{
		    	  name:'柏乡县'
		    	  ,id:130524
		    	  ,href:'AdminClassicificationResult.jsp?district=130524'
		      },{
		    	  name:'隆尧县'
		    	  ,id:130525
		    	  ,href:'AdminClassicificationResult.jsp?district=130525'
		      },{
		    	 name: '任县'
				 ,id: 130526
				 ,href: 'AdminClassicificationResult.jsp?district=130526'
			  },{
			     name: '南和县'
				 ,id: 130527
				 ,href: 'AdminClassicificationResult.jsp?district=130527'
			  },{
			      name:'宁晋县'
			      ,id:130528
			      ,href:'AdminClassicificationResult.jsp?district=130528'
			  },{
			     name:'巨鹿县'
				 ,id:130529
			     ,href:'AdminClassicificationResult.jsp?district=130529'
			  },{
			    name:'新河县'
			    ,id:130530
			    ,href:'AdminClassicificationResult.jsp?district=130530'
			  },{
			    name:'广宗县'
			    ,id:130531
			    ,href:'AdminClassicificationResult.jsp?district=130531'
			  },{
			    name: '平乡县'
				,id: 130532
				,href: 'AdminClassicificationResult.jsp?district=130532'
			  },{
				 name: '威县'
				,id: 130533
				,href: 'AdminClassicificationResult.jsp?district=130533'
			 },{
				name:'清河县'
				,id:130534
				,href:'AdminClassicificationResult.jsp?district=130534'
			 },{
				name:'临西县'
				,id:130535
				,href:'AdminClassicificationResult.jsp?district=130535'
			},{
				name:'南宫市'
				,id:130581
				,href:'AdminClassicificationResult.jsp?district=130581'
		    },{
				name:'沙河县'
				,id:130582
				,href:'AdminClassicificationResult.jsp?district=130582'
		    }]
	    },{
	      name:  '保定市'
	    	  ,children:[{
		    	  name: '竞秀区'
		    	  ,id: 130602
		    	  ,href: 'AdminClassicificationResult.jsp?district=130602'
		    	  /* ,alias: 'weidu' 命令别名  */
		      },{
		    	  name: '莲池区'
			      ,id: 130606
			      ,href: 'AdminClassicificationResult.jsp?district=130606'
		      },{
		    	  name: '满城区'
			      ,id: 130607
			      ,href: 'AdminClassicificationResult.jsp?district=130607'
		      },{
		    	  name:'清苑区'
		    	  ,id:130608
		    	  ,href:'AdminClassicificationResult.jsp?district=130608'
		      },{
		    	  name:'徐水区'
			      ,id:130609
			      ,href:'AdminClassicificationResult.jsp?district=130609'
		      },{
		    	  name:'涞水县'
		    	  ,id:130623
		    	  ,href:'AdminClassicificationResult.jsp?district=130623'
		      },{
		    	  name:'阜平县'
		    	  ,id:130624
		    	  ,href:'AdminClassicificationResult.jsp?district=130624'
		      },{
		    	  name: '定兴县'
		    	  ,id: 130626
		    	  ,href: 'AdminClassicificationResult.jsp?district=130626'
		    	  /* ,alias: 'weidu' 命令别名  */
		      },{
		    	  name: '唐县'
			      ,id: 130627
			      ,href: 'AdminClassicificationResult.jsp?district=130627'
		      },{
		    	  name: '高阳县'
			      ,id: 130628
			      ,href: 'AdminClassicificationResult.jsp?district=130628'
		      },{
		    	  name:'容城县'
		    	  ,id:130629
		    	  ,href:'AdminClassicificationResult.jsp?district=130629'
		      },{
		    	  name:'涞源县'
			      ,id:130630
			      ,href:'AdminClassicificationResult.jsp?district=130630'
		      },{
		    	  name:'望都县'
		    	  ,id:130631
		    	  ,href:'AdminClassicificationResult.jsp?district=130631'
		      },{
		    	  name:'安新县'
		    	  ,id:1130632
		    	  ,href:'AdminClassicificationResult.jsp?district=130632'
		      },{
		    	  name:'易县'
		    	  ,id:130633
		    	  ,href:'AdminClassicificationResult.jsp?district=130633'
		      },{
		    	  name:'曲阳县'
		    	  ,id:130634
		    	  ,href:'AdminClassicificationResult.jsp?district=130634'
		      },{
		    	  name:'蠡县'
		    	  ,id:130635
		    	  ,href:'AdminClassicificationResult.jsp?district=130635'
		      },{
		    	  name:'顺平县'
		    	  ,id:130636
		    	  ,href:'AdminClassicificationResult.jsp?district=130636'
		      },{
		    	  name:'博野县'
		    	  ,id:130637
		    	  ,href:'AdminClassicificationResult.jsp?district=130637'
		      },{
		    	  name:'雄县'
		    	  ,id:130638
		    	  ,href:'AdminClassicificationResult.jsp?district=130638'
		      },{
		    	  name:'涿州市'
		    	  ,id:130681
		    	  ,href:'AdminClassicificationResult.jsp?district=130681'
		      },{
		    	  name:'定州市'
			     ,id:130682
			     ,href:'AdminClassicificationResult.jsp?district=130682'
			  },{
			     name:'安国市'
			     ,id:130683
			     ,href:'AdminClassicificationResult.jsp?district=130683'
			  },{
			    name:'高碑店市'
			    ,id:130684
			    ,href:'AdminClassicificationResult.jsp?district=130684'
			  }]
	    },{
	      name:  '张家口市'
	    	  ,children:[{
		    	  name: '桥东区'
		    	  ,id: 130702
		    	  ,href: 'AdminClassicificationResult.jsp?district=130702'
		    	  /* ,alias: 'weidu' 命令别名  */
		      },{
		    	  name: '桥西区'
			      ,id: 130703
			      ,href: 'AdminClassicificationResult.jsp?district=130703'
		      },{
		    	  name: '宣化区'
			      ,id: 130705
			      ,href: 'AdminClassicificationResult.jsp?district=130705'
		      },{
		    	  name:'下花园区'
		    	  ,id:130706
		    	  ,href:'AdminClassicificationResult.jsp?district=130706'
		      },{
		    	  name:'万全区'
			      ,id:130708
			      ,href:'AdminClassicificationResult.jsp?district=130708'
		      },{
		    	  name:'崇礼区'
		    	  ,id:130709
		    	  ,href:'AdminClassicificationResult.jsp?district=130709'
		      },{
		    	  name:'张北县'
		    	  ,id:130722
		    	  ,href:'AdminClassicificationResult.jsp?district=130722'
		      },{
		    	  name: '康保县'
		    	  ,id: 130723
		    	  ,href: 'AdminClassicificationResult.jsp?district=130723'
		    	  /* ,alias: 'weidu' 命令别名  */
		      },{
		    	  name: '沽源县'
			      ,id: 130724
			      ,href: 'AdminClassicificationResult.jsp?district=130724'
		      },{
		    	  name: '尚义县'
			      ,id: 130725
			      ,href: 'AdminClassicificationResult.jsp?district=130725'
		      },{
		    	  name:'蔚县'
		    	  ,id:130726
		    	  ,href:'AdminClassicificationResult.jsp?district=130726'
		      },{
		    	  name:'阳原县'
			      ,id:130727
			      ,href:'AdminClassicificationResult.jsp?district=130727'
		      },{
		    	  name:'怀安县'
		    	  ,id:130728
		    	  ,href:'AdminClassicificationResult.jsp?district=130728'
		      },{
		    	  name:'怀来县'
		    	  ,id:130730
		    	  ,href:'AdminClassicificationResult.jsp?district=130730'
		      },{
		    	  name:'涿鹿县'
		    	  ,id:130731
		    	  ,href:'AdminClassicificationResult.jsp?district=130731'
		      },{
		    	  name:'赤城县'
		    	  ,id:130732
		    	  ,href:'AdminClassicificationResult.jsp?district=130732'
		      }]
	    },{
	      name:  '承德市'
	    	  ,children:[{
		    	  name: '双桥区'
		    	  ,id: 130802
		    	  ,href: 'AdminClassicificationResult.jsp?district=130802'
		    	  /* ,alias: 'weidu' 命令别名  */
		      },{
		    	  name: '双滦区'
			      ,id: 130803
			      ,href: 'AdminClassicificationResult.jsp?district=130803'
		      },{
		    	  name: '鹰手营子矿区'
			      ,id: 130804
			      ,href: 'AdminClassicificationResult.jsp?district=130804'
		      },{
		    	  name:'承德县'
		    	  ,id:130821
		    	  ,href:'AdminClassicificationResult.jsp?district=130821'
		      },{
		    	  name:'兴隆县'
			      ,id:130822
			      ,href:'AdminClassicificationResult.jsp?district=130822'
		      },
		      {
		    	  name:'滦平县'
			      ,id:130824
			      ,href:'AdminClassicificationResult.jsp?district=130824'
		      },{
		    	  name:'隆化县'
		    	  ,id:130825
		    	  ,href:'AdminClassicificationResult.jsp?district=130825'
		      },{
		    	  name:'丰宁满族自治县'
		    	  ,id:130826
		    	  ,href:'AdminClassicificationResult.jsp?district=130826'
		      },{
		    	  name: '宽城满族自治县'
			      ,id: 130827
			      ,href: 'AdminClassicificationResult.jsp?district=130827'
		      },{
		    	  name: '围场满族蒙古族自治县'
			      ,id: 130828
			      ,href: 'AdminClassicificationResult.jsp?district=130828'
		      },{
		    	  name:'平泉市'
		    	  ,id:130881
		    	  ,href:'AdminClassicificationResult.jsp?district=130881'
		      }]
	    },{
	      name:	 '沧州市'
	    	  ,children:[{
		    	  name: '新华区'
		    	  ,id: 130902
		    	  ,href: 'AdminClassicificationResult.jsp?district=130902'
		    	  /* ,alias: 'weidu' 命令别名  */
		      },{
		    	  name: '运河区'
			      ,id: 130903
			      ,href: 'AdminClassicificationResult.jsp?district=130903'
		      },{
		    	  name: '沧县'
			      ,id: 130921
			      ,href: 'AdminClassicificationResult.jsp?district=130921'
		      },{
		    	  name:'青县'
		    	  ,id:130922
		    	  ,href:'AdminClassicificationResult.jsp?district=130921'
		      },{
		    	  name:'东光县'
			      ,id:130923
			      ,href:'AdminClassicificationResult.jsp?district=130923'
		      },{
		    	  name:'海兴县'
				  ,id:130924
				  ,href:'AdminClassicificationResult.jsp?district=130924'
			  },{
		    	  name:'盐山县'
		    	  ,id:130925
		    	  ,href:'AdminClassicificationResult.jsp?district=130925'
		      },{
		    	  name:'肃宁县'
		    	  ,id:130926
		    	  ,href:'AdminClassicificationResult.jsp?district=130926'
		      },{
		    	  name: '南皮县'
			      ,id: 130927
			      ,href: 'AdminClassicificationResult.jsp?district=130927'
		      },{
		    	  name: '吴桥县'
			      ,id: 130928
			      ,href: 'AdminClassicificationResult.jsp?district=130928'
		      },{
		    	  name:'献县'
		    	  ,id:130929
		    	  ,href:'AdminClassicificationResult.jsp?district=130929'
		      },{
		    	  name:'孟村回族自治县'
			      ,id:130930
			      ,href:'AdminClassicificationResult.jsp?district=130930'
		      },{
		    	  name:'泊头市'
		    	  ,id:130981
		    	  ,href:'AdminClassicificationResult.jsp?district=130981'
		      },{
		    	  name:'任丘市'
		    	  ,id:130982
		    	  ,href:'AdminClassicificationResult.jsp?district=130982'
		      },{
		    	  name:'黄骅市'
		    	  ,id:130983
		    	  ,href:'AdminClassicificationResult.jsp?district=130983'
		      },{
		    	  name:'河间市'
		    	  ,id:130984
		    	  ,href:'AdminClassicificationResult.jsp?district=130984'
		      }]
	    },{
	      name:  '廊坊市'
	    	  ,children:[{
		    	  name: '安次区'
		    	  ,id: 131002
		    	  ,href: 'AdminClassicificationResult.jsp?district=131002'
		    	  /* ,alias: 'weidu' 命令别名  */
		      },{
		    	  name: '广阳区'
			      ,id: 131003
			      ,href: 'AdminClassicificationResult.jsp?district=131003'
		      },{
		    	  name: '固安县'
			      ,id: 131022
			      ,href: 'AdminClassicificationResult.jsp?district=131022'
		      },{
		    	  name:'永清县'
		    	  ,id:131023
		    	  ,href:'AdminClassicificationResult.jsp?district=131023'
		      },{
		    	  name:'香河县'
			      ,id:131024
			      ,href:'AdminClassicificationResult.jsp?district=131024'
		      },{
		    	  name:'大城县'
		    	  ,id:131025
		    	  ,href:'AdminClassicificationResult.jsp?district=131025'
		      },{
		    	  name:'文安县'
		    	  ,id:131026
		    	  ,href:'AdminClassicificationResult.jsp?district=131026'
		      },{
		    	  name: '大厂回族自治县'
			      ,id: 131028
			      ,href: 'AdminClassicificationResult.jsp?district=131028'
		      },{
		    	  name: '霸州市'
			      ,id: 131081
			      ,href: 'AdminClassicificationResult.jsp?district=131081'
		      },{
		    	  name:'三河市'
		    	  ,id:131082
		    	  ,href:'AdminClassicificationResult.jsp?district=131082'
		      }]
	    },{
	      name:  '衡水市'
	    	  ,children:[{
		    	  name: '桃城区'
		    	  ,id: 131102
		    	  ,href: 'AdminClassicificationResult.jsp?district=131102'
		    	  /* ,alias: 'weidu' 命令别名  */
		      },{
		    	  name: '冀州区'
			      ,id: 131103
			      ,href: 'AdminClassicificationResult.jsp?district=131103'
		      },{
		    	  name: '枣强县'
			      ,id: 131121
			      ,href: 'AdminClassicificationResult.jsp?district=131121'
		      },{
		    	  name:'武邑县'
		    	  ,id:131122
		    	  ,href:'AdminClassicificationResult.jsp?district=131122'
		      },{
		    	  name:'武强县'
			      ,id: 131123
			      ,href:'AdminClassicificationResult.jsp?district=131123'
		      },{
		    	  name:'饶阳县'
		    	  ,id: 131124
		    	  ,href:'AdminClassicificationResult.jsp?district=131124'
		      },{
		    	  name:'安平县'
		    	  ,id: 131125
		    	  ,href:'AdminClassicificationResult.jsp?district=131125'
		      },{
		    	  name: '故城县'
			      ,id: 131126
			      ,href: 'AdminClassicificationResult.jsp?district=131126'
		      },{
		    	  name: '景县'
			      ,id: 131127
			      ,href: 'AdminClassicificationResult.jsp?district=131127'
		      },{
		    	  name:'阜城县'
		    	  ,id: 131128
		    	  ,href:'AdminClassicificationResult.jsp?district=131128'
		      },{
		    	  name:'深州市'
			      ,id: 131182
			      ,href:'AdminClassicificationResult.jsp?district=131182'
		      }]
	    }]
	  }]
	});
})

</script>
</html>