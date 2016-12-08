package cn.com.businessservicesplatform.model.vo;

import java.text.NumberFormat;
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
	private Integer goodSizeRate=0;
	private Integer middleSize=0;
	private Integer middleSizeRate=0;
	private Integer badSize = 0;
	private Integer badSizeRate=0;
	private String tagIds;
	
	private String commentTypeStr;
	
	private String createTimeStr;
	
	private Integer star;
	
	
	public Integer getStar() {
		if(null != getGoodSizeRate()){
			setStar(getGoodSizeRate()/20);
		}
		return star;
	}

	public void setStar(Integer star) {
		this.star = star;
	}

	public Integer getGoodSizeRate() {
		if(getMiddleSizeRate()>0 || getBadSizeRate()>0){
			setGoodSizeRate(100 - getMiddleSizeRate()-getBadSizeRate());
			
		}else{
			setGoodSizeRate(100);
		}
		return goodSizeRate;
	}

	public void setGoodSizeRate(Integer goodSizeRate) {
		this.goodSizeRate = goodSizeRate;
	}

	public Integer getMiddleSizeRate() {
		if(null != middleSize && middleSize > 0 && getAllSize() > 0){
			setMiddleSizeRate(makeRate(middleSize,getAllSize()));
		}else{
			setMiddleSizeRate(0);
		}
		return middleSizeRate;
	}

	public void setMiddleSizeRate(Integer middleSizeRate) {
		this.middleSizeRate = middleSizeRate;
	}

	public Integer getBadSizeRate() {
		if(null != badSize && badSize > 0 && getAllSize() > 0){
			setBadSizeRate(makeRate(badSize,getAllSize()));
		}else{
			setBadSizeRate(0);
		}
		return badSizeRate;
	}

	public void setBadSizeRate(Integer badSizeRate) {
		this.badSizeRate = badSizeRate;
	}
	/***
	 * 计算百分比
	 * @param num1
	 * @param num2
	 * @return
	 */
	private   Integer makeRate(Integer num1,Integer num2){
		Integer resultNum = 0;
		try {
			NumberFormat numberFormat = NumberFormat.getInstance();  
			numberFormat.setMaximumFractionDigits(0);  
			String result = numberFormat.format((float) num1 / (float) num2 * 100);  
			resultNum = Integer.parseInt(result);
		} catch (NumberFormatException e) {
		}
		return resultNum ;
	}

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
		setAllSize(goodSize+middleSize+badSize);
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

	public Integer getBadSize() {
		return badSize;
	}

	public void setBadSize(Integer badSize) {
		this.badSize = badSize;
	}
	 
	
}