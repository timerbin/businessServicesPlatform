package cn.com.businessservicesplatform.model.vo;

import java.util.List;

import cn.com.businessservicesplatform.common.constants.BaseConfigTypeEnum;
import cn.com.businessservicesplatform.model.mysql.BaseConfigData;

public class BaseConfigDataVo extends BaseConfigData {
	
	public BaseConfigDataVo(){
	}
	
	public BaseConfigDataVo(Integer type){
		super.setType(type);
	}
	
	public BaseConfigDataVo(BaseConfigData data){
		super.setType(data.getType());
		super.setId(data.getId());
		super.setShowName(data.getShowName());
		super.setStatus(data.getStatus());
		super.setDirections(data.getDirections());
	}
	
	
	
	/**
	  * Enabled 启用
	  * Disable 停用
	  * 
	  */
	 private String updateCode;
	 private String errorMsg;
	 private String typeStr;
	 public List<Integer> lookSize;
	 
	public List<Integer> getLookSize() {
		return lookSize;
	}

	public void setLookSize(List<Integer> lookSize) {
		this.lookSize = lookSize;
	}

	public String getTypeStr() {
		if(null != super.getType()){
			BaseConfigTypeEnum typeEnum = BaseConfigTypeEnum.get(super.getType());
			if(null != typeEnum){
				setTypeStr(typeEnum.getDes());
			}
		}
		return typeStr;
	}

	public void setTypeStr(String typeStr) {
		this.typeStr = typeStr;
	}

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