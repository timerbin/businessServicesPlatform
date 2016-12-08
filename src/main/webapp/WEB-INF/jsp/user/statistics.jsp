<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我的收藏</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<link href="${BASE_URL}/images/gerenzx.css" rel="stylesheet" type="text/css" />
<meta name="renderer" content="webkit" />
<jsp:include page="../public/baseData.jsp" />
<script type="text/javascript" src="${BASE_URL}/js/echarts.js" ></script>
<script type="text/javascript" src="${BASE_URL}/js/line.js" ></script>
</head>

<body>
<form id="doEditUserInfo" action="${BASE_URL}/user/toStatistics.html" method="post">
	<input id="collectType" name="type" value="${vo.type}" type="hidden"/>
	<input id="baseUrl"  value="${BASE_URL}" type="hidden"/>
	<jsp:include page="../public/loginheader.jsp" />
	<div class="top_tiao"></div>
	<div class="gerenzx_main">
	 <jsp:include page="../public/loginLeft.jsp" />
	 
	 <div class="gerenzx_right">
    	<div class="grzx_h2"><h2>访问情况分析</h2></div>
	      <table border="0" cellspacing="10" cellpadding="0" class="gerenzx_table">
	          <tr>
	            <td width="78" align="right">统计时间：</td>
	            <td width="190"><input name="" type="text" class="grzx_input" /></td>
	            <td width="37" align="center">至</td>
	            <td width="191"><input name="" type="text" class="grzx_input" /></td>
	            <td width="78" align="right">服务类别：</td>
	            <td width="153">
	            	<select name="" class="grzx_input">
	            		<c:forEach items="${serviceTypeList}" var="serviceType">
                   			<c:if test="${serviceType.id==queryVo.serviceType}">
	            	 			<option value="${serviceType.id}" selected="selected">${serviceType.showName}</option>
			   				</c:if>
			   				<c:if test="${serviceType.id!=queryVo.serviceType}">
	            	 			<option value="${serviceType.id}">${serviceType.showName}</option>
			   				</c:if>
						</c:forEach>
	            	</select>
	            </td>
	            <td width="90"><input name="" type="button" value="查询" class="grzx_button2" /></td>
	          </tr>
	          <tr>
	            <td colspan="7">
	            	<div id="statistics" style="height:500px;width:1000px;"></div>
	            </td>
	          </tr>
	     </table>
  </div>
</div>
<script type="text/javascript">
var baseUrl = $("#baseUrl").val();
$("#toStatistics").addClass("li_atab");
var option = {
	    title : {
	        text: '服务申请处理情况趋势分析',
	        x:'center'
	    },
	    tooltip : {
	        trigger: 'axis'
	    },
	    legend: {
	        data:['安置房','规划建设工程'],
	        orient:'vertical',
	        x:80,
	        y:'top',
	        borderColor:'#000000',
	        borderWidth:1,
	        backgroundColor:'rgba(0,0,0,0)'
	    },
	    calculable : true,
	    xAxis : [
	        {
	            type : 'category',
	            boundaryGap : false,
	            data : ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月']
	        }
	    ],
	    yAxis : [
	        {
	            type : 'value',
	            max:2000
	        }
	    ],
	    series : [
	        {
	            name:'规划建设工程',
	            type:'line',
	            smooth:true,
	            itemStyle: {normal: {areaStyle: {type: 'default'}}},
	            data:[10, 12, 21, 54, 260, 830, 710,700,700,700,700,700]
	        },
	        {
	            name:'安置房',
	            type:'line',
	            smooth:true,
	            itemStyle: {normal: {areaStyle: {type: 'default'}}},
	            data:[30, 182, 434, 791, 390, 30, 10,700,700,700,700,700]
	        }
	    ]
	};

require.config({
    paths: {
        echarts: './js'
    }
});
require(
        [
            'echarts',
            'echarts/chart/line',   
        ],
        function (ec) {
            var myChart = ec.init(document.getElementById('statistics'));
            myChart.setOption(option);
        }
    );

 
</script>

</form>
</body>
</html>

