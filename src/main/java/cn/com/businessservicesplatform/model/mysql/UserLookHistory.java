package cn.com.businessservicesplatform.model.mysql;

import java.util.Date;

import cn.com.businessservicesplatform.model.vo.UserLookHistoryVo;

public class UserLookHistory {
    private Integer id;

    private Integer userId;

    private Integer serviceId;

    private Integer companyId;

    private Integer lookCount;

    private Integer status;

    private Integer type;

    private String nowDate;

    private Date modifyTime;

    private Date createTime;
    
    public UserLookHistory(){}
    
    public UserLookHistory(UserLookHistoryVo userLookHistoryVo){
    	this.userId = userLookHistoryVo.getUserId();
    	this.serviceId = userLookHistoryVo.getServiceId();
    	this.type = userLookHistoryVo.getType();
    	this.companyId = userLookHistoryVo.getCompanyId();
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

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getLookCount() {
        return lookCount;
    }

    public void setLookCount(Integer lookCount) {
        this.lookCount = lookCount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getNowDate() {
        return nowDate;
    }

    public void setNowDate(String nowDate) {
        this.nowDate = nowDate == null ? null : nowDate.trim();
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
}