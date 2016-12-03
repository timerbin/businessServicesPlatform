package cn.com.businessservicesplatform.service;

import cn.com.businessservicesplatform.model.mysql.BaseUserCompany;
import cn.com.businessservicesplatform.model.vo.BaseUserCompanyVo;

public interface BaseUserCompanyService {
	
	public int insert(BaseUserCompanyVo vo);
	
	public BaseUserCompanyVo getBaseUserAllCompany(Integer userId);
	
	public BaseUserCompany getUserCompany(BaseUserCompanyVo baseUserCompanyVo);
}
