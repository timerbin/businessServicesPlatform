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
 <input id="sexStr"  value="${vo.sex}" type="hidden"/>
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
            <input id="loginName" maxlength="20" name="loginName" value="${vo.loginName}" type="text" placeholder="设置登录账号" class="login_input_text" />
        </li>
        <li class="border_bj margin_top20">
            <span class="login_img"><img src="${BASE_URL}/images/goin_mm.png" /></span>
            <input id="loginPwd" maxlength="20" name="loginPwd" type="password" placeholder="设置登录密码" class="login_input_text" />
        </li>
        <li class="border_bj margin_top20">
            <span class="login_img"><img src="${BASE_URL}/images/goin_mm.png" /></span>
            <input id="loginPwd2" maxlength="20" name="loginPwd2" type="password" placeholder="输入确认密码" class="login_input_text" />
        </li>
        <li class="border_bj margin_top20">
            <span class="login_img"><img src="${BASE_URL}/images/zhuce_xm.png" /></span>
            <input id="raleName" maxlength="10" name="raleName" value="${vo.raleName}"  type="text" placeholder="姓名" class="login_input_text" />
        </li>
        <li>
        	<input id="sex1" name="sex" type="radio" value="0"   />
        	 男 &nbsp;&nbsp;&nbsp;&nbsp;
        	<input id="sex2" name="sex" type="radio" value="1"  />
        	女</li>
        <li class="border_bj">
            <span class="login_img"><img src="${BASE_URL}/images/zhuce_sj.png" /></span>
            <input id="mobilePhone" maxlength="11" name="mobilePhone" value="${vo.mobilePhone}"  type="text" placeholder="请输入您的手机号" class="login_input_text" />
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
    var sexStr = $("#sexStr").val();
    if($.trim(sexStr).length <= 0){
    	$("#sex1").attr("checked","checked");
    	$("#sex2").removeAttr("checked");
    }else{
    	if(sexStr == 0){
    		$("#sex1").removeAttr("checked");
        	$("#sex2").attr("checked","checked");
    	}else{
    		$("#sex1").attr("checked","checked");
        	$("#sex2").removeAttr("checked");
    	}
    }
    
    function check(){
    	var loginName = $("#loginName").val();
    	if($.trim(loginName).length <= 0){
    		alert("请输入登录名");
    		 $("#loginName").focus();
    		return false;
    	}
    	var clearSymbol = /[^\a-\z\A-\Z0-9\u4E00-\u9FA5]/;
		if(clearSymbol.test(loginName)){
			alert("请输入正确的登录名(只能包含字母和数字)");
			$("#loginName").focus();
			return false;
		}
    	var loginPwd = $("#loginPwd").val();
    	if($.trim(loginPwd).length <= 0){
    		alert("请输入登录密码");
    		 $("#loginPwd").focus();
    		return false;
    	}
    	if($.trim(loginPwd).length < 6){
    		alert("登录密码必须大于6位");
    		 $("#loginPwd").focus();
    		return false;
    	}
    	var loginPwd2 = $("#loginPwd2").val();
    	if($.trim(loginPwd2).length <= 0){
    		alert("请输入确认密码");
    		 $("#loginPwd2").focus();
    		return false;
    	}
    	if(loginPwd != loginPwd2){
    		alert("登录密码与确认密码不相同");
   		 	$("#loginPwd2").focus();
   			return false;
    	}
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
