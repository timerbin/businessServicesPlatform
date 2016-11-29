package cn.com.businessservicesplatform.dao.mysql;

import cn.com.businessservicesplatform.model.mysql.BaseUserSendInfo;

public interface BaseUserSendInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseUserSendInfo record);

    int insertSelective(BaseUserSendInfo record);

    BaseUserSendInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseUserSendInfo record);

    int updateByPrimaryKey(BaseUserSendInfo record);
}