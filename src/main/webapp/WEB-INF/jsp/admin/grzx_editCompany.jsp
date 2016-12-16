<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>企业管理</title>
    <link href="${BASE_URL}/images/gerenzx.css" rel="stylesheet" type="text/css"/>
    <jsp:include page="../public/baseData.jsp"/>
    <jsp:include page="../public/pager.jsp"/>
    
    <script type="text/javascript" src="${BASE_URL}/js/jquery.datetimepicker.full.min.js" ></script>
	<link href="${BASE_URL}/images/jquery.datetimepicker.css" rel="stylesheet" type="text/css" />
</head>

<body>
<jsp:include page="../public/loginheader.jsp" />
<div class="top_tiao"></div>
<div class="gerenzx_main">
    <jsp:include page="../public/loginLeft.jsp"/>
    <div class="gerenzx_right">
        <div class="grzx_h2"><h2>编辑企业</h2></div>
        <form id="comEditForm" name="comEditForm" action="" method="post">

            <input id="status" name="status" type="hidden"/>
            <input id="page" name="page" type="hidden" value="${basePage.page}"/>
            <input id="curPage" name="curPage" value="${basePage.page}" type="hidden"/>
            <input id="pageCount" name="pageCount" value="${basePage.count}" type="hidden"/>
            <input id="id" name="id" type="hidden" value="${vo.id}"/>
            <input id="picListStr" name="picListStr" type="hidden" value="${vo.picListStr}"/>
			<input id="userId" name="userId" type="hidden" value="${vo.userId}"/>


            <table width="900" border="0" cellspacing="20" cellpadding="0">
                <c:if test="${not empty msg}">
                    <tr>
                        <td width="121" align="right"><span style="color:red;">${msg}</span></td>
                        <td colspan="6">&nbsp;</td>
                    </tr>
                </c:if>
                <c:if test="${not empty errorMsg}">
                    <tr>
                        <td width="121" align="right"><span style="color:red;">${errorMsg}</span></td>
                        <td colspan="2">&nbsp;</td>
                    </tr>
                </c:if>
                <tr>
                    <td width="121" align="right"><span class="hong_xing">*</span>企业名称：</td>
                    <td width="550"><input id="companyName" name="companyName" value="${vo.companyName}" type="text" class="grzx_input2" /></td>
                    <td width="149">&nbsp;</td>
                </tr>
                <tr>
                    <td align="right"><span class="hong_xing">*</span>注册资金：</td>
                    <td><input  id="companyRegisterMoney" name="companyRegisterMoney" value="${vo.companyRegisterMoney}"   type="text" class="grzx_input2" /></td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td align="right"><span class="hong_xing">*</span>企业地址：</td>
                    <td><input id="companyAddress" name="companyAddress" value="${vo.companyAddress}"  type="text" class="grzx_input2" /></td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td align="right"><span class="hong_xing">*</span>联系电话：</td>
                    <td><input id="companyContactTel" name="companyContactTel" value="${vo.companyContactTel}"  type="text" class="grzx_input2" /></td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td align="right"><span class="hong_xing">*</span>联系人：</td>
                    <td><input id="companyContactUser" name="companyContactUser" value="${vo.companyContactUser}" type="text" class="grzx_input2" /></td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td align="right"><span class="hong_xing">*</span>经营范围：</td>
                    <td><select id="companyScope" name="companyScope" class="grzx_input2">
                        <option value="">请选择</option>
                        <c:forEach items="${managementList}" var="management">
                            <c:if test="${management.id==vo.companyScope}">
                                <option value="${management.id}" selected="selected">${management.showName}</option>
                            </c:if>
                            <c:if test="${management.id!=vo.companyScope}">
                                <option value="${management.id}">${management.showName}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                    </td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td align="right"><span class="hong_xing">*</span>成立时间：</td>
                    <td><input id="companyRegisterTimeStr"  name="companyRegisterTimeStr" placeholder="年-月-日" name="companyRegisterTimeStr" value="${vo.companyRegisterTimeStr}"   type="text" class="grzx_input2" /></td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td align="right"><span class="hong_xing">*</span>企业性质：</td>
                    <td><select id="companyType" name="companyType"  class="grzx_input2">
                        <option value="">请选择</option>
                        <c:forEach items="${propertyList}" var="property">
                            <c:if test="${property.id==vo.companyType}">
                                <option value="${property.id}" selected="selected">${property.showName}</option>
                            </c:if>
                            <c:if test="${property.id!=vo.companyType}">
                                <option value="${property.id}">${property.showName}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                    </td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td align="right" valign="top"><span class="hong_xing">*</span>企业图片：</td>
                    <td class="qiye_img" ><span id="cimgs" title="点击删除"></span>
                    </td>
                    <td valign="bottom" height="100">
                        <input  onclick="doSelectPic()"  type="button" value="上传图片" class="upload_button"/>
                        <iframe id="uploadPicFrame" src="" style="display:none;"></iframe>
                    </td>
                </tr>
                <tr>
                    <td align="right"><span class="hong_xing">*</span>企业官网链接：</td>
                    <td><input  id="companyUrl" name="companyUrl" value="${vo.companyUrl}"   type="text" class="grzx_input2" /></td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td align="right" valign="top"><span class="hong_xing">*</span>企业简介：</td>
                    <td colspan="2"><textarea id="companyDirections" name="companyDirections"  cols="" rows="" class="text_area">${vo.companyDirections}</textarea></td>
                </tr>
                <tr>
                    <td align="right">&nbsp;</td>
                    <td>
                        <c:if test="${empty vo}">
                            <input  id="subBtn" name="subBtn" type="button"  value=" 提  交  "  class="grzx_button"/>
                        </c:if>
                        <c:if test="${not empty vo}">
                            <input id="saveBtn" name="saveBtn" type="button"  value=" 保   存  " class="grzx_button"/>
                        </c:if>
                        &nbsp;&nbsp;&nbsp;

                        <input id="returnBtn" name="returnBtn" type="button"  value=" 返   回  " class="grzx_button"/>

                    </td>
                    <td>&nbsp;</td>
                </tr>
            </table>
        </form>
    </div>
