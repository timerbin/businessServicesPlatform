package cn.com.businessservicesplatform.service;

import cn.com.businessservicesplatform.model.mysql.BaseUserCompany;
import cn.com.businessservicesplatform.model.vo.BaseUserCompanyVo;

import java.util.List;

public interface BaseUserCompanyService {
	
	public int insert(BaseUserCompanyVo vo);
	
	public BaseUserCompanyVo getBaseUserAllCompany(Integer userId);
	
	public BaseUserCompany getUserCompany(BaseUserCompanyVo baseUserCompanyVo);
	
	public BaseUserCompanyVo getUserAllCompany(Integer id);


	/**
	 * 获取所有的企业
	 * @param baseUserCompanyVo
	 * @return
     */
	List<BaseUserCompanyVo> getAllUserCompanys(BaseUserCompanyVo baseUserCompanyVo);
}
