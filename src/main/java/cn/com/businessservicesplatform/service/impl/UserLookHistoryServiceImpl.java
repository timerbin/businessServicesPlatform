package cn.com.businessservicesplatform.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.com.businessservicesplatform.common.constants.BaseConfigTypeEnum;
import cn.com.businessservicesplatform.common.constants.UserLookHistoryTypeEnum;
import cn.com.businessservicesplatform.common.util.BasePage;
import cn.com.businessservicesplatform.model.vo.BaseConfigDataVo;
import cn.com.businessservicesplatform.model.vo.BaseUserCompanyVo;
import cn.com.businessservicesplatform.model.vo.ServiceLookSizeVo;
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

		try {
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
		}catch (Exception e){

			e.printStackTrace();
		}

		return 0;

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
		List<UserLookHistory> lst = userLookHistoryMapper.queryPage(basePage,userLookHistoryVo);
		List<UserLookHistoryVo> voLst = new ArrayList<UserLookHistoryVo>();
		for (UserLookHistory hist:lst) {
			UserLookHistoryVo vo = new UserLookHistoryVo(hist);
			voLst.add(vo);
		}


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
		List<ServiceLookSizeVo> sizeList = null;
		Integer serviceType = userLookHistoryVo.getServiceType();
		
		List<BaseConfigData> queryList =  baseConfigDataService.queryList(new BaseConfigDataVo(BaseConfigTypeEnum.SERVICES_TYPE.getId()));
		if(queryList != null && queryList.size() > 0){
			result = new ArrayList<BaseConfigDataVo>();
			
			for(BaseConfigData data : queryList){
				if(null == serviceType || serviceType == data.getId() ){
					userLookHistoryVo.setServiceType(data.getId());
					vo = new BaseConfigDataVo(data);
					Integer [] lookSize = {0,0,0,0,0,0,0,0,0,0,0,0};
					sizeList = userLookHistoryMapper.queryLookSize(userLookHistoryVo);
					if(null != sizeList && sizeList.size() > 0){
						for(ServiceLookSizeVo sizeVo : sizeList){
							if(null != sizeVo){
								Integer months = Integer.parseInt(sizeVo.getMonths());
								Integer size = 0;
								if(months > 0){
									if(null != sizeVo.getSize()){
										size = sizeVo.getSize();
									}
									lookSize[months-1] = size;
								}
							}
						}
					}
					vo.setLookSize(lookSize);
					result.add(vo);
				}
			}
		}
		return result;
	}
	
}
