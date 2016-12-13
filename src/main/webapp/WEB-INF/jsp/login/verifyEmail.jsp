<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>验证邮箱</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<link href="${BASE_URL}/images/login.css" rel="stylesheet" type="text/css" />
<meta name="renderer" content="webkit" />
<jsp:include page="../public/baseData.jsp" />
</head>
<body>

<form id="verifyForm" action="${BASE_URL}/login/verifyEmailCode.html" method="post">
 <input id="userIdStr" name ="userIdStr"  value="${userIdStr}" type="hidden"/>
<div class="login_head">
	<div class="login_title" style="color:#FFFFFF;font-size:20px;text-align:center;padding-top:35px;">验证邮箱</div>
</div>
<div class="login_box">
	<ul>
		<c:if test="${not empty errorMsg}">
	        <li class="margin_top20">
	            <span style="color:red;">${errorMsg}</span>
	        </li>
		</c:if>
    	<li class="margin_top20">
            ${email} &nbsp;  &nbsp;<input id="sendBtn" name="sendBtn" type="button" value="发送验证码"   />
        </li>
        <li class="border_bj margin_top20">
            <input id="updateCode" maxlength="4" name="updateCode" type="text" placeholder="输入邮箱验证码" class="login_input_text" />
        </li>
        <li class="margin_top20"><input id="verifyBtn" name="verifyBtn" type="button" value="验证" class="login_button" /></li>
    </ul>
</div>

<jsp:include page="../public/footer.jsp" />
<script type="text/javascript">
var baseUrl = $("#baseUrl").val();
    $("#verifyBtn").click(function(){
    	if(check()){
    		$("#verifyForm").submit();
    	}
    });
    
    $("#sendBtn").click(function(){
    	var userIdStr = $("#userIdStr").val();
    	if($.trim(userIdStr).length <= 0){
    		alert("请输入用户信息异常,请重新修改");
    		window.location.href=baseUrl+"/login/toLogin.html";
    		return false;
    	}else{
    		$.ajax({
    	       	  type: 'POST',
    	       	  url: baseUrl+"/login/sendEmailCode.html",
    	       	  data: {"userIdStr":userIdStr},
    	       	  success:function (data){
    	       		  if(data){
    	       			 if(data == 1){
    	       				alert("发送成功,请注意查收");
       	       			 	$("#sendBtn").hide();
    	       			 }else{
    	       				alert("发送失败,请稍后再试");
    	       			 }
    	       		  }
    	       	  }
    	    });
    	}
    });
    
   
    function check(){
    	var userIdStr = $("#userIdStr").val();
    	if($.trim(userIdStr).length <= 0){
    		alert("请输入用户信息异常,请重新修改");
    		window.location.href=baseUrl+"/login/toLogin.html";
    		return false;
    	}
    	var updateCode = $("#updateCode").val();
    	if($.trim(updateCode).length <= 0){
    		alert("请输入验证码");
    		 $("#updateCode").focus();
    		return false;
    	}
    	 
    	return true;
    }
</script>
</form>
</body>
</html>
