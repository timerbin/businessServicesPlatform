<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改密码</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<link href="${BASE_URL}/images/login.css" rel="stylesheet" type="text/css" />
<meta name="renderer" content="webkit" />
<jsp:include page="../public/baseData.jsp" />
</head>
<body>

<form id="updatePwdForm" action="${BASE_URL}/login/updatePssword.html" method="post">
<input id="baseUrl"   value="${BASE_URL}"  type="hidden"  />
 <input id="userIdStr" name ="userIdStr"  value="${userIdStr}" type="hidden"/>
 <input id="updateCode" name ="updateCode"  value="${updateCode}" type="hidden"/>
<div class="login_head">
	<div class="login_title" style="color:#FFFFFF;font-size:20px;text-align:center;padding-top:35px;">重置密码</div>
</div>
<div class="login_box">
	<ul>
		<c:if test="${not empty errorMsg}">
	        <li class="margin_top20">
	            <span style="color:red;">${errorMsg}</span>
	        </li>
		</c:if>
		 <li class="border_bj margin_top20">
            <input id="userPassword"   name="userPassword" type="password" placeholder="输入新密码" class="login_input_text" />
        </li>
         <li class="border_bj margin_top20">
            <input id="userPassword2"   name="userPassword2" type="password" placeholder="输入确认新密码" class="login_input_text" />
        </li>
        <li class="margin_top20"><input id="updatePwdBtn" name="updatePwdBtn" type="button" value="修改" class="login_button" /></li>
    </ul>
</div>

<jsp:include page="../public/footer.jsp" />
<script type="text/javascript">
var baseUrl = $("#baseUrl").val();
    $("#updatePwdBtn").click(function(){
    	if(check()){
    		$("#updatePwdForm").submit();
    	}
    });
    function check(){
    	var userIdStr = $("#userIdStr").val();
    	if($.trim(userIdStr).length <= 0){
    		alert("请输入用户信息异常,请重新修改");
    		window.location.href=baseUrl+"/login/toLogin.html";
    		return false;
    	}
    	var userPassword = $("#userPassword").val();
    	if($.trim(userPassword).length <= 0){
    		alert("请输入新密码");
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
    		alert("请输入确认新密码");
    		 $("#userPassword2").focus();
    		return false;
    	}
    	if(userPassword != userPassword2){
    		alert("登录密码与确认密码不相同");
   		 	$("#userPassword2").focus();
   			return false;
    	}
    	return true;
    }
</script>
</form>
</body>
</html>
