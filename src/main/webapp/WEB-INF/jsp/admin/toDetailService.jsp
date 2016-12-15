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
    	<div class="grzx_h2"><h2>服务详情</h2></div>
        <form action="" id="serManageForm" name="serManageForm">
			 <input type="hidden" name="id_edit" id="id_edit" value="${serVo.id}"/>
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
                    <td width="121" align="right"><span class="hong_xing">*</span>服务名称：</td>
                    <td width="550">
                        <label>${serVo.serviceName}</label>
                    </td>
                    <td width="149">&nbsp;</td>
                </tr>
                <tr>
                    <td align="right"><span class="hong_xing">*</span>服务类别：</td>
                    <td>

                            <c:forEach var="serType" items="${typeLst}">
                                <c:if test="${serVo.serviceType == serType.id}">
                                    ${serType.showName}
                                </c:if>
                            </c:forEach>


                    </td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td align="right"><span class="hong_xing">*</span>联系人：</td>
                    <td>
                        <label>${serVo.serviceContactUser}</label>
                    </td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td align="right"><span class="hong_xing">*</span>联系方式：</td>
                    <td>
                        <label>${serVo.serviceContactTel}</label>
                    </td>
                    <td>&nbsp;</td>
                </tr>

                <tr>
                    <td align="right" valign="top"><span class="hong_xing">*</span>服务图片：</td>
                    <td class="qiye_img" >
                        <span id="cimgs"  >
                        	<img src="${serVo.picUrl}" style="width:120px;height:120px;" class="up_pic_img" />
                        </span>
                    </td>
                    <td valign="bottom"  >
                    </td>
                </tr>

                <tr>
                    <td align="right" valign="top"><span class="hong_xing">*</span>服务介绍：</td>
                    <td colspan="2"><textarea name="fwJsEdit" id="fwJsEdit" cols="50" rows="5" class="form_textarea" readonly="readonly">${serVo.serviceDirections}</textarea>
                    </td>
                </tr>
                <tr>
                    <td align="right">&nbsp;</td>
                    <td>
                            <input name="returnBtn" id="returnBtn" type="button"  value="返 回" class="form_button bjse_hong" onclick="retturnSerM()"/>
                    </td>
                    <td>&nbsp;</td>
                </tr>
            </table>

        </form>
  </div>
</div>
<script type="application/javascript">
var baseUrl = $("#baseUrl").val();
    function retturnSerM(){
        window.location.href=baseUrl+"/user/toServiceManage.html";
    }
</script>
</body>
</html>


