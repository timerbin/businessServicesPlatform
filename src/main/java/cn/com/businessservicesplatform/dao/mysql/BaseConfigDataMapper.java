package cn.com.businessservicesplatform.dao.mysql;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.businessservicesplatform.common.util.BasePage;
import cn.com.businessservicesplatform.model.mysql.BaseConfigData;
import cn.com.businessservicesplatform.model.vo.BaseConfigDataVo;

public interface BaseConfigDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseConfigData record);

    int insertSelective(BaseConfigData record);

    BaseConfigData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseConfigData record);

    int updateByPrimaryKey(BaseConfigData record);
    
    public List<BaseConfigData> queryPage(@Param("basePage")BasePage basePage,@Param("base") BaseConfigDataVo baseConfigDataVo);
}