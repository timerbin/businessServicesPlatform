<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户管理</title>
<link href="${BASE_URL}/images/gerenzx.css" rel="stylesheet" type="text/css" />
    <jsp:include page="../public/baseData.jsp" />
    <jsp:include page="../public/pager.jsp" />
</head>

<body>
<form id="userList" action="${BASE_URL}/user/userManagement.html" method="post">
<input id="page" name="page" type="hidden"/>
<input id="curPage" name="curPage"  value="${basePage.page}" type="hidden"/>
<input id="pageCount" name="pageCount" value="${basePage.pages}" type="hidden"/>
<input id="updateCode" name="updateCode" type="hidden"/>
<input id="id" name="id" type="hidden"/>

<jsp:include page="../public/loginheader.jsp" />
	<div class="top_tiao"></div>
	<div class="gerenzx_main">
	 <jsp:include page="../public/loginLeft.jsp" />
    <div class="gerenzx_right">
    	<div class="grzx_h2"><h2>用户管理</h2></div>
      <table border="0" cellspacing="10" cellpadding="0" class="gerenzx_table">
          <tr>
            <td width="78" align="right">用户名称：</td>
            <td width="155"><input id="userName" name="userName" value="${vo.userName}" type="text" class="grzx_input" /></td>
            <td width="90"><input id="queryBtn" name="queryBtn" type="button" value="查询" class="grzx_button2" /></td>
          </tr>
        </table>
        <table width="929" border="0" cellspacing="1" cellpadding="0" class="fuwugl_table">
          <thead>
          <tr>
            <td width="196" height="38" align="center">用户名称</td>
            <td width="187" align="center">真实姓名</td>
            <td width="109" align="center">联系方式</td>
            <td width="102" align="center">邮箱</td>
            <td width="102" align="center">用户类型</td>
            <td width="217" align="center">操作</td>
          </tr>
          </thead>
          <tbody>
          	<c:forEach items="${userList}" var="user">
                <tr>
		            <td height="40">${user.userName}</td>
		            <td align="center">${user.trueName}</td>
		            <td align="center">${user.mobilePhoneNumber}</td>
		            <td align="center">${user.email}</td>
		            <td align="center">
		            	<c:if test="${user.type==1}">
		            		普通用户
		            	</c:if>
		            	<c:if test="${user.type==2}">
		            		管理员
		            	</c:if>
		            </td>
		            <td align="center">
		            	<c:if test="${user.userStatus!=1}">
		            		<a id="Enabled" data-id="${user.id}" href="javascript:;" class="hongzi_a">启用</a>
		            	</c:if>
		            	<c:if test="${user.userStatus==1}">
		            		<a id="Disable" data-id="${user.id}" href="javascript:;" class="hongzi_a">停用</a>
		            	</c:if>
		            	<c:if test="${user.type==1}">
		            		<a id="doAdmin" data-id="${user.id}" href="javascript:;" class="hongzi_a">升为管理员</a>
		            	</c:if>
		            	<c:if test="${user.type==2}">
		            		<a id="doUser" data-id="${user.id}" href="javascript:;" class="hongzi_a">降为普通用户</a>
		            	</c:if>
		            </td>
		          </tr>
			</c:forEach>
          
          <tr>
            <td height="40" colspan ="7"> <div class="pages" id="pager"></div></td>
          </tr>
          </tbody>
        </table>
  </div>
</div>
<jsp:include page="../public/footer.jsp" ></jsp:include>
</form>
<script type="text/javascript">
//分页  begin
var cur_page = $("#curPage").val();
var page_count = $("#pageCount").val();
jQuery("#pager").pager({pagenumber: cur_page, pagecount: page_count, buttonClickCallback: change_page });

function change_page(cur_page) {
    jQuery("#page").val(cur_page);
    jQuery("#userList").submit();
}
$("#Enabled").click(function(){
	 $("#updateCode").val("Enabled");
	 $("#id").val($("#Enabled").attr("data-id"));
	 jQuery("#userList").submit();
});
$("#Disable").click(function(){
	 $("#updateCode").val("Disable");
	 $("#id").val($("#Disable").attr("data-id"));
	 jQuery("#userList").submit();
	 
});
$("#doAdmin").click(function(){
	 $("#updateCode").val("doAdmin");
	 $("#id").val($("#doAdmin").attr("data-id"));
	 jQuery("#userList").submit();
	 
});
$("#doUser").click(function(){
	 $("#updateCode").val("doUser");
	 $("#id").val($("#doUser").attr("data-id"));
	 jQuery("#userList").submit();
	 
});
$("#queryBtn").click(function(){
	 jQuery("#userList").submit();
});


//分页 end
</script>
</body>
</html>
