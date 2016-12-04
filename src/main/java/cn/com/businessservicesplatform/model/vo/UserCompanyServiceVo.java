package cn.com.businessservicesplatform.model.vo;

import cn.com.businessservicesplatform.model.mysql.UserCompanyService;

public class UserCompanyServiceVo extends UserCompanyService {
	
	public UserCompanyServiceVo(){}
	
	public String serviceTypeStr;
	
    public UserCompanyServiceVo(UserCompanyService userCompanyService){
    	super.setCompanyId(userCompanyService.getCompanyId());
    	super.setServiceContactTel(userCompanyService.getServiceContactTel());
    	super.setServiceContactUser(userCompanyService.getServiceContactUser());
    	super.setServiceDirections(userCompanyService.getServiceDirections());
    	super.setServiceName(userCompanyService.getServiceName());
    	super.setServiceType(userCompanyService.getServiceType());
    	super.setStatus(userCompanyService.getStatus());
    	super.setUserId(userCompanyService.getUserId());
    	super.setId(userCompanyService.getId());
    	super.setCreateTime(userCompanyService.getCreateTime());
    	super.setModifyTime(userCompanyService.getModifyTime());
    }

	public String getServiceTypeStr() {
		return serviceTypeStr;
	}

	public void setServiceTypeStr(String serviceTypeStr) {
		this.serviceTypeStr = serviceTypeStr;
	}
    
    
}