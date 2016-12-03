package cn.com.businessservicesplatform.model.vo;

import cn.com.businessservicesplatform.model.mysql.BaseConfigData;

public class BaseConfigDataVo extends BaseConfigData {
    
	public BaseConfigDataVo(){
	}
	
	public BaseConfigDataVo(Integer type){
		super.setType(type);
	}
}