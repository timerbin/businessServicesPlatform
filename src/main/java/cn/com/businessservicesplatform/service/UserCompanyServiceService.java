package cn.com.businessservicesplatform.service;

import java.util.List;

import cn.com.businessservicesplatform.common.util.BasePage;
import cn.com.businessservicesplatform.model.mysql.UserCompanyService;
import cn.com.businessservicesplatform.model.vo.UserCompanyServiceVo;



/**
 * Created by John on 2016/12/3.
 */
public interface UserCompanyServiceService {
   public int insert(UserCompanyServiceVo vo);

   public UserCompanyServiceVo fetchCompanyService(UserCompanyServiceVo vo);
   
   public UserCompanyServiceVo getAllService(Integer id);

   List<UserCompanyService> getAllUserCompanyServices(UserCompanyServiceVo vo);

   public List<UserCompanyServiceVo> queryPage(BasePage basePage, UserCompanyServiceVo vo);

   public List<UserCompanyServiceVo> queryPageAll(BasePage basePage, UserCompanyServiceVo vo);


   public List<UserCompanyServiceVo> queryLikeList(Integer queryRows);

   public List<UserCompanyServiceVo> queryList(UserCompanyServiceVo vo);

   public int updateByPrimaryKeySelective(UserCompanyServiceVo vo);

   public int delCompanyServiceByid(Integer id);
}
