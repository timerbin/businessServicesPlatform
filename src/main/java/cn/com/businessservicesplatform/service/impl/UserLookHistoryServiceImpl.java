package cn.com.businessservicesplatform.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.com.businessservicesplatform.common.constants.BaseConfigTypeEnum;
import cn.com.businessservicesplatform.common.constants.UserLookHistoryTypeEnum;
import cn.com.businessservicesplatform.common.util.BasePage;
import cn.com.businessservicesplatform.model.vo.BaseConfigDataVo;
import cn.com.businessservicesplatform.model.vo.BaseUserCompanyVo;
import cn.com.businessservicesplatform.model.vo.UserCompanyServiceVo;
import cn.com.businessservicesplatform.service.BaseConfigDataService;
import cn.com.businessservicesplatform.service.BaseUserCompanyService;
import cn.com.businessservicesplatform.service.UserCompanyServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.businessservicesplatform.common.util.DateUtils;
import cn.com.businessservicesplatform.dao.mysql.UserLookHistoryMapper;
import cn.com.businessservicesplatform.model.mysql.BaseConfigData;
import cn.com.businessservicesplatform.model.mysql.UserLookHistory;
import cn.com.businessservicesplatform.model.vo.UserLookHistoryVo;
import cn.com.businessservicesplatform.service.UserLookHistoryService;

@Service
public class UserLookHistoryServiceImpl implements UserLookHistoryService{
	
	@Autowired
	UserLookHistoryMapper userLookHistoryMapper;

	@Autowired
	BaseUserCompanyService baseUserCompanyService;
	@Autowired
	UserCompanyServiceService userCompanyServiceService;
	
	@Autowired
	BaseConfigDataService baseConfigDataService;

	@Override
	public int insert(UserLookHistoryVo userLookHistoryVo) {
		int result = 0;
		if(null != userLookHistoryVo && null != userLookHistoryVo.getUserId()){
			/**当前时间**/
			String nowDate = DateUtils.getString(new Date(),DateUtils.DEF_DATE_NO_TIME_FORMAT);
			userLookHistoryVo.setNowDate(nowDate);
			
			UserLookHistory lookHistory = userLookHistoryMapper.getByVo(userLookHistoryVo);
			if(null == lookHistory || lookHistory.getId() == null){
				lookHistory = new UserLookHistory(userLookHistoryVo);
				lookHistory.setStatus(1);
				lookHistory.setNowDate(nowDate);
				lookHistory.setCreateTime(new Date());
				lookHistory.setModifyTime(new Date());
				result = userLookHistoryMapper.insert(lookHistory);
			}else{
				if(null != lookHistory.getLookCount()){
					lookHistory.setLookCount(lookHistory.getLookCount().intValue()+1);
				}else{
					lookHistory.setLookCount(1);
				}
				lookHistory.setModifyTime(new Date());
				result = userLookHistoryMapper.updateByPrimaryKey(lookHistory);
			}
		}
		return result;
	}

	/**
	 * 查询浏览记录
	 *
	 * @param userLookHistoryVo
	 * @return List<UserLookHistory> <br>
	 * @throws
	 * @Description: <br>
	 * @Author: wangwenbin <br>
	 * @Date: 2016年12月2日 <br>
	 * @Time: 下午9:19:41 <br>
	 */
	@Override
	public List<UserLookHistory> queryHistroyList(UserLookHistoryVo userLookHistoryVo) {
		return userLookHistoryMapper.queryHistroyList(userLookHistoryVo);
	}

    @Override
    public List<UserLookHistoryVo> queryByPage(BasePage basePage, UserLookHistoryVo userLookHistoryVo) {
		List<UserLookHistoryVo> voLst = userLookHistoryMapper.queryPage(basePage,userLookHistoryVo);
		for(UserLookHistoryVo vo:voLst){
			if(null != vo){
				if(vo.getType() == UserLookHistoryTypeEnum.SERVICES.getId()){
					UserCompanyServiceVo serviceVo = userCompanyServiceService.getAllService(vo.getCompanyId());
					vo.setUserCompanyServiceVo(serviceVo);
					BaseUserCompanyVo companyVo =  baseUserCompanyService.getUserAllCompany(vo.getCompanyId());
					vo.setBaseUserCompanyVo(companyVo);
				}else if(vo.getType() == UserLookHistoryTypeEnum.COMPANY.getId()){
					BaseUserCompanyVo  companyVo =  baseUserCompanyService.getUserAllCompany(vo.getCompanyId());
					vo.setBaseUserCompanyVo(companyVo);
				}
			}
		}
		return voLst;
    }

	@Override
	public int updateDel(Integer id) {
		if(null == id){
			return 0;
		}
		return userLookHistoryMapper.updateDelStatus(id);
	}

	/**
	 * 获取浏览历史的所有日期
	 *
	 * @return
	 */
	@Override
	public List<String> queryHisDate() {return userLookHistoryMapper.queryHistoryDate();
	}
	@Override
	public List<UserLookHistory> queryTopHistroyList(UserLookHistoryVo userLookHistoryVo){
		return userLookHistoryMapper.queryTopHistroyList(userLookHistoryVo);
	}
	@Override
	public List<BaseConfigDataVo> queryServiceLook(UserLookHistoryVo userLookHistoryVo){
		List<BaseConfigDataVo> result = null;
		BaseConfigDataVo vo = null;
		List<Integer> lookSize = null;
		List<BaseConfigData> queryList =  baseConfigDataService.queryList(new BaseConfigDataVo(BaseConfigTypeEnum.SERVICES_TYPE.getId()));
		if(queryList != null && queryList.size() > 0){
			result = new ArrayList<BaseConfigDataVo>();
			for(BaseConfigData data : queryList){
				lookSize = new ArrayList<Integer>();
				vo = new BaseConfigDataVo(data);
				vo.setLookSize(lookSize);
				result.add(vo);
			}
		}
		return result;
	}
	
}
