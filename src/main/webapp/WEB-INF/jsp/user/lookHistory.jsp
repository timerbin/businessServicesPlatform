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
<form action="" id="lookHisForm" name="lookHisForm">
    <input id="lookType" name="type" value="${vo.type}" type="hidden"/>
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
                <c:if test="${vo.type== null}">
                    <input name="" type="button" value="全部分类" class="llls_button"/>
                    <input name="" type="button" value="企业"  class="llls_button2"/>
                    <input name="" type="button" value="服务" class="llls_button2"/>
                </c:if>
                    <%--服务浏览--%>
                <c:if test="${vo.type==1}">
                    <input name="" type="button" value="全部分类" class="llls_button2"/>
                    <input name="" type="button" value="企业"  class="llls_button2"/>
                    <input name="" type="button" value="服务" class="llls_button"/>
                </c:if>
                    <%--企业浏览--%>
                <c:if test="${vo.type==2}">
                    <input name="" type="button" value="全部分类" class="llls_button2"/>
                    <input name="" type="button" value="企业"  class="llls_button"/>
                    <input name="" type="button" value="服务" class="llls_button2"/>
                </c:if>

            </div>


            <c:if test="${vo.type==1}">
                <c:forEach items="${ulhLst}" var="hisVo" >
                    <div class="llls_time">${hisVo.nowDate}</div>
                    <div>
                        <dl class="llls_list">
                            <dt><img src="${BASE_URL}/${hisVo.baseUserCompanyVo.logoPicPath}"/></dt>
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
                    </div>

                </c:forEach>

            </c:if>

            <c:if test="${vo.type==2}">
                <c:forEach items="${ulhLst}" var="hisVo" >
                    <div class="llls_time">${hisVo.nowDate}</div>
                    <div>
                        <dl class="llls_list">
                            <dt><img src="${BASE_URL}/${hisVo.baseUserCompanyVo.logoPicPath}"/></dt>
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
        </div>
    </div>
</form>
</body>
</html>
