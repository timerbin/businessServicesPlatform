<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form id="searchBox" action="${BASE_URL}/home/allService.html" method="post">
 	<div class="right_search">
           <div class="search_box">
               <table border="0" cellspacing="0" cellpadding="0">
                 <tr>
                   <td>
                   	<label>
                    	<select id="queryType" name="queryType"  class="select_fuwu">
                    		<c:if test="${empty queryVo.queryType}">
			        	 		 <option value="1">企业</option>
			        	 		 <option value="2">服务</option>
			 				</c:if>
                    		<c:if test="${queryVo.queryType==1}">
			        	 		 <option value="1" selected="selected">企业</option>
			        	 		 <option value="2">服务</option>
			 				</c:if>
            	 			<c:if test="${queryVo.queryType==2}">
			        	 		 <option value="1">企业</option>
			        	 		 <option value="2" selected="selected">服务</option>
			 				</c:if>
                    	</select>
                   	</label>
                   </td>
                   <td><label><input id="queryStr" name="queryStr"  value="${queryVo.queryStr}" type="text" placeholder="请输入关键字查询..." class="input_chaxun" /></label></td>
                   <td><label><input id="queryBtn" type="button" value="搜 索" class="button_search" /></label></td>
                 </tr>
               </table>
           </div>
          <div class="release_box">
          	<%--<c:if test="${not empty services_user_info && not empty services_user_info.companyId}">--%>
				<c:if test="${not empty services_user_info}">
        	 		<label><input id="addService" type="button" value="免费发布服务" class="button_release" /></label>
 				</c:if>
          </div>
      </div>
 </form>
<script type="text/javascript">
 var baseUrl = $("#baseUrl").val();
$("#queryBtn").click(function(){
	var queryType = $("#queryType").val();
	if(queryType == 1){
		$("#searchBox").attr("action",baseUrl+"/home/allCompany.html");
		$("#searchBox").submit();
	}else{
		$("#searchBox").attr("action",baseUrl+"/home/allService.html");
		$("#searchBox").submit();
	}
});
$("#addService").click(function(){
	$("#searchBox").attr("action","${BASE_URL}/user/toPushService.html");
	$("#searchBox").submit();
});
</script>
	