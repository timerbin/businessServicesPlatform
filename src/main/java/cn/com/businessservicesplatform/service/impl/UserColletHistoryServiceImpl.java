package cn.com.businessservicesplatform.service.impl;

import cn.com.businessservicesplatform.common.constants.UserCollectHistoryTypeEnum;
import cn.com.businessservicesplatform.common.util.BasePage;
import cn.com.businessservicesplatform.dao.mysql.UserCollectHistoryMapper;
import cn.com.businessservicesplatform.model.mysql.UserCollectHistory;
import cn.com.businessservicesplatform.model.vo.BaseUserCompanyVo;
import cn.com.businessservicesplatform.model.vo.UserCollectHistoryVo;
import cn.com.businessservicesplatform.model.vo.UserCompanyServiceVo;
import cn.com.businessservicesplatform.service.BaseUserCompanyService;
import cn.com.businessservicesplatform.service.UserCollectHistoryService;
import cn.com.businessservicesplatform.service.UserCompanyServiceService;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserColletHistoryServiceImpl implements UserCollectHistoryService {
	
	private static final Logger log = LoggerFactory.getLogger(UserCollectHistoryService.class);

	@Autowired
	UserCollectHistoryMapper userCollectHistoryMapper;
	@Autowired
	BaseUserCompanyService baseUserCompanyService;
	@Autowired
	UserCompanyServiceService userCompanyServiceService;
	

	@Override
	public int addUserCollectHistory(UserCollectHistoryVo vo) {
		int result = 0;
		if(null == vo ){
			log.error("UserCollectHistoryService.addUserCollectHistory.vo.is.null");
			return result;
		}
		if(vo.getUserId() == null){
			log.error("UserCollectHistoryService.addUserCollectHistory.userId.is.null");
			return result;
		}
		if(vo.getCompanyId() == null){
			log.error("UserCollectHistoryService.addUserCollectHistory.companyId.is.null:"+vo.getUserId());
			return result;
		}
		UserCollectHistory userCollectHistory = null;
		if(null == vo.getServiceId()){
			vo.setType(UserCollectHistoryTypeEnum.SERVICES.getId());
			userCollectHistory = userCollectHistoryMapper.getCollect(vo);
		}else{
			vo.setType(UserCollectHistoryTypeEnum.COMPANY.getId());
			userCollectHistory = userCollectHistoryMapper.getCollect(vo);
		}
		if(null != userCollectHistory && null != userCollectHistory.getId()){
			if(userCollectHistory.getStatus() != 1){
				userCollectHistory.setStatus(1);
				userCollectHistory.setModifyTime(new Date());
				result = userCollectHistoryMapper.updateByPrimaryKey(userCollectHistory);
			}else{
				result = 1;
				log.error(String.format("UserCollectHistoryService.addUserCollectHistory.is.success:%s-%s-%s",vo.getType(),vo.getUserId(),vo.getCompanyId()));
			}
		}else{
			vo.setStatus(1);
			vo.setCreateTime(new Date());
			vo.setModifyTime(new Date());
			result = userCollectHistoryMapper.insert(vo);
		}
		return result;
	}
	@Override
	public int delUserCollectHistory(UserCollectHistoryVo vo) {
		int result = 0;
		if(null == vo ){
			log.error("UserCollectHistoryService.delUserCollectHistory.vo.is.null");
			return result;
		}
		if(vo.getUserId() == null){
			log.error("UserCollectHistoryService.delUserCollectHistory.userId.is.null");
			return result;
		}
		if(vo.getCompanyId() == null){
			log.error("UserCollectHistoryService.delUserCollectHistory.companyId.is.null:"+vo.getUserId());
			return result;
		}
		UserCollectHistory userCollectHistory = null;
		if(null == vo.getServiceId()){
			vo.setType(UserCollectHistoryTypeEnum.SERVICES.getId());
			userCollectHistory = userCollectHistoryMapper.getCollect(vo);
		}else{
			vo.setType(UserCollectHistoryTypeEnum.COMPANY.getId());
			userCollectHistory = userCollectHistoryMapper.getCollect(vo);
		}
		if(null != userCollectHistory && null != userCollectHistory.getId()){
			if(userCollectHistory.getStatus() != -1){
				userCollectHistory.setStatus(-1);
				userCollectHistory.setModifyTime(new Date());
				result = userCollectHistoryMapper.updateByPrimaryKey(userCollectHistory);
			}else{
				result = 1;
				log.error(String.format("UserCollectHistoryService.delUserCollectHistory.is.del:%s-%s-%s",vo.getType(),vo.getUserId(),vo.getCompanyId()));
			}
		}else{
			result = 1;
			log.error(String.format("UserCollectHistoryService.delUserCollectHistory.is.success:%s-%s-%s",vo.getType(),vo.getUserId(),vo.getCompanyId()));
		}
		return result;
	}
	@Override
	public List<UserCollectHistoryVo> queryList(UserCollectHistoryVo userCollectHistoryVo) {
		List<UserCollectHistoryVo> list = userCollectHistoryMapper.queryList(userCollectHistoryVo);
		if(null != list && list.size() > 0){
			for(UserCollectHistoryVo vo:list){
				if(null != vo){
					if(vo.getType() == UserCollectHistoryTypeEnum.SERVICES.getId()){
						UserCompanyServiceVo serviceVo = userCompanyServiceService.getAllService(vo.getCompanyId());
						vo.setUserCompanyServiceVo(serviceVo);
						BaseUserCompanyVo  companyVo =  baseUserCompanyService.getUserAllCompany(vo.getCompanyId());
						vo.setBaseUserCompanyVo(companyVo);
					}else if(vo.getType() == UserCollectHistoryTypeEnum.COMPANY.getId()){
						BaseUserCompanyVo  companyVo =  baseUserCompanyService.getUserAllCompany(vo.getCompanyId());
						vo.setBaseUserCompanyVo(companyVo);
					}
				}
			}
		}
		return list;
	}


	@Override
	public List<UserCollectHistoryVo> queryPage(BasePage basePage, UserCollectHistoryVo userCollectHistoryVo) {
		List<UserCollectHistoryVo> list = userCollectHistoryMapper.queryPage(basePage,userCollectHistoryVo);
		if(null != list && list.size() > 0){
			for(UserCollectHistoryVo vo:list){
				if(null != vo){
					if(vo.getType() == UserCollectHistoryTypeEnum.SERVICES.getId()){
						UserCompanyServiceVo serviceVo = userCompanyServiceService.getAllService(vo.getCompanyId());
						vo.setUserCompanyServiceVo(serviceVo);
						BaseUserCompanyVo  companyVo =  baseUserCompanyService.getUserAllCompany(vo.getCompanyId());
						vo.setBaseUserCompanyVo(companyVo);
					}else if(vo.getType() == UserCollectHistoryTypeEnum.COMPANY.getId()){
						BaseUserCompanyVo  companyVo =  baseUserCompanyService.getUserAllCompany(vo.getCompanyId());
						vo.setBaseUserCompanyVo(companyVo);
					}
				}
			}
		}
		return list;
	}
	
	
}
