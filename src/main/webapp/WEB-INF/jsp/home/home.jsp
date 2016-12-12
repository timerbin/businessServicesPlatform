<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<link href="${BASE_URL}/images/hongqiao.css" rel="stylesheet" type="text/css" />
<meta name="renderer" content="webkit" />
<jsp:include page="../public/baseData.jsp" />
</head>
<body>
<form id="allCompany" action="${BASE_URL}/home/homeIndex.html" method="post">
	<input id="baseUrl"   value="${BASE_URL}"  type="hidden"  />
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
	                    	<select id="companyScope" name="companyScope" class="select_fuwu">
	                    		<c:forEach items="${managementList}" var="management">
	                    			<c:if test="${management.id==queryVo.companyScope}">
			            	 			<option value="${management.id}" selected="selected">${management.showName}</option>
					   				</c:if>
					   				<c:if test="${management.id!=queryVo.companyScope}">
			            	 			<option value="${management.id}">${management.showName}</option>
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
            <div class="youzhiqy_box">
                <div class="right2_h2"><span class="more"><a href="#" target="_blank">查看更多>></a></span><h2>优质企业</h2></div>
                
                <div class="youzhiqy_yzqy" >
                    <ul>
                    	<c:forEach items="${companyList}" var="company">
                    		<c:if test="${not empty company.id}">
	                		<li><img src="${BASE_URL}/${company.logoPicPath}"  />
	                            <h3>${company.companyName}</h3>
	                            <p>${company.companyDirections}</p>
	                        </li>
	                        </c:if>
						</c:forEach>
                    </ul>
                        <div class="clear"></div>
                </div>
            </div>
            
            <div class="fuwu_xihuan">
                <div class="tjfw_box">
                    <div class="right_h2"><span class="more"><a href="#" target="_blank">查看更多>></a></span><h2>推荐服务</h2></div>
                    <c:forEach items="${serviceList}" var="service" varStatus="status">
                    	<c:if test="${not empty service.id}">
                     	<dl>
	                        <dt class="bjse_hong">${status.index+1}</dt>
	                        <dd><h3>${service.baseUserCompanyVo.companyName}</h3></dd>
	                        <dd><p>${service.serviceDirections}</p></dd>
	                    </dl>
	                    </c:if>
					</c:forEach>
                </div>
                <div class="cnxh_box">
                  <div class="right_h2"><span class="more">&nbsp;</span><h2>猜你喜欢</h2></div>
                    <ul>
                    	<c:forEach items="${likeServiceList}" var="likeService">
                    		<c:if test="${not empty likeService.id}">
	                        <li class="float_left"><img src="${BASE_URL}/${service.picUrl}" width="180" height="100" />
	                            <h3>${likeService.serviceName}</h3>
	                            <p>${likeService.serviceDirections}</p>
	                            <span><a href="#">查看</a></span>
                        	</li>
                        	</c:if>
						</c:forEach>
                    </ul>
                </div>
                
            </div>
        
        </div>
        <div class="footer">Copyright 2011-2016</div>
    </td></tr>
</table>
        
        
<script type="text/javascript">

$("#queryBtn").click(function(){
	$("#allCompany").submit();
});
$("#addService").click(function(){
//	$("#allCompany").submit();
	$("#allCompany").attr("action","${BASE_URL}/user/toPushService.html");
	$("#allCompany").submit();


});
</script>

</form>
</body>
</html>

