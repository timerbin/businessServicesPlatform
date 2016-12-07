package cn.com.businessservicesplatform.dao.mysql;

import java.util.List;

import cn.com.businessservicesplatform.model.mysql.UserServiceCommentTag;

public interface UserServiceCommentTagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserServiceCommentTag record);

    int insertSelective(UserServiceCommentTag record);

    UserServiceCommentTag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserServiceCommentTag record);

    int updateByPrimaryKey(UserServiceCommentTag record);
    
    
    List<UserServiceCommentTag> getList(Integer commentId);
}