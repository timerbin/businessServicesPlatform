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
</head>

<body>
<form id="doEditUserInfo" action="${BASE_URL}/user/collectList.html" method="post">
	<input id="collectType" name="type" value="${vo.type}" type="hidden"/>
	<input id="baseUrl"  value="${BASE_URL}" type="hidden"/>
	<jsp:include page="../public/loginheader.jsp" />
	<div class="top_tiao"></div>
	<div class="gerenzx_main">
	 <jsp:include page="../public/loginLeft.jsp" />
    <div class="gerenzx_right">
    	<div class="grzx_h2">
    		<h2>我的收藏</h2>
    	</div>
      	<div class="llls_button_box">
			<c:if test="${vo.type==1}">
			    <input id="collectService"  type="button" value="收藏的服务" class="llls_button" />
			    <input id="collectCompany"  type="button" value="收藏的企业" class="llls_button2" />
			</c:if>
			<c:if test="${vo.type==2}">
				<input id="collectService"  type="button" value="收藏的服务" class="llls_button2" />
			    <input id="collectCompany"  type="button" value="收藏的企业" class="llls_button" />
			</c:if>
        </div>
        <div class="wdsc_list">
            <div class="wdsc_left"><img src="${BASE_URL}/${collect.baseUserCompanyVo.logoPicPath}" /></div>
            <div class="wdsc_center">
                <h3>${collect.userCompanyServiceVo.serviceName}</h3>
                <p>${collect.userCompanyServiceVo.serviceDirections}</p>
                <span>${collect.baseUserCompanyVo.companyName}</span>
            </div>
            <span class="wdsc_right"><img class="serviceBtn" dataCompanyId="12" dataId="12" src="${BASE_URL}/images/shoucang.png" /></span>
            <div class="clear"></div>
       	</div>
        <c:if test="${vo.type==1}">
	        <c:forEach items="${collectList}" var="collect">
	        	<div class="wdsc_list">
		            <div class="wdsc_left"><img src="${BASE_URL}/${collect.baseUserCompanyVo.logoPicPath}" /></div>
		            <div class="wdsc_center">
		                <h3>${collect.userCompanyServiceVo.serviceName}</h3>
		                <p>${collect.userCompanyServiceVo.serviceDirections}</p>
		                <span>${collect.baseUserCompanyVo.companyName}</span>
		            </div>
		            <span class="wdsc_right"><img class="serviceBtn" dataCompanyId="${collect.userCompanyServiceVo.id}" dataId="${collect.userCompanyServiceVo.id}" src="${BASE_URL}/images/shoucang.png" /></span>
		            <div class="clear"></div>
	        	</div>
        	</c:forEach>
       	</c:if>
        <c:if test="${vo.type==2}">
	        <div class="wdsc_list2">
	            <ul>
	            	<c:forEach items="${collectList}" var="collect">
		        	  	<li>
		                    <span class="wdsc_qiye"><img src="${BASE_URL}/${collect.baseUserCompanyVo.logoPicPath}" /></span>
		                    <h3>${collect.baseUserCompanyVo.companyName}</h3>
		                    <span class="qysc_pp">${collect.baseUserCompanyVo.companyDirections}</span>
		                    <span class="wdsdc_qy_xing"><img class="companyBtn" dataId="${collect.userCompanyServiceVo.id}" src="${BASE_URL}/images/shoucang.png" /></span>
	                	</li>
	        		</c:forEach>
	            </ul>
	        </div>
        </c:if>
  </div>
</div>
<script type="text/javascript">
$("#collectList").addClass("li_atab");
var baseUrl = $("#baseUrl").val();
$(".serviceBtn").click(function(){
	var serviceId = $(this).attr("dataId");
	var companyId = $(this).attr("dataCompanyId");
	if(serviceId.length>0 && companyId.length>0){
		$.ajax({
	        url: baseUrl+"/user/delCollect.html",
	        data : {"serviceId":serviceId,"companyId":companyId},
	        type : 'POST',
	        success: function (data) {
	            if (data) {
	            	$(this).hide();
	            }else{
	            	alert("取消收藏失败");
	            }
	        }
	    });
	}else{
		alert("取消收藏失败");
	}
});
$(".companyBtn").click(function(){
	var companyId = $(this).attr("dataId");
	if(companyId.length>0){
		$.ajax({
			url: baseUrl+"/user/delCollect.html",
	        data : {"companyId":companyId},
	        type : 'POST',
	        success: function (data) {
	            if (data) {
	            	$(this).hide();
	            }else{
	            	alert("取消收藏失败");
	            }
	        }
	    });
	}else{
		alert("取消收藏失败");
	}
});
$("#collectService").click(function(){
	$("#collectType").val(1);
	$("#doEditUserInfo").submit();
});
$("#collectCompany").click(function(){
	$("#collectType").val(2);
	$("#doEditUserInfo").submit();
});
</script>

</form>
</body>
</html>

