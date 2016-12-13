package cn.com.businessservicesplatform.service.impl;

import cn.com.businessservicesplatform.common.constants.BaseConfigTypeEnum;
import cn.com.businessservicesplatform.common.constants.UserServiceStatuesEnum;
import cn.com.businessservicesplatform.common.util.BasePage;
import cn.com.businessservicesplatform.dao.mysql.BaseConfigDataMapper;
import cn.com.businessservicesplatform.dao.mysql.UserCompanyServiceMapper;
import cn.com.businessservicesplatform.model.mysql.BaseConfigData;
import cn.com.businessservicesplatform.model.mysql.UserCompanyService;
import cn.com.businessservicesplatform.model.mysql.UserLookHistory;
import cn.com.businessservicesplatform.model.vo.BaseConfigDataVo;
import cn.com.businessservicesplatform.model.vo.BaseUserCompanyVo;
import cn.com.businessservicesplatform.model.vo.UserCompanyServiceVo;
import cn.com.businessservicesplatform.model.vo.UserLookHistoryVo;
import cn.com.businessservicesplatform.service.BaseUserCompanyService;
import cn.com.businessservicesplatform.service.UserCompanyServiceService;
import cn.com.businessservicesplatform.service.UserLookHistoryService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * Created by John on 2016/12/3.
 */
@Service
public class UserCompanyServiceServiceImpl implements UserCompanyServiceService{
	
	private static final Logger log = LoggerFactory.getLogger(UserCompanyServiceService.class);

	@Autowired
	UserCompanyServiceMapper userCompanyServiceMapper;
    @Autowired
    BaseConfigDataMapper baseConfigDataMapper;
    @Autowired
    BaseUserCompanyService baseUserCompanyService;
    
    @Autowired
	UserLookHistoryService userLookHistoryService;

    public int insert(UserCompanyServiceVo vo){
    	int result = 0;
    	UserCompanyServiceVo queryVo = new UserCompanyServiceVo();
    	queryVo.setServiceType(vo.getServiceType());
    	queryVo.setServiceName(vo.getServiceName());
    	UserCompanyServiceVo resulstVo = userCompanyServiceMapper.getUserCompanyService(queryVo);
    	if(null == resulstVo || resulstVo.getId() == null){
    		vo.setStatus(1);
        	vo.setCreateTime(new Date());
        	vo.setModifyTime(new Date());
        	vo.setRecommend(0);
        	result = userCompanyServiceMapper.insert(vo);
    	}else{
    		result = -2;
    	}
    	return result;
    	
    }

    @Override
    public UserCompanyServiceVo fetchCompanyService(UserCompanyServiceVo vo) {
        return userCompanyServiceMapper.getUserCompanyService(vo);
    }

	@Override
	public UserCompanyServiceVo getAllService(Integer id) {
		UserCompanyServiceVo userCompanyServiceVo = null;
		if(null == id ){
			log.error("UserCompanyServiceService.getAllService.is.null:");
			return userCompanyServiceVo;
		}
		UserCompanyService userCompanyService = userCompanyServiceMapper.selectByPrimaryKey(id);
		if(null != userCompanyService && userCompanyService.getId() != null){
			userCompanyServiceVo = new UserCompanyServiceVo(userCompanyService);
			if(null != userCompanyServiceVo && userCompanyServiceVo.getCompanyId() != null){
				BaseUserCompanyVo baseUserCompanyVo = baseUserCompanyService.getUserAllCompany(userCompanyServiceVo.getCompanyId());
				userCompanyServiceVo.setBaseUserCompanyVo(baseUserCompanyVo);
			}
		}
		return userCompanyServiceVo;
	}
	
