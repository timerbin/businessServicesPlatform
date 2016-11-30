<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<table>
    <tr>
        <td nowrap width="437"></td>
        <td>
            <img id="img" src="${ctx}/authImage" />
            <a href='#' onclick="javascript:changeImg()" style="color:white;"><label style="color:white;">看不清？</label></a>
        </td>
    </tr>
</table>
</body>
</html>

<!-- 触发JS刷新-->
<script type="text/javascript">
    function changeImg(){
        var img = document.getElementById("img");
        img.src = "${ctx}/authImage?date=" + new Date();;
    }
</script>
