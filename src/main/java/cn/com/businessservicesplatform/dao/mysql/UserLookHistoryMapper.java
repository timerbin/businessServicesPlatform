package cn.com.businessservicesplatform.dao.mysql;

import java.util.List;

import cn.com.businessservicesplatform.common.util.BasePage;
import org.apache.ibatis.annotations.Param;

import cn.com.businessservicesplatform.model.mysql.UserLookHistory;
import cn.com.businessservicesplatform.model.vo.ServiceLookSizeVo;
import cn.com.businessservicesplatform.model.vo.UserLookHistoryVo;

public interface UserLookHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserLookHistory record);

    int insertSelective(UserLookHistory record);

    UserLookHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserLookHistory record);

    int updateByPrimaryKey(UserLookHistory record);
    
    UserLookHistory getByVo(@Param("vo")UserLookHistoryVo UserLookHistoryVo);
    
    public List<UserLookHistory> queryHistroyList(@Param("vo")UserLookHistoryVo userLookHistoryVo);

    public List<UserLookHistory> queryPage(@Param("basePage")BasePage basePage, @Param("vo")UserLookHistoryVo vo);

    int updateDelStatus(Integer id);

    List<String> queryHistoryDate();
    
    public List<UserLookHistory> queryTopHistroyList(@Param("vo")UserLookHistoryVo userLookHistoryVo);
    
    
    public List<ServiceLookSizeVo> queryLookSize(@Param("vo")UserLookHistoryVo userLookHistoryVo);

}