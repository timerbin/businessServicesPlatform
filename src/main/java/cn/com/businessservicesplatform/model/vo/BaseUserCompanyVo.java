package cn.com.businessservicesplatform.model.vo;

import cn.com.businessservicesplatform.model.mysql.BaseUserCompany;

public class BaseUserCompanyVo extends BaseUserCompany {

	public BaseUserCompanyVo(){}
	
	public BaseUserCompanyVo(Integer userId){
		super.setUserId(userId);
	}

}
