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
	<jsp:include page="../public/pager.jsp" />
<style>
.comment-rate {
    float: left;
    width: 256px;
}
.comment-rate dl {
    padding: 9px 0;
    overflow: hidden;
    zoom: 1;
}
.comment-rate dt {
    width: 100px;
    color: #4c515c;
    font-size: 14px;
}
.comment-rate dd {
    width: 150px;
    height: 12px;
    overflow: hidden;
    background-color: #DEDEDE;
}
.comment-rate dd, .comment-rate dt {
    float: left;
}
.comment-rate dd div {
    overflow: hidden;
    height: 12px;
    width: 0;
    background-color: #F43B00;
}
</style>
</head>
<body>
<input id="userId" name="userId"   value="${services_user_info.id}"  type="hidden"  />

    <table width="100%" height="100%" border="0px" cellpadding="0px" cellspacing="0px" >
	<tr><td width="250px" valign="top" class="con_left">
		 <jsp:include page="../public/left.jsp" ></jsp:include>
	</td>
    <td  valign="top">
		<jsp:include page="../public/header.jsp" ></jsp:include>
		
		
		<jsp:include page="../public/search.jsp" ></jsp:include>
    	 
        <form id="saveComment" action="${BASE_URL}/user/saveComment.html" method="post">
			<input id="serviceId" name="serviceId"   value="${queryVo.id}"  type="hidden"  />
			<input id="tagIds" name="tagIds"    type="hidden"  />
			<input id="commentDirections" name="commentDirections"    type="hidden"  />
			<input id="callbackUrl" name="callbackUrl" type="hidden" value="${BASE_URL}/home/serviceShow.html?id=${queryVo.id}" />
			<input id="commentType" name="commentType"    type="hidden"  />


			<input id="id" name="id" type="hidden"/>
			<input id="companyId" name="companyId" type="hidden"/>
			<input id="serviceType" name="serviceType" type="hidden"/>
	
	        <div class="right_main">
	            <div class="fuwu_left_con">
	                <div class="right3_h2"><span class="more"><a href="${BASE_URL}/home/allService.html">查看更多>></a></span><h2>推荐服务</h2></div>
	                <div class="tjfw_tuwen">
	           	    	<span class="tjfw_tu"><img src="${vo.picUrl}" /></span>
	                    <span class="scfuwu"><a data-id="${vo.id}" href="javascript:;">[收藏服务]</a></span>
	                    <h3>${vo.serviceName}</h3> 
	                    <span class="fuwu_time">${vo.createTimeStr}</span>
	                    <span class="fuwu_pingjia">
	                    	服务评价 
	                    	<c:forEach var="s"  begin="1" end="${commentSize.star}">
	                    		 <img src="${BASE_URL}/images/wuxing_huang.png"/> 
							</c:forEach>
							<c:forEach var="s"  begin="1" end="${5-commentSize.star}">
	                    		 <img src="${BASE_URL}/images/wuxing_hui.png"/> 
							</c:forEach>
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
	                		<div class="comment-rate">
								 <dl>
									 <dt><img src="${BASE_URL}/images/shou_03.jpg" />好评</dt>
									 <dd><div style="width:${commentSize.goodSizeRate}%;"></div>${commentSize.goodSize}人</dd>
								 </dl>
								 <dl>
									 <dt><img src="${BASE_URL}/images/shou_07.jpg" />中评  </dt>
									 <dd><div style="width: ${commentSize.middleSizeRate}%;"></div>${commentSize.middleSize}人</dd>
								 </dl>
								 <dl>
									 <dt><img src="${BASE_URL}/images/shou_11.jpg" />差评 </dt>
									 <dd><div style="width:${commentSize.badSizeRate}%;"></div>${commentSize.badSize}人</dd>
								 </dl>
							 </div>
	                        <div class="haopingdu">好评度 <span>${commentSize.goodSizeRate}%</span></div>
	                        <div class="clear"></div>
	                    </div>
	                    <div id="saveComment" class="tjfw_article">
	                    	<c:if test="${not empty errorMsg}">
						        <h4><span style="color:red;">${errorMsg}</span></h4>
							</c:if>
		                    <h4>评论标签</h4>
		                    <p>
		                    	<c:forEach items="${allTagList}" var="dataTag">
	                    			<span><input name="dataTagStr" type="checkbox" value="${dataTag.id}" />${dataTag.showName}</span>
	                    		</c:forEach>
		                    </p>
		                    <h4>评论内容</h4>
		                     <p>
		                     	<input name="commentTypeBtn" type="radio" value="1" checked="checked" />好评
		                        <input name="commentTypeBtn" type="radio" value="2" />中评 
		                        <input name="commentTypeBtn" type="radio" value="3" />差评
		                    </p>
		                    <p>
		                    	 <textarea id="commentDirectionsStr"  cols="" rows="" class="form_textarea"></textarea>
		                    </p>
	                    </div>
	                    <div class="tjfw_button"><input id="addComment"  type="button" / value="我要点评" class="form_button bjse_hong"></div>
	            	</div>
	                
	              <div class="tjfw_evaluation">
	                	<ul class="evaluation">
	                    	<li><input name="queryType" type="radio" value="" />全部 （${commentSize.allSize}）</li>
	                        <li><input name="queryType" type="radio" value="1" />好评 （${commentSize.goodSize}）</li>
	                        <li><input name="queryType" type="radio" value="2" />中评 （${commentSize.middleSize}）</li>
	                        <li><input name="queryType" type="radio" value="3" />差评 （${commentSize.badSize}）</li>
	                    </ul>
	                    <c:forEach items="${commentList}" var="comment">
	                  			<div class="evaluation_ar">
			                    	<h3>
			                    		<c:if test="${comment.commentType==1}">
			                    			<img src="${BASE_URL}/images/shou_03.jpg" />好评 
			   							</c:if>
			   							<c:if test="${comment.commentType==2}">
			   								<img src="${BASE_URL}/images/shou_07.jpg" />中评
			   							</c:if>
			   							<c:if test="${comment.commentType==3}">
			   								<img src="${BASE_URL}/images/shou_011.jpg" />差评
			   							</c:if>
			                    		<c:forEach items="${comment.tagList}" var="tag">
			                    			<span>${tag.commentTagName}</span>
			                    		</c:forEach>
			                    	</h3>
		                        	<p>${comment.commentDirections}</p>
		                        	<span class="hui_zi">${comment.createTimeStr}</span>
		                    	</div>
						</c:forEach>
	                    <div class="pages" id="pager"></div>
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
			                        <li><img src="${service.picUrl}" width="180" height="100" />
			                            <h3>${likeService.serviceName}</h3>
			                            <p>${likeService.serviceDirections}</p>
			                            <span><a id="showLikeService" name="showLikeService" href="#" data-aId="${likeService.id}" data-aComId="${likeService.companyId}" data-aSerType="${likeService.serviceType}">查看</a></span>
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
$("#navMenu0").addClass("left_border");
var baseUrl = $("#baseUrl").val();
//分页  begin
var cur_page = $("#curPage").val();
var page_count = $("#pageCount").val();
jQuery("#pager").pager({pagenumber: cur_page, pagecount: page_count, buttonClickCallback: change_page });

