<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>上传图片</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<link href="http://127.0.0.1/images/gerenzx.css" rel="stylesheet" type="text/css" />
<meta name="renderer" content="webkit" />
</head>
<body>
	<img onclick="doSelectPic('khzm')"  id = "khzm"  src="/images/nav_01.png" alt="" />
	 <iframe id="uploadPicFrame" src="" style="display:none;"></iframe>
<script src="/js/jquery-1.9.1.min.js"></script>
<!-- 触发JS刷新-->
<script type="text/javascript">
function doSelectPic(id) {
	imgId = id;
	$("#pic", $("#uploadPicFrame")[0].contentWindow.document).click();
	return false;
}
initUploadPicFrame();
function initUploadPicFrame(){
	var frameSrc = "/user/getUploadPicForm.html";
	var frameParam = new Object();
	frameParam.formId= "upload";
	frameParam.inputId= "pic";
	frameParam.inputOnChange = "parent.picChange";
	frameParam.jsonp = "parent.picUploadCallback";
	frameSrc += "?"+parseParam(frameParam);
	$("#uploadPicFrame").attr("src", frameSrc);
}
function picChange(inputFile){
	var fileSize = 0;
	var fileName = "";
	//ie7 8 9 10恶心的文件尺寸读取方法需要执行权限,为了体验,干掉本地验证
	if (navigator.userAgent.indexOf('MSIE') >= 0){
		//var fileActObj = new ActiveXObject("Scripting.FileSystemObject");
		//var targetFile = fileActObj.GetFile(inputFile.value);
		//fileSize = targetFile.Size;
		//fileName = targetFile.Name;
	}else{
		var files = inputFile.files;
		if (files.length>0){
			var targetFile = files[0];
			fileSize = targetFile.size;
			fileName = targetFile.name;
		}
	}
	if (fileSize>5242880){
		alert("上传图片大小超过5M");
		initUploadPicFrame();
	}else{
		$("#fileName").html(fileName);
		$("#upload", $("#uploadPicFrame")[0].contentWindow.document).submit();
	}
}
//上传完成后回调的方法
function picUploadCallback(data){
	alert(data);
	layer.close(load);
	if (data.code=="0"){
		var picUrl = data.url;
		$("#"+imgId).attr("src", picUrl);
		$("#"+imgId+"Path").val(picUrl);
		$("#"+imgId+"Pre").show();
	}else{
		alert(data.message);
	}
	initUploadPicFrame();
}
//公共方法,用来将对象转化为URL参数
function parseParam(param, key){
  	var paramStr="";
  	if(param instanceof String||param instanceof Number||param instanceof Boolean){
    	paramStr+="&"+key+"="+encodeURIComponent(param);
  	}else{
    	jQuery.each(param,function(i){
          	var k=key==null?i:key+(param instanceof Array?"["+i+"]":"."+i);
          	paramStr+='&'+parseParam(this, k);
    	});
  	}
  	return paramStr.substr(1);
}
</script>

</body>
</html>
