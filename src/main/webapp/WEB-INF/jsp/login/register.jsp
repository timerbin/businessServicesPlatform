<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<link href="${BASE_URL}/images/login.css" rel="stylesheet" type="text/css" />
<meta name="renderer" content="webkit" />
<jsp:include page="../public/baseData.jsp" />
</head>
<body>

<form id="doRegister" action="${BASE_URL}/login/doRegister.html" method="post">
 <input id="userSexStr"  value="${vo.userSex}" type="hidden"/>
<div class="login_head">
	<div class="login_title"><img src="${BASE_URL}/images/zhuce_h.png" /></div>
</div>
<div class="login_box">
	<ul>
		<c:if test="${not empty errorMsg}">
	        <li class="margin_top20">
	            <span style="color:red;">${errorMsg}</span>
	        </li>
		</c:if>
    	<li class="border_bj margin_top20">
            <span class="login_img"><img src="${BASE_URL}/images/goin_yh.png" /></span>
            <input id="userName" maxlength="20" name="userName" value="${vo.userName}" type="text" placeholder="设置登录账号" class="login_input_text" />
        </li>
        <li class="border_bj margin_top20">
            <span class="login_img"><img src="${BASE_URL}/images/goin_mm.png" /></span>
            <input id="userPassword" maxlength="20" name="userPassword" type="password" placeholder="设置登录密码" class="login_input_text" />
        </li>
        <li class="border_bj margin_top20">
            <span class="login_img"><img src="${BASE_URL}/images/goin_mm.png" /></span>
            <input id="userPassword2" maxlength="20" name="userPassword2" type="password" placeholder="输入确认密码" class="login_input_text" />
        </li>
        <li class="border_bj margin_top20">
            <span class="login_img"><img src="${BASE_URL}/images/zhuce_xm.png" /></span>
            <input id="trueName" maxlength="10" name="trueName" value="${vo.trueName}"  type="text" placeholder="姓名" class="login_input_text" />
        </li>
        <li>
        	<input id="userSex1" name="userSex" type="radio" value="0"   />
        	 男 &nbsp;&nbsp;&nbsp;&nbsp;
        	<input id="userSex2" name="userSex" type="radio" value="1"  />
        	女</li>
        <li class="border_bj">
            <span class="login_img"><img src="${BASE_URL}/images/zhuce_sj.png" /></span>
            <input id="mobilePhoneNumber" maxlength="11" name="mobilePhoneNumber" value="${vo.mobilePhoneNumber}"  type="text" placeholder="请输入您的手机号" class="login_input_text" />
        </li>
        <li class="border_bj margin_top20">
            <span class="login_img"><img src="${BASE_URL}/images/zhuce_yx.png" /></span>
            <input id="email" name="email" maxlength="50" type="text" value="${vo.email}" placeholder="请输入您常用的邮箱" class="login_input_text" />
        </li>
        <li>
            <span class="login_wjmm">已有账号？ <a href="${BASE_URL}/login/toLogin.html">登录</a></span>
        </li>
        <li><input id="registerBtn" name="registerBtn" type="button" value="注 册" class="login_button" /></li>
    </ul>
</div>

<jsp:include page="../public/footer.jsp" />
<script type="text/javascript">
    $("#registerBtn").click(function(){
    	if(check()){
    		$("#doRegister").submit();
    	}
    });
    var userSexStr = $("#userSexStr").val();
    if($.trim(userSexStr).length <= 0){
    	$("#userSex1").attr("checked","checked");
    	$("#userSex2").removeAttr("checked");
    }else{
    	if(userSexStr == 0){
    		$("#userSex1").removeAttr("checked");
        	$("#userSex2").attr("checked","checked");
    	}else{
    		$("#userSex1").attr("checked","checked");
        	$("#userSex2").removeAttr("checked");
    	}
    }
    
    function check(){
    	var userName = $("#userName").val();
    	if($.trim(userName).length <= 0){
    		alert("请输入登录名");
    		 $("#userName").focus();
    		return false;
    	}
    	var clearSymbol = /[^\a-\z\A-\Z0-9\u4E00-\u9FA5]/;
		if(clearSymbol.test(userName)){
			alert("请输入正确的登录名(只能包含字母和数字)");
			$("#userName").focus();
			return false;
		}
		if($.trim(userName).length < 6){
    		alert("登录名必须大于6位");
    		 $("#userName").focus();
    		return false;
    	}
    	var userPassword = $("#userPassword").val();
    	if($.trim(userPassword).length <= 0){
    		alert("请输入登录密码");
    		 $("#userPassword").focus();
    		return false;
    	}
    	if($.trim(userPassword).length < 6){
    		alert("登录密码必须大于6位");
    		 $("#userPassword").focus();
    		return false;
    	}
    	var userPassword2 = $("#userPassword2").val();
    	if($.trim(userPassword2).length <= 0){
    		alert("请输入确认密码");
    		 $("#userPassword2").focus();
    		return false;
    	}
    	if(userPassword != userPassword2){
    		alert("登录密码与确认密码不相同");
   		 	$("#userPassword2").focus();
   			return false;
    	}
    	var trueName = $("#trueName").val();
    	if($.trim(trueName).length <= 0){
    		alert("请输入姓名");
    		 $("#trueName").focus();
    		return false;
    	}
    	var mobilePhoneNumber = $("#mobilePhoneNumber").val();
    	if($.trim(mobilePhoneNumber).length <= 0){
    		alert("请输入联系方式");
    		 $("#mobilePhoneNumber").focus();
    		return false;
    	}
    	if(!checkMob(mobilePhoneNumber)){
			alert("请输入正确联系方式");
			$("#mobilePhoneNumber").focus();
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
