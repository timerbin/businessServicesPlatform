<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>浏览历史</title>
<link href="/images/gerenzx.css" rel="stylesheet" type="text/css" />
    <jsp:include page="../public/baseData.jsp" />
</head>

<body>
<div class="head_box">
	<span class="head_logo"><img src="/images/gerenzx_logo.png" width="220" height="60" /></span>
	<ul class="header_yh">
        <li class="header_xiala"><a href="#"></a></li>
        <li class="header_name">张小二</li>
        <li class="header_touxiang"><img src="/images/touxiang_03.jpg" width="38" height="38" /></li>
    </ul>
    <ul class="head_grzcdl">
        <li class="head_gr"><a href="#">个人中心</a></li>
        <li class="head_zc"><a href="#">注册</a></li>
        <li class="head_dl"><a href="#">登录</a></li>
    </ul>
</div>
<div class="top_tiao"></div>
<div class="gerenzx_main">
	<%--<div class="gerenzx_left">
    	<h2><span><img src="images/gerenzx_d1.png" /></span>账户管理</h2>
        <ul>
       		<li class="li_atab"><span><img src="images/gerenzx_x1.png" /></span><a href="#">个人信息</a></li>
            <li><span><img src="images/gerenzx_x2.png" /></span><a href="#">修改密码</a></li>
        </ul>
        <h2><span><img src="/images/gerenzx_d2.png" /></span>服务相关</h2>
        <ul>
       		<li><span><img src="/images/gerenzx_x3.png" /></span><a href="#">浏览历史</a></li>
            <li><span><img src="/images/gerenzx_x4.png" /></span><a href="#">我的收藏</a></li>
            <li><span><img src="/images/gerenzx_x5.png" /></span><a href="#">企业管理</a></li>
            <li><span><img src="images/gerenzx_x6.png" /></span><a href="#">服务管理</a></li>
        </ul>
        <h2><span><img src="images/gerenzx_d3.png" /></span>统计分析</h2>
        <ul>
       		<li><span><img src="images/gerenzx_x7.png" /></span><a href="#">访问情况分析</a></li>
        </ul>
  </div>--%>
        <jsp:include page="../public/loginLeft.jsp" />
    <div class="gerenzx_right">
    	<div class="grzx_h2"><h2>浏览历史</h2></div>
      <div class="llls_button_box">
        	<input name="" type="button" value="全部分类" class="llls_button" />
          <input name="" type="button" value="企业" class="llls_button2" />
          <input name="" type="button" value="服务" class="llls_button2" />
        </div>

        <c:forEach var="history" items="${ulhLstNew}">

        <div class="llls_time">${history.createTime}</div>

        <div>
            <c:if test="${history.type == 2}" >
            <dl class="llls_list">
                <dt><img src="/images/home_yzqy_16.jpg" /></dt>
                <dd>
                    <h3>斐讯数据通信技术有限公司</h3>
                    <p>激情发展、追求卓越、客户价值、共同成长</p>
                    <span><img src="/images/shanchu.png"/></span>
                </dd>
            </dl>
            </c:if>
            <c:if test="${history.type == 1}" >
            <dl class="llls_list">
                <dt><img src="/images/home_yzqy_16.jpg" /></dt>
                <dd>
                    <h3>斐讯数据通信技术有限公司</h3>
                    <p>激情发展、追求卓越、客户价值、共同成长</p>
                    <span><img src="/images/shanchu.png"/></span>
                </dd>
            </dl>
            </c:if>
            <div class="clear"></div>
      	</div>

        </c:forEach>

        

  </div>

</div>
<jsp:include page="../public/footer.jsp" ></jsp:include>
</body>
</html>
