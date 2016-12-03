<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../public/baseData.jsp" />
<input id="resultCallback"   value="${callback}"  type="hidden"  />
<input id="resultData"  value="${data}"  type="hidden"   />
<script type="text/javascript">
eval($("#resultCallback").val()+"("+$("#resultData").val()+")");
</script>
