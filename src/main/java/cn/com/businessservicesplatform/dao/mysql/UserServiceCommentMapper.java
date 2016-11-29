package cn.com.businessservicesplatform.dao.mysql;

import cn.com.businessservicesplatform.model.mysql.UserServiceComment;

public interface UserServiceCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserServiceComment record);

    int insertSelective(UserServiceComment record);

    UserServiceComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserServiceComment record);

    int updateByPrimaryKeyWithBLOBs(UserServiceComment record);

    int updateByPrimaryKey(UserServiceComment record);
}