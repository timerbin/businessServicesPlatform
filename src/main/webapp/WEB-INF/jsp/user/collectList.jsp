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
<form id="doEditUserInfo" action="${BASE_URL}/user/doEditUserInfo.html" method="post">
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
			    <input name="" type="button" value="收藏的服务" class="llls_button" />
			    <input name="" type="button" value="收藏的企业" class="llls_button2" />
			</c:if>
			<c:if test="${vo.type==2}">
				<input name="" type="button" value="收藏的服务" class="llls_button2" />
			    <input name="" type="button" value="收藏的企业" class="llls_button" />
			</c:if>
        </div>
        <c:if test="${vo.type==1}">
	        <c:forEach items="${collectList}" var="collect">
	        	<div class="wdsc_list">
		            <div class="wdsc_left"><img src="${BASE_URL}/images/home_yzqy_16.jpg" /></div>
		            <div class="wdsc_center">
		                <h3>斐讯数据通信技术有限公司</h3>
		                <p>激情发展、追求卓越、客户价值、共同成长</p>
		                <span>北京天地仁财务咨询有限公司</span>
		            </div>
		            <span class="wdsc_right"><img src="${BASE_URL}/images/shoucang.png" /></span>
		            <div class="clear"></div>
	        	</div>
        	</c:forEach>
       	</c:if>
        <c:if test="${vo.type==2}">
	        <div class="wdsc_list2">
	            <ul>
	            	<c:forEach items="${collectList}" var="collect">
		        	  	<li>
		                    <span class="wdsc_qiye"><img src="images/home_yzqy_16.jpg" /></span>
		                    <h3>斐讯数据通信技术有限公司</h3>
		                    <span class="qysc_pp">激情发展、追求卓越、客户价值、共同成长</span>
		                    <span class="wdsdc_qy_xing"><img src="images/shoucang.png" /></span>
	                	</li>
	        		</c:forEach>
	            </ul>
	        </div>
        </c:if>
  </div>
</div>
<script type="text/javascript">
$("#updateBtn").click(function(){
	$('.td_dis').each(function(){
		 $(this).removeClass("td_dis");
		 $('#updateBtn').hide();
	});
});
$("#saveBtn").click(function(){
	if(check()){
		$("#doEditUserInfo").submit();
	}
});
function check(){
	var raleName = $("#raleName").val();
	if($.trim(raleName).length <= 0){
		alert("请输入姓名");
		 $("#raleName").focus();
		return false;
	}
	var mobilePhone = $("#mobilePhone").val();
	if($.trim(mobilePhone).length <= 0){
		alert("请输入联系方式");
		 $("#mobilePhone").focus();
		return false;
	}
	if(!checkMob(mobilePhone)){
		alert("请输入正确联系方式");
		$("#mobilePhone").focus();
		return false;
	}
	var email = $("#email").val();
	if($.trim(email).length <= 0){
		alert("请输入邮箱");
		 $("#email").focus();
		return false;
	}
	 var isemail  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	 if(!isemail.test(email)){
		 alert("请输入正确邮箱格式");
		 $("#email").focus();
		return false;
	 }
	 
	return true;
}
var isMob = /^((13[0-9])|(14[0-9])|(15[0-9])|(18[0-9])|(17[0-9]))\d{8}$/;
function checkMob(mobile) {
	if (isMob.test(mobile)) {
		return true;
	} else {
		return false;
	}
}
</script>

</form>
</body>
</html>

