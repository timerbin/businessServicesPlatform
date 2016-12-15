package cn.com.businessservicesplatform.model.vo;

import cn.com.businessservicesplatform.model.mysql.UserLookHistory;

public class UserLookHistoryVo extends UserLookHistory {

	private BaseUserCompanyVo baseUserCompanyVo;

	private UserCompanyServiceVo userCompanyServiceVo;

	private String findType;
	private Integer queryRows = 20;
	private String serviceName;
	private String userName;
	private String companyName;
	private String companyPicUrl;
	private String beginTime;
	
	
	public UserLookHistoryVo() {}


	public UserLookHistoryVo(UserLookHistory history) {
		super.setCompanyId(history.getCompanyId());
		super.setCreateTime(history.getCreateTime());
		super.setId(history.getId());
		super.setLookCount(history.getLookCount());
		super.setModifyTime(history.getModifyTime());
		super.setNowDate(history.getNowDate());
		super.setServiceId(history.getServiceId());
		super.setStatus(history.getStatus());
		super.setType(history.getType());
		super.setUserId(history.getUserId());
		super.setServiceType(history.getServiceType());
	}

	public UserLookHistoryVo(Integer userId, Integer serverId, Integer companyId, Integer type) {
		super.setUserId(userId);
		super.setServiceId(serverId);
		super.setCompanyId(companyId);
		super.setType(type);
	}

	public String getBeginTime() {
		return beginTime;
	}


	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public Integer getQueryRows() {
		return queryRows;
	}

	public void setQueryRows(Integer queryRows) {
		this.queryRows = queryRows;
	}

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

	public String getFindType() {
		if(this.findType == null && "".equals(this.findType)) {
			return findType = "0";
		}
		return findType;
	}

	public void setFindType(String findType) {
		this.findType = findType;
	}
}