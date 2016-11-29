package cn.com.businessservicesplatform.dao.mysql;

import cn.com.businessservicesplatform.model.mysql.UserCompanyService;

public interface UserCompanyServiceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserCompanyService record);

    int insertSelective(UserCompanyService record);

    UserCompanyService selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserCompanyService record);

    int updateByPrimaryKeyWithBLOBs(UserCompanyService record);

    int updateByPrimaryKey(UserCompanyService record);
}