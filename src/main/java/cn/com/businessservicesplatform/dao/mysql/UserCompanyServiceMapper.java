package cn.com.businessservicesplatform.dao.mysql;

import cn.com.businessservicesplatform.model.mysql.UserCompanyService;
import cn.com.businessservicesplatform.model.vo.UserCompanyServiceVo;

import java.util.List;

public interface UserCompanyServiceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserCompanyService record);

    int insertSelective(UserCompanyService record);

    UserCompanyService selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserCompanyService record);

    int updateByPrimaryKeyWithBLOBs(UserCompanyService record);

    int updateByPrimaryKey(UserCompanyService record);

    UserCompanyServiceVo getUserCompanyService(UserCompanyService record);

    List<UserCompanyServiceVo> getAllUserCompanyServices(UserCompanyServiceVo record);
}