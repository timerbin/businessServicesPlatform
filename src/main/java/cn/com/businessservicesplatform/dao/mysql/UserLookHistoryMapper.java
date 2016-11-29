package cn.com.businessservicesplatform.dao.mysql;

import cn.com.businessservicesplatform.model.mysql.UserLookHistory;

public interface UserLookHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserLookHistory record);

    int insertSelective(UserLookHistory record);

    UserLookHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserLookHistory record);

    int updateByPrimaryKey(UserLookHistory record);
}