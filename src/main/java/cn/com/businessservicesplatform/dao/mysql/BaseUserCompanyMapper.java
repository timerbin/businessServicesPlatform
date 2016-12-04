package cn.com.businessservicesplatform.dao.mysql;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.businessservicesplatform.common.util.BasePage;
import cn.com.businessservicesplatform.model.mysql.BaseUserCompany;
import cn.com.businessservicesplatform.model.vo.BaseUserCompanyVo;

public interface BaseUserCompanyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseUserCompany record);

    int insertSelective(BaseUserCompany record);

    BaseUserCompany selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseUserCompany record);

    int updateByPrimaryKey(BaseUserCompany record);
    
    BaseUserCompany getUserCompany(BaseUserCompanyVo baseUserCompanyVo);
    
    List<BaseUserCompanyVo> queryPage(@Param("basePage")BasePage basePage,@Param("vo")BaseUserCompanyVo vo);
}