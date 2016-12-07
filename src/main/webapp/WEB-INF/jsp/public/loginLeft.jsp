<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="gerenzx_left">
    	<h2><span><img src="${BASE_URL}/images/gerenzx_d1.png" /></span>账户管理</h2>
        <ul>
       		<li class="li_atab"><span><img src="${BASE_URL}/images/gerenzx_x1.png" /></span><a href="${BASE_URL}/user/toEditUserInfo.html">个人信息</a></li>
            <li><span><img src="${BASE_URL}/images/gerenzx_x2.png" /></span><a href="${BASE_URL}/user/toEditPassword.html">修改密码</a></li>
        </ul>
        <h2><span><img src="${BASE_URL}/images/gerenzx_d2.png" /></span>服务相关</h2>
        <ul>
       		<li><span><img src="${BASE_URL}/images/gerenzx_x3.png" /></span><a href="${BASE_URL}/user/toLookList.html">浏览历史</a></li>
            <li><span><img src="${BASE_URL}/images/gerenzx_x4.png" /></span><a href="${BASE_URL}/user/toEditPassword.html">我的收藏</a></li>
            <c:if test="${not empty services_user_info}">
            	<c:if test="${services_user_info.type == 2}">
		            <li><span><img src="${BASE_URL}/images/gerenzx_x5.png" /></span><a href="#">企业管理</a></li>
		            <li><span><img src="${BASE_URL}/images/gerenzx_x6.png" /></span><a href="#">服务管理</a></li>
	            </c:if>
            </c:if>
        </ul>
        <h2><span><img src="${BASE_URL}/images/gerenzx_d3.png" /></span>统计分析</h2>
        <ul>
       		<li><span><img src="${BASE_URL}/images/gerenzx_x7.png" /></span><a href="${BASE_URL}/user/toStatistics.html">访问情况分析</a></li>
        </ul>
  </div>