function change_page(cur_page) {
    jQuery("#page").val(cur_page);
    jQuery("#saveComment").submit();
}
//分页 end

$("#addComment").click(function(){
	var userId = $("#userId").val();
	if($.trim(userId).length <= 0){
		window.location.href =baseUrl+"/login/toLogin.html?callbackUrl='"+$("#callbackUrl").val()+"'";
		return false;
	}else{
		if(check()){
			$("#saveComment").submit();
		}
	}
});
function check(){
	var commentDirectionsStr = $("#commentDirectionsStr").val();
	if($.trim(commentDirectionsStr).length <= 0){
		alert("请输入评论内容");
		 $("#commentDirectionsStr").focus();
		return false;
	}
	$("#commentDirections").val(commentDirections);
	var commentTypeBtn = $("input[name='commentTypeBtn']:checked").val();
	if($.trim(commentTypeBtn).length <= 0){
		alert("请输入评论类型");
		return false;
	}
	$("#commentType").val(commentTypeBtn);
	return true
}


$("#showLikeService").click(function(){
	$("#saveComment").attr("action",baseUrl+"/home/serviceShow.html");
	$("#id").val($(this).attr("data-aId"));
	$("#companyId").val($(this).attr("data-aComId"));
	$("#serviceType").val($(this).attr("data-aSerType"));
	jQuery("#saveComment").submit();
});
</script>
</body>
</html>

