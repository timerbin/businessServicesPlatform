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
        <div class="grzx_h2"><h2>企业管理</h2></div>
        <form id="comManageForm" name="comManageForm" action="" method="post">

            <input id="status" name="status" type="hidden"/>
            <input id="baseUrl" value="${BASE_URL}" type="hidden"/>
            <input id="page" name="page" type="hidden" value="${basePage.page}"/>
            <input id="curPage" name="curPage" value="${basePage.page}" type="hidden"/>
            <input id="pageCount" name="pageCount" value="${basePage.count}" type="hidden"/>
            <input id="id" name="id" type="hidden"/>

            <table border="0" cellspacing="10" cellpadding="0" class="gerenzx_table">

                <c:if test="${not empty msg}">
                    <tr>
                        <td width="121" align="right"><span style="color:red;">${msg}</span></td>
                        <td colspan="6">&nbsp;</td>
                    </tr>
                </c:if>

                <tr>
                    <td width="78" align="right">企业名称：</td>
                    <td width="155"><input id="companyName" name="companyName" type="text" class="grzx_input"/></td>
                    <%--<td width="78" align="right">创建时间：</td>--%>
                    <%--<td width="150"><input name="" type="text" class="grzx_input"/></td>--%>
                    <td width="90"><input name="" type="button" value="查询" class="grzx_button2" onclick="serAllCom()"/></td>
                    <td width="90"><input name="" type="button" value="创建" class="grzx_button2" onclick="createCom()"/></td>
                    <%--<td width="90"><input name="" type="button" value="导入" class="grzx_button2" /></td>--%>
                </tr>
            </table>
            <table width="929" border="0" cellspacing="1" cellpadding="0" class="fuwugl_table">
                <thead>
                <tr>
                    <td width="196" height="38" align="center">企业名称</td>
                    <td width="187" align="center">企业地址</td>
                    <td width="111" align="center">联系人</td>
                    <td width="109" align="center">联系方式</td>
                    <td width="102" align="center">是否上线</td>
                    <td width="217" align="center">操作</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="com" items="${comVoLst}">
                    <tr>
                        <td height="40">${com.companyName}</td>
                        <td align="center">${com.companyAddress}</td>
                        <td align="center">${com.companyContactUser}</td>
                        <td align="center">${com.companyContactTel}</td>
                        <td align="center">${com.statusStr}</td>
                        <td align="center">

                            <c:if test="${com.status == 2}">
                                <a id="shangxian" name="shangxian" data-id="${com.id}" href="javascript:;"  class="hongzi_a" >上线</a>
                            </c:if>
                            <c:if test="${com.status == 1}">
                                <a id="xiaxian" name="xiaxian" href="javascript:;" data-id="${com.id}" class="hongzi_a">下线</a>
                            </c:if>

                            <a href="${BASE_URL}/user/toOneCompany.html?id=${com.id}&flag=edit" class="lanzi_a">编辑</a>
                            <a id="delCom" href="javascript:;"  data-id="${com.id}" class="hongzi_a">删除</a>
                            <a href="${BASE_URL}/user/toOneCompany.html?id=${com.id}&flag=detail" class="lanzi_a">详细</a>
                        </td>
                    </tr>
                </c:forEach>

                <tr>
                    <td height="40" colspan ="7"> <div class="pages" id="pager"></div></td>
                </tr>
                </tbody>
            </table>
        </form>
    </div>
</div>
<jsp:include page="../public/footer.jsp"></jsp:include>
</body>
</html>

<script type="application/javascript">

    var baseUrl = $("#baseUrl").val();
    $("#baseList").addClass("li_atab");

    //分页  begin
    var cur_page = $("#curPage").val();
    var page_count = $("#pageCount").val();
    jQuery("#pager").pager({pagenumber: cur_page, pagecount: page_count, buttonClickCallback: change_page});

    function change_page(cur_page) {
        jQuery("#page").val(cur_page);
        jQuery("#serManageForm").submit();
    }

    $("#xiaxian").click(function () {
        $("#comManageForm").attr("action", baseUrl + "/user/updateCompany.html");
        $("#status").val(2);
        $("#id").val($("#xiaxian").attr("data-id"));
        jQuery("#comManageForm").submit();
    });
    $("#shangxian").click(function () {

        $("#comManageForm").attr("action", baseUrl + "/user/updateCompany.html");
        $("#status").val(1);
        $("#id").val($("#shangxian").attr("data-id"));
        jQuery("#comManageForm").submit();

    });



    $("#delCom").click(function () {
        debugger;
        $("#companyName").val(null);
        $("#comManageForm").attr("action", baseUrl + "/user/toDelCompany.html");
        $("#id").val($("#delCom").attr("data-id"));
        jQuery("#comManageForm").submit();
    });


    /**
     * 创建企业
     */
    function createCom() {
//        $("#comManageForm").attr("action", baseUrl + "/user/toPushService.html");
//        jQuery("#serManageForm").submit();
        window.location.href="${BASE_URL}/user/toOneCompany.html?flag=create";
    }


    /**
     * 查询企业
     */
    function serAllCom() {
        $("#serManageForm").attr("action", baseUrl + "/user/toAllCompany.html");
        jQuery("#serManageForm").submit();
    }

</script>
