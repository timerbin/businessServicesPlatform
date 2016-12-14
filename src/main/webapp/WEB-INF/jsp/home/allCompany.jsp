<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>所有企业</title>
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
    	 
    	 <form id="allCompany" action="${BASE_URL}/home/allCompany.html" method="post">
			<input id="page" name="page" type="hidden" value="${basePage.page}"/>
		    <input id="curPage" name="curPage"  value="${basePage.page}" type="hidden"/>
		   	<input id="pageCount" name="pageCount" value="${basePage.pages}" type="hidden"/>
		   	<input id="companyName" name="companyName"  value="${queryVo.companyName}"    type="hidden"  />
		   	
		   	
	    	<div class="right_main">
	            <div class="youzhiqy_box">
	                <div class="right2_h2"><span class="more">&nbsp;</span><h2>优质企业</h2></div>
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
	                <div class="pages" id="pager"></div>
	            </div>
	       </div>
       </form>
    </td>
 </tr>
</table>
<script type="text/javascript">
//分页  begin
$("#navMenu0").addClass("left_border");

var cur_page = $("#curPage").val();
var page_count = $("#pageCount").val();
jQuery("#pager").pager({pagenumber: cur_page, pagecount: page_count, buttonClickCallback: change_page });

function change_page(cur_page) {
	$("#companyName").val($("#queryStr").val());
    jQuery("#page").val(cur_page);
    jQuery("#allCompany").submit();
}

</script>


</body>
</html>

