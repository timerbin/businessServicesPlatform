package cn.com.businessservicesplatform.dao.mysql;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.businessservicesplatform.common.util.BasePage;
import cn.com.businessservicesplatform.model.mysql.BaseUser;
import cn.com.businessservicesplatform.model.vo.BaseUserVo;

public interface BaseUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseUser record);

    int insertSelective(BaseUser record);

    BaseUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseUser record);

    int updateByPrimaryKey(BaseUser record);
    
    BaseUser findBaseUser(BaseUserVo baseUserVo);
    
    List<BaseUser> queryPage(@Param("basePage")BasePage basePage, @Param("vo")BaseUserVo baseUserVo);
}