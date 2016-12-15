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
    <table width="100%" height="100%" border="0px" cellpadding="0px" cellspacing="0px" >
	<tr><td width="250px" valign="top" class="con_left">
		 <jsp:include page="../public/left.jsp" ></jsp:include>
	</td>
    <td  valign="top">
		<jsp:include page="../public/header.jsp" ></jsp:include>
		
		<jsp:include page="../public/search.jsp" ></jsp:include>
		
    	<form id="allCompany" action="${BASE_URL}/home/allService.html" method="post">

			<input id="id" name="id" type="hidden"/>
			<input id="companyId" name="companyId" type="hidden"/>
			<input id="serviceType" name="serviceType" type="hidden"/>

	        <div class="right_main">
	            <div class="youzhiqy_box">
	                <div class="right2_h2">
						<span class="more">
							<a href="${BASE_URL}/home/allCompany.html">查看更多>></a>
						</span>
						<h2>优质企业</h2>
					</div>
	                
	                <div class="youzhiqy_yzqy" >
	                    <ul>
	                    	<c:forEach items="${companyList}" var="company">
	                    		<c:if test="${not empty company.id}">
		                		<li><img src="${company.logoPicPath}"  />
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
	                    <div class="right_h2"><span class="more"><a href="${BASE_URL}/home/allService.html">查看更多>></a></span><h2>推荐服务</h2></div>
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
		                        <li class="float_left"><img src="${likeService.picUrl}" width="180" height="100" />
		                            <h3>${likeService.serviceName}</h3>
		                            <p>${likeService.serviceDirections}</p>
		                            <span><a id="showLikeService" name="showLikeService" href="#" data-aId="${likeService.id}" data-aComId="${likeService.companyId}" data-aSerType="${likeService.serviceType}">查看</a></span>
	                        	</li>
	                        	</c:if>
							</c:forEach>
	                    </ul>
	                </div>
	                
	            </div>
	        
	        </div>
        </form>
    </td></tr>
</table>
        
<jsp:include page="../public/footer.jsp" ></jsp:include>   
<script type="text/javascript">
$("#navMenu0").addClass("left_border");

$("#allCompany").click(function(){
	$("#saveComment").attr("action",baseUrl+"/home/serviceShow.html");
	$("#id").val($(this).attr("data-aId"));
	$("#companyId").val($(this).attr("data-aComId"));
	$("#serviceType").val($(this).attr("data-aSerType"));
	jQuery("#allCompany").submit();
});
</script>


</body>
</html>

