<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人资料</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<link href="${BASE_URL}/images/gerenzx.css" rel="stylesheet" type="text/css" />
<meta name="renderer" content="webkit" />
<jsp:include page="../public/baseData.jsp" />
<style>
.td_dis{
display:none
}
</style>
</head>

<body>
<form id="doEditUserInfo" action="${BASE_URL}/user/doEditUserInfo.html" method="post">
	<jsp:include page="../public/loginheader.jsp" />
	<div class="top_tiao"></div>
	<div class="gerenzx_main">
	 <jsp:include page="../public/loginLeft.jsp" />
    <div class="gerenzx_right">
    	<div class="grzx_h2"><h2>个人资料</h2></div>
      <table border="0" cellspacing="20" cellpadding="0" class="gerenzx_table">
      	  <c:if test="${not empty errorMsg}">
	        <tr>
	            <td width="120"   align="right">
	            	<span style="color:red;">${errorMsg }</span>
	            </td>
	            <td width="260" >&nbsp;</td>
	            <td width="260" class="td_dis" colspan="2" >&nbsp;</td>
	        </tr>
		 </c:if>
          <tr>
            <td width="120" align="right">姓名：</td>
            <td width="260" >${vo.raleName}</td>
            <td width="120" class="td_dis" align="right">姓名：</td>
            <td width="260" class="td_dis"><input id="raleName" name="raleName" value="${vo.raleName}" maxlength="10"  type="text" class="grzx_input" /></td>
          </tr>
          <tr>
            <td align="right">年龄：</td>
            <td>${vo.age}</td>
            <td align="right" class="td_dis">年龄：</td>
            <td class="td_dis"><input id="age" name="age" value="${vo.age}" maxlength="2"  type="text" class="grzx_input2" /></td>
          </tr>
          <tr>
            <td align="right">性别：</td>
            <td>
            	<c:if test="${vo.sex==0}">男 </c:if>
            	<c:if test="${vo.sex==1}">女</c:if>
            </td>
            <td align="right" class="td_dis">性别：</td>
            <td class="td_dis">
            	<c:if test="${vo.sex==0}">
            		<input name="sex" type="radio" value="0" checked="checked"/> 男 &nbsp;&nbsp;&nbsp;&nbsp;
            		<input name="sex" type="radio" value="1" /> 女
            	</c:if>
            	<c:if test="${vo.sex==1}">
            		<input name="sex" type="radio" value="0"/> 男 &nbsp;&nbsp;&nbsp;&nbsp;
            		<input name="sex" type="radio" value="1"  checked="checked" /> 女
            	</c:if>
            </td>
          </tr>
          <tr>
            <td align="right">联系方式：</td>
            <td>${vo.mobilePhone}</td>
            <td align="right" class="td_dis">联系方式：</td>
            <td class="td_dis"><input id="mobilePhone" name="mobilePhone" value="${vo.mobilePhone}" maxlength="11" type="text" class="grzx_input" /></td>
          </tr>
          <tr>
            <td align="right">邮箱：</td>
            <td>${vo.email}</td>
            <td align="right" class="td_dis">邮箱：</td>
            <td class="td_dis"><input id="email" name="email" value="${vo.email}" maxlength="50" type="text" class="grzx_input" /></td>
          </tr>
          <tr>
            <td colspan="2" align="center"><input id="updateBtn" name="updateBtn" type="button" value="修 改" class="grzx_button" /></td>
            <td colspan="2" align="center" class="td_dis"><input id="saveBtn" name="saveBtn"   type="button" value="保 存" class="grzx_button"/></td>
          </tr>
        </table>

  </div>
</div>
<script type="text/javascript">
$("#updateBtn").click(function(){
	$('.td_dis').each(function(){
		 $(this).removeClass("td_dis");
		 $('#updateBtn').hide();
	});
});
$("#saveBtn").click(function(){
	if(check()){
		$("#doEditUserInfo").submit();
	}
});
function check(){
	var raleName = $("#raleName").val();
	if($.trim(raleName).length <= 0){
		alert("请输入姓名");
		 $("#raleName").focus();
		return false;
	}
	var mobilePhone = $("#mobilePhone").val();
	if($.trim(mobilePhone).length <= 0){
		alert("请输入联系方式");
		 $("#mobilePhone").focus();
		return false;
	}
	if(!checkMob(mobilePhone)){
		alert("请输入正确联系方式");
		$("#mobilePhone").focus();
		return false;
	}
	var email = $("#email").val();
	if($.trim(email).length <= 0){
		alert("请输入邮箱");
		 $("#email").focus();
		return false;
	}
	 var isemail  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	 if(!isemail.test(email)){
		 alert("请输入正确邮箱格式");
		 $("#email").focus();
		return false;
	 }
	 
	return true;
}
var isMob = /^((13[0-9])|(14[0-9])|(15[0-9])|(18[0-9])|(17[0-9]))\d{8}$/;
function checkMob(mobile) {
	if (isMob.test(mobile)) {
		return true;
	} else {
		return false;
	}
}
</script>

</form>
</body>
</html>

