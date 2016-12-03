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
            <td width="260" ><input id="oldLoginPwd" name="oldLoginPwd" type="password" class="grzx_input" /></td>
          </tr>
          <tr>
            <td align="right">新密码：</td>
            <td><input  id="loginPwd" name="loginPwd"  type="password" class="grzx_input" /></td>
          </tr>
          <tr>
            <td align="right">确定新密码：</td>
            <td><input  id="loginPwd2" name="loginPwd2"  type="password" class="grzx_input" /></td>
          </tr>
          <tr>
            <td colspan="2" align="center"><input id="saveBtn" name="saveBtn" type="button" value="保 存" class="grzx_button" /></td>
          </tr>
        </table>

  </div>
</div>
<script type="text/javascript">
$("#saveBtn").click(function(){
	if(check()){
		$("#doEditPassword").submit();
	}
});
function check(){
	var oldLoginPwd = $("#oldLoginPwd").val();
	if($.trim(oldLoginPwd).length <= 0){
		alert("请输入原密码");
		 $("#oldLoginPwd").focus();
		return false;
	}
	if($.trim(oldLoginPwd).length < 6){
		alert("原密码必须大于6位");
		$("#oldLoginPwd").focus();
		return false;
	}
	var loginPwd = $("#loginPwd").val();
	if($.trim(loginPwd).length <= 0){
		alert("请输入新密码");
		 $("#loginPwd").focus();
		return false;
	}
	if($.trim(loginPwd).length < 6){
		alert("新密码必须大于6位");
		$("#loginPwd").focus();
		return false;
	}
	if(loginPwd == oldLoginPwd){
		alert("新密码与原密码相同");
	 	$("#loginPwd").focus();
		return false;
	}
	var loginPwd2 = $("#loginPwd2").val();
	if($.trim(loginPwd2).length <= 0){
		alert("请输入确定新密码");
		 $("#loginPwd2").focus();
		return false;
	}
	if(loginPwd != loginPwd2){
		alert("登录密码与确认密码不相同");
	 	$("#loginPwd2").focus();
		return false;
	}
	return true;
}
</script>

</form>
</body>
</html>

