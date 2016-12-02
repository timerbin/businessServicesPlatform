package cn.com.businessservicesplatform.dao.mysql;

import org.apache.ibatis.annotations.Param;

import cn.com.businessservicesplatform.model.mysql.UserLookHistory;
import cn.com.businessservicesplatform.model.vo.UserLookHistoryVo;

public interface UserLookHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserLookHistory record);

    int insertSelective(UserLookHistory record);

    UserLookHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserLookHistory record);

    int updateByPrimaryKey(UserLookHistory record);
    
    UserLookHistory getByVo(@Param("vo")UserLookHistoryVo UserLookHistoryVo);
}