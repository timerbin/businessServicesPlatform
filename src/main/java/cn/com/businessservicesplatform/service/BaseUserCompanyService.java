package cn.com.businessservicesplatform.service;

import cn.com.businessservicesplatform.common.util.BasePage;
import cn.com.businessservicesplatform.model.mysql.BaseUserCompany;
import cn.com.businessservicesplatform.model.vo.BaseUserCompanyVo;

import java.util.List;

public interface BaseUserCompanyService {
	
	public int insert(BaseUserCompanyVo vo);
	
	public BaseUserCompanyVo getBaseUserAllCompany(Integer userId);
	
	public BaseUserCompany getUserCompany(BaseUserCompanyVo baseUserCompanyVo);
	
	public BaseUserCompanyVo getUserAllCompany(Integer id);

	List<BaseUserCompanyVo> getAllUserCompanys(BaseUserCompanyVo baseUserCompanyVo);

	public List<BaseUserCompanyVo> queryPage(BasePage basePage,BaseUserCompanyVo vo);

	public List<BaseUserCompanyVo> queryPageAll(BasePage basePage,BaseUserCompanyVo vo);

	public List<BaseUserCompanyVo> queryList(BaseUserCompanyVo vo);

	int updateCompany(BaseUserCompanyVo vo);

	public void deleteCompany(BaseUserCompanyVo vo);
	
	List<BaseUserCompanyVo> queryAllList(BaseUserCompanyVo vo);

}
