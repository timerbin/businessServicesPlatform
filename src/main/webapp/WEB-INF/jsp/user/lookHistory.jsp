<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>浏览历史</title>
    <%--<link href="images/gerenzx.css" rel="stylesheet" type="text/css" />--%>
    <link href="${BASE_URL}/images/gerenzx.css" rel="stylesheet" type="text/css"/>
    <jsp:include page="../public/baseData.jsp"/>
    <jsp:include page="../public/pager.jsp"/>
</head>

<body>
<form action="${BASE_URL}/user/toLookList.html" id="lookHisForm" name="lookHisForm">
    <input id="lookType" name="type" value="${vo.type}" type="hidden"/>
    <input id="findType" name="findType" value="" type="hidden"/>
    <input id="baseUrl" value="${BASE_URL}" type="hidden"/>
    <input id="page" name="page" type="hidden" value="${basePage.page}"/>
    <input id="curPage" name="curPage" value="${basePage.page}" type="hidden"/>
    <input id="pageCount" name="pageCount" value="${basePage.count}" type="hidden"/>


    <jsp:include page="../public/loginheader.jsp"/>
    <div class="top_tiao"></div>
    <div class="gerenzx_main">
        <jsp:include page="../public/loginLeft.jsp"/>
        <div class="gerenzx_right">
            <div class="grzx_h2"><h2>浏览历史</h2></div>
            <div class="llls_button_box">
                <%--默认全部分类--%>
                <c:if test="${vo.findType == 0 or vo.findType == null}">
                    <input id="lookAll" name="lookAll" type="button" value="全部分类" class="llls_button"/>
                    <input id="lookCompany" name="lookCompany" type="button" value="企业"  class="llls_button2"/>
                    <input id="lookService" name="lookService" type="button" value="服务" class="llls_button2"/>
                </c:if>
                    <%--服务浏览--%>
                <c:if test="${vo.findType==1}">
                    <input id="lookAll" name="lookAll" type="button" value="全部分类" class="llls_button2"/>
                    <input id="lookCompany" name="lookCompany" type="button" value="企业"  class="llls_button2"/>
                    <input id="lookService" name="lookService" type="button" value="服务" class="llls_button"/>
                </c:if>
                    <%--企业浏览--%>
                <c:if test="${vo.findType==2}">
                    <input id="lookAll" name="lookAll" type="button" value="全部分类" class="llls_button2"/>
                    <input id="lookCompany" name="lookCompany" type="button" value="企业"  class="llls_button"/>
                    <input id="lookService" name="lookService" type="button" value="服务" class="llls_button2"/>
                </c:if>

            </div>


            <c:if test="${vo.findType ==1}">
                <c:forEach items="${ulhLst}" var="hisVo" >
                    <div class="llls_time">${hisVo.nowDate}</div>
                    <div>
                        <dl class="llls_list">
                            <dt><img src="${BASE_URL}/${hisVo.baseUserCompanyVo.logoPicPath}"/></dt>
                            <dd>
                                <h3>${hisVo.userCompanyServiceVo.serviceName}</h3>
                                <p>${hisVo.userCompanyServiceVo.serviceDirections}</p>
                                <span><img src="images/shanchu.png"/></span>
                            </dd>
                        </dl>
                       <%-- <dl class="llls_list">
                            <dt><img src="images/home_yzqy_16.jpg"/></dt>
                            <dd>
                                <h3>斐讯数据通信技术有限公司</h3>
                                <p>激情发展、追求卓越、客户价值、共同成长</p>
                                <span><img src="images/shanchu.png"/></span>
                            </dd>
                        </dl>--%>
                        <div class="clear"></div>
                    </div>

                </c:forEach>

            </c:if>

            <c:if test="${vo.findType ==2}">
                <c:forEach items="${ulhLst}" var="hisVo" >
                    <div class="llls_time">${hisVo.nowDate}</div>
                    <div>
                        <dl class="llls_list">
                            <dt><img src="${BASE_URL}/${hisVo.baseUserCompanyVo.logoPicPath}"/></dt>
                            <dd>
                                <h3>${BASE_URL}/${hisVo.baseUserCompanyVo.logoPicPath}</h3>
                                <p>${hisVo.baseUserCompanyVo.companyDirections}</p>
                                <%--<span><img src="images/shanchu.png"/></span>--%>
                            </dd>
                        </dl>
                       <%-- <dl class="llls_list">
                            <dt><img src="images/home_yzqy_16.jpg"/></dt>
                            <dd>
                                <h3>斐讯数据通信技术有限公司</h3>
                                <p>激情发展、追求卓越、客户价值、共同成长</p>
                                <span><img src="images/shanchu.png"/></span>
                            </dd>
                        </dl>--%>
                        <div class="clear"></div>
                    </div>

                </c:forEach>

            </c:if>



            <c:if test="${vo.findType ==0}">
                <c:forEach items="${ulhLst}" var="hisVo" >
                    <div class="llls_time">${hisVo.nowDate}</div>
                    <div>
                        <dl class="llls_list">
                            <dt><img src="${BASE_URL}/${hisVo.baseUserCompanyVo.logoPicPath}"/></dt>
                            <dd>
                                <h3>${hisVo.userCompanyServiceVo.serviceName}</h3>
                                <p>${hisVo.userCompanyServiceVo.serviceDirections}</p>
                                <span><img src="images/shanchu.png"/></span>
                            </dd>
                        </dl>
                            <%-- <dl class="llls_list">
                                 <dt><img src="images/home_yzqy_16.jpg"/></dt>
                                 <dd>
                                     <h3>斐讯数据通信技术有限公司</h3>
                                     <p>激情发展、追求卓越、客户价值、共同成长</p>
                                     <span><img src="images/shanchu.png"/></span>
                                 </dd>
                             </dl>--%>
                        <div class="clear"></div>
                    </div>

                </c:forEach>

            </c:if>



            <%--<div class="llls_time">2016年10月2日 12：00 星期日</div>
            <div>
                <dl class="llls_list">
                    <dt><img src="images/home_yzqy_16.jpg"/></dt>
                    <dd>
                        <h3>斐讯数据通信技术有限公司</h3>
                        <p>激情发展、追求卓越、客户价值、共同成长</p>
                        <span><img src="images/shanchu.png"/></span>
                    </dd>
                </dl>
                <dl class="llls_list">
                    <dt><img src="images/home_yzqy_16.jpg"/></dt>
                    <dd>
                        <h3>斐讯数据通信技术有限公司</h3>
                        <p>激情发展、追求卓越、客户价值、共同成长</p>
                        <span><img src="images/shanchu.png"/></span>
                    </dd>
                </dl>
                <dl class="llls_list">
                    <dt><img src="images/home_yzqy_16.jpg"/></dt>
                    <dd>
                        <h3>斐讯数据通信技术有限公司</h3>
                        <p>激情发展、追求卓越、客户价值、共同成长</p>
                        <span><img src="images/shanchu.png"/></span>
                    </dd>
                </dl>
                <div class="clear"></div>
            </div>--%>

            <table>
                <tr>
                    <td height="40" colspan ="7"> <div class="pages" id="pager"></div></td>
                </tr>
            </table>
        </div>
    </div>
</form>
</body>
</html>

<script type="text/javascript">
    $("#collectList").addClass("li_atab");
    var baseUrl = $("#baseUrl").val();


    //分页  begin
    var cur_page = $("#curPage").val();
    var page_count = $("#pageCount").val();
    jQuery("#pager").pager({pagenumber: cur_page, pagecount: page_count, buttonClickCallback: change_page });

    function change_page(cur_page) {
        jQuery("#page").val(cur_page);
        jQuery("#doEditUserInfo").submit();
    }

    $("#lookService").click(function(){
        $("#lokkType").val(1);
        $("#findType").val(1);
        $("#lookHisForm").submit();
    });
    $("#lookCompany").click(function(){
        $("#lookType").val(2);
        $("#findType").val(2);
        $("#lookHisForm").submit();
    });

    $("#lookAll").click(function(){
        $("#lookType").val(null);
        $("#findType").val(0);
        $("#lookHisForm").submit();
    });
</script>
