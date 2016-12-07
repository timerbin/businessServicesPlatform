package cn.com.businessservicesplatform.model.mysql;

import java.util.Date;

public class UserServiceCommentTag {
    private Integer id;

    private Integer commentId;

    private Integer commentTagId;
    
    private String commentTagName;

    private Integer status;

    private Date modifyTime;

    private Date createTime;
    

    public String getCommentTagName() {
		return commentTagName;
	}

	public void setCommentTagName(String commentTagName) {
		this.commentTagName = commentTagName;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Integer getCommentTagId() {
        return commentTagId;
    }

    public void setCommentTagId(Integer commentTagId) {
        this.commentTagId = commentTagId;
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