	@Override
	public List<UserCompanyServiceVo> queryPage(BasePage basePage,UserCompanyServiceVo vo){
		List<UserCompanyService> list = userCompanyServiceMapper.queryPage(basePage, vo);
		List<UserCompanyServiceVo> voList = new ArrayList<UserCompanyServiceVo>();


		if(null != list && list.size()>0){
			for(UserCompanyService service :list){
				if(null != service && service.getCompanyId() != null){
					UserCompanyServiceVo serviceVo = new UserCompanyServiceVo(service);
					BaseUserCompanyVo baseUserCompanyVo = baseUserCompanyService.getUserAllCompany(service.getCompanyId());
					serviceVo.setBaseUserCompanyVo(baseUserCompanyVo);
					serviceVo.setStatusStr(UserServiceStatuesEnum.get(service.getStatus()).getDes());
//					serviceVo.setServiceTypeStr();
//					SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
//					String dateStr = dft.format(service.getCreateTime());
//					serviceVo.setCreateTimeStr(dateStr);
					voList.add(serviceVo);
				}
			}
		}
		return voList;
	}


	@Override
	public List<UserCompanyServiceVo> queryAllPage(BasePage basePage,UserCompanyServiceVo vo){
		List<UserCompanyService> list = userCompanyServiceMapper.queryAllPage(basePage, vo);
		List<UserCompanyServiceVo> voList = new ArrayList<UserCompanyServiceVo>();

		if(null != list && list.size()>0){
			for(UserCompanyService service :list){
				if(null != service && service.getCompanyId() != null){
					UserCompanyServiceVo serviceVo = new UserCompanyServiceVo(service);
					BaseUserCompanyVo baseUserCompanyVo = baseUserCompanyService.getUserAllCompany(service.getCompanyId());
					serviceVo.setBaseUserCompanyVo(baseUserCompanyVo);
					serviceVo.setStatusStr(UserServiceStatuesEnum.get(service.getStatus()).getDes());
//					serviceVo.setServiceTypeStr();
//					SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
//					String dateStr = dft.format(service.getCreateTime());
//					serviceVo.setCreateTimeStr(dateStr);
					voList.add(serviceVo);
				}
			}
		}
		return voList;
	}
	@Override
	 public List<UserCompanyServiceVo> queryList(UserCompanyServiceVo vo){
		List<UserCompanyServiceVo> list = userCompanyServiceMapper.queryList(vo);
		if(null != list && list.size()>0){
			for(UserCompanyServiceVo serviceVo :list){
				if(null != serviceVo && serviceVo.getCompanyId() != null){
					BaseUserCompanyVo baseUserCompanyVo = baseUserCompanyService.getUserAllCompany(serviceVo.getCompanyId());
					serviceVo.setBaseUserCompanyVo(baseUserCompanyVo);
				}
			}
		}
		return list;
	 }


	/**
	 * 更新
	 * @param vo
	 * @return
     */
	@Override
	public int updateByPrimaryKeySelective(UserCompanyServiceVo vo) {
		return userCompanyServiceMapper.updateByPrimaryKeySelective(vo);
	}

	/**
	 * 删除
	 * @param id
	 * @return
     */
	@Override
	public int delCompanyServiceByid(Integer id) {
		return userCompanyServiceMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<UserCompanyServiceVo> queryLikeList(Integer queryRows){
		List<UserCompanyServiceVo> result = null;
		UserLookHistoryVo userLookHistoryVo = new UserLookHistoryVo();
		if(null != queryRows){
			userLookHistoryVo.setQueryRows(queryRows);
		}
		List<UserLookHistory> list =  userLookHistoryService.queryTopHistroyList(userLookHistoryVo);
		if(null != list && list.size()>0){
			result = new ArrayList<UserCompanyServiceVo>();
			for(UserLookHistory history:list){
				if(null != history && history.getServiceId()!=null){
					result.add(getAllService(history.getServiceId()));
				}
			}
		}
		return result;
	}

	/**
	 * 查询所有服务
	 * @param record
	 * @return
     */
	@Override
	public List<UserCompanyService> getAllUserCompanyServices(UserCompanyServiceVo record) {
		return userCompanyServiceMapper.getAllUserCompanyServices(record);
	}


}
