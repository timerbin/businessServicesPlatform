package cn.com.businessservicesplatform.model.vo;

import cn.com.businessservicesplatform.model.mysql.UserLookHistory;

public class UserLookHistoryVo extends UserLookHistory {

	public UserLookHistoryVo() {
	}

	public UserLookHistoryVo(Integer userId, Integer serverId, Integer companyId, Integer type) {
		super.setUserId(userId);
		super.setServiceId(serverId);
		super.setCompanyId(companyId);
		super.setType(type);
	}


	private String userName;
	private String serviceName;
	private String companyName;
	private String companyPicUrl;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyPicUrl() {
		return companyPicUrl;
	}

	public void setCompanyPicUrl(String companyPicUrl) {
		this.companyPicUrl = companyPicUrl;
	}
}