</div>

<script type="text/javascript">
    var baseUrl = $("#baseUrl").val();

    $('#companyRegisterTimeStr').datetimepicker({
    	lang:'ch',
    	timepicker:false,
    	format:'Y-m-d',
    	formatDate:'Y-m-d'
	});
    
    var picUrls = $("#picListStr").val();
    if($.trim(picUrls).length > 0){
        $("#cimgs").html("");
        if(picUrls.indexOf("|") > 0){
            var picUrl = picUrls.split('|');
            for(var i=0;i<picUrl.length;i++){
                var imgHtml = "<img title='点击删除' onclick='delPic(this)' style='width:120px;height:120px;' srcpath='"+picUrl[i]+"' src='"+picUrl[i]+"' class='up_pic_img' />";
                $("#cimgs").append(imgHtml);
            }
        }else{
            var imgHtml = "<img title='点击删除' onclick='delPic(this)' style='width:120px;height:120px;' srcpath='"+picUrls+"' src='"+picUrls+"' class='up_pic_img' />";
            $("#cimgs").append(imgHtml);
        }
    }
    $("#saveBtn").click(function(){
        if(check()){
            $("#comEditForm").attr("action",baseUrl+"/user/updateCompany.html").submit();
        }
    });
    $("#subBtn").click(function(){
        if(check()){
            $("#comEditForm").attr("action",baseUrl+"/user/updateCompany.html").submit();
        }
    });


    $("#returnBtn").click(function(){
        $("#comEditForm").attr("action",baseUrl+"/user/toAllCompany.html").submit();

    });

    function check(){
        var companyName = $("#companyName").val();
        if(0 >= $.trim(companyName).length){
            alert("请输入企业名称");
            $("#companyName").focus();
            return false;
        }
        var companyRegisterMoney = $("#companyRegisterMoney").val();
        if(0 >= $.trim(companyRegisterMoney).length){
            alert("请输入注册资金");
            $("#companyRegisterMoney").focus();
            return false;
        }
        var companyAddress = $("#companyAddress").val();
        if(0 >= $.trim(companyAddress).length){
            alert("请输入企业地址");
            $("#companyAddress").focus();
            return false;
        }
        var companyContactTel = $("#companyContactTel").val();
        if(0 >= $.trim(companyContactTel).length){
            alert("请输入联系电话");
            $("#companyContactTel").focus();
            return false;
        }
        if(!checkMob(companyContactTel)){
            alert("请输入正确联系电话");
            $("#companyContactTel").focus();
            return false;
        }
        var companyScope = $("#companyScope").val();
        if(0 >= $.trim(companyScope).length){
            alert("请选择经营范围");
            return false;
        }

        var companyType = $("#companyType").val();
        if( $.trim(companyType).length <= 0){
            alert("请选择企业性质");
            return false;
        }
        var companyContactUser = $("#companyContactUser").val();
        if(0 >= $.trim(companyContactUser).length){
            alert("请输入联系人");
            $("#companyContactUser").focus();
            return false;
        }
        var companyUrl = $("#companyUrl").val();
        if(0 >= $.trim(companyUrl).length){
            alert("请输入企业官网链接");
            $("#companyUrl").focus();
            return false;
        }

        var isUrl =  /^((https|http)?:\/\/)*$/;
        if (isUrl.test(companyUrl)){
            alert("请输入正确企业官网链接");
            $("#companyUrl").focus();
            return false;
        }

        var companyRegisterTimeStr = $("#companyRegisterTimeStr").val();
        if(0 >= $.trim(companyRegisterTimeStr).length){
            alert("请输入成立时间");
            $("#companyRegisterTimeStr").focus();
            return false;
        }
        var isDate =  /^(\d{4})-(\d{2})-(\d{2})$/;
        if (!isDate.test(companyRegisterTimeStr)){
            alert("请输入正确成立时间");
            $("#companyRegisterTimeStr").focus();
            return false;
        }

        var picListStr = "";
        $('.up_pic_img').each(function(){
            if(picListStr.length > 0){
                picListStr = picListStr + "|";
            }
            picListStr = picListStr+$(this).attr("srcpath");
        });
        if(0 >= $.trim(picListStr).length){
            alert("请上传企业图片");
            return false;
        }
        $("#picListStr").val(picListStr);
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
        $("#pic", $("#uploadPicFrame")[0].contentWindow.document).click();
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
                var imgHtml = "<img title='点击删除' onclick='delPic(this)' style='width:120px;height:120px;' srcpath='"+data.picPath+"' src='"+data.picPath+"' class='up_pic_img' />";
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


