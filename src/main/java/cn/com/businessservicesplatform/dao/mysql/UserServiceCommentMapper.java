package cn.com.businessservicesplatform.dao.mysql;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.businessservicesplatform.common.util.BasePage;
import cn.com.businessservicesplatform.model.mysql.UserServiceComment;
import cn.com.businessservicesplatform.model.vo.UserServiceCommentVo;

public interface UserServiceCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserServiceComment record);

    int insertSelective(UserServiceComment record);

    UserServiceComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserServiceComment record);

    int updateByPrimaryKeyWithBLOBs(UserServiceComment record);

    int updateByPrimaryKey(UserServiceComment record);
    
    public List<UserServiceCommentVo> queryPage(@Param("basePage")BasePage basePage, @Param("vo")UserServiceCommentVo vo); 
}