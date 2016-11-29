package cn.com.businessservicesplatform.dao.mysql;

import cn.com.businessservicesplatform.model.mysql.UserCollectHistory;

public interface UserCollectHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserCollectHistory record);

    int insertSelective(UserCollectHistory record);

    UserCollectHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserCollectHistory record);

    int updateByPrimaryKey(UserCollectHistory record);
}