package cn.com.businessservicesplatform.model.mysql;

import java.util.Date;

import cn.com.businessservicesplatform.model.vo.BaseUserCompanyVo;

public class BaseUserCompany {
    private Integer id;

    private Integer userId;

    private String companyName;

    private String companyAddress;

    private String companyContactUser;

    private String companyContactTel;

    private String companyUrl;

    private String companyRegisterMoney;

    private Date companyRegisterTime;

    private String companyDirections;

    private Integer companyScope;

    private Integer companyType;

    private Integer status;

    private Date modifyTime;

    private Date createTime;

    private Date verifyTime;

    private Integer verifyUserId;

    private String verifyUserName;

    private String verifyUserDes;
    
    private Integer recommend;
    
    public BaseUserCompany(){}
    
    
    public BaseUserCompany(BaseUserCompanyVo baseUserCompany){
    	this.setId(baseUserCompany.getId());
		this.setUserId(baseUserCompany.getUserId());
		this.setCompanyAddress(baseUserCompany.getCompanyAddress());
		this.setCompanyContactTel(baseUserCompany.getCompanyContactTel());
		this.setCompanyContactUser(baseUserCompany.getCompanyContactUser());
		this.setCompanyDirections(baseUserCompany.getCompanyDirections());
		this.setCompanyName(baseUserCompany.getCompanyName());
		this.setCompanyRegisterMoney(baseUserCompany.getCompanyRegisterMoney());
		this.setCompanyRegisterTime(baseUserCompany.getCompanyRegisterTime());
		this.setCompanyScope(baseUserCompany.getCompanyScope());
		this.setCompanyType(baseUserCompany.getCompanyType());
		this.setStatus(baseUserCompany.getStatus());
		this.setCompanyUrl(baseUserCompany.getCompanyUrl());
		this.setCreateTime(baseUserCompany.getCreateTime());
		this.setModifyTime(baseUserCompany.getModifyTime());
		this.setRecommend(baseUserCompany.getRecommend());
	}
    
    public BaseUserCompany make(BaseUserCompany baseUserCompany,BaseUserCompanyVo baseUserCompanyVo){
		baseUserCompany.setUserId(baseUserCompanyVo.getUserId());
		baseUserCompany.setCompanyAddress(baseUserCompanyVo.getCompanyAddress());
		baseUserCompany.setCompanyContactTel(baseUserCompanyVo.getCompanyContactTel());
		baseUserCompany.setCompanyContactUser(baseUserCompanyVo.getCompanyContactUser());
		baseUserCompany.setCompanyDirections(baseUserCompanyVo.getCompanyDirections());
		baseUserCompany.setCompanyName(baseUserCompanyVo.getCompanyName());
		baseUserCompany.setCompanyRegisterMoney(baseUserCompanyVo.getCompanyRegisterMoney());
		baseUserCompany.setCompanyRegisterTime(baseUserCompanyVo.getCompanyRegisterTime());
		baseUserCompany.setCompanyScope(baseUserCompanyVo.getCompanyScope());
		baseUserCompany.setCompanyType(baseUserCompanyVo.getCompanyType());
		baseUserCompany.setCompanyUrl(baseUserCompanyVo.getCompanyUrl());
		baseUserCompany.setRecommend(baseUserCompany.getRecommend());
		return baseUserCompany;
	}

    public Integer getRecommend() {
		return recommend;
	}


	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}


	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress == null ? null : companyAddress.trim();
    }

    public String getCompanyContactUser() {
        return companyContactUser;
    }

    public void setCompanyContactUser(String companyContactUser) {
        this.companyContactUser = companyContactUser == null ? null : companyContactUser.trim();
    }

    public String getCompanyContactTel() {
        return companyContactTel;
    }

    public void setCompanyContactTel(String companyContactTel) {
        this.companyContactTel = companyContactTel == null ? null : companyContactTel.trim();
    }

    public String getCompanyUrl() {
        return companyUrl;
    }

    public void setCompanyUrl(String companyUrl) {
        this.companyUrl = companyUrl == null ? null : companyUrl.trim();
    }

    public String getCompanyRegisterMoney() {
        return companyRegisterMoney;
    }

    public void setCompanyRegisterMoney(String companyRegisterMoney) {
        this.companyRegisterMoney = companyRegisterMoney == null ? null : companyRegisterMoney.trim();
    }

    public Date getCompanyRegisterTime() {
        return companyRegisterTime;
    }

    public void setCompanyRegisterTime(Date companyRegisterTime) {
        this.companyRegisterTime = companyRegisterTime;
    }

    public String getCompanyDirections() {
        return companyDirections;
    }

    public void setCompanyDirections(String companyDirections) {
        this.companyDirections = companyDirections == null ? null : companyDirections.trim();
    }

    public Integer getCompanyScope() {
        return companyScope;
    }

    public void setCompanyScope(Integer companyScope) {
        this.companyScope = companyScope;
    }

    public Integer getCompanyType() {
        return companyType;
    }

    public void setCompanyType(Integer companyType) {
        this.companyType = companyType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getVerifyTime() {
        return verifyTime;
    }

    public void setVerifyTime(Date verifyTime) {
        this.verifyTime = verifyTime;
    }

    public Integer getVerifyUserId() {
        return verifyUserId;
    }

    public void setVerifyUserId(Integer verifyUserId) {
        this.verifyUserId = verifyUserId;
    }

    public String getVerifyUserName() {
        return verifyUserName;
    }

    public void setVerifyUserName(String verifyUserName) {
        this.verifyUserName = verifyUserName == null ? null : verifyUserName.trim();
    }

    public String getVerifyUserDes() {
        return verifyUserDes;
    }

    public void setVerifyUserDes(String verifyUserDes) {
        this.verifyUserDes = verifyUserDes == null ? null : verifyUserDes.trim();
    }
}