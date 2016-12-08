<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>基本信息管理</title>
<link href="${BASE_URL}/images/gerenzx.css" rel="stylesheet" type="text/css" />
    <jsp:include page="../public/baseData.jsp" />
    <jsp:include page="../public/pager.jsp" />
</head>

<body>
<form id="userList" action="${BASE_URL}/user/baseList.html" method="post">
<input id="baseUrl"   value="${BASE_URL}"  type="hidden"  />
<input id="page" name="page" type="hidden" value="${basePage.page}"/>
<input id="curPage" name="curPage"  value="${basePage.page}" type="hidden"/>
<input id="pageCount" name="pageCount" value="${basePage.pages}" type="hidden"/>
<input id="id" name="id" type="hidden"/>
<input id="updateCode" name="updateCode" type="hidden"/>

<jsp:include page="../public/loginheader.jsp" />
	<div class="top_tiao"></div>
	<div class="gerenzx_main">
	 <jsp:include page="../public/loginLeft.jsp" />
    <div class="gerenzx_right">
    	<div class="grzx_h2"><h2>基本信息管理</h2></div>
      <table border="0" cellspacing="10" cellpadding="0" class="gerenzx_table">
          <tr>
            <td width="78" align="right">类型：</td>
            <td width="155">
            	<select id="type" name="type" class="form_input">
	               	<option value="">请选择</option>
	               	<c:forEach items="${typeList}" var="type">
	               		<c:if test="${type.id==vo.type}">
	           	 			<option value="${type.id}" selected="selected">${type.des}</option>
		   				</c:if>
		   				<c:if test="${type.id!=vo.type}">
	           	 			<option value="${type.id}">${type.des}</option>
		   				</c:if>
					</c:forEach>
	            </select>
            </td>
            <td width="78" align="right">显示名称：</td>
            <td width="155"><input id="showName" name="showName" value="${vo.showName}" type="text" class="grzx_input" /></td>
            <td width="200">
            		<input id="addBtn"   type="button" value="添加" class="grzx_button2" />&nbsp;&nbsp;
            		<input id="queryBtn" type="button" value="查询" class="grzx_button2" />
            </td>
          </tr>
        </table>
        <table width="929" border="0" cellspacing="1" cellpadding="0" class="fuwugl_table">
          <thead>
          <tr>
            <td width="196" height="38" align="center">类型</td>
            <td width="187" align="center">显示名称</td>
            <td width="217" align="center">操作</td>
          </tr>
          </thead>
          <tbody>
          	<c:forEach items="${baseList}" var="base">
                <tr>
		            <td height="40" align="center">
		            	${base.typeStr}
		            </td>
		            <td align="center">${base.showName}</td>
		            <td align="center">
		            	<c:if test="${base.status!=1}">
		            		<a id="Enabled" data-id="${base.id}" href="javascript:;" class="hongzi_a">启用</a>
		            	</c:if>
		            	<c:if test="${base.status==1}">
		            		<a id="Disable" data-id="${base.id}" href="javascript:;" class="hongzi_a">停用</a>
		            	</c:if>
		            </td>
		          </tr>
			</c:forEach>
          
          <tr>
            <td height="40" colspan ="3"> <div class="pages" id="pager"></div></td>
          </tr>
          </tbody>
        </table>
  </div>
</div>
</form>
<script type="text/javascript">
var baseUrl = $("#baseUrl").val();
$("#baseList").addClass("li_atab");

//分页  begin
var cur_page = $("#curPage").val();
var page_count = $("#pageCount").val();
jQuery("#pager").pager({pagenumber: cur_page, pagecount: page_count, buttonClickCallback: change_page });

function change_page(cur_page) {
    jQuery("#page").val(cur_page);
    jQuery("#userList").submit();
}
$("#Enabled").click(function(){
	$("#userList").attr("action",baseUrl+"/user/updateList.html");
	 $("#updateCode").val("Enabled");
	$(this).val($("#Enabled").attr("data-id"));
	/*$("#id").val($("#Enabled").attr("data-id"));*/
	 jQuery("#userList").submit();
});
$("#Disable").click(function(){
	 $("#userList").attr("action",baseUrl+"/user/updateList.html");
	 $("#updateCode").val("Disable");
	/* $("#id").val($("#Disable").attr("data-id"));*/
	$(this).val($("#Disable").attr("data-id"));
	 jQuery("#userList").submit();
	 
});
$("#queryBtn").click(function(){
	$("#userList").attr("action",baseUrl+"/user/baseList.html");
	 jQuery("#userList").submit();
});
$("#addBtn").click(function(){
   	if(check()){
   		$("#userList").attr("action",baseUrl+"/user/addBase.html");
   		$("#userList").submit();
   	}
});
function check(){
	var type = $("#type").val();
	if($.trim(type).length <= 0){
		alert("请输入类型");
		 $("#type").focus();
		return false;
	}
	var showName = $("#showName").val();
	if($.trim(showName).length <= 0){
		alert("请输入显示名称");
		 $("#showName").focus();
		return false;
	}
	return true;
}

//分页 end
</script>
</body>
</html>
