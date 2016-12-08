package cn.com.businessservicesplatform.model.vo;


import cn.com.businessservicesplatform.common.constants.BaseConfigTypeEnum;
import cn.com.businessservicesplatform.common.constants.RecommendEnum;
import cn.com.businessservicesplatform.common.util.DateUtils;
import cn.com.businessservicesplatform.model.mysql.BaseConfigData;
import cn.com.businessservicesplatform.model.mysql.UserCompanyService;

import java.util.List;

public class UserCompanyServiceVo extends UserCompanyService {
	
	public UserCompanyServiceVo(){}
	
	private String serviceTypeStr;
	public Integer queryRows = 20;
	
	private String createTimeStr;
	
	public BaseUserCompanyVo baseUserCompanyVo;
	private String statusStr;
	private String recommendStr; //是否推荐
	
	private Integer code;
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

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
		super.setRecommend(userCompanyService.getRecommend());
    }
    

	public Integer getCode() {
		return code;
	}




	public void setCode(Integer code) {
		this.code = code;
	}




	public String getCreateTimeStr() {
		try {
			if(null != super.getCreateTime()){
				this.setCreateTimeStr(DateUtils.getString(super.getCreateTime(), "yyyy-MM-dd HH:mm"));
			}
		} catch (Exception e) {
		}
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	public Integer getQueryRows() {
		return queryRows;
	}

	public void setQueryRows(Integer queryRows) {
		this.queryRows = queryRows;
	}

	public BaseUserCompanyVo getBaseUserCompanyVo() {
		return baseUserCompanyVo;
	}

	public void setBaseUserCompanyVo(BaseUserCompanyVo baseUserCompanyVo) {
		this.baseUserCompanyVo = baseUserCompanyVo;
	}

	public String getServiceTypeStr() {

		return serviceTypeStr;
	}

	public void setServiceTypeStr(String serviceTypeStr) {
		this.serviceTypeStr = serviceTypeStr;
	}


	public String getRecommendStr() {
		try {
			if(null != super.getRecommend()){
				this.setRecommendStr(RecommendEnum.get(super.getRecommend()).getDes());
			}
		} catch (Exception e) {
		}
		return recommendStr;
	}

	public void setRecommendStr(String recommendStr) {
		this.recommendStr = recommendStr;
	}

	public String getStatusStr() {
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}
    
    
}