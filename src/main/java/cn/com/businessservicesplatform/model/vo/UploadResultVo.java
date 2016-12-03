package cn.com.businessservicesplatform.model.vo;

public class UploadResultVo {
	
	private Integer returnCode;
	private String msg;
	private String picPath;
	public UploadResultVo(){}
	
	public UploadResultVo(String picPath){
		this.returnCode = 0;
		this.picPath = picPath;
	}
	public UploadResultVo(Integer returnCode,String msg){
		this.returnCode = 1;
		this.msg = msg;
	}
	public Integer getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(Integer returnCode) {
		this.returnCode = returnCode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

}
