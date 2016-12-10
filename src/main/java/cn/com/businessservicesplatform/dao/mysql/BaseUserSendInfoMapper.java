package cn.com.businessservicesplatform.dao.mysql;

import org.apache.ibatis.annotations.Param;

import cn.com.businessservicesplatform.model.mysql.BaseUserSendInfo;

public interface BaseUserSendInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseUserSendInfo record);

    int insertSelective(BaseUserSendInfo record);

    BaseUserSendInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseUserSendInfo record);

    int updateByPrimaryKey(BaseUserSendInfo record);
    
    BaseUserSendInfo select(@Param("userId")Integer userId,@Param("email")String email);
}