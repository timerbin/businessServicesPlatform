<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>企业管理</title>
    <link href="${BASE_URL}/images/gerenzx.css" rel="stylesheet" type="text/css"/>
    <jsp:include page="../public/baseData.jsp"/>
    <jsp:include page="../public/pager.jsp"/>
</head>

<body>
<jsp:include page="../public/loginheader.jsp" />
<div class="top_tiao"></div>
<div class="gerenzx_main">
    <jsp:include page="../public/loginLeft.jsp"/>
    <div class="gerenzx_right">
        <div class="grzx_h2"><h2>详细信息</h2></div>
        <form id="comDetailForm" name="comDetailForm" action="" method="post">

            <input id="status" name="status" type="hidden"/>
            <input id="page" name="page" type="hidden" value="${basePage.page}"/>
            <input id="curPage" name="curPage" value="${basePage.page}" type="hidden"/>
            <input id="pageCount" name="pageCount" value="${basePage.count}" type="hidden"/>
            <input id="id" name="id" type="hidden"/>


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
                    <td width="550">
                        <label>${vo.companyName}</label>
                    </td>

                    <td width="149">&nbsp;</td>
                </tr>
                <tr>
                    <td align="right"><span class="hong_xing">*</span>注册资金：</td>
                    <td>
                        <label>${vo.companyRegisterMoney}</label>
                    </td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td align="right"><span class="hong_xing">*</span>企业地址：</td>
                    <td>
                            <label>${vo.companyAddress}</label>
                    </td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td align="right"><span class="hong_xing">*</span>联系电话：</td>
                    <td>
                        <label>${vo.companyContactTel}</label>
                    </td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td align="right"><span class="hong_xing">*</span>联系人：</td>
                    <td>
                        <label>${vo.companyContactUser}</label>
                    </td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td align="right"><span class="hong_xing">*</span>经营范围：</td>
                    <td>
                        <c:forEach items="${managementList}" var="management">
                            <c:if test="${management.id==vo.companyScope}">
                                <label>${management.showName}</label>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td align="right"><span class="hong_xing">*</span>成立时间：</td>
                    <td>
                            <label >${vo.companyRegisterTimeStr}</label>
                    </td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td align="right"><span class="hong_xing">*</span>企业性质：</td>
                    <td>
                        <c:forEach items="${propertyList}" var="property">
                            <c:if test="${property.id==vo.companyType}">
                                <label >${property.showName}</label>
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td align="right" valign="top"><span class="hong_xing">*</span>企业图片：</td>
                    <td class="qiye_img" >
                    	   <c:forEach items="${vo.picList}" var="pic">
                             	<img src="${pic.companyPicUrl}" style="width:120px;height:120px;" class="up_pic_img" />
                           </c:forEach>
                    </td>
                    <td valign="bottom" height="100">
                    </td>
                </tr>
                <tr>
                    <td align="right"><span class="hong_xing">*</span>企业官网链接：</td>
                    <td><label >${vo.companyUrl}</label></td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td align="right" valign="top"><span class="hong_xing">*</span>企业简介：</td>
                    <td colspan="2">
                        <textarea id="companyDirections" name="companyDirections"  cols="" rows="" class="form_textarea" readonly="readonly">${vo.companyDirections}</textarea>
                    </td>
                </tr>
                <tr>
                    <td align="right">&nbsp;</td>
                    <td><input id="retturnBtn" name="retturnBtn" type="button"  value="返 回" class="grzx_button"/></td>
                    <td>&nbsp;</td>
                </tr>
            </table>
        </form>
    </div>
</div>
<script type="text/javascript">
	var baseUrl = $("#baseUrl").val();
    $("#retturnBtn").click(function(){
        $("#comDetailForm").attr("action",baseUrl+"/user/toAllCompany.html").submit();
    });
</script>
</body>
</html>




