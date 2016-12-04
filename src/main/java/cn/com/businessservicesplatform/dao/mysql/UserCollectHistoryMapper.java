package cn.com.businessservicesplatform.dao.mysql;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.businessservicesplatform.model.mysql.UserCollectHistory;
import cn.com.businessservicesplatform.model.vo.UserCollectHistoryVo;

public interface UserCollectHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserCollectHistory record);

    int insertSelective(UserCollectHistory record);

    UserCollectHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserCollectHistory record);

    int updateByPrimaryKey(UserCollectHistory record);
    
    UserCollectHistory getCollect(@Param("vo") UserCollectHistoryVo vo);
    
    public List<UserCollectHistoryVo> queryList(UserCollectHistoryVo userCollectHistoryVo);
}