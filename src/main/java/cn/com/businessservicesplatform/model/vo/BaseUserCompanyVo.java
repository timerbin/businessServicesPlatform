package cn.com.businessservicesplatform.model.vo;

import java.util.List;

import cn.com.businessservicesplatform.model.mysql.BaseUserCompany;
import cn.com.businessservicesplatform.model.mysql.BaseUserCompanyPic;

public class BaseUserCompanyVo extends BaseUserCompany {
	
	private String companyRegisterTimeStr;
	
	private List<BaseUserCompanyPic>  picList;
	
	public  String  picListStr;

	public String getPicListStr() {
		return picListStr;
	}

	public void setPicListStr(String picListStr) {
		this.picListStr = picListStr;
	}

	public List<BaseUserCompanyPic> getPicList() {
		return picList;
	}

	public void setPicList(List<BaseUserCompanyPic> picList) {
		this.picList = picList;
	}

	public String getCompanyRegisterTimeStr() {
		return companyRegisterTimeStr;
	}

	public void setCompanyRegisterTimeStr(String companyRegisterTimeStr) {
		this.companyRegisterTimeStr = companyRegisterTimeStr;
	}
	

	public BaseUserCompanyVo(){}
	
	public BaseUserCompanyVo(Integer userId){
		super.setUserId(userId);
	}
	public BaseUserCompanyVo(BaseUserCompany baseUserCompany){
		super.setId(baseUserCompany.getId());
		super.setUserId(baseUserCompany.getUserId());
		super.setCompanyAddress(baseUserCompany.getCompanyAddress());
		super.setCompanyContactTel(baseUserCompany.getCompanyContactTel());
		super.setCompanyContactUser(baseUserCompany.getCompanyContactUser());
		super.setCompanyDirections(baseUserCompany.getCompanyDirections());
		super.setCompanyName(baseUserCompany.getCompanyName());
		super.setCompanyRegisterMoney(baseUserCompany.getCompanyRegisterMoney());
		super.setCompanyRegisterTime(baseUserCompany.getCompanyRegisterTime());
		super.setCompanyScope(baseUserCompany.getCompanyScope());
		super.setCompanyType(baseUserCompany.getCompanyType());
		super.setStatus(baseUserCompany.getStatus());
		super.setCompanyUrl(baseUserCompany.getCompanyUrl());
		super.setCreateTime(baseUserCompany.getCreateTime());
		super.setModifyTime(baseUserCompany.getModifyTime());
	}
	

}
