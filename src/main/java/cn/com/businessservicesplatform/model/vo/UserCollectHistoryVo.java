package cn.com.businessservicesplatform.model.vo;

import cn.com.businessservicesplatform.model.mysql.UserCollectHistory;

public class UserCollectHistoryVo extends UserCollectHistory {
	
	private BaseUserCompanyVo baseUserCompanyVo;
	
	private UserCompanyServiceVo userCompanyServiceVo;

	public BaseUserCompanyVo getBaseUserCompanyVo() {
		return baseUserCompanyVo;
	}

	public void setBaseUserCompanyVo(BaseUserCompanyVo baseUserCompanyVo) {
		this.baseUserCompanyVo = baseUserCompanyVo;
	}

	public UserCompanyServiceVo getUserCompanyServiceVo() {
		return userCompanyServiceVo;
	}

	public void setUserCompanyServiceVo(UserCompanyServiceVo userCompanyServiceVo) {
		this.userCompanyServiceVo = userCompanyServiceVo;
	}
    
}