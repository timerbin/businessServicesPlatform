<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>忘记密码</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<link href="${BASE_URL}/images/login.css" rel="stylesheet" type="text/css" />
<meta name="renderer" content="webkit" />
<jsp:include page="../public/baseData.jsp" />
</head>
<body>

<form id="verifyUerName" action="${BASE_URL}/login/verifyUerName.html" method="post">
<div class="login_head">
	<div class="login_title" style="color:#FFFFFF;font-size:20px;text-align:center;padding-top:35px;">忘记密码</div>
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
            <input id="userName" maxlength="20" name="userName" value="${vo.userName}" type="text" placeholder="输入登录账号" class="login_input_text" />
        </li>
        <li class="margin_top20"><input id="verifyBtn" name="verifyBtn" type="button" value="确认找回" class="login_button" /></li>
    </ul>
</div>

<jsp:include page="../public/footer.jsp" />
<script type="text/javascript">
    $("#verifyBtn").click(function(){
    	if(check()){
    		$("#verifyUerName").submit();
    	}
    });
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
    	return true;
    }
</script>
</form>
</body>
</html>
