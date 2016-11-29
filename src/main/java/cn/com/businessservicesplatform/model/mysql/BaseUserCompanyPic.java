package cn.com.businessservicesplatform.model.mysql;

import java.util.Date;

public class BaseUserCompanyPic {
    private Integer id;

    private Integer companyId;

    private String companyPicUrl;

    private Integer status;

    private Date modifyTime;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyPicUrl() {
        return companyPicUrl;
    }

    public void setCompanyPicUrl(String companyPicUrl) {
        this.companyPicUrl = companyPicUrl == null ? null : companyPicUrl.trim();
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
}