<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>服务管理</title>
<link href="${BASE_URL}/images/gerenzx.css" rel="stylesheet" type="text/css" />
    <jsp:include page="../public/baseData.jsp" />
    <jsp:include page="../public/pager.jsp" />
</head>

<body>

<jsp:include page="../public/loginheader.jsp" />
<div class="top_tiao"></div>
<div class="gerenzx_main">

        <jsp:include page="../public/loginLeft.jsp" />
    <div class="gerenzx_right">
    	<div class="grzx_h2"><h2>创建服务</h2></div>
        <form action="${BASE_URL}/user/doAdminAddService.html" id="fbfwForm" name="fbfwForm">

            <input id="picUrl" name="picUrl" value="${vo.picUrl}"  type="hidden" />
            <input id="userId" name="userId" value="${vo.userId}"  type="hidden" />
            <input id="companyId" name="companyId" value="${vo.companyId}"  type="hidden" />



            <table width="900" border="0" cellspacing="20" cellpadding="0">

                <c:if test="${not empty errorMsg}">
                    <tr>
                        <td colspan="3" align="right"><span style="color:red;">${errorMsg}</span></td>
                    </tr>
                </c:if>


                <tr>
                    <td width="121" align="right"><span class="hong_xing">*</span>公司名称：</td>
                    <td width="550">
                        <select name="companySel" id="companySel" class="grzx_input2">
                            <option value="">请选择</option>
                            <c:forEach var="comany" items="${comanyList}">
                                <c:if test="${comany.id==vo.companyId}">
                                    <option value="${comany.id}" data-id="${comany.userId}" selected="selected">${comany.companyName}</option>
                                </c:if>
                                <c:if test="${comany.id!=vo.companyId}">
                                    <option value="${comany.id}" data-id="${comany.userId}" >${comany.companyName}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </td>
                    <td width="149">&nbsp;</td>
                </tr>

                <tr>
                    <td width="121" align="right"><span class="hong_xing">*</span>服务名称：</td>
                    <td width="550">
                        <input id="serviceName" name="serviceName" type="text" class="grzx_input2" value="${vo.serviceName}"/>
                    </td>
                    <td width="149">&nbsp;</td>
                </tr>
                <tr>
                    <td align="right"><span class="hong_xing">*</span>服务类别：</td>
                    <td>
                        <select name="serviceType" id="serviceTypeEdit" class="grzx_input2">
                            <c:forEach var="serType" items="${serTypeList}">
                                <c:if test="${serType.id==vo.serviceType}">
                                    <option value="${serType.id}" selected="selected">${serType.showName}</option>
                                </c:if>
                                <c:if test="${serType.id!=vo.serviceType}">
                                    <option value="${serType.id}">${serType.showName}</option>
                                </c:if>
                            </c:forEach>
                        </select>

                    </td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td align="right"><span class="hong_xing">*</span>联系人：</td>
                    <td><input name="serviceContactUser" id="serviceContactUser" type="text" class="grzx_input2" value="${vo.serviceContactUser}"/></td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td align="right"><span class="hong_xing">*</span>联系方式：</td>
                    <td><input name="serviceContactTel" id="serviceContactTel" type="text" class="grzx_input2" value="${vo.serviceContactTel}" /></td>
                    <td>&nbsp;</td>
                </tr>

                <tr>
                    <td align="right" valign="top"><span class="hong_xing">*</span>服务图片：</td>
                    <td class="qiye_img" >
                        <span id="cimgs" title="点击删除"></span>
                    </td>
                    <td valign="bottom"  >
                        <input  onclick="doSelectPic()"  type="button" value="上传图片" class="upload_button" />
                        <iframe id="uploadPicFrame" src="" style="display:none;"></iframe>
                    </td>
                </tr>

                <tr>
                    <td align="right" valign="top"><span class="hong_xing">*</span>服务介绍：</td>
                    <td colspan="2"><textarea name="serviceDirections" id="serviceDirections" cols="50" rows="5" class="text_area" >${vo.serviceDirections}</textarea></td>
                </tr>
                <tr>
                    <td align="right">&nbsp;</td>
                    <td><input name="tijiaoBtn" id="tijiaoBtn" type="button"  value="  保   存  " class="grzx_button"/>
                        <input name="chongzhiBtn" id="chongzhiBtn" type="reset"  value=" 取   消  " class="grzx_button" onclick="cancelEditSer()"/>
                    </td>
                    <td>&nbsp;</td>
                </tr>
            </table>

        </form>
  </div>
