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
<form action="${BASE_URL}/user/toUpdateService.html" id="serManageForm" name="serManageForm">
	<input id="recommend" name="recommend" type="hidden" />
	<input id="status" name="status" type="hidden" />
	<input id="page" name="page" type="hidden" value="${basePage.page}"/>
	<input id="curPage" name="curPage"  value="${basePage.page}" type="hidden"/>
	<input id="pageCount" name="pageCount" value="${basePage.count}" type="hidden"/>
	<input id="id" name="id" type="hidden"/>
	<input id="serviceType" name="serviceType" type="hidden"/>
	
	<jsp:include page="../public/loginheader.jsp" />
	<div class="top_tiao"></div>
	<div class="gerenzx_main">
		<jsp:include page="../public/loginLeft.jsp" />
    	<div class="gerenzx_right">
    		<div class="grzx_h2"><h2>服务管理</h2></div>
      			<table border="0" cellspacing="10" cellpadding="0" class="gerenzx_table">
			          <c:if test="${not empty msg}">
			              <tr>
			                  <td width="121" align="right"><span style="color:red;">${msg}</span></td>
			                  <td colspan="6">&nbsp;</td>
			              </tr>
			          </c:if>
			          <tr>
			            <td width="78" align="right">服务名称：</td>
			            <td width="155"><input id="serviceName" name="serviceName" value="${vo.serviceName}" type="text" class="grzx_input" /></td>
			            <%--<td width="78" align="right">创建时间：</td>
			            <td width="150"><input name="" type="text" class="grzx_input" /></td>--%>
			            <td width="78" align="right">服务类别：</td>
			            <td width="140">
			                <%--<select name="" class="grzx_input"></select>--%>
			                    <select name="fwMaType" id="fwMaType" class="grzx_input">
			                        <%--<c:if test="${not empty serTypeList}">--%>
										<option value="" selected="selected">
											--请选择--
										</option>
			                        <c:forEach var="serType" items="${serTypeList}">
			                            <option value="${serType.id}">
			                                    ${serType.showName}
			                            </option>
			                        </c:forEach>
			                    </select>
			
			            </td>
			            <td width="90"><input type="button" value="查询" class="grzx_button2" onclick="serAllService()"/></td>
			            <td width="90"><input id="addBtn" type="button" value="新增" class="grzx_button2"  /></td>
			          </tr>
			        </table>
			        <table width="950" border="0" cellspacing="1" cellpadding="0" class="fuwugl_table">
			          <thead>
				          <tr>
				            <td width="196" height="38" align="center">服务名称</td>
				            <td width="143" align="center">创建时间</td>
				            <td width="113" align="center">服务类型</td>
				            <td width="73" align="center">状态</td>
				            <td width="78" align="center">序号</td>
				            <td width="111" align="center">是否推荐</td>
				            <td width="228" align="center">操作</td>
				          </tr>
			          </thead>
			          <tbody>
				          	<c:forEach var="fwVo" items="${voList}">
				              <tr>
				                  <td height="40" align="center">${fwVo.serviceName}</td>
				                  <td align="center">${fwVo.createTimeStr}</td>
				                  <td align="center">${fwVo.serviceTypeStr}</td>
				                  <td align="center">${fwVo.statusStr}</td>
				                  <td align="center">${fwVo.id}</td>
				                  <td align="center">${fwVo.recommendStr}</td>
				                  <td align="center">


									  <%--<c:if test="${fwVo.status == 2}">
										  <a id="fwOnline" name="fwOnline" data-id="${fwVo.id}" href="javascript:;"  class="hongzi_a" >上线</a>
									  </c:if>
									  <c:if test="${fwVo.status == 1}">
										  <a id="fwOffLine" name="fwOffLine" href="javascript:;" data-id="${fwVo.id}" class="hongzi_a">下线</a>
									  </c:if>--%>

									  <c:if test="${fwVo.status == 2}">
										  <a id="fwOnline" name="fwOnline" data-fid="${fwVo.id}" href="javascript:;"  class="hongzi_a" >上线</a>
									  </c:if>
									  <c:if test="${fwVo.status == 1}">
										  <a id="fwOffLine" name="fwOffLine" href="javascript:;" data-fid="${fwVo.id}" class="hongzi_a">下线</a>
									  </c:if>


				                      <c:if test="${fwVo.recommend == 0}">
				                          <a id="butuijian" name="butuijian" data-id="${fwVo.id}" href="javascript:;"  class="hongzi_a" >不推荐</a>
				                      </c:if>
				                      <c:if test="${fwVo.recommend == 1}">
				                          <a id="tuijian" name="tuijian" href="javascript:;" data-id="${fwVo.id}" class="hongzi_a">推荐</a>
				                      </c:if>
				
				                      <a href="${BASE_URL}/user/toFindService.html?id=${fwVo.id}&flag=edit" class="lanzi_a">编辑</a>
				                      <a href="${BASE_URL}/user/toDelService.html?id=${fwVo.id}" class="hongzi_a">删除</a>
				                      <a href="${BASE_URL}/user/toFindService.html?id=${fwVo.id}&flag=detail" class="lanzi_a">详情</a>
				                  </td>
				              </tr>
				
				          </c:forEach>
				          <tr>
				              <td height="40" colspan ="7"> <div class="pages" id="pager"></div></td>
				          </tr>
			          </tbody>
			     </table>
  			</div>
		</div>
