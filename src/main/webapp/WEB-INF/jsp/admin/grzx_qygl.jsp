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
<jsp:include page="../public/loginLeft.jsp"/>
<div class="top_tiao"></div>
<div class="gerenzx_main">
    <jsp:include page="../public/loginLeft.jsp"/>
    <div class="gerenzx_right">
        <div class="grzx_h2"><h2>企业管理</h2></div>
        <form id="comManageForm" name="" action="">

            <input id="recommend" name="recommend" type="hidden"/>
            <input id="baseUrl" value="${BASE_URL}" type="hidden"/>
            <input id="page" name="page" type="hidden" value="${basePage.page}"/>
            <input id="curPage" name="curPage" value="${basePage.page}" type="hidden"/>
            <input id="pageCount" name="pageCount" value="${basePage.count}" type="hidden"/>
            <input id="id" name="id" type="hidden"/>
            <input id="serviceType" name="serviceType" type="hidden"/>
            <table border="0" cellspacing="10" cellpadding="0" class="gerenzx_table">


                <tr>
                    <td width="78" align="right">企业名称：</td>
                    <td width="155"><input name="" type="text" class="grzx_input"/></td>
                    <td width="78" align="right">创建时间：</td>
                    <td width="150"><input name="" type="text" class="grzx_input"/></td>
                    <td width="90"><input name="" type="button" value="查询" class="grzx_button2"/></td>
                    <td width="90"><input name="" type="button" value="创建" class="grzx_button2"/></td>
                    <%--<td width="90"><input name="" type="button" value="导入" class="grzx_button2" /></td>--%>
                </tr>
            </table>
            <table width="929" border="0" cellspacing="1" cellpadding="0" class="fuwugl_table">
                <thead>
                <tr>
                    <td width="196" height="38" align="center">服务名称</td>
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
                                <a id="shangxian" name="shangxian" data-id="${fwVo.id}" href="javascript:;"  class="hongzi_a" >上线</a>
                            </c:if>
                            <c:if test="${com.status == 1}">
                                <a id="xiaxian" name="xiaxian" href="javascript:;" data-id="${fwVo.id}" class="hongzi_a">下线</a>
                            </c:if>
                            <a href="#" class="lanzi_a">编辑</a>
                            <a href="#" class="hongzi_a">删除</a>
                            <a href="#" class="lanzi_a">详情</a>
                        </td>
                    </tr>
                </c:forEach>
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
        $("#serManageForm").attr("action", baseUrl + "/user/toUpdateService.html");
        $("#recommend").val(1);
        $(this).val($("#butuijian").attr("data-id"));
        jQuery("#serManageForm").submit();
    });
    $("#shangxian").click(function () {

        $("#serManageForm").attr("action", baseUrl + "/user/toUpdateService.html");
        $("#recommend").val(0);
        $(this).val($("#tuijian").attr("data-id"));
        jQuery("#serManageForm").submit();

    });


    /**
     * 创建企业
     */
    function createCom() {
        $("#serManageForm").attr("action", baseUrl + "/user/toPushService.html");
        jQuery("#serManageForm").submit();
    }


    /**
     * 查询企业
     */
    function serAllCom() {
        $("#serManageForm").attr("action", baseUrl + "/user/toServiceManage.html");
        jQuery("#serManageForm").submit();
    }

</script>
