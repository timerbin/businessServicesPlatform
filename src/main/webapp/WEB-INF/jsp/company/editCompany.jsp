<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<link href="/images/gerenzx.css" rel="stylesheet" type="text/css" />
<meta name="renderer" content="webkit" />
    <jsp:include page="../public/baseData.jsp" />
</head>
<body>
<form action="#" method="post">
    <div class="gerenzx_right">
      <table border="0" cellspacing="20" cellpadding="0" class="gerenzx_table">
      	  <tr>
            <td width="120" align="right">用户名：</td>
            <td width="260"><input name="loginName" type="text" class="grzx_input"  /></td>
          </tr>
          <tr>
            <td width="120" align="right">姓名：</td>
            <td width="260"><input name="raleName" type="text" class="grzx_input" /></td>
          </tr>
          <tr>
            <td width="120" align="right">密码：</td>
            <td width="260"><input name="loginPwd" type="password" class="grzx_input" /></td>
          </tr>
          <tr>
            <td width="120" align="right">确认密码：</td>
            <td width="260"><input name="loginPwd2" type="password" class="grzx_input" /></td>
          </tr>
          <tr>
            <td align="right">年龄：</td>
            <td><input name="age" type="text" class="grzx_input2" /></td>
          </tr>
          <tr>
            <td align="right">性别：</td>
            <td><input name="sex" type="radio" value="0" /> 男 &nbsp;&nbsp;&nbsp;&nbsp;<input name="sex" type="radio" value="1" /> 女</td>
          </tr>
          <tr>
            <td align="right">联系方式：</td>
            <td><input name="mobilePhone" type="text" class="grzx_input" /></td>
          </tr>
          <tr>
            <td align="right">邮箱：</td>
            <td><input name="email" type="text" class="grzx_input" /></td>
          </tr>
          <tr>
            <td colspan="2" align="center"><input name="" type="button" value=" 提 交 " class="grzx_button"/></td>
          </tr>
        </table>
  	</div>
    <jsp:include page="../public/footer.jsp" ></jsp:include>
</form>
</body>
</html>

