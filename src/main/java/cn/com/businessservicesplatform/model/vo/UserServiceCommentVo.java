package cn.com.businessservicesplatform.model.vo;

import java.util.List;

import cn.com.businessservicesplatform.model.mysql.UserServiceComment;

public class UserServiceCommentVo extends UserServiceComment {

	private List<UserServiceCommentTagVo>  tagList;
	
	private Integer allSize;
	private Integer goodSize;
	private Integer middleSize;
	private Integer badSiz;

	public List<UserServiceCommentTagVo> getTagList() {
		return tagList;
	}
	public void setTagList(List<UserServiceCommentTagVo> tagList) {
		this.tagList = tagList;
	}
	public Integer getAllSize() {
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