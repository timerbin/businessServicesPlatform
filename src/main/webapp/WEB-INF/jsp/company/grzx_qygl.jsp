<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
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
	<div class="gerenzx_left">
    	<h2><span><img src="/images/gerenzx_d1.png" /></span>账户管理</h2>
        <ul>
       		<li class="li_atab"><span><img src="/images/gerenzx_x1.png" /></span><a href="#">个人信息</a></li>
            <li><span><img src="/images/gerenzx_x2.png" /></span><a href="#">修改密码</a></li>
        </ul>
        <h2><span><img src="/images/gerenzx_d2.png" /></span>服务相关</h2>
        <ul>
       		<li><span><img src="/images/gerenzx_x3.png" /></span><a href="#">浏览历史</a></li>
            <li><span><img src="/images/gerenzx_x4.png" /></span><a href="#">我的收藏</a></li>
            <li><span><img src="/images/gerenzx_x5.png" /></span><a href="#">企业管理</a></li>
            <li><span><img src="/images/gerenzx_x6.png" /></span><a href="#">服务管理</a></li>
        </ul>
        <h2><span><img src="/images/gerenzx_d3.png" /></span>统计分析</h2>
        <ul>
       		<li><span><img src="/images/gerenzx_x7.png" /></span><a href="#">访问情况分析</a></li>
        </ul>
  </div>
    <div class="gerenzx_right">
    	<div class="grzx_h2"><h2>企业管理</h2></div>
      <table border="0" cellspacing="10" cellpadding="0" class="gerenzx_table">
          <tr>
            <td width="78" align="right">企业名称：</td>
            <td width="155"><input name="" type="text" class="grzx_input" /></td>
            <td width="78" align="right">创建时间：</td>
            <td width="150"><input name="" type="text" class="grzx_input" /></td>
            <td width="90"><input name="" type="button" value="查询" class="grzx_button2" /></td>
            <td width="90"><input name="" type="button" value="创建" class="grzx_button2" /></td>
            <td width="90"><input name="" type="button" value="导入" class="grzx_button2" /></td>
          </tr>
        </table>
        <table width="929" border="0" cellspacing="1" cellpadding="0" class="fuwugl_table">
          <thead>
          <tr>
            <td width="196" height="38" align="center">服务名称</td>
            <td width="187" align="center">企业地址</td>
            <td width="111" align="center">联系人</td>
            <td width="109" align="center">联系方式</td>
            <td width="102" align="center">是否推荐</td>
            <td width="217" align="center">操作</td>
          </tr>
          </thead>
          <tbody>
          <tr>
            <td height="40">***快捷服务</td>
            <td align="center">2016-10-10 12：00</td>
            <td align="center">注册服务</td>
            <td align="center">上线</td>
            <td align="center">是</td>
            <td align="center"><a href="#" class="hongzi_a">推荐</a> <a href="#" class="lanzi_a">编辑</a> <a href="#" class="hongzi_a">删除</a> <a href="#" class="lanzi_a">详情</a></td>
          </tr>
          <tr>
            <td height="40">***快捷服务</td>
            <td align="center">2016-10-10 12：00</td>
            <td align="center">注册服务</td>
            <td align="center">上线</td>
            <td align="center">是</td>
            <td align="center"><a href="#" class="hongzi_a">推荐</a> <a href="#" class="lanzi_a">编辑</a> <a href="#" class="hongzi_a">删除</a> <a href="#" class="lanzi_a">详情</a></td>
          </tr>
          </tbody>
        </table>

  </div>
</div>
<jsp:include page="../public/footer.jsp" ></jsp:include>
</body>
</html>
