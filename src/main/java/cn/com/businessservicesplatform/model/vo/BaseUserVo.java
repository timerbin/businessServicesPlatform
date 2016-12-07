package cn.com.businessservicesplatform.model.vo;

import cn.com.businessservicesplatform.model.mysql.BaseUser;

public class BaseUserVo extends BaseUser {
	
	 public BaseUserVo(){}
	 
	 public BaseUserVo(BaseUser baseUser){
		 super.setEmail(baseUser.getEmail());
		 super.setMobilePhoneNumber(baseUser.getMobilePhoneNumber());
		 super.setId(baseUser.getId());
		 super.setUserName(baseUser.getUserName());
		 super.setTrueName(baseUser.getTrueName());
		 super.setType(baseUser.getType());
		 super.setUserStatus(baseUser.getUserStatus());
		 super.setUserSex(baseUser.getUserSex());
	 }
	
	 private String userPassword2;
	 
	 private String oldUserPassword;
	 
	 private String callbackUrl;
	 
	 private String verifyCode;
	 
	 private Integer companyId;
	 

 
	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getUserPassword2() {
		return userPassword2;
	}

	public void setUserPassword2(String userPassword2) {
		this.userPassword2 = userPassword2;
	}

	public String getOldUserPassword() {
		return oldUserPassword;
	}

	public void setOldUserPassword(String oldUserPassword) {
		this.oldUserPassword = oldUserPassword;
	}

	 
}
