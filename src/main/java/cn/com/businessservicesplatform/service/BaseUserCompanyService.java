package cn.com.businessservicesplatform.service;

import cn.com.businessservicesplatform.model.mysql.BaseUser;
import cn.com.businessservicesplatform.model.vo.BaseUserCompanyVo;
import cn.com.businessservicesplatform.model.vo.BaseUserVo;

public interface BaseUserCompanyService {
	
	public int insert(BaseUserCompanyVo vo);
}
