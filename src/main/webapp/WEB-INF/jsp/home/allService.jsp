<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>所有服务</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<link href="${BASE_URL}/images/hongqiao.css" rel="stylesheet" type="text/css" />
<meta name="renderer" content="webkit" />
	<jsp:include page="../public/baseData.jsp" />
	<jsp:include page="../public/pager.jsp" />
</head>
<body>
    <table width="100%" height="100%" border="0px" cellpadding="0px" cellspacing="0px" >
	<tr><td width="250px" valign="top" class="con_left">
		 <jsp:include page="../public/left.jsp" ></jsp:include>
	</td>
    <td  valign="top">
		<jsp:include page="../public/header.jsp" ></jsp:include>
    	 
    	 <jsp:include page="../public/search.jsp" ></jsp:include>
    	 
    	 <form id="allService" action="${BASE_URL}/home/allService.html" method="post">
			<input id="page" name="page" type="hidden" value="${basePage.page}"/>
		    <input id="curPage" name="curPage"  value="${basePage.page}" type="hidden"/>
		   	<input id="pageCount" name="pageCount" value="${basePage.pages}" type="hidden"/>
		   	<input id="initMenuType"   value="${queryVo.serviceType}" type="hidden"/>
		   	<input id="serviceName" name="serviceName"  value="${queryVo.serviceName}"   type="hidden"  />

			 <input id="id" name="id" type="hidden"/>
			 <input id="companyId" name="companyId" type="hidden"/>
			 <input id="serviceType" name="serviceType" type="hidden"/>
		   	
		   	
	        <div class="right_main">
	            <div class="fuwu_left_con">
	                <div class="right3_h2"><span class="more">&nbsp;</span><h2>推荐服务</h2></div>
	                <c:forEach items="${serviceList}" var="service">
	                <c:if test="${not empty service.id}">
	               		<div class="tjfw_tuwen">
		           	    	<div class="tjfw_tu">
								<img id="imgSeriveShow" data-id="${service.id}" date-cid="${service.companyId}" data-type="${service.serviceType}" src="${BASE_URL}/${service.picUrl}"/>
							</div>
		                    <span class="scfuwu">
		                    	<c:if test="${service.recommend==1}">
		                    		<img  src="${BASE_URL}/images/tuijian.png" width="35" height="44" />
				   				</c:if>
		                    </span> 
		                    <div class="tjfw_center">
		                        <h3>${service.serviceName}</h3> 
		                        <span class="fuwu_time">${service.serviceDirections}</span>
		                        <span class="fuwu_gongsim">${service.baseUserCompanyVo.companyName}</span>
		                    </div>
	                	</div>
	                	</c:if>
					</c:forEach>
					 <div class="pages" id="pager"></div>
	         	</div>
	            <div class="fuwu_right_con">
	                <div class="tjfw_cnxh">
	                	<div class="right_h2"><span class="more"><a href="#" target="_blank">查看更多>></a></span><h2>猜你喜欢</h2></div>
	                    <ul>
	                    	<c:forEach items="${likeServiceList}" var="likeService">
	                    		<c:if test="${not empty likeService.id}">
			                        <li><img src="${BASE_URL}/${service.picUrl}" width="180" height="100" />
			                            <h3>${likeService.serviceName}</h3>
			                            <p>${likeService.serviceDirections}</p>
			                            <span><a id="showLikeService" name="showLikeService" href="#" data-sid="${likeService.id}" date-lid="${likeService.companyId}" data-stype="${likeService.serviceType}">查看</a></span>
		                        	</li>
	                        	</c:if>
							</c:forEach>
	                    </ul>
	                </div>
	            </div>
	            <div class="clear"></div>
	        </div>
	        
         </form>
    </td></tr>
</table>
<script type="text/javascript">
//分页  begin

var initMenuType = $("#initMenuType").val();
if(initMenuType.length > 0){
	$("#navMenu"+initMenuType).addClass("left_border");
}else{
	$("#navMenu0").addClass("left_border");
}
var cur_page = $("#curPage").val();
var page_count = $("#pageCount").val();
jQuery("#pager").pager({pagenumber: cur_page, pagecount: page_count, buttonClickCallback: change_page });

function change_page(cur_page) {
	$("#serviceName").val($("#queryStr").val());
    jQuery("#page").val(cur_page);
    jQuery("#allService").submit();
}


$("#imgSeriveShow").click(function(){
	$("#allService").attr("action",baseUrl+"/home/serviceShow.html");
	/*$("#id").val("Enabled");*/
	/*$(this).val($("#Enabled").attr("data-id"));*/
	alert($(this).attr("data-cid"));
	$("#id").val($(this).attr("data-id"));
	$("#companyId").val($(this).attr("data-cid"));
	$("#serviceType").val($(this).attr("data-type"));
	jQuery("#allService").submit();
});



$("#showLikeService").click(function(){
	$("#allService").attr("action",baseUrl+"/home/serviceShow.html");
	/*$("#id").val("Enabled");*/
	/*$(this).val($("#Enabled").attr("data-id"));*/
	alert($(this).attr("data-sid"));
	$("#id").val($(this).attr("data-sid"));
	$("#companyId").val($(this).attr("data-lid"));
	$("#serviceType").val($(this).attr("data-stype"));
	jQuery("#allService").submit();
});



</script>

</body>
</html>

