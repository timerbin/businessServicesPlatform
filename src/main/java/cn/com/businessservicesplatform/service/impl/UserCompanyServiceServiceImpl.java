package cn.com.businessservicesplatform.service.impl;

import cn.com.businessservicesplatform.dao.mysql.BaseConfigDataMapper;
import cn.com.businessservicesplatform.dao.mysql.UserCompanyServiceMapper;
import cn.com.businessservicesplatform.model.mysql.BaseConfigData;
import cn.com.businessservicesplatform.model.mysql.UserCompanyService;
import cn.com.businessservicesplatform.model.vo.UserCompanyServiceVo;
import cn.com.businessservicesplatform.service.UserCompanyServiceService;

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

    public int insert(UserCompanyServiceVo vo){
        return userCompanyServiceMapper.insert(vo);
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
			if(null != userCompanyServiceVo.getServiceType()){
				BaseConfigData baseConfigData = baseConfigDataMapper.selectByPrimaryKey(id);
				if(null != baseConfigData){
					userCompanyServiceVo.setServiceTypeStr(baseConfigData.getShowName());
				}
			}
		}
		return userCompanyServiceVo;
	}


}
