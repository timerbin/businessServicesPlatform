package cn.com.businessservicesplatform.service.impl;


import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.businessservicesplatform.common.constants.UserServiceCommentTypeEnum;
import cn.com.businessservicesplatform.common.util.BasePage;
import cn.com.businessservicesplatform.dao.mysql.BaseConfigDataMapper;
import cn.com.businessservicesplatform.dao.mysql.UserServiceCommentMapper;
import cn.com.businessservicesplatform.dao.mysql.UserServiceCommentTagMapper;
import cn.com.businessservicesplatform.model.mysql.BaseConfigData;
import cn.com.businessservicesplatform.model.mysql.UserServiceComment;
import cn.com.businessservicesplatform.model.mysql.UserServiceCommentTag;
import cn.com.businessservicesplatform.model.vo.UserServiceCommentVo;
import cn.com.businessservicesplatform.service.UserServiceCommentService;

@Service
public class UserServiceCommentServiceImpl implements UserServiceCommentService{
	
	
	public static final Logger log = LoggerFactory.getLogger(UserServiceCommentService.class);
	
	@Autowired
	UserServiceCommentMapper userServiceCommentMapper;
	
	@Autowired
	UserServiceCommentTagMapper userServiceCommentTagMapper;
	
	@Autowired
	BaseConfigDataMapper baseConfigDataMapper;

	@Override
	public int insert(UserServiceCommentVo vo) {
		int result = 0;
		if(null == vo || vo.getServiceId() == null){
			return result;
		}
		UserServiceComment comment = userServiceCommentMapper.getCommentByUserId(vo);
		if(null != comment && comment.getId() > 0){
			log.error("UserServiceCommentService.insert.is.error:已经评论"+vo.getCommentUserId());
			result = -2;
		}else{
			comment = new UserServiceComment(vo);
			comment.setStatus(1);
			comment.setModifyTime(new Date());
			comment.setCreateTime(new Date());
			result = userServiceCommentMapper.insert(comment);
			if(result > 0){
				insertCommentTag(comment,vo);
			}
			
		}
		return result;
	}
	
	private void insertCommentTag(UserServiceComment comment,UserServiceCommentVo vo){
		try {
			if(null !=vo && null !=comment && comment.getId() !=null   &&  !StringUtils.isBlank(vo.getTagIds())){
				UserServiceCommentTag commentTag = null;
				BaseConfigData configData = null;
				if(vo.getTagIds().indexOf(",")>0){
					String [] tagIds = vo.getTagIds().split(",");
					for(int i=0;i<tagIds.length;i++){
						configData = baseConfigDataMapper.selectByPrimaryKey(Integer.parseInt(tagIds[i]));
						if(null != configData ){
							commentTag = new UserServiceCommentTag();
							commentTag.setCommentId(comment.getId());
							commentTag.setModifyTime(new Date());
							commentTag.setCreateTime(new Date());
							commentTag.setStatus(1);
							commentTag.setCommentTagId(configData.getId());
							commentTag.setCommentTagName(configData.getShowName());
							userServiceCommentTagMapper.insert(commentTag);
						}
					}
				}else{
					commentTag = new UserServiceCommentTag();
					configData = baseConfigDataMapper.selectByPrimaryKey(Integer.parseInt(vo.getTagIds()));
					if(null != configData ){
						commentTag = new UserServiceCommentTag();
						commentTag.setCommentId(comment.getId());
						commentTag.setModifyTime(new Date());
						commentTag.setCreateTime(new Date());
						commentTag.setStatus(1);
						commentTag.setCommentTagId(configData.getId());
						commentTag.setCommentTagName(configData.getShowName());
						userServiceCommentTagMapper.insert(commentTag);
					}
					
				}
			}
		} catch (Exception e) {
			log.error("UserServiceCommentService.insertCommentTag.is.error:已经评论"+vo.getCommentUserId(),e);
		}
		
	}

	@Override
	public UserServiceCommentVo getCommentSize(UserServiceCommentVo vo) {
		if(null == vo || vo.getServiceId() == null){
			return vo;
		}
		List<UserServiceCommentVo> listSize = userServiceCommentMapper.getCommentSizeList(vo);
		if(null != listSize && listSize.size()>0){
			for(UserServiceCommentVo commentVo : listSize){
				if(null != commentVo && commentVo.getCommentType()!=null){
					if(commentVo.getCommentType().intValue() == UserServiceCommentTypeEnum.GOOD.getId()){
						vo.setGoodSize(null != commentVo.getQuerySize()?commentVo.getQuerySize():0);
					}else if(commentVo.getCommentType().intValue() == UserServiceCommentTypeEnum.MIDDLE.getId()){
						vo.setMiddleSize(null != commentVo.getQuerySize()?commentVo.getQuerySize():0);
					}else if(commentVo.getCommentType().intValue() == UserServiceCommentTypeEnum.BAD.getId()){
						vo.setBadSize(null != commentVo.getQuerySize()?commentVo.getQuerySize():0);
					}
				}
			}
		}
		return vo;
	}

	@Override
	public List<UserServiceCommentVo> queryPage(BasePage basePage, UserServiceCommentVo vo) {
		List<UserServiceCommentVo> commentVoList = userServiceCommentMapper.queryPage(basePage, vo);
		if(null != commentVoList && commentVoList.size() > 0){
			List<UserServiceCommentTag> tagList = null;
			for(UserServiceCommentVo commentVo :commentVoList){
				if(null != commentVo ){
					tagList = userServiceCommentTagMapper.getList(commentVo.getId());
					commentVo.setTagList(tagList);
				}
			}
		}
		return commentVoList;
	}
 
}
