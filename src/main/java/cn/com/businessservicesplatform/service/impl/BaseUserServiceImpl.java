package cn.com.businessservicesplatform.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.businessservicesplatform.common.constants.BaseUserTypeEnum;
import cn.com.businessservicesplatform.common.util.MD5Util;
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
		baseUserVo.setLoginPwd(MD5Util.getMD5(baseUserVo.getLoginPwd()));
		baseUserVo.setCreateTime(new Date());
		baseUserVo.setStatus(1);
		baseUserVo.setModifyTime(new Date());
		baseUserVo.setType(BaseUserTypeEnum.GENERAL_USER.getId());
		return baseUserMapper.insert(baseUserVo);
	}

	@Override
	public BaseUser findBaseUser(BaseUserVo baseUserVo) {
		baseUserVo.setLoginPwd(MD5Util.getMD5(baseUserVo.getLoginPwd()));
		return baseUserMapper.findBaseUser(baseUserVo);
	}

	 

}
