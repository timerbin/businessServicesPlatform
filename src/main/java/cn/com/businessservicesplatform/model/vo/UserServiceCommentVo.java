package cn.com.businessservicesplatform.model.vo;

import java.util.List;


import cn.com.businessservicesplatform.common.util.DateUtils;
import cn.com.businessservicesplatform.model.mysql.UserServiceComment;
import cn.com.businessservicesplatform.model.mysql.UserServiceCommentTag;

public class UserServiceCommentVo extends UserServiceComment {
	
	public UserServiceCommentVo(){}
	
	public UserServiceCommentVo(Integer serviceId){
		super.setServiceId(serviceId);
	}

	private List<UserServiceCommentTag>  tagList;
	
	private Integer querySize;
	private Integer allSize;
	private Integer goodSize=0;
	private Integer middleSize=0;
	private Integer badSiz = 0;
	private String tagIds;
	
	private String commentTypeStr;
	
	private String createTimeStr;
	
	public String getCreateTimeStr() {
		try {
			if(null != super.getCreateTime()){
				setCreateTimeStr(DateUtils.getString(super.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
			}
		} catch (Exception e) {
		}
		return createTimeStr;
	}
	
	

	public String getCommentTypeStr() {
		return commentTypeStr;
	}

	public void setCommentTypeStr(String commentTypeStr) {
		this.commentTypeStr = commentTypeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	public String getTagIds() {
		return tagIds;
	}
	public void setTagIds(String tagIds) {
		this.tagIds = tagIds;
	}
	public Integer getQuerySize() {
		return querySize;
	}
	public void setQuerySize(Integer querySize) {
		this.querySize = querySize;
	}
	
	public List<UserServiceCommentTag> getTagList() {
		return tagList;
	}
	public void setTagList(List<UserServiceCommentTag> tagList) {
		this.tagList = tagList;
	}
	public Integer getAllSize() {
		setAllSize(goodSize+middleSize+badSiz);
		return allSize;
	}
	public void setAllSize(Integer allSize) {
		this.allSize = allSize;
	}
	public Integer getGoodSize() {
		return goodSize;
	}
	public void setGoodSize(Integer goodSize) {
		this.goodSize = goodSize;
	}
	public Integer getMiddleSize() {
		return middleSize;
	}
	public void setMiddleSize(Integer middleSize) {
		this.middleSize = middleSize;
	}
	public Integer getBadSiz() {
		return badSiz;
	}
	public void setBadSiz(Integer badSiz) {
		this.badSiz = badSiz;
	}
	
	
}