package cn.com.businessservicesplatform.service;

import java.util.List;

import cn.com.businessservicesplatform.common.util.BasePage;
import cn.com.businessservicesplatform.model.mysql.BaseUserCompany;
import cn.com.businessservicesplatform.model.vo.BaseUserCompanyVo;

public interface BaseUserCompanyService {
	
	public int insert(BaseUserCompanyVo vo);
	
	public BaseUserCompanyVo getBaseUserAllCompany(Integer userId);
	
	public BaseUserCompany getUserCompany(BaseUserCompanyVo baseUserCompanyVo);
	
	public BaseUserCompanyVo getUserAllCompany(Integer id);
	
	public List<BaseUserCompanyVo> queryPage(BasePage basePage,BaseUserCompanyVo vo);
	
	public List<BaseUserCompanyVo> queryList(BaseUserCompanyVo vo);
}
