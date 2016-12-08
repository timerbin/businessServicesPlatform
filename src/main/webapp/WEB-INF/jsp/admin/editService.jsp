<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>编辑服务</title>
<link href="/images/hongqiao.css" rel="stylesheet" type="text/css" />
    <jsp:include page="../public/baseData.jsp" />
</head>

<body>
<table width="100%" height="100%" border="0px" cellpadding="0px" cellspacing="0px" >
	<tr><td width="250px"  class="con_left" valign="top" height="100%">
       <%-- <div>
            <div class="left_logo"><img src="images/home_logo.png" width="152" height="100" /></div>
            <ul>
                <li><span class="left_biao"><img src="images/nav_01.png" /></span>首页</li>
                <li class="left_border"><span class="left_biao"><img src="/images/nav_02.png" /></span>行政办公</li>
                <li><span class="left_biao"><img src="/images/nav_03.png" /></span>商旅出行</li>
                <li><span class="left_biao"><img src="/images/nav_04.png" /></span>注册服务</li>
                <li><span class="left_biao"><img src="/images/nav_05.png" /></span>知识产权</li>
                <li><span class="left_biao"><img src="/images/nav_06.png" /></span>招聘培训</li>
                <li><span class="left_biao"><img src="/images/nav_07.png" /></span>企业展示</li>
                <li><span class="left_biao"><img src="/images/nav_08.png" /></span>企业推广</li>
                <li><span class="left_biao"><img src="/images/nav_09.png" /></span>金融服务</li>
                <li><span class="left_biao"><img src="/images/nav_10.png" /></span>法律服务</li>
                <li><span class="left_biao"><img src="/images/nav_11.png" /></span>软件服务</li>
            </ul>
        </div>--%>
           <jsp:include page="../public/loginLeft.jsp" />
	</td>
    <td  valign="top">
        <div class="right_header">
            <span class="header_left">您好，欢迎光临泰兴虹桥园区商业服务整合平台</span>
            <ul class="header_yh">
                <li class="header_xiala"><a href="#"></a></li>
                <li class="header_name">张小二</li>
                <li class="header_touxiang"><img src="/images/touxiang_03.jpg" width="38" height="38" /></li>
            </ul>
            <ul class="head_grzcdl">
                <li class="head_gr"><a href="#">个人中心</a></li>
                <li class="head_zc"><a href="#">注册</a></li>
                <li class="head_dl"><a href="#">登录</a></li>
            </ul>
        </div>
        <div class="location">编辑服务</div>
        <div class="form_box">

            <form action="" id="bjfwForm" name="bjfwForm">

                <input type="hidden" name="id_edit" id="id_edit" value="${serVo.id}"/>
            <table width="900" border="0" cellspacing="20" cellpadding="0">
              <tr>
                <td width="121" align="right"><span class="hong_xing">*</span>服务名称：</td>
                <td width="550">
                    <input id="serviceNameEdit" name="serviceNameEdit" type="text" class="form_input" value="${serVo.serviceName}"/>
                </td>
                <td width="149">&nbsp;</td>
              </tr>
              <tr>
                <td align="right"><span class="hong_xing">*</span>服务类别：</td>
                <td>
                    <select name="serviceTypeEdit" id="serviceTypeEdit" class="form_input">
                        <%--<c:if test="${not empty serTypeList}">--%>
                           <c:forEach var="serType" items="${typeLst}">

                               <c:if test="${serVo.serviceType == serType.id}">

                                   <option value="${serType.id}" selected="selected">
                                           ${serType.showName}
                                   </option>
                               </c:if>

                               <c:if test="${serVo.serviceType != serType.id}">

                                   <option value="${serType.id}">
                                           ${serType.showName}
                                   </option>
                               </c:if>



                           </c:forEach>
                        <%--</c:if>--%>
                    </select>

                </td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td align="right"><span class="hong_xing">*</span>联系人：</td>
                <td><input name="fwLxrEdit" id="fwLxrEdit" type="text" class="form_input2" value="${serVo.serviceContactUser}"/></td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td align="right"><span class="hong_xing">*</span>联系方式：</td>
                <td><input name="fwLxfsEdit" id="fwLxfsEdit" type="text" class="form_input2" value="${serVo.serviceContactTel}" /></td>
                <td>&nbsp;</td>
              </tr>

                <tr>
                    <td align="right" valign="top"><span class="hong_xing">*</span>服务图片：</td>
                    <td class="qiye_img" >
                        <span id="cimgs" title="点击删除"></span>
                    </td>
                    <td valign="bottom"  >
                        <input  onclick="doSelectPic()"  type="button" value="上传图片" class="form_shangchuan" />
                        <iframe id="uploadPicFrame" src="${serVo.picUrl}" style="display:none;"></iframe>
                    </td>
                </tr>

              <tr>
                <td align="right" valign="top"><span class="hong_xing">*</span>服务介绍：</td>
                <td colspan="2"><textarea name="fwJsEdit" id="fwJsEdit" cols="" rows="" class="form_textarea" value="${serVo.serviceDirections}"></textarea></td>
              </tr>
              <tr>
                <td align="right">&nbsp;</td>
                <td><input name="baocunBtn" id="baocunBtn" type="button"  value="保 存" class="form_button bjse_hong" onclick="updateSer()">
                    <%--<input name="tijiaoBtn" id="tijiaoBtn" type="button"  value="提 交" class="form_button bjse_lan">--%>
                    <input name="chongzhiBtn" id="chongzhiBtn" type="reset"  value="取 消" class="form_button bjse_cheng" onclick="cancelSer()">
                </td>
                <td>&nbsp;</td>
              </tr>
            </table>
                </form>
        </div>
    </td></tr>

