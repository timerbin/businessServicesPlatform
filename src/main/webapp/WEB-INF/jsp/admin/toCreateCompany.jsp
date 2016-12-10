<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>企业管理</title>
    <link href="/images/gerenzx.css" rel="stylesheet" type="text/css"/>
    <jsp:include page="../public/baseData.jsp"/>
    <jsp:include page="../public/pager.jsp"/>
</head>

<body>
<jsp:include page="../public/loginheader.jsp" />
<div class="top_tiao"></div>
<div class="gerenzx_main">
    <jsp:include page="../public/loginLeft.jsp"/>
    <div class="gerenzx_right">
        <div class="grzx_h2"><h2>创建企业</h2></div>
        <form id="createComForm" name="createComForm" action="" method="post">

            <input id="status" name="status" type="hidden"/>
            <input id="baseUrl" value="${BASE_URL}" type="hidden"/>
            <input id="page" name="page" type="hidden" value="${basePage.page}"/>
            <input id="curPage" name="curPage" value="${basePage.page}" type="hidden"/>
            <input id="pageCount" name="pageCount" value="${basePage.count}" type="hidden"/>

            <input id="picUrl" name="picUrl" value="${vo.picUrl}"  type="hidden"  />

            <table width="900" border="0" cellspacing="20" cellpadding="0">
                <c:if test="${not empty errorMsg}">
                    <tr>
                        <td width="121" align="right"><span style="color:red;">${errorMsg}</span></td>
                        <td colspan="2">&nbsp;</td>
                    </tr>
                </c:if>




                <tr>
                    <td width="121" align="right"><span class="hong_xing">*</span></td>
                    <td width="550">---------------用户信息---------------------</td>
                    <td width="149">&nbsp;</td>
                </tr>


                <tr>
                    <td width="121" align="right"><span class="hong_xing">*</span>登录账号：</td>
                    <td width="550"><input id="userName" name="userName" value="" maxlength="20" type="text" class="form_input" /></td>
                    <td width="149">&nbsp;</td>
                </tr>

                <tr>
                    <td width="121" align="right"><span class="hong_xing">*</span>登录密码：</td>
                    <td width="550"><input id="userPassword" name="userPassword" value="" maxlength="20" type="password" class="form_input" /></td>
                    <td width="149">&nbsp;</td>
                </tr>

                <tr>
                    <td width="121" align="right"><span class="hong_xing">*</span>确认密码：</td>
                    <td width="550"><input id="userPassword2" name="userPassword2" value="" maxlength="20" type="password" class="form_input" /></td>
                    <td width="149">&nbsp;</td>
                </tr>

                <tr>
                    <td width="121" align="right"><span class="hong_xing">*</span>姓名：</td>
                    <td width="550"><input id="trueName" name="trueName" value="" maxlength="20" type="text" class="form_input" /></td>
                    <td width="149">&nbsp;</td>
                </tr>

                <tr>
                    <td width="121" align="right"><span class="hong_xing">*</span>性别：</td>
                    <td width="550">
                        <input id="userSex1" name="userSex" type="radio" value="0"   />
                        男 &nbsp;&nbsp;&nbsp;&nbsp;
                        <input id="userSex2" name="userSex" type="radio" value="1"  />
                        女

                    </td>
                    <td width="149">&nbsp;</td>
                </tr>

                <tr>
                    <td width="121" align="right"><span class="hong_xing">*</span>手机号：</td>
                    <td width="550"><input id="mobilePhoneNumber" name="mobilePhoneNumber" value="" maxlength="20" type="text" class="form_input" /></td>
                    <td width="149">&nbsp;</td>
                </tr>

                <tr>
                    <td width="121" align="right"><span class="hong_xing">*</span>常用邮箱：</td>
                    <td width="550"><input id="email" name="email" value="" maxlength="20" type="text" class="form_input" /></td>
                    <td width="149">&nbsp;</td>
                </tr>




                <tr>
                    <td width="121" align="right"><span class="hong_xing">*</span></td>
                    <td width="550">-----------------------------------------------</td>
                    <td width="149">&nbsp;</td>
                </tr>

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
                    <td><input id="companyRegisterTimeStr" placeholder="yyyy-MM-dd" name="companyRegisterTimeStr" value="${vo.companyRegisterTimeStr}"  type="text" class="form_input2" /></td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td align="right"><span class="hong_xing">*</span>企业性质：</td>
                    <td><select id="companyType" name="companyType"  class="form_input">
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
                    <td valign="bottom"  >
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
                    <td colspan="2"><textarea id="companyDirections" name="companyDirections"  cols="60" rows="5" class="form_textarea">${vo.companyDirections}</textarea></td>
                </tr>
                <tr>
                    <td align="right">&nbsp;</td>
                    <td>
                        <c:if test="${empty vo}">
                            <input  id="subBtn" name="subBtn" type="button"  value="提 交"  class="form_button bjse_lan"/>
                        </c:if>
                        <c:if test="${not empty vo}">
                            <input id="saveBtn" name="saveBtn" type="button"  value="保 存" class="form_button bjse_hong"/>
                        </c:if>

                        &nbsp;&nbsp;&nbsp;
                        <input name="returnBtn" id="returnBtn" type="button"  value="返 回" class="form_button bjse_hong" onclick="retturnComManage()">
                    </td>
                    <td>&nbsp;</td>
                </tr>
            </table>
        </form>
    </div>
    <%--<jsp:include page="../public/footer.jsp" ></jsp:include>--%>
