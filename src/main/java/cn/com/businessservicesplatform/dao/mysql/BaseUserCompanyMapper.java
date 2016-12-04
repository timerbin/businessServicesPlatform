package cn.com.businessservicesplatform.dao.mysql;

import cn.com.businessservicesplatform.model.mysql.BaseUserCompany;
import cn.com.businessservicesplatform.model.vo.BaseUserCompanyVo;

import java.util.List;

public interface BaseUserCompanyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseUserCompany record);

    int insertSelective(BaseUserCompany record);

    BaseUserCompany selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseUserCompany record);

    int updateByPrimaryKey(BaseUserCompany record);
    
    BaseUserCompany getUserCompany(BaseUserCompanyVo baseUserCompanyVo);

    List<BaseUserCompany> getAllUserCompanys(BaseUserCompanyVo baseUserCompanyVo);
    
}