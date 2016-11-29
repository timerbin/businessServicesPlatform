package cn.com.businessservicesplatform.dao.mysql;

import cn.com.businessservicesplatform.model.mysql.BaseConfigData;

public interface BaseConfigDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseConfigData record);

    int insertSelective(BaseConfigData record);

    BaseConfigData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseConfigData record);

    int updateByPrimaryKey(BaseConfigData record);
}