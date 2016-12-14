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
 	<input id="userLogo" name="userLogo" value="${vo.userLogo}"  type="hidden"  />
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
	            	<span style="color:red;">${errorMsg}</span>
	            </td>
	            <td width="260" >&nbsp;</td>
	            <td width="260" class="td_dis" colspan="2" >&nbsp;</td>
	        </tr>
		 </c:if>
		 <tr>
            <td width="120" align="right">头像：</td>
            <td width="260" > 
	            <c:if test="${empty vo.userLogo}">
	            	 <img src="${BASE_URL}/images/touxiang_03.jpg" width="38" height="38" />
				</c:if>
				<c:if test="${not empty vo.userLogo}">
					 <img src="${BASE_URL}/${vo.userLogo}" width="38" height="38" />
				</c:if>
            </td>
            <td width="120" class="td_dis" align="right">头像：</td>
            <td width="260" class="td_dis">
            		<c:if test="${empty vo.userLogo}">
		            	 <img id="userLogoImg"  src="${BASE_URL}/images/touxiang_03.jpg" data-src="images/touxiang_03.jpg" width="38" height="38" />
					</c:if>
					<c:if test="${not empty vo.userLogo}">
						 <img id="userLogoImg" src="${BASE_URL}/${vo.userLogo}" data-src="${vo.userLogo}"  width="38" height="38"  />
					</c:if>
                	<input  onclick="doSelectPic()"  type="button" value="上传图片" class="form_shangchuan" />
                	<iframe id="uploadPicFrame" src="" style="display:none;"></iframe>
           	</td>
          </tr>
          <tr>
            <td width="120" align="right">姓名：</td>
            <td width="260" >${vo.trueName}</td>
            <td width="120" class="td_dis" align="right">姓名：</td>
            <td width="260" class="td_dis"><input id="trueName" name="trueName" value="${vo.trueName}" maxlength="10"  type="text" class="grzx_input" /></td>
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
            	<c:if test="${vo.userSex==0}">男 </c:if>
            	<c:if test="${vo.userSex==1}">女</c:if>
            </td>
            <td align="right" class="td_dis">性别：</td>
            <td class="td_dis">
            	<c:if test="${vo.userSex==0}">
            		<input name="userSex" type="radio" value="0" checked="checked"/> 男 &nbsp;&nbsp;&nbsp;&nbsp;
            		<input name="userSex" type="radio" value="1" /> 女
            	</c:if>
            	<c:if test="${vo.userSex==1}">
            		<input name="userSex" type="radio" value="0"/> 男 &nbsp;&nbsp;&nbsp;&nbsp;
            		<input name="userSex" type="radio" value="1"  checked="checked" /> 女
            	</c:if>
            </td>
          </tr>
          <tr>
            <td align="right">联系方式：</td>
            <td>${vo.mobilePhoneNumber}</td>
            <td align="right" class="td_dis">联系方式：</td>
            <td class="td_dis"><input id="mobilePhoneNumber" name="mobilePhoneNumber" value="${vo.mobilePhoneNumber}" maxlength="11" type="text" class="grzx_input" /></td>
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
$("#toEditUserInfo").addClass("li_atab");
var baseUrl = $("#baseUrl").val();
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
	var logo = $("#userLogoImg").attr("data-src");
	if($.trim(logo).length <= 0){
		alert("请上传头像");
		return false;
	}
	$("#userLogo").val(logo);
	var trueName = $("#trueName").val();
	if($.trim(trueName).length <= 0){
		alert("请输入姓名");
		 $("#trueName").focus();
		return false;
	}
	var mobilePhoneNumber = $("#mobilePhoneNumber").val();
	if($.trim(mobilePhoneNumber).length <= 0){
		alert("请输入联系方式");
		 $("#mobilePhoneNumber").focus();
		return false;
	}
	if(!checkMob(mobilePhoneNumber)){
		alert("请输入正确联系方式");
		$("#mobilePhoneNumber").focus();
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

function doSelectPic() {
	var imgSize = 0;
	$("#pic", $("#uploadPicFrame")[0].contentWindow.document).click();
	return false;
}

initUploadPicFrame();
function initUploadPicFrame(){
	var frameSrc = "/user/getUploadPicForm.html";
	var frameParam = new Object();
	frameParam.formId= "upload";
	frameParam.inputId= "pic";
	frameParam.inputOnChange = "parent.picChange";
	frameParam.jsonp = "parent.picUploadCallback";
	frameSrc += "?"+parseParam(frameParam);
	$("#uploadPicFrame").attr("src", frameSrc);
}
function picChange(inputFile){
	var fileSize = 0;
	if (navigator.userAgent.indexOf('MSIE') >= 0){
	}else{
		var files = inputFile.files;
		if (files.length>0){
			var targetFile = files[0];
			fileSize = targetFile.size;
		}
		if(files.length > 1){
			alert("请单张上传");
    		initUploadPicFrame();
		}
	}
	if (fileSize>2097152){
		alert("上传图片大小超过2M");
		initUploadPicFrame();
	}else{
		$("#upload", $("#uploadPicFrame")[0].contentWindow.document).submit();
	}
}
function delPic(data){
	$(data).remove();
}
//上传完成后回调的方法
function picUploadCallback(data){
	if (data.returnCode == "1"){
		
		var picUrl = data.picPath;
		if(picUrl.length > 0){
			$("#userLogoImg").attr("data-src",data.picPath);
			$("#userLogoImg").attr("src",data.picPath);
		}else{
			alert("上传失败,请稍后再试");
		}
	}else{
		if(data.msg != ""){
			alert(data.msg);
		}else{
			alert("上传失败,请稍后再试");
		}
	}
	initUploadPicFrame();
}
//公共方法,用来将对象转化为URL参数
function parseParam(param, key){
  	var paramStr="";
  	if(param instanceof String||param instanceof Number||param instanceof Boolean){
    	paramStr+="&"+key+"="+encodeURIComponent(param);
  	}else{
    	jQuery.each(param,function(i){
          	var k=key==null?i:key+(param instanceof Array?"["+i+"]":"."+i);
          	paramStr+='&'+parseParam(this, k);
    	});
  	}
  	return paramStr.substr(1);
}




</script>

</form>
</body>
</html>

