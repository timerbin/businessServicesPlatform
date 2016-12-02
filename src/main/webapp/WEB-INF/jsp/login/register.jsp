<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<form action="${BASE_URL}/login/toRegister.html" method="post">
<div class="login_head">
	<div class="login_title"><img src="${BASE_URL}/images/zhuce_h.png" /></div>
</div>
<div class="login_box">
	<ul>
		<c:if test="${not empty errorMsg}">
	        <li class="border_bj margin_top20">
	            <span>${errorMsg}</span>
	        </li>
		</c:if>
    	<li class="border_bj margin_top20">
            <span class="login_img"><img src="${BASE_URL}/images/goin_yh.png" /></span>
            <input id="loginName" name="loginName" type="text" placeholder="设置登录账号" class="login_input_text" />
        </li>
        <li class="border_bj margin_top20">
            <span class="login_img"><img src="${BASE_URL}/images/goin_mm.png" /></span>
            <input id="loginPwd" name="loginPwd" type="password" placeholder="设置登录密码" class="login_input_text" />
        </li>
        <li class="border_bj margin_top20">
            <span class="login_img"><img src="${BASE_URL}/images/goin_mm.png" /></span>
            <input id="loginPwd2"  name="loginPwd2" type="password" placeholder="输入确认密码" class="login_input_text" />
        </li>
        <li class="border_bj margin_top20">
            <span class="login_img"><img src="${BASE_URL}/images/zhuce_xm.png" /></span>
            <input id="raleName"  name="raleName" type="text" placeholder="姓名" class="login_input_text" />
        </li>
        <li><input id="sex1" name="sex" type="radio" /> 男 &nbsp;&nbsp;&nbsp;&nbsp; <input id="sex2" name="sex" type="radio" /> 女</li>
        <li class="border_bj">
            <span class="login_img"><img src="${BASE_URL}/images/zhuce_sj.png" /></span>
            <input id="mobilePhone" name="mobilePhone" type="text" placeholder="请输入您的手机号" class="login_input_text" />
        </li>
        <li class="border_bj margin_top20">
            <span class="login_img"><img src="${BASE_URL}/images/zhuce_yx.png" /></span>
            <input name="email" type="text" placeholder="请输入您常用的邮箱" class="login_input_text" />
        </li>
        <li>
            <span class="login_wjmm">已有账号？ <a href="${BASE_URL}/login/toLogin.html">登录</a></span>
        </li>
        <li><input name="" type="button" value="注 册" class="login_button" /></li>
    </ul>
</div>

<jsp:include page="../public/footer.jsp" />

</form>
</body>
</html>
