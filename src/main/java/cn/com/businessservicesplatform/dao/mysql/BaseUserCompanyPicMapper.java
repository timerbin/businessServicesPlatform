package cn.com.businessservicesplatform.dao.mysql;

import cn.com.businessservicesplatform.model.mysql.BaseUserCompanyPic;

public interface BaseUserCompanyPicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseUserCompanyPic record);

    int insertSelective(BaseUserCompanyPic record);

    BaseUserCompanyPic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseUserCompanyPic record);

    int updateByPrimaryKey(BaseUserCompanyPic record);
}