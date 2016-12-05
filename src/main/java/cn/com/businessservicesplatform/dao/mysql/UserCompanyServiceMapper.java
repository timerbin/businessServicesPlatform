package cn.com.businessservicesplatform.dao.mysql;

import cn.com.businessservicesplatform.common.util.BasePage;
import cn.com.businessservicesplatform.model.mysql.UserCompanyService;
import cn.com.businessservicesplatform.model.vo.UserCompanyServiceVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserCompanyServiceMapper {
    int deleteByPrimaryKey(@Param("id")Integer id);

    int insert(UserCompanyService record);

    int insertSelective(UserCompanyService record);

    UserCompanyService selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserCompanyService record);

    int updateByPrimaryKeyWithBLOBs(UserCompanyService record);

    int updateByPrimaryKey(UserCompanyService record);

    UserCompanyServiceVo getUserCompanyService(UserCompanyService record);


    List<UserCompanyServiceVo> getAllUserCompanyServices(UserCompanyServiceVo record);

    List<UserCompanyServiceVo> queryPage(@Param("basePage")BasePage basePage,@Param("vo")UserCompanyServiceVo vo);
    
    public List<UserCompanyServiceVo> queryList(@Param("vo")UserCompanyServiceVo vo);

}