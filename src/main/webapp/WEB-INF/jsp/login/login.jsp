<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<link href="${BASE_URL}/images/login.css" rel="stylesheet" type="text/css" />
<meta name="renderer" content="webkit" />

<jsp:include page="../public/baseData.jsp" />

</head>
<body>
<form id="doLogin" action="${BASE_URL}/login/doLogin.html" method="post">
<input id="callbackUrl" name="callbackUrl"   value="${callbackUrl}"  type="hidden"  />
<div class="login_head">
	<div class="login_title"><img src="${BASE_URL}/images/goin_h.png" width="301" height="57" /></div>
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
            <input id="userName" maxlength="20"  name="userName" type="text" placeholder="请输入登录名" class="login_input_text" />
        </li>
        <li class="border_bj margin_top20">
            <span class="login_img"><img src="${BASE_URL}/images/goin_mm.png" /></span>
            <input id="userPassword" maxlength="20"  name="userPassword" type="password" placeholder="请输入密码" class="login_input_text" />
        </li>
        <li class="  margin_top20">
            <span><input id="verifyCode" maxlength="4"  name="verifyCode" type="text" placeholder="请输入验证码" class="login_input_text"  style="width:150px;" /></span>
            <span><img id="img" style="width:110px;height:30px;" src="${BASE_URL}/authImage" title="换一张" /></span>
        </li>
        <li>
            <span class="login_wjmm"><a href="${BASE_URL}/login/toRegister.html">立即注册</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="${BASE_URL}/login/toUpdatePassword.html">忘记密码</a></span>
        </li>
        <li><input id="loginBtn" name="loginBtn" type="button" value="登 录" class="login_button" /></li>
    </ul>
</div>
</form>

<jsp:include page="../public/footer.jsp" />


<script type="text/javascript">
    $("#img").click(function(){
    	$("#img").attr("src","${BASE_URL}/authImage?date=" + new Date());
    });
    $("#loginBtn").click(function(){
    	if(check()){
    		$("#doLogin").submit();
    	}
    });
    function check(){
    	var userName = $("#userName").val();
    	if($.trim(userName).length <= 0){
    		alert("请输入登录名");
    		 $("#userName").focus();
    		return false;
    	}
    	var userPassword = $("#userPassword").val();
    	if($.trim(userPassword).length <= 0){
    		alert("请输入密码");
    		 $("#userPassword").focus();
    		return false;
    	}
    	if($.trim(userPassword).length < 6){
    		 alert("密码长度必须大于6位");
    		 $("#userPassword").focus();
    		return false;
    	}
    	var verifyCode = $("#verifyCode").val();
    	if($.trim(verifyCode).length <= 0){
    		alert("请输入验证码");
    		 $("#verifyCode").focus();
    		return false;
    	}
    	return true;
    }
</script>
</body>
</html>
