<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改密码</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<link href="${BASE_URL}/images/gerenzx.css" rel="stylesheet" type="text/css" />
<meta name="renderer" content="webkit" />
<jsp:include page="../public/baseData.jsp" />
</head>

<body>
<form id="doEditPassword" action="${BASE_URL}/user/doEditPassword.html" method="post">
 	<jsp:include page="../public/loginheader.jsp" />
	<div class="top_tiao"></div>
	<div class="gerenzx_main">
	 <jsp:include page="../public/loginLeft.jsp" />
    <div class="gerenzx_right">
    	<div class="grzx_h2">
    	  <h2>修改密码</h2></div>
      <table border="0" cellspacing="20" cellpadding="0" class="gerenzx_table">
      		<c:if test="${not empty errorMsg}">
		        <tr>
		            <td width="120" align="right">
		            	<span style="color:red;">${errorMsg }</span>
		            </td>
		            <td width="260" >&nbsp;</td>
		        </tr>
			</c:if>
          <tr>
            <td width="120" align="right">原密码：</td>
            <td width="260" ><input id="oldUserPassword" name="oldUserPassword" type="password" class="grzx_input" /></td>
          </tr>
          <tr>
            <td align="right">新密码：</td>
            <td><input  id="userPassword" name="userPassword"  type="password" class="grzx_input" /></td>
          </tr>
          <tr>
            <td align="right">确定新密码：</td>
            <td><input  id="userPassword2" name="userPassword2"  type="password" class="grzx_input" /></td>
          </tr>
          <tr>
            <td colspan="2" align="center"><input id="saveBtn" name="saveBtn" type="button" value="保 存" class="grzx_button" /></td>
          </tr>
        </table>

  </div>
</div>
<script type="text/javascript">
$("#toEditPassword").addClass("li_atab");
$("#saveBtn").click(function(){
	if(check()){
		$("#doEditPassword").submit();
	}
});
function check(){
	var oldUserPassword = $("#oldUserPassword").val();
	if($.trim(oldUserPassword).length <= 0){
		alert("请输入原密码");
		 $("#oldUserPassword").focus();
		return false;
	}
	if($.trim(oldUserPassword).length < 6){
		alert("原密码必须大于6位");
		$("#oldUserPassword").focus();
		return false;
	}
	$("#oldUserPassword").val(hex_md5(oldUserPassword));
	var userPassword = $("#userPassword").val();
	if($.trim(userPassword).length <= 0){
		alert("请输入新密码");
		 $("#userPassword").focus();
		return false;
	}
	if($.trim(userPassword).length < 6){
		alert("新密码必须大于6位");
		$("#userPassword").focus();
		return false;
	}
	$("#userPassword").val(hex_md5(userPassword));
	if(userPassword == oldUserPassword){
		alert("新密码与原密码相同");
	 	$("#userPassword").focus();
		return false;
	}
	var userPassword2 = $("#userPassword2").val();
	if($.trim(userPassword2).length <= 0){
		alert("请输入确定新密码");
		 $("#userPassword2").focus();
		return false;
	}
	if(userPassword != userPassword2){
		alert("登录密码与确认密码不相同");
	 	$("#userPassword2").focus();
		return false;
	}
	$("#userPassword2").val(hex_md5(userPassword2));
	return true;
}
</script>

</form>
</body>
</html>

