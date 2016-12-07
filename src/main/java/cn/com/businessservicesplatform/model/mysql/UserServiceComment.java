package cn.com.businessservicesplatform.model.mysql;

import java.util.Date;

import cn.com.businessservicesplatform.model.vo.UserServiceCommentVo;

public class UserServiceComment {
    private Integer id;

    private Integer userId;

    private Integer companyId;

    private Integer serviceId;

    private Integer commentUserId;

    private String commentUserName;

    private Integer commentType;

    private Integer status;

    private Date modifyTime;

    private Date createTime;

    private Date verifyTime;

    private Integer verifyUserId;

    private String verifyUserName;

    private String verifyUserDes;

    private String commentDirections;
    
    public UserServiceComment(){}
    
    
    
    
    public UserServiceComment(UserServiceCommentVo vo) {
		this.userId = vo.getUserId();
		this.companyId = vo.getCompanyId();
		this.serviceId = vo.getServiceId();
		this.commentUserId = vo.getCommentUserId();
		this.commentUserName = vo.getCommentUserName();
		this.commentType = vo.getCommentType();
		this.commentDirections = vo.getCommentDirections();
	}




	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
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

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(Integer commentUserId) {
        this.commentUserId = commentUserId;
    }

    public String getCommentUserName() {
        return commentUserName;
    }

    public void setCommentUserName(String commentUserName) {
        this.commentUserName = commentUserName == null ? null : commentUserName.trim();
    }

    public Integer getCommentType() {
        return commentType;
    }

    public void setCommentType(Integer commentType) {
        this.commentType = commentType;
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

    public String getCommentDirections() {
        return commentDirections;
    }

    public void setCommentDirections(String commentDirections) {
        this.commentDirections = commentDirections == null ? null : commentDirections.trim();
    }
}