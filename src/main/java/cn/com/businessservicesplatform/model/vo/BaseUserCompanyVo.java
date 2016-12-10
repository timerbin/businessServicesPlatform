package cn.com.businessservicesplatform.model.vo;

import java.util.List;

import cn.com.businessservicesplatform.common.constants.UserServiceStatuesEnum;
import org.apache.commons.lang.StringUtils;

import cn.com.businessservicesplatform.common.util.DateUtils;
import cn.com.businessservicesplatform.model.mysql.BaseUserCompany;
import cn.com.businessservicesplatform.model.mysql.BaseUserCompanyPic;

public class BaseUserCompanyVo extends BaseUserCompany {
	
	private String companyRegisterTimeStr;
	
	private List<BaseUserCompanyPic>  picList;
	
	private  String  picListStr;
	
	private String logoPicPath;
	
	private String queryStr;
	
	private Integer queryRows=10;

	private String statusStr;

	private String msg;


	public BaseUserVo getUserVo() {
		return userVo;
	}

	public void setUserVo(BaseUserVo userVo) {
		this.userVo = userVo;
	}

	/****管理员创建企业包含 用户信息*****/
	private BaseUserVo userVo;
	/***********END********************/

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getStatusStr() {
		String str = "";
		if(super.getStatus() != null){
			str = UserServiceStatuesEnum.get(super.getStatus()).getDes();
			this.setStatusStr(str);
		}
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}

	public Integer getQueryRows() {
		return queryRows;
	}

	public void setQueryRows(Integer queryRows) {
		this.queryRows = queryRows;
	}

	public String getQueryStr() {
		return queryStr;
	}

	public void setQueryStr(String queryStr) {
		this.queryStr = queryStr;
	}

	public String getLogoPicPath() {
		if(null != picList && picList.size() > 0){
			BaseUserCompanyPic pic = picList.get(0);
			if(null != pic && !StringUtils.isBlank(pic.getCompanyPicUrl())){
				this.setLogoPicPath(pic.getCompanyPicUrl());
			}
		}
		return logoPicPath;
	}

	public void setLogoPicPath(String logoPicPath) {
		this.logoPicPath = logoPicPath;
	}

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
		try {
			if(StringUtils.isBlank(companyRegisterTimeStr) && null != super.getCompanyRegisterTime()){
				setCompanyRegisterTimeStr(DateUtils.getString(super.getCompanyRegisterTime(), "yyyy年MM月dd日"));
			}
		} catch (Exception e) {
		}
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
