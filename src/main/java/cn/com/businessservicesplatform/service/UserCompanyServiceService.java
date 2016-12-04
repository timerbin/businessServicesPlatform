package cn.com.businessservicesplatform.service;

import java.util.List;

import cn.com.businessservicesplatform.common.util.BasePage;
import cn.com.businessservicesplatform.model.vo.UserCompanyServiceVo;


/**
 * Created by John on 2016/12/3.
 */
public interface UserCompanyServiceService {
   public int insert(UserCompanyServiceVo vo);

   public UserCompanyServiceVo fetchCompanyService(UserCompanyServiceVo vo);
   
   public UserCompanyServiceVo getAllService(Integer id);
   
   public List<UserCompanyServiceVo> queryPage(BasePage basePage,UserCompanyServiceVo vo);
   
   public List<UserCompanyServiceVo> queryLikeList();
}
