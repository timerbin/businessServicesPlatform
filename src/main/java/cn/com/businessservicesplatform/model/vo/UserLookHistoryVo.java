package cn.com.businessservicesplatform.model.vo;

import cn.com.businessservicesplatform.model.mysql.UserLookHistory;

public class UserLookHistoryVo extends UserLookHistory {
	
	public UserLookHistoryVo(){}
	
	public UserLookHistoryVo(Integer userId, Integer serverId,Integer companyId,Integer type){
		super.setUserId(userId);
		super.setServiceId(serverId);
		super.setCompanyId(companyId);
		super.setType(type);
	}


}
