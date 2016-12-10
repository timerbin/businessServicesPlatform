package cn.com.businessservicesplatform.service;

import cn.com.businessservicesplatform.model.mysql.BaseUserSendInfo;

public interface BaseUserSendInfoService {
	
	public int insertEmailCode(Integer userId);
	
	public BaseUserSendInfo updateCheckCode(Integer userId);

}
