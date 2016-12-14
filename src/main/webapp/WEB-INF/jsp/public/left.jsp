<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
     <div class="left_logo"><a href="${BASE_URL}/home/homeIndex.html"><img src="${BASE_URL}/images/home_logo.png" width="152" height="100" /></a></div>
     <ul id="initMenu">
     </ul>
 </div>
 <script type="text/javascript">
 var baseUrl = $("#baseUrl").val();
 $("#initMenu").html("<li id='navMenu0'><span class='left_biao'><img src='"+baseUrl+"/images/nav_01.png'/> </span><a href='"+baseUrl+"/home/homeIndex.html' style='color:white'>首页</a></li>");
 $.ajax({
     url: baseUrl+"/initMenu.html",
     type : 'GET',
     success: function (data) {
         if (data) {
        	 $.each(data,function(n,value) {
        		 var picName = "0"+(n+1);
        		 if(n+1>=10){
        			 picName = (n+1);
        		 }
        		  var menuLi = "<li id='navMenu"+value.id+"'><span class='left_biao'><img src='"+baseUrl+"/images/nav_"+picName+".png' /></span><a href='"+baseUrl+"/home/allService.html?serviceType="+value.id+"'  style='color:white' >"+value.showName+"</a></li>";
                  $("#initMenu").append(menuLi);
             });
         }
     }
 });
 </script>