</form>
<script type="application/javascript">
$("#serviceManage").addClass("li_atab");

    var baseUrl = $("#baseUrl").val();

    //分页  begin
    var cur_page = $("#curPage").val();
    var page_count = $("#pageCount").val();
    jQuery("#pager").pager({pagenumber: cur_page, pagecount: page_count, buttonClickCallback: change_page });

    function change_page(cur_page) {
        jQuery("#page").val(cur_page);
        jQuery("#serManageForm").submit();
    }
    
    $("#addBtn").click(function(){
        window.location.href=baseUrl+"/user/toAdminAddService.html";
    });
    
    

    $("#butuijian").click(function(){
        $("#serManageForm").attr("action",baseUrl+"/user/toUpdateService.html");
        $("#recommend").val(1);
        $("#id").val($(this).attr("data-id"));
        jQuery("#serManageForm").submit();
    });
    $("#tuijian").click(function(){
        $("#serManageForm").attr("action",baseUrl+"/user/toUpdateService.html");
        $("#recommend").val(0);
        $("#id").val($(this).attr("data-id"));

        jQuery("#serManageForm").submit();

    });

	//上线 下线 处理
	$("#fwOnline").click(function(){
		$("#serManageForm").attr("action",baseUrl+"/user/toUpdateService.html");
		$("#status").val(1);
		/*$("#id").val($("#fwOnline").attr("data-fid"));*/
		$("#id").val($(this).attr("data-fid"));
		jQuery("#serManageForm").submit();
	});

	$("#fwOffLine").click(function(){
		$("#serManageForm").attr("action",baseUrl+"/user/toUpdateService.html");
		$("#status").val(2);
		/*$("#id").val($("#fwOffline").attr("data-fid"));*/
		$("#id").val($(this).attr("data-fid"));
		jQuery("#serManageForm").submit();

	});


    function pushService() {
        $("#serManageForm").attr("action",baseUrl+"/user/toPushService.html");
        jQuery("#serManageForm").submit();
    }

    function updateEditSer(recommend,id){
        $.ajax({
            url:'${BASE_URL}/user/toUpdateService.html',
            type:'POST', //GET
            async:false,    //或false,是否异步
            data:{
                id:id,
                recommend:recommend
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
                /* $("#fbfwForm")[0].reset();*/
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

    function serAllService() {
        $("#serManageForm").attr("action",baseUrl+"/user/toServiceManage.html");
        jQuery("#serManageForm").submit();
    }

    $("#fwMaType").change(function(){
//        alert($("#fwMaType").val());
        $("#serviceType").val($("#fwMaType").val());
    });
</script>
</body>
</html>