</div>

</body>
</html>

<script type="application/javascript">

    var baseUrl = $("#baseUrl").val();
    $("#subBtn").click(function(){
        if(check()){
            $("#createComForm").attr("action","${BASE_URL}/user/createCompany.html");
            $("#createComForm").submit();
        }
    });


    $("#saveBtn").click(function(){
        if(check()){
            $("#createComForm").attr("action","${BASE_URL}/user/createCompany.html");
            $("#createComForm").submit();
        }
    });


    function retturnComManage(){
        window.location.href="${BASE_URL}/user/toAllCompany.html";
    }


    var picUrls = $("#picListStr").val();
    if($.trim(picUrls).length > 0){
        $("#cimgs").html("");
        if(picUrls.indexOf("|") > 0){
            var picUrl = picUrls.split('|');
            for(var i=0;i<picUrl.length;i++){
                var imgHtml = "<img title='点击删除' onclick='delPic(this)' srcpath='"+picUrl[i]+"' src='"+baseUrl+"/"+picUrl[i]+"' class='up_pic_img' />";
                $("#cimgs").append(imgHtml);
            }
        }else{
            var imgHtml = "<img title='点击删除' onclick='delPic(this)' srcpath='"+picUrls+"' src='"+baseUrl+"/"+picUrls+"' class='up_pic_img' />";
            $("#cimgs").append(imgHtml);
        }
    }
//    $("#saveBtn").click(function(){
//        if(check()){
//            $("#saveCompany").submit();
//        }
//    });
//    $("#subBtn").click(function(){
//        if(check()){
//            $("#saveCompany").submit();
//        }
//    });
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
        if(0 >= $.trim(companyType).length){
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
                var imgHtml = "<img title='点击删除' onclick='delPic(this)' srcpath='"+data.picPath+"' src='"+baseUrl+"/"+data.picPath+"' class='up_pic_img' />";
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



    /*-----------------------用户信息*/
    var userSexStr = $("#userSexStr").val();
    if(0 >= $.trim(userSexStr).length){
        $("#userSex1").attr("checked","checked");
        $("#userSex2").removeAttr("checked");
    }else{
        if(userSexStr == 0){
            $("#userSex1").removeAttr("checked");
            $("#userSex2").attr("checked","checked");
        }else{
            $("#userSex1").attr("checked","checked");
            $("#userSex2").removeAttr("checked");
        }
    }

    function check(){
        var userName = $("#userName").val();
        if(0 >= $.trim(userName).length){
            alert("请输入登录名");
            $("#userName").focus();
            return false;
        }
        var clearSymbol = /[^\a-\z\A-\Z0-9\u4E00-\u9FA5]/;
        if(clearSymbol.test(userName)){
            alert("请输入正确的登录名(只能包含字母和数字)");
            $("#userName").focus();
            return false;
        }
        if(6 > $.trim(userName).length){
            alert("登录名必须大于6位");
            $("#userName").focus();
            return false;
        }
        var userPassword = $("#userPassword").val();
        if(0 >= $.trim(userPassword).length){
            alert("请输入登录密码");
            $("#userPassword").focus();
            return false;
        }
        if(6 > $.trim(userPassword).length){
            alert("登录密码必须大于6位");
            $("#userPassword").focus();
            return false;
        }
        var userPassword2 = $("#userPassword2").val();
        if(0 >= $.trim(userPassword2).length){
            alert("请输入确认密码");
            $("#userPassword2").focus();
            return false;
        }
        if(userPassword != userPassword2){
            alert("登录密码与确认密码不相同");
            $("#userPassword2").focus();
            return false;
        }
        var trueName = $("#trueName").val();
        if(0 >= $.trim(trueName).length){
            alert("请输入姓名");
            $("#trueName").focus();
            return false;
        }
        var mobilePhoneNumber = $("#mobilePhoneNumber").val();
        if(0 >= $.trim(mobilePhoneNumber).length){
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
        if(0 >= $.trim(email).length){
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
