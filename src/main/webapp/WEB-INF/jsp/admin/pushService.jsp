<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>发布服务</title>
<link href="/images/hongqiao.css" rel="stylesheet" type="text/css" />
    <jsp:include page="../public/baseData.jsp" />
</head>

<body>
<table width="100%" height="100%" border="0px" cellpadding="0px" cellspacing="0px" >
	<tr><td width="250px"  class="con_left" valign="top" height="100%">
        <div>
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
        </div>
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
        <div class="location">发布服务</div>
        <div class="form_box">

            <form action="" id="fbfwForm" name="fbfwForm">
            <table width="900" border="0" cellspacing="20" cellpadding="0">
              <tr>
                <td width="121" align="right"><span class="hong_xing">*</span>服务名称：</td>
                <td width="550">
                    <input id="fwName" name="fwName" type="text" class="form_input" />
                </td>
                <td width="149">&nbsp;</td>
              </tr>
              <tr>
                <td align="right"><span class="hong_xing">*</span>服务类别：</td>
                <td>
                    <select name="fwType" id="fwType" class="form_input">
                        <%--<c:if test="${not empty serTypeList}">--%>
                           <c:forEach var="serType" items="${serTypeList}">
                               <option value="${serType.id}">
                                   ${serType.showName}
                               </option>
                           </c:forEach>
                        <%--</c:if>--%>
                    </select>

                </td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td align="right"><span class="hong_xing">*</span>联系人：</td>
                <td><input name="fwLxr" id="fwLxr" type="text" class="form_input2" /></td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td align="right"><span class="hong_xing">*</span>联系方式：</td>
                <td><input name="fwLxfs" id="fwLxfs" type="text" class="form_input2" /></td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td align="right" valign="top"><span class="hong_xing">*</span>服务介绍：</td>
                <td colspan="2"><textarea name="fwJs" id="fwJs" cols="" rows="" class="form_textarea"></textarea></td>
              </tr>
              <tr>
                <td align="right">&nbsp;</td>
                <td><input name="baocunBtn" id="baocunBtn" type="button"  value="保 存" class="form_button bjse_hong" onclick="addSer()">
                    <input name="tijiaoBtn" id="tijiaoBtn" type="button"  value="提 交" class="form_button bjse_lan">
                    <input name="chongzhiBtn" id="chongzhiBtn" type="reset"  value="重 置" class="form_button bjse_cheng">
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

    function addSer(){
        $.ajax({
            url:'${BASE_URL}/shopp/userCompanyService/toFabuService.html',
            type:'POST', //GET
            async:false,    //或false,是否异步
            data:{
                serviceName:$("#fwName").val(), //服务名称
                serviceType:$("#fwType").val(), //服务类别
                serviceContactUser:$("#fwLxr").val(), //服务联系人
                serviceContactTel:$("#fwLxfs").val(),    //联系方式
                serviceDirections:$("#fwJs").val()   //服务介绍

            },
            timeout:20000,    //超时时间
            dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
            beforeSend:function(xhr){
                console.log(xhr)
                console.log('发送前')
            },
            success:function(data,textStatus,jqXHR){
                console.log(data)
                console.log(textStatus)
                console.log(jqXHR)
                alert(data.msg);
                $("#fbfwForm")[0].reset();
            },
            error:function(xhr,textStatus){
                console.log('错误')
                console.log(xhr)
                console.log(textStatus)
            },
            complete:function(){

                console.log('结束')
            }
        })
    }


</script>