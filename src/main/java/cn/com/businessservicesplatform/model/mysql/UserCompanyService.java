package cn.com.businessservicesplatform.model.mysql;

import java.util.Date;

public class UserCompanyService {
    private Integer id;

    private Integer userId;

    private Integer companyId;

    private String serviceName;

    private String serviceContactUser;

    private String serviceContactTel;

    private Integer serviceType;

    private Integer status;

    private Date modifyTime;

    private Date createTime;

    private Date verifyTime;

    private Integer verifyUserId;

    private String verifyUserName;

    private String verifyUserDes;

    private String serviceDirections;

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

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? null : serviceName.trim();
    }

    public String getServiceContactUser() {
        return serviceContactUser;
    }

    public void setServiceContactUser(String serviceContactUser) {
        this.serviceContactUser = serviceContactUser == null ? null : serviceContactUser.trim();
    }

    public String getServiceContactTel() {
        return serviceContactTel;
    }

    public void setServiceContactTel(String serviceContactTel) {
        this.serviceContactTel = serviceContactTel == null ? null : serviceContactTel.trim();
    }

    public Integer getServiceType() {
        return serviceType;
    }

    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
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

    public String getServiceDirections() {
        return serviceDirections;
    }

    public void setServiceDirections(String serviceDirections) {
        this.serviceDirections = serviceDirections == null ? null : serviceDirections.trim();
    }
}