</div>
<script type="application/javascript">
    function cancelEditSer(){
        window.location.href="${BASE_URL}/user/toServiceManage.html";
    }

    var baseUrl = $("#baseUrl").val();


    var picUrl = $("#picUrl").val();
    if($.trim(picUrl).length > 0){
        $("#cimgs").html("");
        var imgHtml = "<img title='点击删除' onclick='delPic(this)' srcpath='"+picUrl+"' src='"+picUrl+"' class='up_pic_img' />";
        $("#cimgs").append(imgHtml);
    }


    $('#companySel').change(function(){
        $("#companyId").val($(this).children('option:selected').val());
        $("#userId").val($(this).children('option:selected').attr("data-id"));
    });

    $("#tijiaoBtn").click(function(){
        if(check()){
            $("#fbfwForm").submit();
        }
    });
    function check(){
        var companyId = $("#companyId").val();
        if($.trim(companyId).length <= 0){
            alert("请选择公司信息");
            $("#companySel").focus();
            return false;
        }
        var userId = $("#userId").val();
        if($.trim(userId).length <= 0){
            alert("请选择公司信息");
            $("#companySel").focus();
            return false;
        }
        var serviceName = $("#serviceName").val();
        if($.trim(serviceName).length <= 0){
            alert("请输入服务名称");
            $("#serviceName").focus();
            return false;
        }
        var serviceType = $("#serviceType").val();
        if($.trim(serviceName).length <= 0){
            alert("请选择服务类型");
            $("#serviceType").focus();
            return false;
        }
        var serviceContactUser = $("#serviceContactUser").val();
        if($.trim(serviceContactUser).length <= 0){
            alert("请输入服务联系人");
            $("#serviceContactUser").focus();
            return false;
        }
        var serviceContactTel = $("#serviceContactTel").val();
        if($.trim(serviceContactTel).length <= 0){
            alert("请输入服务联系方式");
            $("#serviceContactTel").focus();
            return false;
        }
        if(!checkMob(serviceContactTel)){
            alert("请输入正确服务联系方式");
            $("#serviceContactTel").focus();
            return false;
        }
        var serviceDirections = $("#serviceDirections").val();
        if($.trim(serviceDirections).length <= 0){
            alert("请输入服务介绍");
            $("#serviceDirections").focus();
            return false;
        }
        var picUrl = "";
        $('.up_pic_img').each(function(){
            picUrl = $(this).attr("srcpath");
        });
        if($.trim(picUrl).length <= 0){
            alert("请上传服务图片");
            return false;
        }
        $("#picUrl").val(picUrl);
        return true;
    }
    var isMob = /^((13[0-9])|(14[0-9])|(15[0-9])|(18[0-9])|(17[0-9]))\d{8}$/;
    function checkMob(mobile) {
        var isPhone = /^([0-9]{3,4}-)?[0-9]{7,8}$/;
        if (isMob.test(mobile) || isPhone.test(mobile)) {
            return true;
        } else {
            return false;
        }
    }

    function doSelectPic() {
        var imgSize = 0;
        $('.up_pic_img').each(function(){
            imgSize = imgSize+1;
        });
        if(imgSize <= 0 ){
            $("#pic", $("#uploadPicFrame")[0].contentWindow.document).click();
        }else{
            alert("服务仅能上传一张图片");
        }
        return false;
    }

    initUploadPicFrame();
    function initUploadPicFrame(){
        var frameSrc = baseUrl+"/user/getUploadPicForm.html";
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
                var imgHtml = "<img title='点击删除' onclick='delPic(this)' srcpath='"+data.picPath+"' src='"+data.picPath+"' class='up_pic_img' />";
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
</body>
</html>


