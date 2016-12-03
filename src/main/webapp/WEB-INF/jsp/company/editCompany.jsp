<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>成为企业</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<link href="${BASE_URL}/images/hongqiao.css" rel="stylesheet" type="text/css" />
<meta name="renderer" content="webkit" />
<jsp:include page="../public/baseData.jsp" />
</head>


<body>
<form id="saveCompany" action="${BASE_URL}/user/saveCompany.html" method="post">
	<input id="baseUrl"   value="${BASE_URL}"  type="hidden"  />
     <table width="100%" height="100%" border="0px" cellpadding="0px" cellspacing="0px" >
	<tr><td width="250px" valign="top" class="con_left">
		 <jsp:include page="../public/left.jsp" ></jsp:include>
	</td>
    <td  valign="top">
		<jsp:include page="../public/loginheader.jsp" ></jsp:include>
    	<div class="location">企业入驻-填写企业相关信息提交审核</div>
    	<div class="form_box">
            <table width="900" border="0" cellspacing="20" cellpadding="0">
              <tr>
                <td width="121" align="right"><span class="hong_xing">*</span>企业名称：</td>
                <td width="550"><input id="companyName" name="companyName" value="${vo.companyName}" type="text" class="form_input" /></td>
                <td width="149">&nbsp;</td>
              </tr>
              <tr>
                <td align="right"><span class="hong_xing">*</span>注册资金：</td>
                <td><input  id="companyRegisterMoney" name="companyRegisterMoney" value="${vo.companyRegisterMoney}"   type="text" class="form_input2" /></td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td align="right"><span class="hong_xing">*</span>企业地址：</td>
                <td><input id="companyAddress" name="companyAddress" value="${vo.companyAddress}"  type="text" class="form_input" /></td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td align="right"><span class="hong_xing">*</span>联系电话：</td>
                <td><input id="companyContactTel" name="companyContactTel" value="${vo.companyContactTel}"  type="text" class="form_input2" /></td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td align="right"><span class="hong_xing">*</span>联系人：</td>
                <td><input id="companyContactUser" name="companyContactUser" value="${vo.companyContactUser}" type="text" class="form_input2" /></td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td align="right"><span class="hong_xing">*</span>经营范围：</td>
                <td><select id="companyScope" name="companyScope" class="form_input">
	                	<option value="">请选择</option>
	                	<c:forEach items="${managementList}" var="management">
							<option value="${management.id}">${management.showName}</option>
						</c:forEach>
                    </select>
                </td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td align="right"><span class="hong_xing">*</span>成立时间：</td>
                <td><input id="companyRegisterTimeStr" name="companyRegisterTimeStr" value="${vo.companyRegisterTimeStr}"  type="text" class="form_input2" /></td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td align="right"><span class="hong_xing">*</span>企业性质：</td>
                <td><select id="companyType" name="companyType"  class="form_input">
                		<option value="">请选择</option>
	                	<c:forEach items="${propertyList}" var="property">
							<option value="${property.id}">${property.showName}</option>
						</c:forEach>
                	</select>
                </td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td align="right" valign="top"><span class="hong_xing">*</span>企业图片：</td>
                <td class="qiye_img" ><span id="cimgs"></span>
                </td>
                <td valign="bottom">
                	<input  onclick="doSelectPic()"  type="button" value="上传图片" class="form_shangchuan" />
                	<iframe id="uploadPicFrame" src="" style="display:none;"></iframe>
                </td>
              </tr>
              <tr>
                <td align="right"><span class="hong_xing">*</span>企业官网链接：</td>
                <td><input  id="companyUrl" name="companyUrl" value="${vo.companyUrl}"   type="text" class="form_input" /></td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td align="right" valign="top"><span class="hong_xing">*</span>企业简介：</td>
                <td colspan="2"><textarea id="companyDirections" name="companyDirections"  value="${vo.companyDirections}" cols="" rows="" class="form_textarea"></textarea></td>
              </tr>
              <tr>
                <td align="right">&nbsp;</td>
                <td><input id="saveBtn" name="saveBtn" type="button" / value="保 存" class="form_button bjse_hong"> <input name="" type="button" / value="提 交" class="form_button bjse_lan"> <input name="" type="button" / value="重 置" class="form_button bjse_cheng"></td>
                <td>&nbsp;</td>
              </tr>
            </table>
        </div>
    </td></tr>
</table>
<jsp:include page="../public/footer.jsp" ></jsp:include>
<script type="text/javascript">
	var baseUrl = $("#baseUrl").val();
    $("#saveBtn").click(function(){
    	if(check()){
    		$("#saveCompany").submit();
    	}
    });
    function check(){
    	var companyName = $("#companyName").val();
    	if($.trim(companyName).length <= 0){
    		alert("请输入企业名称");
    		 $("#companyName").focus();
    		return false;
    	}
    	var companyRegisterMoney = $("#companyRegisterMoney").val();
    	if($.trim(companyRegisterMoney).length <= 0){
    		alert("请输入注册资金");
    		 $("#companyRegisterMoney").focus();
    		return false;
    	}
    	var companyAddress = $("#companyAddress").val();
    	if($.trim(companyAddress).length <= 0){
    		alert("请输入企业地址");
    		 $("#companyAddress").focus();
    		return false;
    	}
    	var companyContactTel = $("#companyContactTel").val();
    	if($.trim(companyContactTel).length <= 0){
    		alert("请输入联系电话");
    		 $("#companyContactTel").focus();
    		return false;
    	}
    	var companyScope = $("#companyScope").val();
    	if($.trim(companyScope).length <= 0){
    		alert("请选择经营范围");
    		return false;
    	}
    	var companyType = $("#companyType").val();
    	if($.trim(companyType).length <= 0){
    		alert("请选择企业性质");
    		return false;
    	}
    	var companyContactUser = $("#companyContactUser").val();
    	if($.trim(companyContactUser).length <= 0){
    		alert("请输入联系人");
    		 $("#companyContactUser").focus();
    		return false;
    	}
    	var companyRegisterTimeStr = $("#companyRegisterTimeStr").val();
    	if($.trim(companyRegisterTimeStr).length <= 0){
    		alert("请输入成立时间");
    		 $("#companyRegisterTimeStr").focus();
    		return false;
    	}
    	return true;
    }
    function doSelectPic() {
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
        		var imgHtml = "<img title='点击删除' onclick='delPic(this)' src='"+baseUrl+"/"+data.picPath+"' class='up_pic_img' />";
        		$("#cimgs").append(imgHtml);
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

