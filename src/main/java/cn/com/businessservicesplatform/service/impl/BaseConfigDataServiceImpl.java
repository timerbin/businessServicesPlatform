package cn.com.businessservicesplatform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.businessservicesplatform.common.util.BasePage;
import cn.com.businessservicesplatform.dao.mysql.BaseConfigDataMapper;
import cn.com.businessservicesplatform.model.mysql.BaseConfigData;
import cn.com.businessservicesplatform.model.vo.BaseConfigDataVo;
import cn.com.businessservicesplatform.service.BaseConfigDataService;

@Service
public class BaseConfigDataServiceImpl implements BaseConfigDataService{
	
	@Autowired
	BaseConfigDataMapper baseConfigDataMapper;

	public List<BaseConfigData> queryPage(BasePage basePage, BaseConfigDataVo baseConfigDataVo) {
		return baseConfigDataMapper.queryPage(basePage, baseConfigDataVo);
	}

}
