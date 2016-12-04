<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>服务详情</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<link href="${BASE_URL}/images/hongqiao.css" rel="stylesheet" type="text/css" />
<meta name="renderer" content="webkit" />
<jsp:include page="../public/baseData.jsp" />
</head>
<body>
<form id="allCompany" action="${BASE_URL}/home/allService.html" method="post">
	<input id="baseUrl"   value="${BASE_URL}"  type="hidden"  />
	<input id="page" name="page"   value="${basePage.page}"  type="hidden"  />
    <table width="100%" height="100%" border="0px" cellpadding="0px" cellspacing="0px" >
	<tr><td width="250px" valign="top" class="con_left">
		 <jsp:include page="../public/left.jsp" ></jsp:include>
	</td>
    <td  valign="top">
		<jsp:include page="../public/header.jsp" ></jsp:include>
    	 <div class="right_search">
            <div class="search_box">
                <table border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td>
                    	<label>
	                    	<select id="serviceType" name="serviceType" class="select_fuwu">
	                    		<c:forEach items="${serviceTypeList}" var="serviceType">
	                    			<c:if test="${serviceType.id==queryVo.serviceType}">
			            	 			<option value="${serviceType.id}" selected="selected">${serviceType.showName}</option>
					   				</c:if>
					   				<c:if test="${serviceType.id!=queryVo.serviceType}">
			            	 			<option value="${serviceType.id}">${serviceType.showName}</option>
					   				</c:if>
								</c:forEach>
	                    	</select>
                    	</label>
                    </td>
                    <td><label><input id="queryStr" name="queryStr" type="text" placeholder="请输入关键字查询..." class="input_chaxun" /></label></td>
                    <td><label><input id="queryBtn" type="button" value="搜 索" class="button_search" /></label></td>
                  </tr>
                </table>
            </div>
            <div class="release_box">
            	<c:if test="${not empty user}">
          	 		<label><input id="addService" type="button" value="免费发布服务" class="button_release" /></label>
   				</c:if>
            </div>
        </div>
        
        <div class="right_main">
            <div class="fuwu_left_con">
                <div class="right3_h2"><span class="more"><a href="#" target="_blank">查看更多>></a></span><h2>推荐服务</h2></div>
                <div class="tjfw_tuwen">
           	    	<span class="tjfw_tu"><img src="${BASE_URL}/${vo.picUrl}" /></span>
                    <span class="scfuwu"><a data-id="${vo.id}" href="javascript:;">[收藏服务]</a></span>
                    <h3>${vo.serviceName}</h3> 
                    <span class="fuwu_time">${vo.createTimeStr}</span>
                    <span class="fuwu_pingjia">
                    	服务评价 
	                    <img src="${BASE_URL}/images/wuxing_huang.png"/> 
	                    <img src="${BASE_URL}/images/wuxing_huang.png"/> 
	                    <img src="${BASE_URL}/images/wuxing_huang.png"/>
	                    <img src="${BASE_URL}/images/wuxing_huang.png"/> 
	                    <img src="${BASE_URL}/images/wuxing_hui.png"/>
                    </span>
                </div>
                
                <div class="tjfw_article">
                    <h4>服务介绍</h4>
                    <p>${vo.serviceDirections}</p>
                    <h4>联系方式</h4>
                    <p>联系人：${vo.serviceContactUser}</p>
                    <p>联系方式：${vo.serviceContactTel}</p>
                	<h4>服务评价</h4>
                	<div class="fwpj_fwpj">
                        <ul>
                          <li><img src="${BASE_URL}/images/shou_03.jpg" /> <span class="haoping">好评</span> <span class="hp_tiao bjse_cheng"></span> 4人</li>
                          <li><img src="${BASE_URL}/images/shou_07.jpg" /> <span class="haoping">中评</span> <span class="hp_tiao bjse_hui"></span> 4人</li>
                          <li><img src="${BASE_URL}/images/shou_11.jpg" /> <span class="haoping">差评</span> <span class="hp_tiao bjse_hui"></span> 4人</li>
                        </ul>
                        <div class="haopingdu">好评度 <span>100%</span></div>
                        <div class="clear"></div>
                    </div>
                    <div class="tjfw_button"><input name="" type="button" / value="我要点评" class="form_button bjse_hong"></div>
            	</div>
                
              <div class="tjfw_evaluation">
                	<ul class="evaluation">
                    	<li><input name="" type="radio" value="" />全部 （4）</li>
                        <li><input name="" type="radio" value="" />好评 （4）</li>
                        <li><input name="" type="radio" value="" />中评 （0）</li>
                        <li><input name="" type="radio" value="" />差评 （0）</li>
                    </ul>
                <div class="evaluation_ar">
                    	<h3><img src="${BASE_URL}/images/shou_03.jpg" /> 好评 <span>服务态度好</span><span>质量好</span></h3>
                        <p>很好西红柿</p>
                        <span class="hui_zi">2015-02-23 12:23:33</span>
                    </div>
                    <div class="evaluation_ar">
                    	<h3><img src="${BASE_URL}/images/shou_03.jpg" /> 好评 <span>服务态度好</span><span>质量好</span></h3>
                        <p>很好西红柿</p>
                        <span class="hui_zi">2015-02-23 12:23:33</span>
                    </div>
                    <div class="evaluation_ar">
                    	<h3><img src="${BASE_URL}/images/shou_03.jpg" /> 好评 <span>服务态度好</span><span>质量好</span></h3>
                        <p>很好西红柿</p>
                        <span class="hui_zi">2015-02-23 12:23:33</span>
                    </div>
                    <div class="tjfw_page"><a href="#">上一页</a> <a href="#">1</a> <a href="#">2</a> <a href="#">3</a> <a href="#">下一页</a></div>
                
              </div>
            
            </div>
            <div class="fuwu_right_con">
            	<div class="company">
                	<h2>${vo.baseUserCompanyVo.companyName}</h2>
                    <ul>
                        <li>注册时间：${vo.baseUserCompanyVo.companyRegisterTimeStr}</li>
                        <li>地址：${vo.baseUserCompanyVo.companyAddress}</li>
                        <li>公司主页：<a href="#">${vo.baseUserCompanyVo.companyUrl}</a></li>
                    </ul>
                    <span data-id="${vo.baseUserCompanyVo.id}" >收藏企业</span>
                    <div class="clear"></div>
                </div>
                
                <div class="tjfw_cnxh margin_top25">
                	<div class="right_h2"><span class="more">&nbsp;</span><h2>猜你喜欢</h2></div>
                    <ul>
                        <c:forEach items="${likeServiceList}" var="likeService">
                    		<c:if test="${not empty likeService.id}">
		                        <li><img src="${BASE_URL}/${service.picUrl}" width="180" height="100" />
		                            <h3>${likeService.serviceName}</h3>
		                            <p>${likeService.serviceDirections}</p>
		                            <span><a href="#">查看</a></span>
	                        	</li>
                        	</c:if>
						</c:forEach>
                    
                    </ul>
                
                </div>
            
            </div>
            <div class="clear"></div>
        </div>
        <div class="footer">Copyright 2011-2016</div>
    </td></tr>
</table>
         
<script type="text/javascript">
$("#queryBtn").click(function(){
	$("#allCompany").submit();
});
$("#addService").click(function(){
	$("#allCompany").submit();
});
</script>

</form>
</body>
</html>

