package cn.com.businessservicesplatform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.businessservicesplatform.dao.mysql.BaseUserMapper;
import cn.com.businessservicesplatform.model.mysql.BaseUser;
import cn.com.businessservicesplatform.model.vo.BaseUserVo;
import cn.com.businessservicesplatform.service.BaseUserService;

@Service
public class BaseUserServiceImpl implements BaseUserService{
	
	@Autowired
	BaseUserMapper baseUserMapper;

	@Override
	public Integer register(BaseUserVo baseUserVo) {
		return baseUserMapper.insert(baseUserVo);
	}

	@Override
	public BaseUser findBaseUser(BaseUserVo baseUserVo) {
		return baseUserMapper.findBaseUser(baseUserVo);
	}

	 

}
