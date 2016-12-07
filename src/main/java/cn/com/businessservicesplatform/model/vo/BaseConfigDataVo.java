package cn.com.businessservicesplatform.model.vo;

import cn.com.businessservicesplatform.model.mysql.BaseConfigData;

public class BaseConfigDataVo extends BaseConfigData {
    
	public BaseConfigDataVo(){
	}
	
	public BaseConfigDataVo(Integer type){
		super.setType(type);
	}
	
	
	/**
	  * Enabled 启用
	  * Disable 停用
	  * 
	  */
	 private String updateCode;
	 private String errorMsg;
	 
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getUpdateCode() {
		return updateCode;
	}

	public void setUpdateCode(String updateCode) {
		this.updateCode = updateCode;
	}
}