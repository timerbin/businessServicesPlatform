<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="right_header">
     <span class="header_left">您好，欢迎光临泰兴虹桥园区商业服务整合平台</span>
     <c:if test="${not empty services_user_info}">
     <ul class="header_yh">
         	<li class="header_name">${services_user_info.userName}</li>
	        <li class="header_touxiang">
	        	<c:if test="${empty services_user_info.userLogo}">
	            	 <img id="userLogoImg"  src="${BASE_URL}/images/touxiang_03.jpg"  width="38" height="38" />
				</c:if>
				<c:if test="${not empty services_user_info.userLogo}">
					 <img id="userLogoImg" src="${BASE_URL}/${services_user_info.userLogo}"    width="38" height="38"  />
				</c:if>
	        </li>
     </ul>
     </c:if>
     <ul class="head_grzcdl">
         <c:if test="${empty services_user_info}">
	        <li class="head_zc"><a href="${BASE_URL}/login/toRegister.html">注册</a></li>
        	<li class="head_dl"><a href="${BASE_URL}/login/toLogin.html">登录</a></li>
		</c:if>
		<c:if test="${not empty services_user_info}">
	        <li class="head_gr"><a href="${BASE_URL}/user/toEditUserInfo.html">个人中心</a></li>
	        <li class="head_dl"><a href="${BASE_URL}/login/loginOut.html">退出</a></li>
		</c:if>
     </ul>
 </div>