</table>
<jsp:include page="../public/footer.jsp" ></jsp:include>
</body>
</html>

<script type="application/javascript">
    /*$("baocunBtn").click(function(){
        $.post("demo_test_post.asp",
                {
                    serviceName:$("fwName").val(),
                    city:"Duckburg"
                },
                function(data,status){
                    alert("Data: " + data + "\nStatus: " + status);
                });
    });*/


    function cancelSer(){
        window.location.href="${BASE_URL}/user/toServiceManage.html";
    }

    $("#tijiaoBtn").click(function(){
        if(check()){
            $("#bjfwForm").submit();
        }
    });


    function check(){
        var serviceName = $("#serviceNameEdit").val();
        if($.trim(serviceName).length <= 0){
            alert("请输入服务名称");
            $("#serviceNameEdit").focus();
            return false;
        }
        var serviceType = $("#serviceTypeEdit").val();
        if($.trim(serviceName).length <= 0){
            alert("请选择服务类型");
            $("#serviceTypeEdit").focus();
            return false;
        }
        var serviceContactUser = $("#fwLxrEdit").val();
        if($.trim(serviceContactUser).length <= 0){
            alert("请输入服务联系人");
            $("#fwLxrEdit").focus();
            return false;
        }
        var serviceContactTel = $("#fwLxfsEdit").val();
        if($.trim(serviceContactTel).length <= 0){
            alert("请输入服务联系方式");
            $("#fwLxfsEdit").focus();
            return false;
        }
        if(!checkMob(serviceContactTel)){
            alert("请输入正确服务联系方式");
            $("#fwLxfsEdit").focus();
            return false;
        }
        var serviceDirections = $("#fwJsEdit").val();
        if($.trim(serviceDirections).length <= 0){
            alert("请输入服务介绍");
            $("#fwJsEdit").focus();
            return false;
        }
       /* var picUrl = "";
        $('.up_pic_img').each(function(){
            picUrl = $(this).attr("srcpath");
        });
        if($.trim(picUrl).length <= 0){
            alert("请上传服务图片");
            return false;
        }
        $("#picUrl").val(picUrl);*/
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
</script>