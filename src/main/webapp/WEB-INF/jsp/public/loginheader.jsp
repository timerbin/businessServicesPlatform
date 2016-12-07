<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="head_box">
	<span class="head_logo"><img src="${BASE_URL}/images/gerenzx_logo.png" width="220" height="60" /></span>
	<c:if test="${not empty errorMsg}">
		<ul class="header_yh">
	        <!-- <li class="header_xiala"><a href="#"></a></li> -->
	        <li class="header_name">${services_user_info.userName}</li>
	        <li class="header_touxiang"><img src="${BASE_URL}/images/touxiang_03.jpg" width="38" height="38" /></li>
	    </ul>
    </c:if>
    <ul class="head_grzcdl">
    	<c:if test="${empty services_user_info}">
	        <li class="head_zc"><a href="${BASE_URL}/login/toRegister.html">注册</a></li>
        	<li class="head_dl"><a href="${BASE_URL}/login/toLogin.html">登录</a></li>
		</c:if>
		<c:if test="${not empty errorMsg}">
	        <li class="head_gr"><a href="${BASE_URL}/user/toEditUserInfo.html">个人中心</a></li>
		</c:if>
        
    </ul>
</div>