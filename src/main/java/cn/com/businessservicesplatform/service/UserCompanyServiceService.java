package cn.com.businessservicesplatform.service;

import cn.com.businessservicesplatform.model.mysql.UserCompanyService;
import cn.com.businessservicesplatform.model.vo.UserCompanyServiceVo;

import java.util.List;


/**
 * Created by John on 2016/12/3.
 */
public interface UserCompanyServiceService {

   public int insert(UserCompanyServiceVo vo);

   public UserCompanyServiceVo fetchCompanyService(UserCompanyServiceVo vo);
   
   public UserCompanyServiceVo getAllService(Integer id);

   List<UserCompanyServiceVo> getAllUserCompanyServices(UserCompanyServiceVo vo);
}
