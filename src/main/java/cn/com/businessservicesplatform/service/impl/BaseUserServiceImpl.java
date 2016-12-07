package cn.com.businessservicesplatform.service.impl;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger log = LoggerFactory.getLogger(BaseUserService.class);
	@Autowired
	BaseUserMapper baseUserMapper;
	
	@Override
	public BaseUser selectByPrimaryKey(Integer id){
		return baseUserMapper.selectByPrimaryKey(id);
	}

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
		if(!StringUtils.isBlank(baseUserVo.getLoginPwd())){
			baseUserVo.setLoginPwd(MD5Util.getMD5(baseUserVo.getLoginPwd()));
		}
		return baseUserMapper.findBaseUser(baseUserVo);
	}

	@Override
	public int updatePassword(BaseUserVo baseUserVo) {
		int result = 0;
		if(null == baseUserVo || baseUserVo.getId() == null){
			log.error("BaseUserService.updatePassword.is.null");
			return result;
		}
		BaseUser baseUser = baseUserMapper.selectByPrimaryKey(baseUserVo.getId());
		if(null == baseUser){
			log.error("BaseUserService.updatePassword.obj.is.null:"+baseUserVo.getId());
			return result;
		}
		baseUserVo.setOldLoginPwd(MD5Util.getMD5(baseUserVo.getOldLoginPwd()));
		if(!baseUserVo.getOldLoginPwd().equals(baseUser.getLoginPwd())){
			log.error("BaseUserService.updatePassword.oldPwd.is.error:"+baseUserVo.getId());
			result = -2;
			return result;
		}
		baseUser.setLoginPwd(MD5Util.getMD5(baseUserVo.getLoginPwd()));
		baseUser.setModifyTime(new Date());
		result = baseUserMapper.updateByPrimaryKey(baseUser);
		
		return result;
	}

	@Override
	public int updateUserInfo(BaseUserVo baseUserVo) {
		int result = 0;
		if(null == baseUserVo || baseUserVo.getId() == null){
			log.error("BaseUserService.updateUserInfo.is.null");
			return result;
		}
		BaseUser baseUser = baseUserMapper.selectByPrimaryKey(baseUserVo.getId());
		if(null == baseUser){
			log.error("BaseUserService.updateUserInfo.obj.is.null:"+baseUserVo.getId());
			return result;
		}
		baseUser.setRaleName(baseUserVo.getRaleName());
		baseUser.setAge(baseUserVo.getAge());
		baseUser.setEmail(baseUserVo.getEmail());
		baseUser.setMobilePhone(baseUserVo.getMobilePhone());
		baseUser.setSex(baseUserVo.getSex());
		baseUser.setModifyTime(new Date());
		result = baseUserMapper.updateByPrimaryKey(baseUser);
		return result;
	}

	 

}
