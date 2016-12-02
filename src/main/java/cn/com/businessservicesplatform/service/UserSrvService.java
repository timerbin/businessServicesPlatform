package cn.com.businessservicesplatform.service;

import cn.com.businessservicesplatform.common.util.BasePage;
import cn.com.businessservicesplatform.model.mysql.BaseConfigData;
import cn.com.businessservicesplatform.model.mysql.UserServiceComment;
import cn.com.businessservicesplatform.model.vo.BaseConfigDataVo;
import cn.com.businessservicesplatform.model.vo.UserServiceVo;

import java.util.List;

public interface UserSrvService {
	
	public int addUserService(UserServiceVo vo);

}
