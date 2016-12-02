package cn.com.businessservicesplatform.service.impl;

import cn.com.businessservicesplatform.common.util.BasePage;
import cn.com.businessservicesplatform.dao.mysql.BaseConfigDataMapper;
import cn.com.businessservicesplatform.dao.mysql.UserServiceCommentMapper;
import cn.com.businessservicesplatform.model.mysql.BaseConfigData;
import cn.com.businessservicesplatform.model.vo.BaseConfigDataVo;
import cn.com.businessservicesplatform.model.vo.UserServiceVo;
import cn.com.businessservicesplatform.service.BaseConfigDataService;
import cn.com.businessservicesplatform.service.UserSrvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSrvServiceImpl implements UserSrvService{

	@Autowired
	UserServiceCommentMapper userServiceCommentMapper;

	@Override
	public int addUserService(UserServiceVo vo) {
		return userServiceCommentMapper.insert(vo);
	}
}
